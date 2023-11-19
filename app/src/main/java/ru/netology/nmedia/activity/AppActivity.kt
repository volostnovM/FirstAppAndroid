package ru.netology.nmedia.activity

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.NewPostFragment.Companion.text
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.databinding.ActivityAppBinding
import ru.netology.nmedia.viewmodel.AuthViewModel

class AppActivity : AppCompatActivity() {

    val viewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let { intent ->
            if (intent.action != Intent.ACTION_SEND) {
                return@let
            }

            val text = intent.getStringExtra(Intent.EXTRA_TEXT)
            if (text.isNullOrBlank()) {
                Snackbar.make(binding.root, R.string.error_empty_content, LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok) {
                        finish()
                    }
                    .show()
                return@let
            }

            Snackbar.make(binding.root, text.toString(), LENGTH_INDEFINITE)
                .setAction(android.R.string.ok) {
                    finish()
                }
                .show()

            val navHostFragment =
                supportFragmentManager.findFragmentById(com.google.android.material.R.id.container) as NavHostFragment
            val navController = navHostFragment.navController

            findNavController(com.google.android.material.R.id.container).navigate(R.id.action_feedFragment_to_newPostFragment,
                Bundle().also { it.text = text }
            )
        }


        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.data.collect {
                    invalidateOptionsMenu()
                }
            }
        }

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)
            }

            override fun onPrepareMenu(menu: Menu) {
                menu.setGroupVisible(R.id.authenticated, viewModel.authenticated)
                menu.setGroupVisible(R.id.unauthenticated, !viewModel.authenticated)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.signin -> {
                        findNavController(R.id.nav_host_fragment).navigate(R.id.signInFragment)
                        true
                    }

                    R.id.signup -> {
                        findNavController(R.id.nav_host_fragment).navigate(R.id.signUpFragment)
                        true
                    }

                    R.id.signout -> {
                        AlertDialog.Builder(this@AppActivity).setMessage("Вы уверены?")
                            .setPositiveButton("Выйти"
                            ) { _, _ ->
                                AppAuth.getInstance().removeAuth()
                                findNavController(R.id.nav_host_fragment).navigateUp()
                            }
                            .setNegativeButton("Остаться"
                            ) { _, _ ->
                                return@setNegativeButton
                            }
                            .show()
                        true
                    }

                    else -> false
                }
            }
        })


        requestNotificationsPermission()
    }

    private fun requestNotificationsPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return
        }

        val permission = Manifest.permission.POST_NOTIFICATIONS

        if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
            return
        }

        requestPermissions(arrayOf(permission), 1)
    }
}
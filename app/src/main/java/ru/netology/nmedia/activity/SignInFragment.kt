package ru.netology.nmedia.activity

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import ru.netology.nmedia.R
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.databinding.FragmentSignInBinding
import ru.netology.nmedia.viewmodel.SignInViewModel

class SignInFragment: Fragment() {

    private val signInViewModel: SignInViewModel by viewModels()
    private var bindingSI: FragmentSignInBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSignInBinding.inflate(
            inflater,
            container,
            false
        )
        bindingSI = binding

        signInViewModel.dataState.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state.loading) {
                    signInProgressLoading.visibility = View.VISIBLE
                }
                if (state.authState) {
                    findNavController().navigate(R.id.feedFragment)
                }
                if (state.error) {
                    signInProgressLoading.visibility = View.GONE
                    signInError.visibility = View.VISIBLE
                    ifErrorGone.visibility = View.GONE
                    retryButton.setOnClickListener {
                        signInError.visibility = View.GONE
                        ifErrorGone.visibility = View.VISIBLE
                    }
                }
            }
        }

        with(binding) {
            signInButton.setOnClickListener {
                if (usernameInput.text?.trim().toString().isBlank() || passwordInput.text?.trim().toString().isBlank()) {
                    Toast.makeText(context, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
                } else {
                    signInViewModel.signIn(usernameInput.text?.trim().toString(), passwordInput.text?.trim().toString())
                }
            }
            cancelButton.setOnClickListener {
                findNavController().navigate(R.id.feedFragment)
            }

        }

        return binding.root
    }

}
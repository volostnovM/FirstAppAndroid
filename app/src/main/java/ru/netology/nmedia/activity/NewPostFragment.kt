package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toFile
import androidx.core.view.MenuProvider
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.dhaval2404.imagepicker.ImagePicker
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.FragmentNewPostBinding
import ru.netology.nmedia.util.AndroidUtils
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.viewmodel.PostViewModel

class NewPostFragment : Fragment() {

    companion object {
        var Bundle.text by StringArg
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewPostBinding.inflate(layoutInflater)
        val viewModel: PostViewModel by activityViewModels()

        val photoResultContract =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val uri = it.data?.data ?: return@registerForActivityResult
                    val file = uri.toFile()

                    viewModel.setPhoto(uri, file)
                }
            }

        var text = arguments?.text
        if (text != null) {
            binding.edit.setText(text)
        }

        viewModel.photo.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.imageContainer.isGone = true
                return@observe
            }
            binding.imageContainer.isVisible = true
            binding.preview.setImageURI(it.uri)
        }

        binding.remove.setOnClickListener {
            viewModel.clearPhoto()
        }

        binding.edit.requestFocus()

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.save_post, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
                when (menuItem.itemId) {
                    R.id.save -> {
                        if (!binding.edit.text.isNullOrBlank()) {
                            val content = binding.edit.text.toString()
                            viewModel.changeContentAndSave(content)
                            AndroidUtils.hideKeyboard(binding.edit)
                        }
                        true
                    }

                    else -> false
                }
        })

        viewModel.postCreated.observe(viewLifecycleOwner)
        {
            findNavController().navigateUp()
        }

        binding.takePhoto.setOnClickListener {
            ImagePicker.Builder(this)
                .cameraOnly()
                .maxResultSize(2048, 2048)
                .createIntent {
                    photoResultContract.launch(it)
                }
        }

        binding.takePhoto.setOnClickListener {
            ImagePicker.Builder(this)
                .crop()
                .cameraOnly()
                .maxResultSize(2048, 2048)
                .createIntent {
                    photoResultContract.launch(it)
                }
        }

        binding.pickPhoto.setOnClickListener {
            ImagePicker.Builder(this)
                .crop()
                .galleryOnly()
                .maxResultSize(2048, 2048)
                .createIntent {
                    photoResultContract.launch(it)
                }
        }

        viewModel.cancelEditing()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("onDestroyView")
    }
}
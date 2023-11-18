package ru.netology.nmedia.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.FragmentEditPostBinding
import ru.netology.nmedia.util.AndroidUtils
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.viewmodel.PostViewModel

class EditPostFragment : Fragment() {

    companion object {
        var Bundle.textArg by StringArg
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEditPostBinding.inflate(layoutInflater)
        val viewModel: PostViewModel by activityViewModels()

        binding.editPost.requestFocus()

        arguments?.textArg?.let {
            binding.editPost.setText(it)
        }

        binding.saveButton.setOnClickListener {
            val content = binding.editPost.text.toString()

            if (content.isNotBlank()) {
                viewModel.changeContentAndSave(content)
                AndroidUtils.hideKeyboard(binding.editPost)
            } else {
                Toast.makeText(
                    activity,
                    getString(R.string.error_empty_content),
                    Toast.LENGTH_SHORT
                ).show()
            }

            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener {
            viewModel.cancelEditing()
            AndroidUtils.hideKeyboard(binding.editPost)
            findNavController().navigateUp()
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    viewModel.cancelEditing()
                    AndroidUtils.hideKeyboard(binding.editPost)
                    findNavController().navigateUp()
                }
            }
        )

        return binding.root
    }
}
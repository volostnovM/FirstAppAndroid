package ru.netology.nmedia.activity

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.FragmentSignUpBinding
import ru.netology.nmedia.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {


    private val signUpViewModel: SignUpViewModel by activityViewModels()
    private var bindingSU: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSignUpBinding.inflate(
            inflater,
            container,
            false
        )
        bindingSU = binding

        signUpViewModel.dataState.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state.loading) {
                    signUpProgressLoading.visibility = View.VISIBLE
                }
                if (state.authState) {
                    findNavController().navigate(R.id.feedFragment)
                }
                if (state.error) {
                    signUpProgressLoading.visibility = View.GONE
                    regError.visibility = View.VISIBLE
                    ifErrorGone.visibility = View.GONE
                    retryButton.setOnClickListener {
                        regError.visibility = View.GONE
                        ifErrorGone.visibility = View.VISIBLE
                    }
                }
            }
        }

        with(binding) {

            regButton.setOnClickListener {
                if (usernameRegInput.text?.trim().toString().isBlank() || loginRegInput.text?.trim().toString().isBlank()
                    || passwordRegInput.text?.trim().toString().isBlank()
                ) {
                    Toast.makeText(
                        context,
                        "Введите все данные для регистрации",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    signUpViewModel.signeUp(
                        usernameRegInput.text?.trim().toString(),
                        loginRegInput.text?.trim().toString(),
                        passwordRegInput.text?.trim().toString()
                    )
                }
            }
            cancelButton.setOnClickListener {
                findNavController().navigate(R.id.feedFragment)
            }
        }

        return binding.root
    }

}
package ru.netology.nmedia.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.netology.nmedia.BuildConfig
import ru.netology.nmedia.databinding.FragmentImageBinding
import ru.netology.nmedia.util.load

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentImageBinding.inflate(layoutInflater, container, false)

        val urlAttachment = arguments?.getString("image")

        binding.apply {
            urlAttachment?.let {
                val url = "${BuildConfig.BASE_URL}/media/${it}"
                image.load(url)
                image.visibility = View.VISIBLE
            }
        }

        binding.image.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}
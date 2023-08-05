package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.service.Service
import ru.netology.nmedia.util.AndroidUtils
import ru.netology.nmedia.util.AndroidUtils.focusAndShowKeyboard
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.group.visibility = View.GONE

        val viewModel: PostViewModel by viewModels()
        val adapter = PostsAdapter(object : OnInteractionListener {
            override fun like(post: Post) {
                viewModel.likeById(post.id)
            }

            override fun share(post: Post) {
                viewModel.share(post.id)
            }

            override fun remove(post: Post) {
                viewModel.removeById(post.id)
            }

            override fun edit(post: Post) {
                viewModel.edit(post)
                binding.group.visibility = View.VISIBLE
            }
        }
        )

        viewModel.edited.observe(this) {
            if(it.id != 0L) {
                binding.content.setText(it.content)
                binding.content.focusAndShowKeyboard()
            }
        }


        binding.recyclerList.adapter = adapter
        viewModel.data.observe(this) { posts ->
            val newPost = posts.size > adapter.currentList.size
            adapter.submitList(posts) {
                if (newPost) {
                    binding.recyclerList.smoothScrollToPosition(0)
                }
            }
        }

        binding.saveButton.setOnClickListener {
            val text = binding.content.text.toString()
            if (text.isEmpty()) {
                val makeText =
                    Toast.makeText(this, R.string.error_empty_content, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.changeContentAndSave(text)

            binding.content.setText("")
            binding.content.clearFocus()
            AndroidUtils.hideKeyboard(it)
            binding.group.visibility = View.GONE
        }

        binding.cancelButton.setOnClickListener {
            binding.content.setText("")
            binding.content.clearFocus()
            AndroidUtils.hideKeyboard(it)
            viewModel.cancelEditing()
            binding.group.visibility = View.GONE
        }
    }
}
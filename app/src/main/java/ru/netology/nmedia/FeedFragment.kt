package ru.netology.nmedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import ru.netology.nmedia.activity.EditPostFragment.Companion.textArg
import ru.netology.nmedia.activity.PostFragment.Companion.idArg
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.FragmentFeedBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(layoutInflater)

        val viewModel: PostViewModel by activityViewModels()

        val adapter = PostsAdapter(object : OnInteractionListener {
            override fun like(post: Post) {
                if (post.likedByMe) {
                    viewModel.unlikeById(post.id)
                } else {
                    viewModel.likeById(post.id)
                }
            }

            override fun share(post: Post) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, post.content)
                    type = "text/plain"
                }

                val shareIntent =
                    Intent.createChooser(intent, getString(R.string.chooser_share_post))
                startActivity(shareIntent)
            }

            override fun remove(post: Post) {
                viewModel.removeById(post.id)
            }

            override fun edit(post: Post) {
                viewModel.edit(post)
                findNavController().navigate(
                    R.id.action_feedFragment_to_editPostFragment,
                    Bundle().apply {
                        this.textArg = post.content
                    }
                )
            }

            override fun video(post: Post) {
//                val videoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(post.video))
//                startActivity(videoIntent)
            }

            override fun viewPost(post: Post) {
                findNavController().navigate(
                    R.id.action_feedFragment_to_postFragment,
                    Bundle().apply {
                        idArg = post.id
                    }
                )
            }
        }
        )


        binding.recyclerList.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner) { state ->
            val newPost = state.posts.size > adapter.currentList.size
            adapter.submitList(state.posts) {
                if (newPost) {
                    binding.recyclerList.smoothScrollToPosition(0)
                }
            }
            binding.emptyTextView.isVisible = state.empty
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->

            binding.progress.isVisible = state.loading
            binding.errorGroup.isVisible = state.error
            binding.swipeRefresh.isRefreshing = state.refreshing

            if (state.error) {
                Snackbar.make(
                    binding.root,
                    state.errorMessage,
                    BaseTransientBottomBar.LENGTH_LONG
                )
                    .setAnchorView(binding.fab)
                    .show()
            }

            if (state.errorLike) {
                Snackbar.make(
                    binding.root,
                    state.errorMessage,
                    BaseTransientBottomBar.LENGTH_LONG
                )
                    .setAnchorView(binding.fab)
                    .show()
            }
        }

        binding.retryButton.setOnClickListener {
            viewModel.loadPosts()
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshPosts()
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_newPostFragment)
        }

        return binding.root
    }
}
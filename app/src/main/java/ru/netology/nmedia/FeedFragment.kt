package ru.netology.nmedia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.netology.nmedia.activity.EditPostFragment.Companion.textArg
import ru.netology.nmedia.activity.PostFragment.Companion.idArg
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostLoadingStateAdapter
import ru.netology.nmedia.adapter.PostLoadingViewHolder
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.FragmentFeedBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.AuthViewModel
import ru.netology.nmedia.viewmodel.PostViewModel

@AndroidEntryPoint
class FeedFragment : Fragment() {

    val viewModelAuth by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(layoutInflater)

        val viewModel: PostViewModel by activityViewModels()

        val adapter = PostsAdapter(object : OnInteractionListener {
            override fun like(post: Post) {
                if (viewModelAuth.authenticated) {
                    if (post.likedByMe) {
                        viewModel.unlikeById(post.id)
                    } else {
                        viewModel.likeById(post.id)
                    }
                } else {
                    findNavController().navigate(R.id.signInFragment)
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
//                findNavController().navigate(
//                    R.id.action_feedFragment_to_postFragment,
//                    Bundle().apply {
//                        idArg = post.id
//                    }
//                )
            }

            override fun onImage(image: String) {
                findNavController().navigate(
                    R.id.action_feedFragment_to_imageFragment,
                    Bundle().apply {
                        putString("image", image)
                    }
                )
            }
        }
        )


        binding.recyclerList.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PostLoadingStateAdapter {
                adapter.retry()
            },
            footer = PostLoadingStateAdapter {
                adapter.retry()
            }
        )

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.data.collectLatest {
                    adapter.submitData(it)
                }
            }
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->

            binding.progress.isVisible = state.loading
            binding.swipeRefresh.isRefreshing = state.refreshing

            if (state.error) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.error_send_message),
                    BaseTransientBottomBar.LENGTH_LONG
                )
                    .setAction("RETRY", View.OnClickListener {
                        viewModel.loadPosts()
                    })
                    .setAnchorView(binding.fab)
                    .show()
            }

            if (state.errorLike) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.error_send_message),
                    BaseTransientBottomBar.LENGTH_LONG
                )
                    .setAction("RETRY", View.OnClickListener {
                        viewModel.loadPosts()
                    })
                    .setAnchorView(binding.fab)
                    .show()
            }
        }

//        viewModel.newerCount.observe(viewLifecycleOwner) {
//            if (it > 0) {
//                binding.newPosts.visibility = View.VISIBLE
//            }
//        }

//        binding.newPosts.setOnClickListener {
//            binding.newPosts.visibility = View.GONE
//            viewModel.loadNewPosts()
//        }

        binding.retryButton.setOnClickListener {
            viewModel.loadPosts()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.loadStateFlow.collectLatest { state ->
                    binding.swipeRefresh.isRefreshing =
                        state.refresh is LoadState.Loading
                }
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            adapter.refresh()
        }

        binding.fab.setOnClickListener {
            if (viewModelAuth.authenticated) {
                findNavController().navigate(R.id.action_feedFragment_to_newPostFragment)
            } else {
                findNavController().navigate(R.id.signInFragment)
            }
        }

        return binding.root
    }


}
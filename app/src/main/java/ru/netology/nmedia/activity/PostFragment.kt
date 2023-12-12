package ru.netology.nmedia.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.map
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.EditPostFragment.Companion.textArg
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostViewHolder
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.FragmentPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.util.LongArg
import ru.netology.nmedia.viewmodel.PostViewModel
@AndroidEntryPoint
class PostFragment : Fragment() {
    companion object {
        var Bundle.idArg by LongArg
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPostBinding.inflate(layoutInflater, container, false)
        val id = arguments?.idArg

        val viewModel: PostViewModel by activityViewModels()

        viewLifecycleOwner.lifecycleScope.launch {
            binding.postFragment.apply {
                viewModel.data.map { posts ->
                    posts.map { post ->
                        if (post.id == id) {
                            PostViewHolder(this, object : OnInteractionListener {

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
                                        Intent.createChooser(
                                            intent,
                                            getString(R.string.chooser_share_post)
                                        )
                                    startActivity(shareIntent)
                                }

                                override fun remove(post: Post) {
                                    viewModel.removeById(post.id)
                                    findNavController().navigate(
                                        R.id.action_postFragment_to_feedFragment
                                    )
                                }

                                override fun edit(post: Post) {
                                    viewModel.edit(post)
                                    findNavController().navigate(
                                        R.id.action_postFragment_to_editPostFragment,
                                        Bundle().apply {
                                            textArg = post.content
                                        }
                                    )
                                }

                                override fun video(post: Post) {
//                                val videoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(post.video))
//                                startActivity(videoIntent)
                                }

                                override fun viewPost(post: Post) {

                                }

                            }).bind(post)
                        }
                    }
                }
            }
        }

        return binding.root
    }
}
package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.FeedItem
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.util.load
import ru.netology.nmedia.BuildConfig
import ru.netology.nmedia.databinding.CardAdBinding
import ru.netology.nmedia.dto.Ad

interface OnInteractionListener {
    fun like(post: Post)
    fun share(post: Post)
    fun remove(post: Post)
    fun edit(post: Post)
    fun video(post: Post)
    fun viewPost(post: Post)
    fun onImage(image: String) {}
}

class PostsAdapter(
    private val onInteractionListener: OnInteractionListener
) : PagingDataAdapter<FeedItem, RecyclerView.ViewHolder>(PostDiffCallback()) {

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is Ad -> R.layout.card_ad
            is Post -> R.layout.card_post
            else -> error("unknown item type")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.card_post -> {
                val binding =
                    CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PostViewHolder(binding, onInteractionListener)
            }

            R.layout.card_ad -> {
                val binding =
                    CardAdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                AdViewHolder(binding)
            }

            else -> error("unknown view type: $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Ad -> (holder as? AdViewHolder)?.bind(item)
            is Post -> (holder as? PostViewHolder)?.bind(item)
            else -> error("unknown item type")
        }
    }
}

class AdViewHolder(
    private val binding: CardAdBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ad: Ad) {
        binding.image.load("${BuildConfig.BASE_URL}/media/${ad.image}")
    }
}


class PostViewHolder(
    private val binding: CardPostBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            val options = RequestOptions().circleCrop()
            val url = "${BuildConfig.BASE_URL}/avatars/${post.authorAvatar}"
            avatar.load(url, options)

            attachment.visibility = View.GONE
            val urlAttachment = "${BuildConfig.BASE_URL}/media/${post.attachment?.url}"
            if (post.attachment != null) {
                attachment.visibility = View.VISIBLE
                attachment.load(urlAttachment)
            } else {
                attachment.visibility = View.GONE
            }

            attachment.setOnClickListener {
                post.attachment?.let { attachment ->
                    onInteractionListener.onImage(attachment.url)
                }
            }

            likeButton.isChecked = post.likedByMe
            likeButton.text = post.likes.toString()
            likeButton.setOnClickListener {
                likeButton.isChecked = !likeButton.isChecked
                onInteractionListener.like(post)
            }

            shareButton.setOnClickListener {
                onInteractionListener.share(post)
            }

            menu.isVisible = post.ownedByMe
            menu.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.menu_options)
                    menu.setGroupVisible(R.id.owned, post.ownedByMe)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.remove -> {
                                onInteractionListener.remove(post)
                                true
                            }

                            R.id.edit -> {
                                onInteractionListener.edit(post)
                                true
                            }

                            else -> false
                        }
                    }
                }.show()
            }
            root.setOnClickListener { onInteractionListener.viewPost(post) }
        }
    }
}


class PostDiffCallback : DiffUtil.ItemCallback<FeedItem>() {
    override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        if (oldItem::class != newItem::class) {
            return false
        }

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        return oldItem == newItem
    }
}
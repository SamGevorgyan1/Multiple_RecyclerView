package com.multiplerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.multiplerecyclerview.R
import com.multiplerecyclerview.model.ImagePost
import com.multiplerecyclerview.model.TextPost
import com.multiplerecyclerview.model.WebViewPost
import com.multiplerecyclerview.utils.Utils

class PostAdapter(val itemclickListener:(Any)->Unit) : RecyclerView.Adapter<PostAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    private val items: MutableList<Any> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_IMAGE_POST -> ImagePostViewHolder(
                layoutInflater.inflate(
                    R.layout.item_image,
                    parent,
                    false
                )
            )
            VIEW_TYPE_TEXT_POST -> TextPostViewHolder(
                layoutInflater.inflate(
                    R.layout.item_text,
                    parent,
                    false
                )
            )
            VIEW_TYPE_WEB_VIEW_POST -> WebPostViewHolder(
                layoutInflater.inflate(
                    R.layout.item_web_view,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("undefined viewType: $viewType in ${this::class.java.simpleName}")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is TextPost -> VIEW_TYPE_TEXT_POST
            is ImagePost -> VIEW_TYPE_IMAGE_POST
            is WebViewPost -> VIEW_TYPE_WEB_VIEW_POST
            else -> UNDEFINED
        }
    }

    fun updateData(items: MutableList<Any>) {
        this.items.clear()
        this.items.addAll(items)

    }


    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: Any)

    }

    inner class ImagePostViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val likeButton = itemView.findViewById<ImageView>(R.id.likeImagePost)
        private val shareButton = itemView.findViewById<ImageView>(R.id.shareImagePost)
        private val imagePost = itemView.findViewById<ImageView>(R.id.imagePost)


init {
    likeButton.setOnClickListener{Utils.likeClicked(context,likeButton) }
    shareButton.setOnClickListener{Utils.shareItem(context)}

}

        override fun bind(item: Any) {
            (item as ImagePost).let {
                Glide.with(context)
                    .load(item.imagePostUrl)
                    .into(imagePost)
            }
        }

    }

    inner class TextPostViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val shareButton = itemView.findViewById<ImageView>(R.id.shareImagePost)
        private val like = itemView.findViewById<ImageView>(R.id.likeImagePost)
        private val textPost = itemView.findViewById<TextView>(R.id.textPost)


        override fun bind(item: Any) {
            (item as TextPost).let {
                textPost.text = item.textPost
            }
        }
    }

    inner class WebPostViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val shareButton = itemView.findViewById<ImageView>(R.id.shareImagePost)
        private val like = itemView.findViewById<ImageView>(R.id.likeImagePost)
        private val webViewImagePost = itemView.findViewById<ImageView>(R.id.web_View_Image_post_id)
        private val webUrlPost = itemView.findViewById<TextView>(R.id.web_view_url_post)
init {
    webUrlPost.setOnClickListener{itemclickListener(items[absoluteAdapterPosition])}
}


        override fun bind(item: Any) {
            (item as WebViewPost).let {
                Glide.with(context).load(item.imageWebView).into(webViewImagePost)
                webUrlPost.text = item.webViewUrl
            }
        }
    }

    companion object {
        private const val UNDEFINED: Int = -1
        private const val VIEW_TYPE_TEXT_POST: Int = 1
        private const val VIEW_TYPE_IMAGE_POST: Int = 2
        private const val VIEW_TYPE_WEB_VIEW_POST: Int = 3

    }

}
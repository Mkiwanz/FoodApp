package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlogPostsAdapter(private val blogPosts: List<BlogPost>) :
    RecyclerView.Adapter<BlogPostsAdapter.BlogPostViewHolder>() {

    class BlogPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.blog_post_title)
        val contentView: TextView = view.findViewById(R.id.blog_post_content)
        val authorView: TextView = view.findViewById(R.id.blog_post_author)
        val dateView: TextView = view.findViewById(R.id.blog_post_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_blog_post, parent, false)
        return BlogPostViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val post = blogPosts[position]
        holder.titleView.text = post.title
        holder.contentView.text = post.content
        holder.authorView.text = post.author
        holder.dateView.text = post.date
    }

    override fun getItemCount() = blogPosts.size
}

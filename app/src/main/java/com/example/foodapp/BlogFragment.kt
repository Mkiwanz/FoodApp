package com.example.foodapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BlogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private val blogPostsList = mutableListOf<BlogPost>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        recyclerView = view.findViewById(R.id.blog_recycler_view)
        fab = view.findViewById(R.id.add_blog_post_fab)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = BlogPostsAdapter(blogPostsList)

        fab.setOnClickListener {
            // Code to add a new blog post
        }

        return view
    }
}

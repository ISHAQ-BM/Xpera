package com.example.xpera.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xpera.R
import com.example.xpera.databinding.FragmentPostBinding
import com.example.xpera.domain.model.Post
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostFragment : Fragment() {

    private var binding: FragmentPostBinding? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPostBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val posts= listOf(Post(1,"Olivia Bennett.",null,"30 minutes","A UI/UX Odyssey from Learner to Leader","My first exposure to UI/UX came through a chat with a friend at a marketing agency. Her stories about blending design and user experience caught my interest. This sparked a curiosity that led me into popular online courses like Udacity's UX Designer Nanodegree",
            listOf("graphic design","leadership","ui/ux")
        ),Post(1,"Olivia Bennett.",null,"30 minutes","A UI/UX Odyssey from Learner to Leader","My first exposure to UI/UX came through a chat with a friend at a marketing agency. Her stories about blending design and user experience caught my interest. This sparked a curiosity that led me into popular online courses like Udacity's UX Designer Nanodegree",
            listOf("graphic design","leadership","ui/ux")
        ),Post(1,"Olivia Bennett.",null,"30 minutes","A UI/UX Odyssey from Learner to Leader","My first exposure to UI/UX came through a chat with a friend at a marketing agency. Her stories about blending design and user experience caught my interest. This sparked a curiosity that led me into popular online courses like Udacity's UX Designer Nanodegree",
            listOf("graphic design","leadership","ui/ux")
        ),Post(1,"Olivia Bennett.",null,"30 minutes","A UI/UX Odyssey from Learner to Leader","My first exposure to UI/UX came through a chat with a friend at a marketing agency. Her stories about blending design and user experience caught my interest. This sparked a curiosity that led me into popular online courses like Udacity's UX Designer Nanodegree",
            listOf("graphic design","leadership","ui/ux")
        ))
        val adapter=PostAdapter()
        binding?.postRecyclerView?.adapter = adapter
        adapter.submitList(posts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }


}
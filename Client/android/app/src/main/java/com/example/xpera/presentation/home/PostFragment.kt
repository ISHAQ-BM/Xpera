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

        val posts= listOf(Post(1,"Wanderlust Journeyer",null,"30 minutes","A Spiritual Retreat in the Himalayas","Embarking on a spiritual retreat in the serene Himalayas was a transformative experience. Surrounded by majestic peaks and tranquil monasteries, I found inner peace and a renewed sense of purpose. The daily meditation sessions and interactions with the local monks left an indelible mark on my soul, and I returned home with a profound sense of clarity and tranquility.",
            listOf("spirituality" ,"retreat ","Himalayas" ,"meditation" ,"innerpeace")
        ),Post(1,"TechGeek24",null,"30 minutes","Building My First Robot","Building my first robot from scratch was an exhilarating journey. From designing the circuitry to programming its functions, every step was a challenge that I eagerly embraced. The moment when my creation came to life, whirring and blinking with lights, was a testament to my hard work and dedication. This project ignited a passion for robotics that continues to drive my pursuits in the field of technology.",
            listOf("technology" ,"robotics" ,"DIY" ,"innovation" ,"engineering")
        ),Post(1,"ArtisticSoul",null,"30 minutes","Painting the Sunset","As an artist, capturing the essence of a breathtaking sunset on canvas has always been a dream of mine. The interplay of vibrant hues and the fleeting nature of light presented a unique challenge. With each stroke of the brush, I sought to convey the ethereal beauty of the moment. The process was both meditative and invigorating, and the finished painting stands as a testament to the fleeting yet eternal nature of natural beauty.",
            listOf("art" ,"painting" ,"sunset" ,"creativity" ,"expression")
        ),Post(1,"EcoWarrior",null,"30 minutes","Volunteering in the Amazon Rainforest","Volunteering in the Amazon Rainforest was a humbling and eye-opening experience. Witnessing the unparalleled biodiversity and the delicate balance of the ecosystem reinforced the urgency of conservation efforts. From planting trees to assisting in wildlife rehabilitation, every task felt like a small yet meaningful contribution to the preservation of this vital natural treasure.",
            listOf("volunteering" ,"conservation" ,"environment")
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
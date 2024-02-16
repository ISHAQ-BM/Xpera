package com.example.xpera.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.xpera.core.fields
import com.example.xpera.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel:HomeViewModel by viewModels()
    private var binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.apply {
            userProfileImage.load(viewModel.currentUser?.photoUrl?.buildUpon()?.scheme("https")?.build())

            userName.text = viewModel.currentUser?.displayName

            userJobTitle.text = viewModel.currentUser?.email

            val postPagerAdapter=PostPagerAdapter(requireActivity())

            postViewPager.adapter=postPagerAdapter

            postTabLayout.let {
                binding?.postViewPager?.let { it1 ->
                    TabLayoutMediator(it, it1){ tab, position ->
                        tab.text= fields[position]
                    }.attach()
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }


}
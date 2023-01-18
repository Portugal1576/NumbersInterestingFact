package com.portugal1576.numbersinterestingfact.ui.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portugal1576.numbersinterestingfact.APP
import com.portugal1576.numbersinterestingfact.R
import com.portugal1576.numbersinterestingfact.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnDelete.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
//            TODO
        }
        binding.btnAdd.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
//            TODO
        }
    }
}
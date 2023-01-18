package com.portugal1576.numbersinterestingfact.ui.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portugal1576.numbersinterestingfact.APP
import com.portugal1576.numbersinterestingfact.R
import com.portugal1576.numbersinterestingfact.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetFact.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment)
//            TODO
        }
        binding.btnRandomFact.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment)
//            TODO
        }
    }
}
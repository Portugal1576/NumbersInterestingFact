package com.portugal1576.numbersinterestingfact.ui.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.portugal1576.numbersinterestingfact.APP
import com.portugal1576.numbersinterestingfact.R
import com.portugal1576.numbersinterestingfact.databinding.FragmentDetailBinding
import com.portugal1576.numbersinterestingfact.model.NumberFact
import com.portugal1576.numbersinterestingfact.ui.screens.MainViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var number: String
    private lateinit var numberFact: String
    private lateinit var deleteResult: NumberFact
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        if (viewModel.numberOfList.value == true) {
            binding.btnAdd.visibility = View.GONE
            binding.btnDelete.visibility = View.VISIBLE
            viewModel.numberFact.observe(activity as LifecycleOwner) {
                deleteResult = it
            }
            viewModel.number.value = deleteResult.number
            viewModel.numberFactResult.value = deleteResult.description
        } else {
            binding.btnAdd.visibility = View.VISIBLE
            binding.btnDelete.visibility = View.GONE
        }

        viewModel.number.observe(activity as LifecycleOwner) {
            viewModel.getNumberFact(it)
        }

        viewModel.numberFactResult.observe(activity as LifecycleOwner) {
            binding.tvNumberDetail.text = it.toString()
            numberFact = it.toString()
            number = it.substringBefore(' ').toString()
            binding.tvNumberFact.text = number
            binding.tvNumberDetail.text = numberFact
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnDelete.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
            detailViewModel.delete(deleteResult) {}
        }
        binding.btnAdd.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
            detailViewModel.insert(NumberFact(number = number, description = numberFact)) {}
        }
    }
}
package com.portugal1576.numbersinterestingfact.ui.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.numbersinterestingfact.APP
import com.portugal1576.numbersinterestingfact.R
import com.portugal1576.numbersinterestingfact.adapter.NumbersAdapter
import com.portugal1576.numbersinterestingfact.databinding.FragmentStartBinding
import com.portugal1576.numbersinterestingfact.model.NumberFact
import com.portugal1576.numbersinterestingfact.ui.screens.MainViewModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var number_et: String
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NumbersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        val startViewModel = ViewModelProvider(this)[StartViewModel::class.java]
        startViewModel.initDatabase()
        recyclerView = binding.recyclerView
        adapter = NumbersAdapter()
        recyclerView.adapter = adapter
        startViewModel.getAllNumbers().observe(viewLifecycleOwner) { listNumbers ->
            adapter.setList(listNumbers.asReversed())
        }
        binding.btnGetFact.setOnClickListener {
            number_et = binding.etNumber.text.toString()
            if (number_et.toIntOrNull() != null) {
                viewModel.number.value = number_et.toInt().toString()
                viewModel.numberOfList.value = false
                APP.navController.navigate(R.id.action_startFragment_to_detailFragment)
            } else Toast.makeText(activity, "Incorrect input", Toast.LENGTH_LONG).show()
        }
        binding.btnRandomFact.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment)
            viewModel.number.value = "random"
            viewModel.numberOfList.value = false
        }
    }

    companion object {

        fun clickFact(numberFact: NumberFact) {
            val mainViewModel = ViewModelProvider(APP)[MainViewModel::class.java]
            mainViewModel.numberFact.value = numberFact
            mainViewModel.numberOfList.value = true
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment)
        }
    }
}
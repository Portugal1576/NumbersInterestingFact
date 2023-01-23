package com.portugal1576.numbersinterestingfact.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.numbersinterestingfact.R
import com.portugal1576.numbersinterestingfact.model.NumberFact
import com.portugal1576.numbersinterestingfact.ui.screens.start.StartFragment
import kotlinx.android.synthetic.main.number_item.view.*


class NumbersAdapter : RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {

    private var listNumbers = emptyList<NumberFact>()


    class NumbersViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return NumbersViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.itemView.tv_number.text = listNumbers[position].number
        holder.itemView.tv_detail.text = listNumbers[position].description
    }

    override fun getItemCount(): Int {
        return listNumbers.size
    }

    override fun onViewAttachedToWindow(holder: NumbersViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickFact(listNumbers[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NumbersViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NumberFact>) {
        listNumbers = list
        notifyDataSetChanged()
    }
}
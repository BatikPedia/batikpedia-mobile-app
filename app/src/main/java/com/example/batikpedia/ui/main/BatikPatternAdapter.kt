package com.example.batikpedia.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ItemRvBinding

class BatikPatternAdapter : RecyclerView.Adapter<BatikPatternAdapter.BatikPatternViewHolder>() {

    private val data = ArrayList<Batik>()

    fun set(users: List<Batik>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCalllback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class BatikPatternViewHolder(val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(batik: Batik) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(batik)
            }
            binding.apply {
                namaBatik.text = batik.name
                asalBatik.text = batik.province
                imageView.setImageResource(R.drawable.ic_batik)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikPatternViewHolder {
        val view = ItemRvBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return BatikPatternViewHolder(view)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: BatikPatternViewHolder, position: Int) {
        holder.bind(data[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}





package com.example.batikpedia.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ItemRvBinding

class BatikScanResultAdapter : RecyclerView.Adapter<BatikScanResultAdapter.BatikScanResultAdapterViewHolder>() {


    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCalllback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class BatikScanResultAdapterViewHolder(val binding: ItemRvBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikScanResultAdapterViewHolder {
        val view = ItemRvBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return BatikScanResultAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = 10


    override fun onBindViewHolder(holder: BatikScanResultAdapterViewHolder, position: Int) {
        val dummyBatik = Batik(name = "Parang", province="Jawa Tengah")
        holder.bind(dummyBatik)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}





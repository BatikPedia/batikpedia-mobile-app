package com.example.batikpedia.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ItemRvBinding

class ProvinceAdapter : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(batik: Batik) {
            binding.apply {
                namaBatik.text = batik.name
                asalBatik.text = batik.province
                imageView.setImageResource(R.drawable.ic_batik)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = ItemRvBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int = 10


    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        val dummyBatik = Batik(name = "Parang", province="Jawa Tengah")
        holder.bind(dummyBatik)
    }
}





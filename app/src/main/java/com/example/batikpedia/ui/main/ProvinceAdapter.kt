package com.example.batikpedia.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.data.model.Provinces
import com.example.batikpedia.databinding.EachItemProvincesBinding
import com.example.batikpedia.databinding.ItemRvBinding

class ProvinceAdapter : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(val binding: EachItemProvincesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(province: Provinces) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(province)
            }
            binding.apply {
                namaProvince.text = province.nama
                imageView.setImageResource(province.image)

            }
        }
    }

    private val data = ArrayList<Provinces>()

    fun set(users: List<Provinces>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCalllback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = EachItemProvincesBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int = 3


    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        val provinces = arrayOf(Provinces("D.I Yogyakarta", R.drawable.yogyakarta), Provinces("Jawa Tengah", R.drawable.jawatengah), Provinces("Jawa Barat", R.drawable.jawabarat))
        holder.bind(provinces[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Provinces)
    }
}





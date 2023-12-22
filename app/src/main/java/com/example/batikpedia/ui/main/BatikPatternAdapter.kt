package com.example.batikpedia.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ItemRvBinding

class BatikPatternAdapter : RecyclerView.Adapter<BatikPatternAdapter.BatikPatternViewHolder>() {

    private val data = ArrayList<Batik>()

//    val gambarBatik = listOf(R.drawable.batik_kawung, R.drawable.batik_megamendung, R.drawable.batik_parang, R.drawable.batik_sekarjagad, R.drawable.batik_tambal)

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
                Glide.with(itemView)
                    .load(batik.photos?.first())
                    .centerCrop()
                    .into(imageView)
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





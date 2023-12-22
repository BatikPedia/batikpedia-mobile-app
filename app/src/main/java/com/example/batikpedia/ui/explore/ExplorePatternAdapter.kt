package com.example.batikpedia.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.EachBatikPatternBinding

class ExplorePatternAdapter : RecyclerView.Adapter<ExplorePatternAdapter.ExplorePatternViewHolder>() {

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

    inner class ExplorePatternViewHolder(val binding: EachBatikPatternBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorePatternViewHolder {
        val view = EachBatikPatternBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ExplorePatternViewHolder(view)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ExplorePatternViewHolder, position: Int) {
        holder.bind(data[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}
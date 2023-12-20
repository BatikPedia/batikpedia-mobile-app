package com.example.batikpedia.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.EachScanResultItemBinding
import com.example.batikpedia.databinding.ItemRvBinding

class ExploreScanAdapter : RecyclerView.Adapter<ExploreScanAdapter.ExploreScanViewHolder>() {

    private val data = ArrayList<Batik>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCalllback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ExploreScanViewHolder(val binding: EachScanResultItemBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreScanViewHolder {
        val view = EachScanResultItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ExploreScanViewHolder(view)
    }

    override fun getItemCount(): Int = 10


    override fun onBindViewHolder(holder: ExploreScanViewHolder, position: Int) {
        val dummyBatik = Batik(name = "Parang", province="Jawa Tengah")
        holder.bind(dummyBatik)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}
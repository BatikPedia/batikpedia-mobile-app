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
                imageView.setImageResource(R.drawable.batik_megamendung)
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

    override fun getItemCount(): Int = 1


    override fun onBindViewHolder(holder: BatikScanResultAdapterViewHolder, position: Int) {
        val dummyBatik = Batik(name = "Mega Mendung", province="Jawa Barat", history = "Batik Mega Mendung, menurut sejarah, berasal dari perpaduan budaya antara budaya Sunan Gunung Jati yang dulu ikut menyebarkan agama Islam di wilayah Cirebon dan bangsa Tionghoa yang dipimpin oleh Ratu Ong Tien. Pernikahan kedua tokoh ini menciptakan perpaduan budaya dari keduanya. Para seniman batik keraton lalu menuangkan budaya dan tradisi Tiongkok ke dalam motif batik yang dibuat saat itu. Di Tiongkok awan menjadi salah satu motif yang umum terdapat di karya seni, hal ini ikut menjadi inspirasi bagi seniman batik keraton di Cirebon")
        holder.bind(dummyBatik)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}





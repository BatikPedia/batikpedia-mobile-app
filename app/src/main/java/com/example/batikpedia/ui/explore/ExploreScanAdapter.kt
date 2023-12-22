package com.example.batikpedia.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.EachScanResultItemBinding
import com.example.batikpedia.ui.main.BatikScanResultAdapter

class ExploreScanAdapter : RecyclerView.Adapter<ExploreScanAdapter.ExploreScanViewHolder>() {

    private val data = ArrayList<Batik>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun set(users: List<Batik>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }
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
                imageView.setImageResource(R.drawable.batik_megamendung)
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


    override fun onBindViewHolder(holder: ExploreScanAdapter.ExploreScanViewHolder, position: Int) {
        val dummyBatik = Batik(name = "Mega Mendung", province="Jawa Barat", history = "Batik Mega Mendung, menurut sejarah, berasal dari perpaduan budaya antara budaya Sunan Gunung Jati yang dulu ikut menyebarkan agama Islam di wilayah Cirebon dan bangsa Tionghoa yang dipimpin oleh Ratu Ong Tien. Pernikahan kedua tokoh ini menciptakan perpaduan budaya dari keduanya. Para seniman batik keraton lalu menuangkan budaya dan tradisi Tiongkok ke dalam motif batik yang dibuat saat itu. Di Tiongkok awan menjadi salah satu motif yang umum terdapat di karya seni, hal ini ikut menjadi inspirasi bagi seniman batik keraton di Cirebon")
        holder.bind(dummyBatik)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}
package com.example.batikpedia.ui.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ActivityExploreScanBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.main.BatikScanResultAdapter

class ExploreScanActivity : AppCompatActivity() {

    private lateinit var binding : ActivityExploreScanBinding
    private lateinit var adapter: ExploreScanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExploreScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ExploreScanAdapter()
        adapter.setOnItemClickCalllback(object : ExploreScanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Batik) {
                Intent(this@ExploreScanActivity, DetailBatikActivity::class.java).also {
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
                    startActivity(it)
                }
            }
        })
//
//        binding.apply {
//            rvScanresult.layoutManager = LinearLayoutManager(this@ExploreScanActivity)
//            rvScanresult.setHasFixedSize(true)
//            rvScanresult.adapter = adapter
//        }
    }

    companion object {

    }
}
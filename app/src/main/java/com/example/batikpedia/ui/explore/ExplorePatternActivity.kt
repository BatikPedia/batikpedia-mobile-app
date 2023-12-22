package com.example.batikpedia.ui.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ActivityExplorePatternBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.main.BatikPatternAdapter
import com.example.batikpedia.ui.main.BatikViewModel

class ExplorePatternActivity : AppCompatActivity() {

     private lateinit var binding: ActivityExplorePatternBinding
     private lateinit var adapter: ExplorePatternAdapter
     private lateinit var viewModel: BatikViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplorePatternBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ExplorePatternAdapter()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(BatikViewModel::class.java)
        viewModel.setBatikPattern()

        binding.rvBatikpattern.layoutManager = LinearLayoutManager(this@ExplorePatternActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvBatikpattern.setHasFixedSize(true)
        binding.rvBatikpattern.adapter = adapter

        adapter.setOnItemClickCalllback(object :
            ExplorePatternAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Batik) {
                Intent(this@ExplorePatternActivity, DetailBatikActivity::class.java).also {
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_DESC, data.history)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PROV, data.province)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PHOTO, data.photos?.first())
                    startActivity(it)
                }
            }

        })

        viewModel.getBatik().observe(this) {
            if (it != null) {
                adapter.set(it)
                adapter.notifyDataSetChanged()
            }
        }


    }
}
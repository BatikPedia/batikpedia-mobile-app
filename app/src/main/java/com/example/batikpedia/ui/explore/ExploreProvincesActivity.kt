package com.example.batikpedia.ui.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ActivityExploreProvincesBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.main.ProvincesViewModel

class ExploreProvincesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExploreProvincesBinding
    private lateinit var viewModel: ProvincesViewModel
    private lateinit var adapterProvince: ExploreProvincesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreProvincesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val namaProv = intent.getStringExtra(EXTRA_PROVINCE_NAME)
        adapterProvince = ExploreProvincesAdapter()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProvincesViewModel::class.java)
        viewModel.setBatikPattern(namaProv.orEmpty())

        adapterProvince.setOnItemClickCalllback(object : ExploreProvincesAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Batik) {
                Intent(this@ExploreProvincesActivity, DetailBatikActivity::class.java).also {
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_DESC, data.history)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PROV, data.province)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PHOTO, data.photos?.first())
                    startActivity(it)
                }
            }
        })

        viewModel.getProvinces().observe(this) {
            if (it != null) {
                adapterProvince.set(it)
                adapterProvince.notifyDataSetChanged()
            }
        }

        binding.rvBatikpattern.apply {
            layoutManager = LinearLayoutManager(this@ExploreProvincesActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterProvince
        }
    }

    companion object {
        const val EXTRA_PROVINCE_NAME = "extra_province_name"
    }
}
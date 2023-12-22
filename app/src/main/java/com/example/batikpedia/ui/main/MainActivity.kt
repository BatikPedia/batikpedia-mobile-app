package com.example.batikpedia.ui.main

import CameraFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.databinding.ActivityMainBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.explore.ExplorePatternActivity
import com.example.batikpedia.ui.explore.ExplorePatternAdapter
import com.example.batikpedia.ui.explore.ExploreScanActivity
import com.example.batikpedia.ui.fragment.HomeFragment
import com.example.batikpedia.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapterScan: BatikScanResultAdapter
    private lateinit var adapterPattern : BatikPatternAdapter
//    private lateinit var adapterProvinces : ProvinceAdapter

    private lateinit var viewModelBatikPattern: BatikViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.camera -> replaceFragment(CameraFragment())

                else ->{
                }
            }
            true
        }


//        //Bagian Recycle View Scan Result
//
//        adapterScan = BatikScanResultAdapter()
//        adapterScan.setOnItemClickCalllback(object : BatikScanResultAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Batik) {
//                Intent(this@MainActivity, DetailBatikActivity::class.java).also {
//                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
//                    startActivity(it)
//                }
//            }
//        })
//
//        binding.apply {
//            rvBatikresult.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//            rvBatikresult.setHasFixedSize(true)
//            rvBatikresult.adapter = adapterScan
//        }
//
//        //Bagian Recycle View Batik Pattern
//
//        adapterPattern = BatikPatternAdapter()
//        viewModelBatikPattern = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        ).get(BatikViewModel::class.java)
//        viewModelBatikPattern.setBatikPattern()
//
//
//        adapterPattern.setOnItemClickCalllback(object :
//            BatikPatternAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Batik) {
//                Intent(this@MainActivity, DetailBatikActivity::class.java).also {
//                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
//                    startActivity(it)
//                }
//            }
//
//        })
//
//        viewModelBatikPattern.getGitHubUsers().observe(this) {
//            if (it != null) {
//                adapterPattern.set(it)
//                adapterPattern.notifyDataSetChanged()
//            }
//        }
//
//        binding.apply {
//            rvBatikpattern.layoutManager =
//                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//            rvBatikpattern.setHasFixedSize(true)
//            rvBatikpattern.adapter = adapterPattern
//        }
//
//
//
//        //Bagian Recycle View Provinces
//
////        adapterProvinces = ProvinceAdapter()
//        binding.apply {
//            rvProvinces.layoutManager =
//                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//            rvProvinces.setHasFixedSize(true)
//            rvProvinces.adapter = adapterScan
//        }
//
//        binding.apply {
//            moreScanResult.setOnClickListener {
//                Intent(this@MainActivity, ExploreScanActivity::class.java).also {
//                    startActivity(it)
//                }
//            }
//            moreBatikPattern.setOnClickListener {
//                Intent(this@MainActivity, ExplorePatternActivity::class.java).also {
//                    startActivity(it)
//                }
//            }
//            morePronvices.setOnClickListener {
//                Intent(this@MainActivity, ExploreScanActivity::class.java).also {
//                    startActivity(it)
//                }
//            }
//        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }

}
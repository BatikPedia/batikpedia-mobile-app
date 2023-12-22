package com.example.batikpedia.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.data.model.Provinces
import com.example.batikpedia.databinding.FragmentHomeBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.explore.ExplorePatternActivity
import com.example.batikpedia.ui.explore.ExploreProvincesActivity
import com.example.batikpedia.ui.explore.ExploreScanActivity
import com.example.batikpedia.ui.main.BatikPatternAdapter
import com.example.batikpedia.ui.main.BatikScanResultAdapter
import com.example.batikpedia.ui.main.BatikViewModel
import com.example.batikpedia.ui.main.ProvinceAdapter
import com.example.batikpedia.ui.main.ProvincesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterScan: BatikScanResultAdapter
    private lateinit var adapterPattern: BatikPatternAdapter
    private lateinit var adapterProvinces: ProvinceAdapter
    private lateinit var viewModelBatikPattern: BatikViewModel
    private lateinit var viewModelProvinces: ProvincesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize adapters and view models here

        // Bagian Recycle View Scan Result
        adapterScan = BatikScanResultAdapter()
        adapterScan.setOnItemClickCalllback(object : BatikScanResultAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Batik) {
                Intent(requireContext(), DetailBatikActivity::class.java).also {
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_DESC, data.history)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PROV, data.province)
                    startActivity(it)
                }
            }
        })

        binding.rvBatikresult.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = adapterScan
        }

        // Bagian Recycle View Batik Pattern
        adapterPattern = BatikPatternAdapter()
        viewModelBatikPattern = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(BatikViewModel::class.java)
        viewModelBatikPattern.setBatikPattern()

        adapterPattern.setOnItemClickCalllback(object : BatikPatternAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Batik) {
                Intent(requireContext(), DetailBatikActivity::class.java).also {
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_NAME, data.name)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_DESC, data.history)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PROV, data.province)
                    it.putExtra(DetailBatikActivity.EXTRA_BATIK_PHOTO, data.photos?.first())
                    startActivity(it)
                }
            }
        })

        viewModelBatikPattern.getBatik().observe(viewLifecycleOwner) {
            if (it != null) {
                adapterPattern.set(it)
                adapterPattern.notifyDataSetChanged()
            }
        }

        binding.rvBatikpattern.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = adapterPattern
        }

        // Bagian Recycle View Provinces
        adapterProvinces = ProvinceAdapter()
        viewModelProvinces = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProvincesViewModel::class.java)


        adapterProvinces.setOnItemClickCalllback(object : ProvinceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Provinces) {
                viewModelProvinces.setBatikPattern(data.nama.orEmpty())
                Intent(requireContext(), ExploreProvincesActivity::class.java).also {
                    it.putExtra(ExploreProvincesActivity.EXTRA_PROVINCE_NAME, data.nama)
                    startActivity(it)
                }
            }
        })


        binding.rvProvinces.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = adapterProvinces
        }


        binding.moreScanResult.setOnClickListener {
            Intent(requireContext(), ExploreScanActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.moreBatikPattern.setOnClickListener {
            Intent(requireContext(), ExplorePatternActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.morePronvices.setOnClickListener {
            Intent(requireContext(), ExploreScanActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
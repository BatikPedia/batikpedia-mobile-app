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
import com.example.batikpedia.databinding.FragmentHomeBinding
import com.example.batikpedia.databinding.FragmentProfileBinding
import com.example.batikpedia.ui.detail.DetailBatikActivity
import com.example.batikpedia.ui.explore.ExplorePatternActivity
import com.example.batikpedia.ui.explore.ExploreScanActivity
import com.example.batikpedia.ui.main.BatikPatternAdapter
import com.example.batikpedia.ui.main.BatikScanResultAdapter
import com.example.batikpedia.ui.main.BatikViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapterScan: BatikScanResultAdapter
    private lateinit var adapterPattern: BatikPatternAdapter
    private lateinit var viewModelBatikPattern: BatikViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize adapters and view models here

        binding.imageView.setImageResource(R.drawable.baseline_person_24)
    }
}
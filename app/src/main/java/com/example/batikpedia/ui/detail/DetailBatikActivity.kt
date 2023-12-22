package com.example.batikpedia.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.batikpedia.databinding.DetailBatikActivityBinding

class DetailBatikActivity : AppCompatActivity() {



    private lateinit var binding: DetailBatikActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailBatikActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra(EXTRA_BATIK_NAME)
        val desc = intent.getStringExtra(EXTRA_BATIK_DESC)
        val prov = intent.getStringExtra(EXTRA_BATIK_PROV)
        val photo = intent.getStringExtra(EXTRA_BATIK_PHOTO)
        val bundle = Bundle()
        bundle.putString(EXTRA_BATIK_NAME, nama)

        binding.apply {
            detailNamaBatik.text = nama
            detailAsalBatik.text = prov
            detaildeskBatik.text = desc
            Glide.with(this@DetailBatikActivity)
                .load(photo)
                .centerCrop()
                .into(binding.imageView)
        }




//        if (username != null) {
//            viewModel.fetchGitHubUserDetail(username)
//        }
//        viewModel.getGitHubUserDetail().observe(this) {
//            if (it != null) {
//                binding.apply {
//                    binding.progressBarPage.visibility = View.GONE
//                    tvName.text = it.name
//                    tvUsername.text = it.login
//                    tvFollowers.text = "${it.followers}"
//                    tvFollowing.text = "${it.following}"
//                    Glide.with(this@DetailGitHubUserActivity).load(it.avatar_url)
//                        .transition(DrawableTransitionOptions.withCrossFade()).centerCrop()
//                        .into(ivProfilePic)
//                }
//            }
//        }


    }

    companion object {
        const val EXTRA_BATIK_NAME = "intent_batik_name"
        const val EXTRA_BATIK_PROV = "intent_batik_prov"
        const val EXTRA_BATIK_DESC = "intent_batik_desc"
        const val EXTRA_BATIK_PHOTO = "intent_batik_photo"
    }
}
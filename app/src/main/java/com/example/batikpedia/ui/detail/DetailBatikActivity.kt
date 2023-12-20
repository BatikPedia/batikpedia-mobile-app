package com.example.batikpedia.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

        val username = intent.getStringExtra(EXTRA_BATIK_NAME)
        val bundle = Bundle()
        bundle.putString(EXTRA_BATIK_NAME, username)

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
        const val EXTRA_BATIK_NAME = "intent_batik"
    }
}
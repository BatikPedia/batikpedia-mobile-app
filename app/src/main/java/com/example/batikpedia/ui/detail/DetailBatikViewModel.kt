package com.example.batikpedia.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailBatikViewModel : ViewModel() {

    private val _batik = MutableLiveData<Batik>()
    val batik: LiveData<Batik> get() = _batik

    fun setBatikPattern(pattern: String){
        ApiConfig.apiInstance.getBatikPattern(pattern).enqueue(object : Callback<Batik> {
            override fun onResponse(call: Call<Batik>, response: Response<Batik>) {
                if (response.isSuccessful) {
                    _batik.postValue(response.body())
                }
                }

            override fun onFailure(call: Call<Batik>, t: Throwable) {
                Log.d("Gagal", t.message.toString())
            }

        })
    }

    fun getGitHubUsers(): LiveData<Batik> {
        return batik
    }
}
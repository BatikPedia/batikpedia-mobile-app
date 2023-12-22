package com.example.batikpedia.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.data.model.BatikResponse
import com.example.batikpedia.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatikViewModel : ViewModel() {

    val listBatik = MutableLiveData<ArrayList<Batik>>()

//    private val _batik = MutableLiveData<Batik>()
//    val batik: LiveData<Batik> get() = _batik

    fun setBatikPattern(){
        ApiConfig.apiInstance.getAllBatikPattern().enqueue(object : Callback<BatikResponse>{
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    listBatik.postValue(response.body()?.data)
                    Log.d("ListBatik", response.body().toString())
                    Log.d("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "SUCCESS")
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Log.d("Gagal", t.message.toString())
            }

        })
    }

    fun getBatik(): LiveData<ArrayList<Batik>> {
        Log.d("List Batik", listBatik.toString())
        return listBatik
    }
}
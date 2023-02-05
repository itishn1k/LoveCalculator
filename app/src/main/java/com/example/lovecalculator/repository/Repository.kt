package com.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()
        api.calculateLove(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            liveLove.postValue(it)
                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }
            })
        return liveLove
    }
}
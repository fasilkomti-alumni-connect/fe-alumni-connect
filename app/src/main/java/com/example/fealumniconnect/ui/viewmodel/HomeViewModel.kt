package com.example.fealumniconnect.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fealumniconnect.data.News
import com.example.fealumniconnect.data.DataItem
import com.example.fealumniconnect.Network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _newsData : MutableStateFlow<List<DataItem>> = MutableStateFlow(listOf())
    val newsData : StateFlow<List<DataItem>> = _newsData

//    init{
//        retrieveNewsData()
//    }
    private fun retrieveNewsData(){
        viewModelScope.launch {
            val call : Call<News> = RetrofitInstance.apiService.getAllNews()
            call.enqueue(object : Callback<News> {
                override fun onResponse(
                    call: Call<News>,
                    response: Response<News>
                ) {
                    if(response.isSuccessful){
                        val responseData: List<DataItem>? = response.body()?.data
                        if (responseData != null) {
                            _newsData.value = responseData.filter { dataItem -> dataItem.namaInfo != null }
                        }
//                        if(responseData != null){
//                            _newsData.value = responseData.filter { dataItem ->  dataItem.role?.displayName != null }
//                        }
                    }
                }
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Failed Retrieve", "Network Error")
                }
            })
        }
    }
}
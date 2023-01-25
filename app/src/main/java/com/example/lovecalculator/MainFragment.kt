package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnHeart.setOnClickListener {
                RetrofitService().api.calculateLove(
                    edFirst.text.toString(),
                    etSecond.text.toString()
                ).enqueue(object : Callback<LoveModel> {

                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("ololo", "onResponse: ${response.body()?.result}")
                            response.body()
                            val bundle = Bundle()
                            bundle.putSerializable("response",response.body())
                            findNavController().navigate(R.id.resultFragment, bundle)
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onResponse: ${t.message}")
                    }
                })
            }
        }
    }
}
package com.example.lovecalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result: LoveModel = arguments?.getSerializable("response") as LoveModel
        with(binding) {
            tvFirst.text = result.firstName
            tvSecond.text = result.secondName
            tvPercent.text = result.percentage
            tvResult.text = result.result
        }
    }

}
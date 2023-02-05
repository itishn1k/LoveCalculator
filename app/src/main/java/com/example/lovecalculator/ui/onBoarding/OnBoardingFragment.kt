package com.example.lovecalculator.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.data.Pref
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(requireContext(), this::onClick)
        binding.viewPager.adapter = adapter
        attachIndicator()
    }

    private fun onClick() {
        pref = Pref(requireContext())
        pref.setOnBoardingSeen()
        findNavController().navigate(R.id.mainFragment)
    }

    //circle indicator
    private fun attachIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewpager = binding.viewPager
        indicator.setViewPager(viewpager)
    }

}
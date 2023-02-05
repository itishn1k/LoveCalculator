package com.example.lovecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculator.data.Pref
import com.example.lovecalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var pref: Pref

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        navController = findNavController(R.id.nav_host_fragment)

        pref.setOnBoardingSeen()
        if (pref.isOnBoardingSeen()) {
            navController.navigate(R.id.mainFragment)
        }
    }

}

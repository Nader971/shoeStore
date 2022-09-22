package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        val navController = this.findNavController((R.id.myNavHostFragment))
        appBarConfiguration = AppBarConfiguration(navController.graph)


    }

    override fun onNavigateUp(): Boolean {
        this.findNavController((R.id.myNavHostFragment))
        return super.onNavigateUp()
    }
}

package com.seohyunni.cyphersscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seohyunni.cyphersscanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
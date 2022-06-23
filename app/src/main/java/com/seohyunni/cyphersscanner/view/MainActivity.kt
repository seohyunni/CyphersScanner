package com.seohyunni.cyphersscanner

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.seohyunni.cyphersscanner.databinding.ActivityMainBinding
import com.seohyunni.cyphersscanner.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //main tool bar setting
        setSupportActionBar(mainBinding.mainToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)

        mainBinding.lifecycleOwner = this

        mainBinding.searchRecordBtn.setOnClickListener {
            val intent = Intent(this,SearchRecordActivity::class.java)
            startActivity(intent)
        }

        mainBinding.searchRankCharacterBtn.setOnClickListener {
            val intent = Intent(this, SearchCharacterRankActivity::class.java)
            startActivity(intent)
        }

        mainBinding.searchRankBtn.setOnClickListener {
            val intent = Intent(this, SearchRankActivity::class.java)
            startActivity(intent)
        }

        mainBinding.noticeBtn.setOnClickListener {
            val intent = Intent(this, NoticeActivity::class.java)
            startActivity(intent)
        }

        mainBinding.rinkHomepage.setOnClickListener{
            rinkHomepage()
        }

        mainBinding.rinkQuestion.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun rinkHomepage(){
        val webIntent: Intent = Uri.parse("https://cyphers.nexon.com/cyphers/main").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        startActivity(webIntent)
    }
}
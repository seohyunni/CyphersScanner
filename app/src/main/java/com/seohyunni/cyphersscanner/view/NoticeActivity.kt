package com.seohyunni.cyphersscanner.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.seohyunni.cyphersscanner.R
import com.seohyunni.cyphersscanner.databinding.ActivityNoticeBinding

class NoticeActivity: AppCompatActivity()  {

    private lateinit var dataBinding: ActivityNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_notice)

        dataBinding.expandable.secondLayout.setOnClickListener {
            dataBinding.expandable.collapse()
        }

        dataBinding.expandable.parentLayout.setOnClickListener {
            if(dataBinding.expandable.isExpanded){
                dataBinding.expandable.collapse()
            } else{
                dataBinding.expandable.expand()
            }
        }

        dataBinding.backButton.setOnClickListener {
            finish()
        }
    }
}
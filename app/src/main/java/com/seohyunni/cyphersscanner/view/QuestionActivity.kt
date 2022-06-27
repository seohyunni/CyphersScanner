package com.seohyunni.cyphersscanner.view

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.seohyunni.cyphersscanner.R
import com.seohyunni.cyphersscanner.databinding.ActivityQuestionBinding


class QuestionActivity: AppCompatActivity()  {
    private lateinit var dataBinding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_question)

        dataBinding.backButton.setOnClickListener {
            finish()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode){
            KeyEvent.KEYCODE_BACK -> finish()
            else -> return super.onKeyDown(keyCode, event)
        }
        return super.onKeyDown(keyCode, event)
    }
}
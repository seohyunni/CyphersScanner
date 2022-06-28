package com.seohyunni.cyphersscanner.view

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.seohyunni.cyphersscanner.R
import com.seohyunni.cyphersscanner.databinding.ActivitySearchRecordBinding
import com.seohyunni.cyphersscanner.model.InterfaceAPI
import com.seohyunni.cyphersscanner.model.Players
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRecordActivity : AppCompatActivity()  {

    private lateinit var dataBinding: ActivitySearchRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_search_record)

        setSupportActionBar(dataBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)

        dataBinding.lifecycleOwner = this

        dataBinding.searchView.isSubmitButtonEnabled = true

        dataBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //검색 버튼 누를 때
                if(query == ""){
                    val emptySnackbar = Snackbar.make(dataBinding.searchRecordLayout, R.string.search_nickname_empty, Snackbar.LENGTH_SHORT)
                    emptySnackbar.show()
                } else{
                    searchRecord(query!!)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //검색창 글자 바뀔 때마다
                TODO("Not yet implemented")
            }

        })
    }

    override fun onBackPressed() {
        if(!dataBinding.searchView.isIconified){
            dataBinding.searchView.isIconified
        } else{
            finish()
        }
    }

    private fun searchRecord(nickname:String){
        val request = InterfaceAPI.create().searchPlayer(nickname,null)
        request.enqueue(object: Callback<Players>{
            override fun onResponse(call: Call<Players>, response: Response<Players>) {
                searchRecordResult(response.body()!!.playerId, nickname, response.body()!!.grade)
            }

            override fun onFailure(call: Call<Players>, t: Throwable) {
                val errorSnackbar = Snackbar.make(dataBinding.searchRecordLayout, R.string.search_error, Snackbar.LENGTH_SHORT)
                errorSnackbar.show()
            }
        })
    }

    private fun searchRecordResult(playerId:String, nickname: String, grade:Int){

    }
}
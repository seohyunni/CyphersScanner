package com.seohyunni.cyphersscanner.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.seohyunni.cyphersscanner.R
import com.seohyunni.cyphersscanner.databinding.ActivitySearchRecordBinding
import com.seohyunni.cyphersscanner.model.InterfaceAPI
import com.seohyunni.cyphersscanner.model.PlayerInfo
import com.seohyunni.cyphersscanner.model.PlayerMatch
import com.seohyunni.cyphersscanner.model.Players
import com.seohyunni.cyphersscanner.view.adapter.SearchRecordAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRecordActivity : AppCompatActivity()  {

    private lateinit var dataBinding: ActivitySearchRecordBinding
    private lateinit var recordAdapter: SearchRecordAdapter

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
                if(response.isSuccessful){
                    Log.d("test","searchRecord is successful")
                    if(response.body()!!.nickname.isEmpty()){
                        dataBinding.playerNotFound.visibility = View.VISIBLE
                    } else{
                        searchPlayerResult(response.body()!!.playerId, nickname, response.body()!!.grade)
                    }
                } else{
                    dataBinding.playerNotFound.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<Players>, t: Throwable) {
                val errorSnackbar = Snackbar.make(dataBinding.searchRecordLayout, R.string.search_error, Snackbar.LENGTH_SHORT)
                errorSnackbar.show()
            }
        })
    }

    private fun searchPlayerResult(playerId:String, nickname: String, grade:Int){
        dataBinding.resultNickname.text = nickname
        dataBinding.resultGrade.text = "${grade}급"

        val request = InterfaceAPI.create().searchPlayerInfo(playerId)
        request.enqueue(object: Callback<PlayerInfo>{
            override fun onResponse(call: Call<PlayerInfo>, response: Response<PlayerInfo>) {
                dataBinding.resultClan.text = response.body()!!.clanName
                searchRecordResult(playerId)
            }

            override fun onFailure(call: Call<PlayerInfo>, t: Throwable) {
                val errorSnackbar = Snackbar.make(dataBinding.searchRecordLayout, R.string.search_error, Snackbar.LENGTH_SHORT)
                errorSnackbar.show()
            }
        })
    }

    private fun searchRecordResult(playerId: String){
        val request = InterfaceAPI.create().searchMatching(playerId,"normal","","",100,"")
        request.enqueue(object: Callback<PlayerMatch>{
            override fun onResponse(call: Call<PlayerMatch>, response: Response<PlayerMatch>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<PlayerMatch>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
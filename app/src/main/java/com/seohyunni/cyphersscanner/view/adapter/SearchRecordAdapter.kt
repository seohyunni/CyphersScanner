package com.seohyunni.cyphersscanner.view.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.seohyunni.cyphersscanner.R
import com.seohyunni.cyphersscanner.model.PlayerMatch

class SearchRecordAdapter(): RecyclerView.Adapter<SearchRecordHolder>(){
    private var items: List<PlayerMatch> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecordHolder = SearchRecordHolder(parent)

    override fun onBindViewHolder(holder: SearchRecordHolder, position: Int) {
        with(holder){
            characterImage.loadUrl("https://img-api.neople.co.kr/cy/characters/${items[position].play.characterId}")
            playDate.text = items[position].matches.date.toString()
            mapInfo.text = items[position].matches.rows[position].map.name
            characterLevel.text = items[position].play.level.toString()
            characterName.text = items[position].play.characterName
            characterKDA.text =  "${items[position].play.killCount}킬 ${items[position].play.assistCount}어시 ${items[position].play.deathCount}데스"
        }
//        holder.itemView.setOnClickListener {
//
//        }
    }

    fun setItems(value:List<PlayerMatch>){
        items = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = if(items.isEmpty()) 0 else items.size
}

class SearchRecordHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_record, parent, false)) {

    val characterImage = itemView.findViewById<WebView>(R.id.character_img)
    val playDate = itemView.findViewById<TextView>(R.id.play_date)
    val mapInfo = itemView.findViewById<TextView>(R.id.map_info)
    val characterLevel = itemView.findViewById<TextView>(R.id.character_level)
    val characterName = itemView.findViewById<TextView>(R.id.character_name)
    val characterKDA = itemView.findViewById<TextView>(R.id.character_kda)
}
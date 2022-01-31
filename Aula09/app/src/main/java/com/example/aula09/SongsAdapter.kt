package com.example.aula09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongsAdapter(
    private val list: List<Song>,
    private val onItemClickListener: ItemClickListener
): RecyclerView.Adapter<SongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val song = list[position]
        holder.bind(song, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size

}

class SongsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(song: Song, onItemClickListener: ItemClickListener) {
        val songDurationMin = kotlin.math.floor((song.duration / 60).toDouble()).toInt()
        val songDurationSec = song.duration % 60
        val songDurationText = "$songDurationMin:$songDurationSec"
        view.apply {
            setOnClickListener { onItemClickListener.onClick(song) }
            findViewById<TextView>(R.id.songName).text = song.name
            findViewById<TextView>(R.id.songDuration).text = songDurationText
        }
    }

}

fun interface ItemClickListener {
    fun onClick(song: Song)
}
package com.example.aula09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SongsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        val onClickListener = ItemClickListener { song ->
            Toast.makeText(this, "'${song.name}' clicked", Toast.LENGTH_SHORT).show()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = SongsAdapter(SongsData().loadItems(), onClickListener)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
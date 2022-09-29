package com.example.islami.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constans
import com.example.islami.R


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        // back Button
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        titleTextView = findViewById(R.id.title_text_view)

        initRecyclerView()

        val suraName: String = intent.getStringExtra(Constans.Extra_sura_name) as String
        val suraPos: Int = intent.getIntExtra(Constans.Extra_sura_position, -1)

        titleTextView.setText(suraName)

        readSuraFile(suraPos)

    }

    fun initRecyclerView() {

        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }

    fun readSuraFile(pos: Int) {

        val fileName = "${pos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }

        val verses: List<String> = fileContent.split("\n")

        // show the list in recyclerView
        adapter.changeDate(verses)
    }

}
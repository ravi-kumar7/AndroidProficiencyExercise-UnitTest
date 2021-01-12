package com.android.assignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.R
import com.android.assignment.data.DummyData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factAdapter = FactAdapter(DummyData.getData())
        findViewById<RecyclerView>(R.id.rv_facts).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = factAdapter
        }
    }
}
package com.android.assignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.assignment.R
import com.android.assignment.data.model.Fact
import com.android.assignment.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var factAdapter:FactAdapter
    private val factsList: ArrayList<Fact> = ArrayList()
    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factAdapter = FactAdapter(factsList)
        binding.rvFacts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = factAdapter
        }
        viewModel.facts.observe(this, {
            it?.let {
                factsList.clear()
                factsList.addAll(it)
                factAdapter.notifyDataSetChanged()
            }
        })
    }
}
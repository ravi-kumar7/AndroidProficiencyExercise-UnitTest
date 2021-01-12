package com.android.assignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.assignment.data.model.Fact
import com.android.assignment.data.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(repository:Repository): ViewModel() {

    val facts:LiveData<ArrayList<Fact>> = MutableLiveData(repository.getData())

}
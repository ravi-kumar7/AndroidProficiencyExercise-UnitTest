package com.android.assignment.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.android.assignment.R
import com.android.assignment.data.Repository
import com.android.assignment.data.model.Fact
import com.android.assignment.data.model.State
import com.android.assignment.ui.MainViewModel
import com.android.assignment.util.DummyData
import com.android.assignment.util.NetworkHelper
import com.android.assignment.util.TestSchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {


    @get:Rule
    val rule =  InstantTaskExecutorRule()

    private lateinit var repository: Repository

    @Mock
    private lateinit var resultObserver: Observer<State>

    private lateinit var testScheduler: TestScheduler

    private lateinit var viewModel: MainViewModel

    private lateinit var networkHelper : NetworkHelper

    @Before
    fun setup(){
        val compositeDisposable = CompositeDisposable()
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
        networkHelper = mock(NetworkHelper::class.java)
        repository = mock(Repository::class.java)
        viewModel = MainViewModel(compositeDisposable,repository,testSchedulerProvider, networkHelper)
        viewModel.facts.observeForever(resultObserver)
    }

    @Test
    fun givenNoNetwork_whenFetchingFacts_shouldReturnNetworkError(){
        doReturn(Observable.just(false))
            .`when`(networkHelper).checkNetworkAvailability()
        viewModel.loadFacts()
        testScheduler.triggerActions()
        assert(viewModel.facts.value == State.Error(R.string.network_error))
    }

    @Test
    fun givenNetwork_whenFetchingFacts_shouldThrowError(){
        doReturn(Observable.just(true))
            .`when`(networkHelper).checkNetworkAvailability()
        doReturn(Single.error<List<Fact>>(Exception("Dummy Exception")))
            .`when`(repository).getData()
        viewModel.loadFacts()
        testScheduler.triggerActions()
        assert(viewModel.facts.value == State.Error(R.string.error))
    }

    @Test
    fun givenNetwork_whenFetchingFacts_shouldFetchFacts(){
        val facts = DummyData.getData()
        doReturn(Observable.just(true))
            .`when`(networkHelper).checkNetworkAvailability()
        doReturn(Single.just(facts))
            .`when`(repository).getData()
        viewModel.loadFacts()
        testScheduler.triggerActions()
        val responseFromServer = viewModel.facts.value
        assert(responseFromServer is State.Success<*>)
        assert(facts == (responseFromServer as State.Success<List<Fact>>).data)
    }

    @After
    fun tearDown()
    {
        viewModel.facts.removeObserver(resultObserver)
    }



}
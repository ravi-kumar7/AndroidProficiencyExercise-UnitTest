package com.android.assignment.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
open class NetworkHelper(private val context: Context){

    open fun checkNetworkAvailability(): Observable<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetwork?.let { networkInfo ->
            connectivityManager.getNetworkCapabilities(networkInfo)?.let {
                return Observable.create{ emitter ->
                    emitter.onNext(it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || it.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    ))
                }
            }
        }
        return Observable.just(false)
    }
}
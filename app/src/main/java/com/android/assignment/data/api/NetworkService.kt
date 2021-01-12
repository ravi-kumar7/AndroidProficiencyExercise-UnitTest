package com.android.assignment.data.api

import com.android.assignment.data.model.Response
import com.android.assignment.util.Constants
import io.reactivex.Single
import retrofit2.http.GET


interface NetworkService {

    @GET(Constants.END_POINT)
    fun fetchFacts(): Single<Response>

}
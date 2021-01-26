package com.android.myapplication.contact.util

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.myapplication.contact.api.responses.ApiEmptyResponse
import com.android.myapplication.contact.api.responses.ApiErrorResponse
import com.android.myapplication.contact.api.responses.ApiResponse
import com.android.myapplication.contact.api.responses.ApiSuccessResponse


@Suppress("LeakingThis")
abstract class NetworkBoundResourceNoCaching<UiObject, RequestObject>
@MainThread constructor() {

    protected val result = MediatorLiveData<Resource<UiObject>>()

    init {
        result.value = Resource.Loading(null)
        val apiResponse = createCall()
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            handleNetworkCall(response)
        }
    }

    fun handleNetworkCall(response: ApiResponse<RequestObject>) {
        when (response) {
            is ApiSuccessResponse -> {
                handleApiSuccessResponse(response)
            }
            is ApiEmptyResponse -> {
                handleApiEmptyResponse(response)
            }
            is ApiErrorResponse -> {
                handleApiErrorResponse(response)
            }
        }
    }


    fun asLiveData() = result as LiveData<Resource<UiObject>>

    abstract fun handleApiSuccessResponse(response: ApiSuccessResponse<RequestObject>)
    abstract fun handleApiEmptyResponse(response: ApiEmptyResponse<RequestObject>)
    abstract fun handleApiErrorResponse(response: ApiErrorResponse<RequestObject>)

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestObject>>

}
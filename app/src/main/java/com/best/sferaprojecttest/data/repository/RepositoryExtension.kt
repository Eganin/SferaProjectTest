package com.best.sferaprojecttest.data.repository

import com.best.sferaprojecttest.data.util.DefaultDispatchers
import com.best.sferaprojecttest.domain.util.Resource
import com.bumptech.glide.load.HttpException
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.withContext
import java.io.IOException

suspend fun <T> FlowCollector<Resource<T>>.bodyForDataLoading(
    dispatchers: DefaultDispatchers,
    blockResponse: suspend () -> T
) {
    emit(Resource.Loading(isLoading = true))
    val response = try {
        withContext(dispatchers.main()) {
            blockResponse()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        emit(Resource.Error(message = "Couldn't load data"))
        null
    } catch (e: HttpException) {
        e.printStackTrace()
        emit(Resource.Error(message = "Couldn't load data"))
        null
    } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error(message = "Unknown error.Turn on Gps and restart the application"))
        null
    }

    response?.let {
        emit(Resource.Loading(isLoading = false))
        emit(Resource.Success(data = it))
    }
}
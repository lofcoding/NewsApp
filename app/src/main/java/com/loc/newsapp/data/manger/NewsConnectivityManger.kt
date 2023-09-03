package com.loc.newsapp.data.manger

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface ConnectionState {
    object Connected : ConnectionState
    object NotConnected : ConnectionState
    object Unknown : ConnectionState

}

class NewsConnectivityManger(
    context: Context
) {

    private val _connectionState = MutableStateFlow<ConnectionState>(ConnectionState.Unknown)
    val connectionState = _connectionState.asStateFlow()

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            _connectionState.update {
                ConnectionState.Connected
            }
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            _connectionState.update {
                ConnectionState.NotConnected
            }
        }
    }

    private val connectivityManager = context.getSystemService(ConnectivityManager::class.java)

    init {
        connectivityManager.registerNetworkCallback(getNetworkRequest(), networkCallback)
    }

    private fun getNetworkRequest(): NetworkRequest {
        return NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
    }

}
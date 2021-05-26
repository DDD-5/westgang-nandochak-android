package kr.co.west_gang.nan_do_chak.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi

/*
* Created by JJJoonngg
*/

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class NetworkStatusChecker(context: Context) : ConnectivityManager.NetworkCallback() {
    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun isOnline(): Boolean {
        val network = connectivityManager.activeNetwork
        val connection = connectivityManager.getNetworkCapabilities(network) ?: return false
        return connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
    }

    fun registerNetwork() {
        val networkRequest: NetworkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()

        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    fun unregisterNetwork() {
        connectivityManager.unregisterNetworkCallback(this)
    }
}
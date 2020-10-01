package com.e.msappsreview.session

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager
@Inject
constructor(
    val application: Application
) {
    private val TAG = "SessionManager"

//    private val _cachedToken = MutableLiveData<AuthToken>()
//
//    val cachedToken: LiveData<AuthToken>
//        get() = _cachedToken

//    fun login(newValue: AuthToken) {
//        setValue(newValue)
//    }
//
//    fun logout() {
//        Log.d(TAG, "logout...")
//        GlobalScope.launch(IO) {
//            var errorMessage: String? = null
//
//            try {
//                cachedToken.value!!.account_pk?.let {
//                    authTokenDao.nullifyToken(it)
//                }
//            } catch (e: CancellationException) {
//                Log.e(TAG, "logout:  ${e.message}")
//                errorMessage = e.message
//            } catch (e: Exception) {
//                Log.e(TAG, "logout: ${e.message}")
//                errorMessage = e.message + "\n" + e.message
//            } finally {
//                errorMessage?.let {
//                    Log.e(TAG, "logout: ${errorMessage}")
//                }
//                Log.d(TAG, "logout: finally..")
//                setValue(null)
//            }
//        }
//    }

//    fun setValue(newValue: AuthToken?) {
//        GlobalScope.launch(Main) {
//            if (_cachedToken.value != newValue) {
//                _cachedToken.value = newValue
//            }
//        }
//    }

    fun isConnectedToInternet(): Boolean {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            return cm.activeNetworkInfo.isConnected
        } catch (e: Exception) {
            Log.e(TAG, "isConnectedToTheInternet: ${e.message}")
        }
        return false
    }
}


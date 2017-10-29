package me.leig.myapplication

import android.app.Application
import android.util.Log

/**
 *
 *
 * @author leig.
 * @version 29/10/2017.
 */
class App: Application() {

    val TAG: String = "App"

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "App start...")

    }
}
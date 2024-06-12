package com.example.hiltpractice

import android.app.Application
import android.support.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProductApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}
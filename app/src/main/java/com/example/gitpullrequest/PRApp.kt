package com.example.gitpullrequest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PRApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
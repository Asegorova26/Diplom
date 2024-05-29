package com.example.a30daysfitness

import android.app.Application
import com.google.firebase.FirebaseApp

class YourApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

package com.android.myapplication.contact.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.myapplication.contact.R
import com.android.myapplication.contact.api.ContactApi
import com.android.myapplication.contact.models.Contact
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var contactApi: ContactApi

    private lateinit var toolbar: Toolbar

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.main_container,
                    MainContactFragment()
                )
                .commit()
        }
    }

    private fun setUpToolbar() {
        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        (supportFragmentManager.findFragmentById(R.id.main_container) as MainContactFragment).onBackPressed()
    }

}
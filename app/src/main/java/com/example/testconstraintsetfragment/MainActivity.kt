package com.example.testconstraintsetfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testconstraintsetfragment.fragments.Fragment1

class MainActivity : AppCompatActivity() {
    private lateinit var fragment1: Fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1 = Fragment1()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.layout, fragment1)
            .commit()
    }
}
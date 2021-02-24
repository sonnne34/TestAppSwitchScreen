package com.example.testconstraintsetfragment.fragments

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.testconstraintsetfragment.R

class Fragment2 : Fragment() {

    private lateinit var fragment1: Fragment1
    private lateinit var layout2: ConstraintLayout
    private val height = 100
    private val width = 400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_2, container, false)

        layout2 = root.findViewById(R.id.layout2)

        addButton(root.context)

        return root
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun addButton(context: Context){

        val button = Button(context)
        button.id = View.generateViewId()
        button.layoutParams = ConstraintLayout.LayoutParams(width, height)
        layout2.setBackgroundColor(Color.WHITE)
        layout2.addView(button)

        val set = ConstraintSet()
        set.clone(layout2)
        set.connect(button.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, )
        set.connect(button.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, )
        set.connect(button.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, )
        set.connect(button.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, )
        set.applyTo(layout2)

        buttonClick(button)
    }

    private fun buttonClick(button: Button) {
        button.setOnClickListener {
            val manager = (activity as AppCompatActivity).supportFragmentManager
            fragment1 = Fragment1()
            manager.beginTransaction()
                .remove(this)
                .commit()
        }
    }
}
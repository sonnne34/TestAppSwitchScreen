package com.example.testconstraintsetfragment.fragments

import android.content.Context
import android.content.Intent
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
import androidx.constraintlayout.widget.ConstraintSet.*
import com.example.testconstraintsetfragment.R

class Fragment1 : Fragment() {

    private lateinit var myLayout: ConstraintLayout
    private lateinit var fragment2: Fragment2
    private val height = 100
    private val width = 400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_1, container, false)

        myLayout = root.findViewById(R.id.const_layout)

        addButtons(root.context)

        return root
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun addButtons(context: Context){
        val set = ConstraintSet()

        val buttonRed = Button(context)
        val buttonGreen = Button(context)
        val buttonBlue = Button(context)

        myLayout.addView(buttonRed)
        myLayout.addView(buttonGreen)
        myLayout.addView(buttonBlue)

        buttonRed.id = View.generateViewId()
        buttonGreen.id = View.generateViewId()
        buttonBlue.id = View.generateViewId()

        buttonRed.layoutParams = ConstraintLayout.LayoutParams(width, height)
        buttonGreen.layoutParams = ConstraintLayout.LayoutParams(width, height)
        buttonBlue.layoutParams = ConstraintLayout.LayoutParams(width, height)

        buttonRed.setBackgroundColor(Color.RED)
        buttonGreen.setBackgroundColor(Color.GREEN)
        buttonBlue.setBackgroundColor(Color.BLUE)

        set.clone(myLayout)

        set.connect(buttonRed.id, LEFT, PARENT_ID, LEFT, )
        set.connect(buttonRed.id, RIGHT, PARENT_ID, RIGHT, )
        set.connect(buttonRed.id, TOP, PARENT_ID, TOP, )
        set.connect(buttonRed.id, BOTTOM, PARENT_ID, BOTTOM, )

        set.connect(buttonGreen.id, LEFT, PARENT_ID, LEFT, )
        set.connect(buttonGreen.id, RIGHT, PARENT_ID, RIGHT, )
        set.connect(buttonGreen.id, TOP, buttonRed.id, BOTTOM, 10)

        set.connect(buttonBlue.id, LEFT, PARENT_ID, LEFT, )
        set.connect(buttonBlue.id, RIGHT, PARENT_ID, RIGHT, )
        set.connect(buttonBlue.id, TOP, buttonGreen.id, BOTTOM, 10)

        set.applyTo(myLayout)

        buttonBlueClick(buttonBlue)
        buttonGreenClick(buttonGreen)
        buttonRedClick(buttonRed)
    }

    private fun buttonRedClick(buttonRed: Button){
        buttonRed.setOnClickListener {
            val startMain = Intent(Intent.ACTION_MAIN)
            startMain.addCategory(Intent.CATEGORY_HOME)
            startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(startMain)
        }
    }

    private fun buttonGreenClick(buttonGreen: Button){
        buttonGreen.setOnClickListener {
            buttonGreen.visibility = View.GONE
        }
    }

    private fun buttonBlueClick(buttonBlue: Button){
        buttonBlue.setOnClickListener {
            val manager = (activity as AppCompatActivity).supportFragmentManager
            fragment2 = Fragment2()
            manager.beginTransaction()
                .add(R.id.layout, fragment2)
                .commit()
        }
    }
}
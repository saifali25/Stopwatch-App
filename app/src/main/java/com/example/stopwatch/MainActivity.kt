package com.example.stopwatch

import android.content.Intent
import android.os.Build.ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Image = findViewById<ImageView>(R.id.iv_splash)
        val main_Splash = findViewById<TextView>(R.id.tv_Splash)
        val sub_Splash = findViewById<TextView>(R.id.tv_SubSplash)
        val getStartedbtn = findViewById<Button>(R.id.btn_GetStarted)

        //load animation
        val atg = AnimationUtils.loadAnimation(this,R.anim.atg)
        val btgone = AnimationUtils.loadAnimation(this,R.anim.btgone)
        val btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo)

        //start animation
        Image.startAnimation(atg)
        main_Splash.startAnimation(btgone)
        sub_Splash.startAnimation(btgone)
        getStartedbtn.startAnimation(btgtwo)

        getStartedbtn.setOnClickListener {
            val i = Intent(this,StopwatcchActiivity::class.java)
            startActivity(i)

        }





    }


}
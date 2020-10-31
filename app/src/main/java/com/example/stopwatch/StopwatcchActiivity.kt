package com.example.stopwatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext

class StopwatcchActiivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatcch)

        val icanchor = findViewById<ImageView>(R.id.iv_icanchor)
        val startbtn = findViewById<Button>(R.id.btn_startNow)
        val endbtn = findViewById<Button>(R.id.btn_endNow)
        val timer = findViewById<Chronometer>(R.id.timer)

        //load animation
        val roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone)

        startbtn.setOnClickListener {
            icanchor.startAnimation(roundingalone)
            endbtn.animate().alpha(1F).translationY(-80F).setDuration(300).start()
            startbtn.animate().alpha(0F).setDuration(300).start()
            //Set time
            timer.base = SystemClock.elapsedRealtime()
            timer.start()
        }

        endbtn.setOnClickListener {
            startbtn.animate().alpha(1F).translationY(-80F).setDuration(300).start()
            endbtn.animate().alpha(0F).setDuration(300).start()
            timer.stop()
            icanchor.clearAnimation()

            //Dailog Box
            val msg = "Rate Us?"
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Feedback")
            alertDialogBuilder.setMessage(msg)
            alertDialogBuilder.setCancelable(true)

            alertDialogBuilder.setPositiveButton("YES") { dialog, which ->
                val i = Intent(this,FeedbackActivity::class.java)
                startActivity(i)
            }

            alertDialogBuilder.setNegativeButton("NO") { dialog, which ->
                dialog.cancel()
            }
            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }


    }
}
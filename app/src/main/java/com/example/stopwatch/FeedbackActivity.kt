 package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val button = findViewById<Button>(R.id.btn_feedback)
        val resultText = findViewById<TextView>(R.id.tv_ResultRate)
        val image = findViewById<ImageView>(R.id.iv_Emoji)
        val ratingBar = findViewById<RatingBar>(R.id.rb_Stars)
        var rate = 0F



        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            rate = ratingBar?.rating!!
            if (rate == 1F){
                resultText.text = getString(R.string.zero_star)
                image.setImageResource(R.drawable.zero_star)
            }
            if (rate == 2F){
                resultText.text = getString(R.string.two_star)
                image.setImageResource(R.drawable.twostar)
            }
            if (rate == 3F){
                resultText.text =getString(R.string.three_star)
                image.setImageResource(R.drawable.threestar)
            }
            if (rate == 4F){
                resultText.text = getString(R.string.four_star)
                image.setImageResource(R.drawable.fourstar)
            }
            if (rate == 5F){
                resultText.text = getString(R.string.five_star)
                image.setImageResource(R.drawable.fivestar)
            }
        }


        button.setOnClickListener {
            Toast.makeText(baseContext, "Thanks for your feedback", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
package com.practise.calculator_mini

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.widget.VideoView
import java.lang.Exception

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fun jump() {
            if (isFinishing)
                return
        }

        try {
            val videoHolder = VideoView(this)
            setContentView(videoHolder)
            println("Done1")
            val video = Uri.parse("android.resource://" + "Calculator_mini" + "/" + R.raw.splash)
            println("Done2")
            videoHolder.setVideoURI(video)
            println("Done3")
            videoHolder.setOnCompletionListener { jump() }
            println("Done4")
            videoHolder.start()
            println("Done5")
        } catch (ex: Exception) {
            jump()
        }

        fun onTouchEvent(event: MotionEvent): Boolean {
            jump()
            return true
        }



        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        finish()
    }
}

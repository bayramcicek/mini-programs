package com.example.frequencyapp.audio

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import com.example.frequencyapp.R
import com.example.frequencyapp.audio.calculators.AudioCalculator
import com.example.frequencyapp.audio.core.Callback
import com.example.frequencyapp.audio.core.Recorder

class MainActivity : Activity() {
    private var recorder: Recorder? = null
    private var audioCalculator: AudioCalculator? = null
    private var handler: Handler? = null
    private var textAmplitude: TextView? = null
    private var textDecibel: TextView? = null
    private var textFrequency: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        recorder = Recorder(callback)
        audioCalculator = AudioCalculator()
        handler = Handler(Looper.getMainLooper())
        textAmplitude = findViewById<View>(R.id.textAmplitude) as TextView
        textDecibel = findViewById<View>(R.id.textDecibel) as TextView
        textFrequency = findViewById<View>(R.id.textFrequency) as TextView
    }

    private val callback = Callback { buffer ->
        audioCalculator!!.setBytes(buffer)
        val amplitude = audioCalculator!!.amplitude
        val decibel = audioCalculator!!.decibel
        val frequency = audioCalculator!!.frequency
        val amp = "$amplitude Amp"
        val db = "$decibel db"
        val hz = "$frequency Hz"
        handler!!.post {
            textAmplitude!!.text = amp
            textDecibel!!.text = db
            textFrequency!!.text = hz
        }
    }

    override fun onResume() {
        super.onResume()
        recorder!!.start()
    }

    override fun onPause() {
        super.onPause()
        recorder!!.stop()
    }
}
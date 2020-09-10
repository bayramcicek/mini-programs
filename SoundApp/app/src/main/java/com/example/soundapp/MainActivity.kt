package com.example.soundapp

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*


class MainActivity : AppCompatActivity() {
    private var timer: Timer? = null
    private var recorder: MediaRecorder? = null

    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    // Requesting permission to RECORD_AUDIO
    private val requiredPermissions: Array<String> = arrayOf(
        Manifest.permission.RECORD_AUDIO
    )

    // onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startRecording)
        stopButton = findViewById(R.id.stopRec)

    } // onCreate

    fun startRecording(view: View) {
        if (!permissionsIsGranted(requiredPermissions)) {
            ActivityCompat.requestPermissions(this, requiredPermissions, 200)
            return
        }

        startButton.isEnabled = false
        stopButton.isEnabled = true

        //Creating MediaRecorder and specifying audio source, output format, encoder & output format
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP) // it: MPEG_4
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC) // me: AMR_NB
            setOutputFile("/dev/null")
            setAudioSamplingRate(48000)
            setAudioEncodingBitRate(48000)

            try {
                prepare()
                Log.i("startRecording", "startRecording")
            } catch (e: IOException) {
                Log.e("Prepare", "prepare() failed")
            }

            start()
        }
        calculateAmp()
    }

    fun stopRecording(view: View) {
        startButton.isEnabled = true
        stopButton.isEnabled = false
        timer?.cancel()

        Log.i("stopRecording", "stopRecording")
        amp_tv.text = "0"

        recorder?.apply {
            stop()
            reset()
            release()
        }
        recorder = null
    }

    private fun calculateAmp() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (recorder != null) {
                        val currentMaxAmplitude = recorder?.maxAmplitude // 0-32767
                        amp_tv.text = currentMaxAmplitude.toString()
                    }
                }
            }
        }, 0, 200)
    }

    private fun permissionsIsGranted(perms: Array<String>): Boolean {
        for (perm in perms) {
            val checkVal: Int = checkCallingOrSelfPermission(perm)
            if (checkVal != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return
            }
        }
        startRecording(View(this))
    }

    override fun onPause() {
        super.onPause()
        startButton.isEnabled = true
    }

    override fun onStop() {
        super.onStop()
        Log.i("onStop", "onStop")

        timer?.cancel()

        recorder?.stop()
        recorder?.reset()
        recorder?.release()
        recorder = null
    }
}
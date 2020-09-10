package com.example.audiorec

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
import java.util.*


class MainActivity : AppCompatActivity() {

    private val requiredPermissions = arrayOf(
        Manifest.permission.RECORD_AUDIO
    )

    private var timer: Timer? = null
    private var recorder: MediaRecorder? = null

    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startRecording)
        stopButton = findViewById(R.id.stopRec)
    }

    fun startRecording(view: View) {
        if (!permissionsIsGranted(requiredPermissions)) {
            ActivityCompat.requestPermissions(this, requiredPermissions, 200)
            return
        }

        startButton.isEnabled = false
        stopButton.isEnabled = true

        //Creating MediaRecorder and specifying audio source, output format, encoder & output format
        recorder = MediaRecorder()
        recorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        recorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        recorder?.setOutputFile("/dev/null")
        recorder?.setAudioSamplingRate(48000)
        recorder?.setAudioEncodingBitRate(48000)
        recorder?.prepare()
        recorder?.start()

        startDrawing()
    }

    fun stopRecording(view: View) {
        startButton.isEnabled = true
        stopButton.isEnabled = false
        timer?.cancel()

        recorder?.stop()
        recorder?.reset()
        recorder?.release()
        recorder = null
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()

        recorder?.stop()
        recorder?.reset()
        recorder?.release()
        recorder = null
    }

    override fun onPause() {
        super.onPause()
        startButton.isEnabled = true
    }

    private fun startDrawing() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (recorder != null) {
                        val currentMaxAmplitude = recorder?.maxAmplitude
                        audioRecordView.update(currentMaxAmplitude!!) //redraw view
                        Log.i("currentMaxAmplitude", currentMaxAmplitude.toString())
                    }
                }
            }
        }, 0, 100)
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
}
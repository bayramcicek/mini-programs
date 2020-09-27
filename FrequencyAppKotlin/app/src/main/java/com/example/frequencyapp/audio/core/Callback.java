package com.example.frequencyapp.audio.core;

public interface Callback {
    void onBufferAvailable(byte[] buffer);
}
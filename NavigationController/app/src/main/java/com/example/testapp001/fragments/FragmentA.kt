package com.example.testapp001.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapp001.Communicator
import com.example.testapp001.R
import kotlinx.android.synthetic.main.fragment_a.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        communicator = activity as Communicator

        view.sendBtn.setOnClickListener {
            communicator.passDataCom(view.messageInput.text.toString())
        }

        return view
    }
}
package com.shatrudhan.netclan.Explore

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shatrudhan.netclan.R

class ExploreScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_screen)
        val items = listOf("Available, Hey let us connected","Not Available","Available","Not sure")
        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete_txt)
        val adapter = ArrayAdapter(this, R.layout.dropdown_list, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
             adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Item: $itemSelected",Toast.LENGTH_SHORT).show()
            }
        val seekBar = findViewById<SeekBar>(R.id.seekbar)
        val txtseek = findViewById<TextView>(R.id.txtseek)

        seekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtseek.text = "$progress Km"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtseek.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                txtseek.text = seekBar!!.progress.toString()
            }

        })
    }
}
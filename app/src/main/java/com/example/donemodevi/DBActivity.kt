package com.example.donemodevi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_db.*
class DBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)
        if(intent.getStringExtra("Yazi") == null){
            Toast.makeText(getApplicationContext(),"Data Yok", Toast.LENGTH_LONG).show();
        }else{
            textView.text = intent.getStringExtra("Yazi")
        }
        hkkButton.setOnClickListener { view ->
            val intent = Intent(this,HKKActivity::class.java)
            startActivity(intent)
        }
    }
}
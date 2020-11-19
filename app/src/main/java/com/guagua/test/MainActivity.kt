package com.guagua.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.androidDan).setOnClickListener {
            startActivity(
                Intent(
                    MainActivity@ this,
                    AndroidDanActivity::class.java
                )
            )
        }

        findViewById<Button>(R.id.compileDan).setOnClickListener {
            startActivity(
                Intent(
                    MainActivity@ this,
                    AndroidDanActivity::class.java
                ).putExtra("Type", 1)
            )
        }

        findViewById<Button>(R.id.compileDuo).setOnClickListener {
            startActivity(
                Intent(
                    MainActivity@ this,
                    AndroidDanActivity::class.java
                ).putExtra("Type", 2)
            )
        }

        findViewById<Button>(R.id.compilePd).setOnClickListener {
            startActivity(
                Intent(
                    MainActivity@ this,
                    CompileTkActivity::class.java
                ).putExtra("Type", 1)
            )
        }

        findViewById<Button>(R.id.compileTk).setOnClickListener {
            startActivity(
                Intent(
                    MainActivity@ this,
                    CompileTkActivity::class.java
                )
            )
        }
    }
}
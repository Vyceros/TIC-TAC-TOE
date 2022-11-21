package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var motamashe1 = findViewById<EditText>(R.id.player1)
        var motamashe2 = findViewById<EditText>(R.id.player2)
        var button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener(){

            if (motamashe1.text.toString().length == 0){
                motamashe1.setText("Player1")
            }
            if (motamashe2.text.toString().length == 0){
                motamashe2.setText("Player2")
            }
            val player1 = motamashe1.text.toString()
            val player2 = motamashe2.text.toString()
            val intent = Intent(this@MainActivity,TicTacToe::class.java)
            intent.putExtra("player1",player1)
            intent.putExtra("player2",player2)
            startActivity(intent)

        }



    }
}
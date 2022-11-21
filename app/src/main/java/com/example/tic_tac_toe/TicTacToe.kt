package com.example.tic_tac_toe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class TicTacToe : AppCompatActivity(), android.view.View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private var score1 = 0
    private var score2 = 0
    private var player1 = ""
    private var player2 = ""
    private lateinit var qula1: TextView
    private lateinit var qula2: TextView
    private var activeplayer = 1
    private var first = ArrayList<Int>()
    private var second = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)
        var intent = getIntent()
        var motamashe1 = intent.getStringExtra("saxeli1")
        var motamashe2 = intent.getStringExtra("saxeli2")

        var saxeli1 = findViewById<TextView>(R.id.saxeli1)
        var saxeli2 = findViewById<TextView>(R.id.saxeli2)
        saxeli1.text = "$motamashe1"
        saxeli2.text = "$motamashe2"
        player1 = motamashe1.toString()
        player2 = motamashe2.toString()

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        qula1 = findViewById(R.id.qula1)
        qula2 = findViewById(R.id.qula2)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        reset.setOnClickListener {
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""






            button1.setBackgroundColor(Color.parseColor("#7D0E97"))
            button2.setBackgroundColor(Color.parseColor("#7D0E97"))
            button3.setBackgroundColor(Color.parseColor("#7D0E97"))
            button4.setBackgroundColor(Color.parseColor("#7D0E97"))
            button5.setBackgroundColor(Color.parseColor("#7D0E97"))
            button6.setBackgroundColor(Color.parseColor("#7D0E97"))
            button7.setBackgroundColor(Color.parseColor("#7D0E97"))
            button8.setBackgroundColor(Color.parseColor("#7D0E97"))
            button9.setBackgroundColor(Color.parseColor("#7D0E97"))
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            first.clear()
            second.clear()
        }

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNum = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNum = 1
                R.id.button2 -> buttonNum = 2
                R.id.button3 -> buttonNum = 3
                R.id.button4 -> buttonNum = 4
                R.id.button5 -> buttonNum = 5
                R.id.button6 -> buttonNum = 6
                R.id.button7 -> buttonNum = 7
                R.id.button8 -> buttonNum = 8
                R.id.button9 -> buttonNum = 9
            }
            playGame(buttonNum, clickedView)
        }

    }

    private fun playGame(buttonNum: Int, clickedView: Button) {
        if (activeplayer == 1) {
            clickedView.text = "X"
            activeplayer = 2
            first.add(buttonNum)
            clickedView.setBackgroundColor(Color.GREEN)
        } else if (activeplayer == 2) {
            clickedView.text = "O"
            activeplayer = 1
            second.add(buttonNum)
            clickedView.setBackgroundColor(Color.RED)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winner = 0
        if (first.contains(1) && first.contains(2) && first.contains(3)) {
            winner = 1
        }
        if (first.contains(4) && first.contains(5) && first.contains(6)) {
            winner = 1
        }
        if (first.contains(7) && first.contains(8) && first.contains(9)) {
            winner = 1
        }
        if (first.contains(1)&&first.contains(5)&&first.contains(9)){
            winner=1
    }
        if (first.contains(3)&&first.contains(5)&&first.contains(7)){
            winner=1
}
        if (first.contains(2)&&first.contains(5)&&first.contains(8)){
            winner=1
        }
        if (first.contains(1)&&first.contains(4)&&first.contains(7)){
            winner=1
        }
        if (first.contains(3)&&first.contains(6)&&first.contains(9)){
            winner=1
        }
        if (second.contains(1)&&second.contains(2)&&second.contains(3)){
            winner=2
        }
        if (second.contains(4)&&second.contains(5)&&second.contains(6)){
            winner=2
        }
        if (second.contains(7)&&second.contains(8)&&second.contains(9)){
            winner=2
        }
        if (second.contains(1)&&second.contains(5)&&second.contains(9)){
            winner=2
        }
        if (second.contains(3)&&second.contains(5)&&second.contains(7)){
            winner=2
        }
        if (second.contains(2)&&second.contains(5)&&second.contains(8)){
            winner=2
        }
        if (second.contains(1)&&second.contains(4)&&second.contains(7)){
            winner=2
        }
        if (second.contains(3)&&second.contains(6)&&second.contains(9)){
            winner=2
        }
        if (winner == 1){
            Toast.makeText(this, "გილოცავ", Toast.LENGTH_SHORT).show()
            score1+=1
            activeplayer=1
        }else if (winner == 2){
            Toast.makeText(this, "გილოცავ", Toast.LENGTH_SHORT).show()
            score2+=1
            activeplayer=2
        }else if (first.size+second.size == 9){
            Toast.makeText(this, "მეგობრობამ პური ჭამა", Toast.LENGTH_SHORT).show()
            first.clear()
            second.clear()
        }
        if (winner>0){
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
            qula1.text=score1.toString()
            qula2.text=score2.toString()
            first.clear()
            second.clear()
        }

}
}
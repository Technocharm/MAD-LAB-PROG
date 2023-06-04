package com.example.calculator1cr20cs109

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private  lateinit var value : TextView
    private  lateinit var result : TextView
    private  lateinit var one : TextView
    private  lateinit var two : TextView
    private  lateinit var three : TextView
    private  lateinit var four : TextView
    private  lateinit var five : TextView
    private  lateinit var six : TextView
    private  lateinit var seven : TextView
    private  lateinit var eight : TextView
    private  lateinit var nine : TextView
    private  lateinit var zero : TextView
    private  lateinit var clear : TextView
    private  lateinit var divide : TextView
    private  lateinit var multiply : TextView
    private  lateinit var add : TextView
    private  lateinit var equal : TextView
    private  lateinit var subtract : TextView
    private  lateinit var dot : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value = findViewById(R.id.value)
        result = findViewById(R.id.result)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        divide = findViewById(R.id.divide)
        clear = findViewById(R.id.clear)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.add)
        equal = findViewById(R.id.equal)
        subtract = findViewById(R.id.subtract)
        dot = findViewById(R.id.dot)

        zero.setOnClickListener{
            pressButton("0")
        }

        one.setOnClickListener{
            pressButton("1")
        }

        two.setOnClickListener{
            pressButton("2")
        }

        three.setOnClickListener{
            pressButton("3")
        }

        four.setOnClickListener{
            pressButton("4")
        }

        five.setOnClickListener{
            pressButton("5")
        }

        six.setOnClickListener{
            pressButton("6")
        }

        seven.setOnClickListener{
            pressButton("7")
        }

        eight.setOnClickListener{
            pressButton("8")
        }

        nine.setOnClickListener{
            pressButton("9")
        }

        dot.setOnClickListener{
            pressButton(".")
        }

        subtract.setOnClickListener{
            pressButton("-")
        }

        add.setOnClickListener{
            pressButton("+")
        }

        multiply.setOnClickListener{
            pressButton("*")
        }

        divide.setOnClickListener{
            pressButton("/")
        }

        equal.setOnClickListener{
            try {
                val text = value.text.toString()
                val value = ExpressionBuilder(text).build()
                val expResult = value.evaluate().toDouble()
                result.text = expResult.toString()
            }
            catch (e:Exception){
                result.text = "Error"
            }
        }

        clear.setOnClickListener{
            result.text=""
            value.text=""
        }


    }

    fun pressButton(s: String){
        result.text=""
        value.append(s)
    }
}
package com.nts.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button

    lateinit var button_clear: Button
    lateinit var button_all_clear: Button
    lateinit var button_open_bracket: Button
    lateinit var button_close_bracket: Button
    lateinit var button_divide: Button
    lateinit var button_multiply: Button
    lateinit var button_plus: Button
    lateinit var button_minus: Button
    lateinit var button_equals: Button
    lateinit var button_dot: Button

    lateinit var solution_tv:TextView
    lateinit var result_tv:TextView
    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0 = findViewById(R.id.button_0)
        button1 = findViewById(R.id.button_1)
        button2 = findViewById(R.id.button_2)
        button3 = findViewById(R.id.button_3)
        button4 = findViewById(R.id.button_4)
        button5 = findViewById(R.id.button_5)
        button6 = findViewById(R.id.button_6)
        button7 = findViewById(R.id.button_7)
        button8 = findViewById(R.id.button_8)
        button9 = findViewById(R.id.button_9)
        button_dot = findViewById(R.id.button_dot)
        button_clear = findViewById(R.id.button_c)
        button_all_clear = findViewById(R.id.button_ac)
        button_open_bracket = findViewById(R.id.button_open_bracket)
        button_close_bracket = findViewById(R.id.button_close_bracket)
        button_divide = findViewById(R.id.button_divide)
        button_multiply = findViewById(R.id.button_multiply)
        button_plus = findViewById(R.id.button_plus)
        button_minus = findViewById(R.id.button_minus)
        button_equals = findViewById(R.id.button_equals)
        solution_tv = findViewById(R.id.solution_tv)
        result_tv = findViewById(R.id.result_tv)

        var text :String

        button0.setOnClickListener {
            text =solution_tv.text.toString()+"0"
            solution_tv.setText(text)
            resut(text)
        }


        button1.setOnClickListener {
            text =solution_tv.text.toString()+"1"
            solution_tv.setText(text)
            resut(text)
        }
        button2.setOnClickListener {
            text =solution_tv.text.toString()+"2"
            solution_tv.setText(text)
            resut(text)
        }
        button3.setOnClickListener {
            text =solution_tv.text.toString()+"3"
            solution_tv.setText(text)
            resut(text)
        }
        button4.setOnClickListener {
            text =solution_tv.text.toString()+"4"
            solution_tv.setText(text)
            resut(text)
        }
        button5.setOnClickListener {
            text =solution_tv.text.toString()+"5"
            solution_tv.setText(text)
            resut(text)
        }
        button6.setOnClickListener {
            text =solution_tv.text.toString()+"6"
            solution_tv.setText(text)
            resut(text)
        }
        button7.setOnClickListener {
            text =solution_tv.text.toString()+"7"
            solution_tv.setText(text)
            resut(text)
        }
        button8.setOnClickListener {
            text =solution_tv.text.toString()+"8"
            solution_tv.setText(text)
            resut(text)
        }
        button9.setOnClickListener {
            text =solution_tv.text.toString()+"9"
            solution_tv.setText(text)
            resut(text)
        }
        button_dot.setOnClickListener {
            text =solution_tv.text.toString()+"."
            solution_tv.setText(text)
            resut(text)
        }

        button_divide.setOnClickListener {
            text =solution_tv.text.toString()+"/"
            solution_tv.setText(text)
            check = check+1
        }
        button_multiply.setOnClickListener {
            text =solution_tv.text.toString()+"*"
            solution_tv.setText(text)
            check = check+1
        }
        button_plus.setOnClickListener {
            text =solution_tv.text.toString()+"+"
            solution_tv.setText(text)
            check = check+1
        }

        button_minus.setOnClickListener {
            text =solution_tv.text.toString()+"-"
            solution_tv.setText(text)
            check = check+1
        }

        button_equals.setOnClickListener {
            text =result_tv.text.toString()
            solution_tv.setText(text)
            result_tv.setText(null)
        }


        button_clear.setOnClickListener {

            var BackSpace: String ? =null
            if (solution_tv.length()>0){
                val stringBuilder : StringBuilder = java.lang.StringBuilder(solution_tv.text)
                val find = solution_tv.text.toString()
                val find2 =find.last()

                if (find2.equals('+') || find2.equals('-')|| find2.equals('/')|| find2.equals('*')|| find2.equals('-')){

                    check =check-1
                }

                stringBuilder.deleteCharAt(solution_tv.text.length-1)
                BackSpace =stringBuilder.toString()
                solution_tv.setText(BackSpace)
                resut(BackSpace)
            }

        }

        button_all_clear.setOnClickListener {
            solution_tv.setText(null)
            result_tv.setText(null)
        }

    }

    private fun resut(text: String) {

        val engine : ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            val result:Any=engine.eval(text)
            val mainresult =result.toString()
            if (check==0){
                result_tv.setText(null)
            }else{
                result_tv.setText(mainresult)
            }
        }
        catch (e:ScriptException){
            Log.d("TAG" ,"ERROR")
        }

    }
}
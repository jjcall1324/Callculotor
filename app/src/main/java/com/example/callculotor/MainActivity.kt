package com.example.callculotor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.callculotor.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder






class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        workingsTV = binding.workingsTV
        resultsTV = binding.resultsTV


        with(binding) {

            //Numbers
            oneTV.setOnClickListener { appendOnExpression("1", false) }
            twoTV.setOnClickListener { appendOnExpression("2", true) }
            threeTV.setOnClickListener { appendOnExpression("3", true) }
            fourTV.setOnClickListener { appendOnExpression("4", true) }
            fiveTV.setOnClickListener { appendOnExpression("5", true) }
            sixTV.setOnClickListener { appendOnExpression("6", true) }
            sevenTV.setOnClickListener { appendOnExpression("7", true) }
            eightTV.setOnClickListener { appendOnExpression("8", true) }
            nineTV.setOnClickListener { appendOnExpression("9", true) }
            zeroTV.setOnClickListener { appendOnExpression("0", true) }
            dotTV.setOnClickListener { appendOnExpression(".", true) }

            //Operators
            plusTV.setOnClickListener { appendOnExpression("+", false) }
            minusTV.setOnClickListener { appendOnExpression("-", false) }
            mulTV.setOnClickListener { appendOnExpression("*", false) }
            divideTV.setOnClickListener { appendOnExpression("/", false) }


            clearTV.setOnClickListener {
                workingsTV.text = ""
                resultsTV.text = ""
            }
            backTV.setOnClickListener {
                val string = workingsTV.text.toString()
                if (string.isNotEmpty()) {
                    workingsTV.text = string.substring(0, string.length - 1)
                }
                resultsTV.text = ""
            }
            equalTV.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(workingsTV.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if(result == longResult.toDouble())
                        resultsTV.text = longResult.toString()
                    else
                        resultsTV.text = result.toString()

                }catch (e:Exception){
                    Log.d("Exception"," message : " + e.message )
                }
                }
            }

        }
        private fun appendOnExpression(string: String, clearResult: Boolean){
            if(clearResult){
                workingsTV.text = ""
            }
            workingsTV.append(resultsTV.text)
            workingsTV.append(string)
            resultsTV.text = ""
        }


}















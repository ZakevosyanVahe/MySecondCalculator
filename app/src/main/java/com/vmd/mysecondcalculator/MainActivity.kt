package com.vmd.mysecondcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private lateinit var displayTextView: TextView
private lateinit var operator: String
const val STRING_KEY: String = "string_key"


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var dotUsed: Boolean = false
    var operatorPlus: Boolean = false
    var operatorMinus: Boolean = false
    var operatorMultiply: Boolean = false
    var operatorDivide: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataNumber()
        //displayTextView.text = savedInstanceState?.getString(STRING_KEY)
        savedInstanceState?.let { data ->
            displayTextView.text = data.getString(STRING_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STRING_KEY, displayTextView.text?.toString())
    }


    private fun dataNumber() {
        displayTextView = findViewById(R.id.text_view)


        val buttonZero: Button = findViewById(R.id.btn0)
        val buttonOne: Button = findViewById(R.id.btn1)
        val buttonTwo: Button = findViewById(R.id.btn2)
        val buttonThree: Button = findViewById(R.id.btn3)
        val buttonFour: Button = findViewById(R.id.btn4)
        val buttonFive: Button = findViewById(R.id.btn5)
        val buttonSix: Button = findViewById(R.id.btn6)
        val buttonSeven: Button = findViewById(R.id.btn7)
        val buttonEight: Button = findViewById(R.id.btn8)
        val buttonNine: Button = findViewById(R.id.btn9)
        val buttonCancel: Button = findViewById(R.id.btn_cancel)
        val buttonDot: Button = findViewById(R.id.btn_dot)
        val buttonPlus: Button = findViewById(R.id.btn_plus)
        val buttonMinus: Button = findViewById(R.id.btn_minus)
        val buttonMultiply: Button = findViewById(R.id.btn_multiply)
        val buttonDivide: Button = findViewById(R.id.btn_divide)
        val buttonEqual: Button = findViewById(R.id.btn_equal)

        buttonZero.setOnClickListener(this)
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        when (v?.id) {
            R.id.btn0 -> {
                if (displayTextView.text == "" || displayTextView.text == "0") {
                    displayTextView.text = getString(R.string._0)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._0))
            }
            R.id.btn1 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._1))
            }
            R.id.btn2 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._2))
            }
            R.id.btn3 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._3))
            }
            R.id.btn4 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._4))
            }
            R.id.btn5 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._5))
            }
            R.id.btn6 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._6))
            }
            R.id.btn7 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._7))
            }
            R.id.btn8 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._8))
            }
            R.id.btn9 -> {
                if (displayTextView.text.toString() == getString(R.string._0)) {
                    displayTextView.text = getString(R.string._1)
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string._9))
            }
            R.id.btn_cancel -> {
                displayTextView.text = ""
                dotUsed = false
                operatorPlus = false
                operatorMinus = false
                operatorMultiply = false
                operatorDivide = false
            }

            R.id.btn_dot -> {
                if (!dotUsed) {
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string.dot))
                    dotUsed = true
                }
            }
            R.id.btn_plus -> {
                if (displayTextView.text != "") {
                    if (!operatorPlus) {
                        displayTextView.text =
                            displayTextView.text.toString().plus(getString(R.string.plus))
                        dotUsed = false
                    }
                    operator = "+"
                    operatorPlus = true
                    operatorMinus = true
                    operatorMultiply = true
                    operatorDivide = true
                }
            }
            R.id.btn_minus -> {
                if (!operatorMinus) {
                    displayTextView.text =
                        displayTextView.text.toString().plus(getString(R.string.minus))
                    operatorMinus = displayTextView.text != getString(R.string.minus)
                    dotUsed = false

                }
                operator = "-"
                operatorPlus = true
                //operatorMinus = true
                operatorMultiply = true
                operatorDivide = true
            }

            R.id.btn_multiply -> {
                if (displayTextView.text != "") {
                    if (!operatorMultiply) {
                        displayTextView.text =
                            displayTextView.text.toString().plus(getString(R.string.multiply))
                        dotUsed = false
                    }
                    operator = "*"
                    operatorPlus = true
                    operatorMinus = true
                    operatorMultiply = true
                    operatorDivide = true
                }
            }
            R.id.btn_divide -> {
                if (displayTextView.text != "") {
                    if (!operatorDivide) {
                        displayTextView.text =
                            displayTextView.text.toString().plus(getString(R.string.divide))
                        dotUsed = false
                    }
                    operator = "/"
                    operatorPlus = true
                    operatorMinus = true
                    operatorMultiply = true
                    operatorDivide = true
                }
            }

            R.id.btn_equal -> {
                val firstOperand: Double
                val secondOperand: Double
                val operands: List<String>

                when (operator) {
                    "+" -> {
                        operands = displayTextView.text.toString().split('+')
                        if (operands[1].isNotEmpty() ) {
                            firstOperand = operands[0].toDouble()
                            secondOperand = operands[1].toDouble()
                            displayTextView.text = (firstOperand + secondOperand).toString()
                        } else {
                            displayTextView.text
                        }

                    }
                    "-" -> {
                        operands = displayTextView.text.toString().split('-')
                        if (operands[1].isNotEmpty() ) {
                            firstOperand = operands[0].toDouble()
                            secondOperand = operands[1].toDouble()
                            displayTextView.text = (firstOperand - secondOperand).toString()
                        } else {
                            displayTextView.text
                        }
                    }
                    "*" -> {
                        operands = displayTextView.text.toString().split('*')
                        if (operands[1].isNotEmpty() ) {
                            firstOperand = operands[0].toDouble()
                            secondOperand = operands[1].toDouble()
                            displayTextView.text = (firstOperand * secondOperand).toString()
                        } else {
                            displayTextView.text
                        }
                    }
                    "/" -> {
                        operands = displayTextView.text.toString().split('/')
                        if (operands[1].isNotEmpty() ) {
                            firstOperand = operands[0].toDouble()
                            secondOperand = operands[1].toDouble()
                            if (secondOperand != 0.0) {
                                displayTextView.text = (firstOperand / secondOperand).toString()
                            } else {
                                displayTextView.text = getString(R.string.Can_not_divide_by_0)
                                return
                            }
                        } else {
                            displayTextView.text
                        }
                    }
                }
                operatorPlus = false
                operatorMinus = false
                operatorMultiply = false
                operatorDivide = false
            }
        }
    }
}

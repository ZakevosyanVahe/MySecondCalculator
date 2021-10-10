package com.vmd.mysecondcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val STRING_KEY: String = "string_key"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var displayTextView: TextView
    private lateinit var operator: String
    private var dotUsed: Boolean = false
    private var operatorPlus: Boolean = false
    private var operatorMinus: Boolean = false
    private var operatorMultiply: Boolean = false
    private var operatorDivide: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataNumber()
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

    override fun onClick(view: View?) {
        when ((view as Button).id) {

            R.id.btn0 -> {
                if (displayTextView.text == "" || displayTextView.text == "0" || displayTextView.text == getString(R.string.Can_not_divide_by_0)) {
                    displayTextView.text = view.text
                } else
                    displayTextView.text =
                        displayTextView.text.toString().plus(view.text)

            }
            R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn7, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn8, R.id.btn9 -> insertNumber(view)

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
                            displayTextView.text.toString().plus(" + ")
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
                    displayTextView.text = when (displayTextView.text) {
                        "" -> {
                            operatorPlus = false
                            displayTextView.text.toString().plus("-")
                        }
                        else -> {
                            operatorPlus = true
                            operatorMultiply = true
                            operatorDivide = true
                            displayTextView.text.toString().plus(" - ")
                        }
                    }
                    operatorMinus = displayTextView.text != getString(R.string.minus)
                    dotUsed = false

                }
                operator = "-"
            }

            R.id.btn_multiply -> {
                if (displayTextView.text != "") {
                    if (!operatorMultiply) {
                        displayTextView.text =
                            displayTextView.text.toString().plus(" * ")
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
                            displayTextView.text.toString().plus(" / ")
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
                val firstOperand: Float
                val secondOperand: Float
                val operand: String
                val operands: List<String> = displayTextView.text.toString().split(" ")
                if (operands.size > 2 && operands[2].isNotEmpty() && displayTextView.text != getString(
                        R.string.Can_not_divide_by_0
                    )
                ) {
                    firstOperand = operands[0].toFloat()
                    secondOperand = operands[2].toFloat()
                    operand = operands[1]

                    displayTextView.text = when (operand) {
                        "+" -> (firstOperand + secondOperand).toString()

                        "-" -> (firstOperand - secondOperand).toString()

                        "*" -> (firstOperand * secondOperand).toString()

                        "/" -> {
                            if (secondOperand != 0F) {
                                (firstOperand / secondOperand).toString()
                            } else {
                                getString(R.string.Can_not_divide_by_0)
                            }
                        }
                        else -> ""
                    }

                    operatorPlus = false
                    operatorMinus = false
                    operatorMultiply = false
                    operatorDivide = false
                    dotUsed = true
                }
            }
        }
    }

    private fun insertNumber(view: Button) {
        if (displayTextView.text.toString() == getString(R.string._0) || displayTextView.text == getString(R.string.Can_not_divide_by_0)) {
            displayTextView.text = view.text
        } else
            displayTextView.text =
                displayTextView.text.toString().plus(view.text)

    }
}


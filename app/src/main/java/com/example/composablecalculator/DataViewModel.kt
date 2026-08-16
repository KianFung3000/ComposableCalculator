package com.example.composablecalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class DataViewModel : ViewModel() {
    var firstNumber by mutableStateOf("")
    var secondNumber by mutableStateOf("")
    var result by mutableStateOf("")
    var isResultVisible by mutableStateOf(false)
    var selectedOperator by mutableStateOf<Operator?>(null) // To track the currently selected operator
    enum class Operator { // This is to represent different operators
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    fun add() {
        selectedOperator = Operator.ADD
        val f1 = firstNumber.toDoubleOrNull()
        val f2 = secondNumber.toDoubleOrNull()
        if (f1 != null && f2 != null) {
            result = (f1 + f2).toString()
            isResultVisible = true
        } else {
            result = "Error: Invalid input!"
            isResultVisible = true
        }
    }

    fun subtract() {
        selectedOperator = Operator.SUBTRACT
        val f1 = firstNumber.toDoubleOrNull()
        val f2 = secondNumber.toDoubleOrNull()
        if (f1 != null && f2 != null) {
            result = (f1 - f2).toString()
            isResultVisible = true
        } else {
            result = "Error: Invalid input!"
            isResultVisible = true
        }
    }

    fun multiply() {
        selectedOperator = Operator.MULTIPLY
        val f1 = firstNumber.toDoubleOrNull()
        val f2 = secondNumber.toDoubleOrNull()
        if (f1 != null && f2 != null) {
            result = (f1 * f2).toString()
            isResultVisible = true
        } else {
            result = "Error:  Invalid input!"
            isResultVisible = true
        }
    }

    fun divide() {
        selectedOperator = Operator.DIVIDE
        val f1 = firstNumber.toDoubleOrNull()
        val f2 = secondNumber.toDoubleOrNull()
        if (f1 != null && f2 != null) {
            if (f2 == 0.0) {
                result = "Error: Division by zero"
                isResultVisible = true
            } else {
                result = (f1 / f2).toString()
                isResultVisible = true
            }
        } else {
            result = "Error: Invalid input!"
            isResultVisible = true
        }
    }

    fun hideResult() {
        isResultVisible = false
    }
}
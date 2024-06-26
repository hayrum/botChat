package com.example.botmessages.utils

import android.util.Log

/**
 * This object is used to solve mathematical equations.
 */
object SolveMath {

    fun solveMath(equation: String): Int {

        val newEquation = equation.replace(" ", "")
        Log.d("Math", newEquation)

        return when {
            newEquation.contains("+") -> {
                val split = newEquation.split("+")
                val result = split[0].toInt() + split[1].toInt()
                result
            }

            newEquation.contains("-") -> {
                val split = newEquation.split("-")
                val result = split[0].toInt() - split[1].toInt()
                result
            }

            newEquation.contains("*") -> {
                val split = newEquation.split("*")
                val result = split[0].toInt() * split[1].toInt()
                result
            }

            newEquation.contains("/") -> {
                val split = newEquation.split("/")
                val result = split[0].toInt() / split[1].toInt()
                result
            }

            else -> {
                0
            }
        }
    }
}
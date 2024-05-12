package com.example.botmessages.utils

import com.example.botmessages.utils.Constants.OPEN_GOOGLE
import com.example.botmessages.utils.Constants.OPEN_SEARCH
import java.util.Locale

object BotResponse {

    fun basicResponse(customerMessage: String): String {

        val random = (0..2).random()
        val message = customerMessage.lowercase(Locale.getDefault())

        // is not english
        return when {

            // Check if the message contains "hola"
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola!"
                    1 -> "Que tal!"
                    3 -> "Buenos dias!"
                    4 -> "Buenas tardes!"
                    else -> "Error"
                }
            }

            // Check if the message contains "como estas"
            message.contains("como estas") -> {
                when (random) {
                    0 -> "Estoy bien!"
                    2 -> "Estoy excelente!"
                    3 -> "Estoy muy bien!"
                    else -> "Error"
                }
            }

            // Check if the message contains "voltear"
            message.contains("voltear") && message.contains("moneda") -> {
                val randomCoin = (0..1).random()
                val result = if (randomCoin == 0) "Cara" else "Cruz"
                "He volteado una moneda y el resultado es $result!"
            }

            // Check if the message contains "resolver"
            message.contains("resolver") -> {
                val equation = message.substringAfter("resolver")

                return try {
                    val answer = SolveMath.solveMath(equation)
                    "El resultado de tu ecuación es $answer."
                } catch (e: Exception) {
                    "Lo siento, no puedo resolver eso."
                }
            }

            // Get the current time
            message.contains("hora") && message.contains("?") -> {
                Time.timeStamp()
            }

            // Check if the message contains "abrir"
            message.contains("abrir") -> {
                OPEN_GOOGLE
            }

            // Check if the message contains "buscar"
            message.contains("buscar") -> {
                OPEN_SEARCH
            }

            // If the message doesn't contain "abrir" or "buscar"
            else -> {
                when (random) {
                    0 -> "Lo siento, no entiendo."
                    1 -> "No estoy seguro de lo que quieres decir."
                    2 -> "No estoy seguro de cómo respondes a eso."
                    else -> "Error"
                }
            }
        }
    }
}
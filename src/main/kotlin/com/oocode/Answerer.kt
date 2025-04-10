package com.oocode

import kotlin.math.cbrt
import kotlin.math.sqrt

class Answerer {
    fun answerFor(question: String): String {
        var questionCopy = question
        if (questionCopy.contains("What is your name", ignoreCase = true)) {
            return "Chris and Ed"
        }
        if (question.contains("Which of the following numbers are primes:")) { //Which of the following numbers are primes: 13, 52, 21, 35, 59?
            questionCopy = questionCopy.replace("?", "")
            val x = questionCopy.split(": ")[1].split(",").map { v -> v.trim().toInt() }
            val s = mutableListOf<String>()
            for (y in x) {
                if (y > 1) {
                    var divisible = false
                    for (i in 2..sqrt(y.toDouble()).toInt()) {
                        if (y % i == 0) {
                            divisible = true
                        }
                    }
                    if (!divisible) {
                        s.add(y.toString())
                    }
                }
            }
            return s.joinToString(", ")
        }
        if (question.contains("-?\\d+\\s+plus\\s+-?\\d+\\s+plus\\s+-?\\d+".toRegex())) {
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split(" ")
            return (parts[2].trim().toInt() + parts[4].trim().toInt() + parts[6].trim().toInt()).toString()
        }
        if (question.contains("Which of the following numbers is both a square and a cube:")) {
            questionCopy = questionCopy.replace("?", "")
            val x = questionCopy.split(": ")[1].split(",").map { v -> v.trim().toInt() }
            for (y in x) {
                val cubeRoot = cbrt(y.toDouble())
                if (cubeRoot == cubeRoot.toLong().toDouble()) {
                    val sqrRoot = sqrt(y.toDouble())
                    if (sqrRoot == sqrRoot.toLong().toDouble()) {
                        return y.toString()
                    }
                }
            }
        }
        if (questionCopy.contains("largest", ignoreCase = true)) {
            questionCopy = questionCopy.replace("?", "")
            return questionCopy.split(": ")[1].split(",").map { v -> v.trim().toInt() }.max().toString()
        }
        if (questionCopy.contains("smallest", ignoreCase = true)) {
            questionCopy = questionCopy.replace("?", "")
            return questionCopy.split(": ")[1].split(",").map { v -> v.trim().toInt() }.min().toString()
        }
        if ("-?\\d+\\s+\\+\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+\\+-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("+")
            return (parts[0].trim().toInt() + parts[1].trim().toInt()).toString()
        }
        if ("-?\\d+\\s+plus\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+plus-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("plus")
            return (parts[0].trim().toInt() + parts[1].trim().toInt()).toString()
        }
        if ("-?\\d+\\s+-\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+--?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("-")
            return (parts[0].trim().toInt() - parts[1].trim().toInt()).toString()
        }
        if ("-?\\d+\\s+minus\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+minus-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("minus")
            return (parts[0].trim().toInt() - parts[1].trim().toInt()).toString()
        }
        if ("-?\\d+\\s+\\*\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+\\*-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("*")
            return (parts[0].trim().toInt() * parts[1].trim().toInt()).toString()
        }
        if ("-?\\d+\\s+multiplied by\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+multiplied by-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val whatIs = "What is"
            val index = questionCopy.indexOf(whatIs, ignoreCase = true)
            if (index != 1) {
                questionCopy = questionCopy.removeRange(index, whatIs.length)
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("multiplied by")
            return (parts[0].trim().toInt() * parts[1].trim().toInt()).toString()
        }
        return "I don't know"
    }
}
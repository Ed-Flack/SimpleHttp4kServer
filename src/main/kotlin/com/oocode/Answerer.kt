package com.oocode

class Answerer {
    fun answerFor(question: String): String {
        var questionCopy = question
        if (questionCopy.contains("What is your name?")) {
            return "Ed and Ilona"
        }
        if ("\\d+\\s+\\+\\s+\\d+".toRegex().containsMatchIn(questionCopy) || "\\d+\\+\\d+".toRegex().containsMatchIn(questionCopy)) {
            if (questionCopy.contains("What is", ignoreCase = true)) {
                questionCopy = questionCopy.substringAfter("What is")
            }
            if (questionCopy.contains("?")) {
                questionCopy = questionCopy.replace("?", "")
            }
            val parts = questionCopy.split("+")
            return (parts[0].trim().toInt() + parts[1].trim().toInt()).toString()
        }
        return "I don't know"
    }
}
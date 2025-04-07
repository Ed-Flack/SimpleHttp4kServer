package com.oocode

class Answerer {
    fun answerFor(question: String): String {
        var questionCopy = question
        if (questionCopy.contains("What is your name", ignoreCase = true)) {
            return "Ed and Ilona"
        }
        if ("-?\\d+\\s+\\+\\s+-?\\d+".toRegex().containsMatchIn(questionCopy) || "-?\\d+\\+-?\\d+".toRegex().containsMatchIn(questionCopy)) {
            val index: Int
            val whatIs = "What is"
            if (questionCopy.indexOf(whatIs, ignoreCase = true) != -1) {
                index = questionCopy.indexOf(whatIs, ignoreCase = true)
                questionCopy = questionCopy.removeRange(index, whatIs.length)
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
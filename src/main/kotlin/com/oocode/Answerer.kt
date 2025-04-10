package com.oocode

class Answerer {
    fun answerFor(question: String): String {
        var questionCopy = question
        if (questionCopy.contains("What is your name", ignoreCase = true)) {
            return "Chris and Ed"
        }
        if (questionCopy.contains("largest", ignoreCase = true)) {
            questionCopy = questionCopy.replace("?", "")
            return questionCopy.split(": ")[1].split(",").map { v -> v.trim().toInt() }.max().toString()
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
        return "I don't know"
    }
}
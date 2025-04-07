package com.oocode

class Answerer {
    fun answerFor(question: String): String {
        if (question.contains("What is your name?")) {
            return "Ed and Ilona"
        }
        if (question.contains("2 + 2")) {
            return "4"
        }
        return "I don't know"
    }
}
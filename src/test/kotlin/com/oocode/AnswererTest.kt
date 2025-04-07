package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class AnswererTest {
    @Test
    fun `can answer name`() {
        val contents = Answerer().answerFor("What is your name?")
        assertThat(contents, equalTo("Ed and Ilona"))
    }

    @Test
    fun `just name`() {
        val contents = Answerer().answerFor("name")
        assertThat(contents, equalTo("I don't know"))
    }

    @Test
    fun `can pretend to do calculations`() {
        val contents = Answerer().answerFor("What is 2 + 2?")
        assertThat(contents, equalTo("4"))
    }

    @Test
    fun `just number`() {
        val contents = Answerer().answerFor("2")
        assertThat(contents, equalTo("I don't know"))
    }

    @Test
    fun `does not know the answer in other cases`() {
        val contents = Answerer().answerFor("What is the answer to life, the universe, and everything?")
        assertThat(contents, equalTo("I don't know"))
    }
}
/**/
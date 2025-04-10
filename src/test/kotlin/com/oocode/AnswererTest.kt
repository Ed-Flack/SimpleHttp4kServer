package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class AnswererTest {
    @Test
    fun `can answer name`() {
        val contents = Answerer().answerFor("What is your name?")
        assertThat(contents, equalTo("Chris and Ed"))
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
    fun `can pretend to do calculations 2`() {
        val contents = Answerer().answerFor("What is 25 + 2?")
        assertThat(contents, equalTo("27"))
    }

    @Test
    fun `can pretend to do calculations 3`() {
        val contents = Answerer().answerFor("What is 2 plus 2?")
        assertThat(contents, equalTo("4"))
    }

    @Test
    fun `max`() {
        val contents = Answerer().answerFor("Which of the following numbers is the largest: 24, 90, 91?")
        assertThat(contents, equalTo("91"))
    }

    @Test
    fun `min`() {
        val contents = Answerer().answerFor("Which of the following numbers is the smallest: 24, 90, 91?")
        assertThat(contents, equalTo("24"))
    }

    @Test
    fun `can pretend to do calculations minus`() {
        val contents = Answerer().answerFor("What is 25 minus 2?")
        assertThat(contents, equalTo("23"))
    }

    @Test
    fun `can pretend to do calculations minus 2`() {
        val contents = Answerer().answerFor("What is 25 - 2?")
        assertThat(contents, equalTo("23"))
    }

    @Test
    fun `can pretend to do calculations prime`() {
        val contents = Answerer().answerFor("Which of the following numbers are primes: 13, 52, 21, 35, 59?")
        assertThat(contents, equalTo("13"))
    }

    @Test
    fun `can pretend to do calculations  cube and square`() {
        val contents = Answerer().answerFor("Which of the following numbers is both a square and a cube: 2869, 4769, 4902, 144, 4096, 3200?")
        assertThat(contents, equalTo("4096"))
    }

    @Test
    fun `can pretend to do calculations multi`() {
        val contents = Answerer().answerFor("What is 25 * 2?")
        assertThat(contents, equalTo("50"))
    }

    @Test
    fun `can pretend to do calculations multi 2`() {
        val contents = Answerer().answerFor("What is 25 multiplied by 2?")
        assertThat(contents, equalTo("50"))
    }


    @Test
    fun `can pretend to do calculations 4`() {
        val contents = Answerer().answerFor("What is 25 plus 2?")
        assertThat(contents, equalTo("27"))
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
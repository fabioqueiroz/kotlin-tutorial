package com.fq.navigationtutorial

import kotlin.random.Random

class Data {
    companion object {
        fun getLanguages(): Array<String> = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")
        fun getCardSpinnerOptions(): Array<String> = arrayOf("Bar", "Cafe", "Restaurant")
        fun getRandomNumber(): Int = (0..10).random() //Random.nextInt(0, 10)
    }
}
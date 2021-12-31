package com.fq.navigationtutorial

import kotlin.random.Random

class Data {
    companion object {
        fun getLanguages(): Array<String> = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")
        fun getCardSpinnerOptions(): Array<String> = arrayOf("Bar", "Cafe", "Restaurant")

        fun getQuestionOneSpinnerOptions(): Array<String> = arrayOf("Test 1.1", "Test 1.2", "Test 1.3", "Test 1.4")

        fun getQuestionTwoSpinnerOptions(): Array<String> = arrayOf("Test 2.1", "Test 2.2", "Test 2.3", "Test 2.4")

        fun getQuestionThreeSpinnerOptions(): Array<String> = arrayOf("Test 3.1", "Test 3.2", "Test 3.3", "Test 3.4")

        fun getQuestionFourSpinnerOptions(): Array<String> = arrayOf("Test 4.1", "Test 4.2", "Test 4.3", "Test 4.4")

        fun getQuestionFiveSpinnerOptions(): Array<String> = arrayOf("Test 5.1", "Test 5.2", "Test 5.3", "Test 5.4")

        fun getImageSpinnerOptions(): Array<String> = arrayOf("Cell organelles", "Test 2", "Test 3")

        fun getRandomNumber(): Int = (0..10).random() //Random.nextInt(0, 10)

        fun getDragOptionsQuestions() : Array<String> = arrayOf(
            "Who is responsible for modifying and packaging proteins and lipids into vesicles?",
            "Which is the organelle responsible for producing cell energy that contains a unique genome?",
            "What is the name of a cellular particle made of RNA and protein that serves as the site for protein synthesis in the cell?",
            "Name the eukaryotic organelle which fully enclosed membrane contains the majority of the cell's genetic material:"
        )
        fun getDragOptionsTwoQuestions() : Array<String> = arrayOf(
            "test 2",
            "Which is the organelle responsible for producing cell energy that contains a unique genome?",
            "What is the name of a cellular particle made of RNA and protein that serves as the site for protein synthesis in the cell?",
            "Name the eukaryotic organelle which fully enclosed membrane contains the majority of the cell's genetic material:"
        )
        fun getDragOptionsThreeQuestions() : Array<String> = arrayOf(
            "test 3",
            "Which is the organelle responsible for producing cell energy that contains a unique genome?",
            "What is the name of a cellular particle made of RNA and protein that serves as the site for protein synthesis in the cell?",
            "Name the eukaryotic organelle which fully enclosed membrane contains the majority of the cell's genetic material:"
        )
    }
}
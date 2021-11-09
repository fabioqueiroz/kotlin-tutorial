package com.fq.navigationtutorial

class SurveyModel() {
    val survey = ArrayList<SurveyItem>()

    init {
        survey.add(SurveyItem("Restaurant", 1.0f, R.drawable.restaurant))
        survey.add(SurveyItem("Cafe", 2.0f, R.drawable.coffee))
        survey.add(SurveyItem("Bar", 4.0f,R.drawable.bar))
    }
}
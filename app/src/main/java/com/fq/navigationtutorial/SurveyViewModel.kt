package com.fq.navigationtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel()  {
    val surveyLiveModel = MutableLiveData<SurveyModel>()

    init {
        surveyLiveModel.value = SurveyModel()
    }
}
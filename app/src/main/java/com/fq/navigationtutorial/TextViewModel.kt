package com.fq.navigationtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    val myLiveModel = MutableLiveData<DisplayTextModel>()

    init {
        myLiveModel.value = DisplayTextModel("Test",666)
    }
}
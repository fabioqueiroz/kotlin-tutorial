package com.fq.navigationtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DraggableViewModel : ViewModel()  {
    val draggableLiveModel = MutableLiveData<DraggableModel>()

    init {
        draggableLiveModel.value = DraggableModel()
    }
}
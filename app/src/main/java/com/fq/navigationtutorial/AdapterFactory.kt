package com.fq.navigationtutorial

import android.R
import android.content.Context
import android.widget.ArrayAdapter

class AdapterFactory {
    companion object{
        fun createArrayAdapter(context: Context, resource: Int, objects: Array<Any>): ArrayAdapter<Any> {
            var arrayAdapter = ArrayAdapter(context, R.layout.simple_spinner_item, objects)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            return  arrayAdapter
        }
    }
}
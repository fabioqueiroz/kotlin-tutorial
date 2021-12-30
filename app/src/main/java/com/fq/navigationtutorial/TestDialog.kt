package com.fq.navigationtutorial

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class TestDialog : DialogFragment() {
    private lateinit var dialogBuilder: AlertDialog.Builder
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Test message")
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                    })
                .setNegativeButton("Close",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            dialogBuilder = builder
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun showTestDialog(): AlertDialog? {
        return dialogBuilder.show()
    }
}
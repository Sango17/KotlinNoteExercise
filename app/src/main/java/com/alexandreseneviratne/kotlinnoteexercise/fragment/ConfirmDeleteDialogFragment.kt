package com.alexandreseneviratne.kotlinnoteexercise.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteDialogFragment: DialogFragment() {
    interface ConfirmDeleteDialogListener {
        fun onPositiveListener()
        fun onNegativeListener()
    }

    var listener: ConfirmDeleteDialogListener? = null
    val noteTitle: String = ""

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder
            .setTitle("Delete note")
            .setMessage("Are you sure to delete \"$noteTitle\" ?")
            .setPositiveButton("Yes") {dialog, which ->
                listener?.onPositiveListener()
            }
            .setNegativeButton("Cancel") {dialog, which ->
                listener?.onNegativeListener()
            }

        return builder.create()
    }
}
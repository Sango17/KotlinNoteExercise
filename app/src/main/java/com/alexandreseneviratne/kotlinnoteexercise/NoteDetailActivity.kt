package com.alexandreseneviratne.kotlinnoteexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NOTE: String = "note"
        const val EXTRA_NOTE_INDEX: String = "noteIndex"

        const val EDIT_NOTE_REQUEST_CODE: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)
    }
}

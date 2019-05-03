package com.alexandreseneviratne.kotlinnoteexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_note_detail.*

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NOTE: String = "note"
        const val EXTRA_NOTE_INDEX: String = "noteIndex"

        const val EDIT_NOTE_REQUEST_CODE: Int = 1
    }

    private lateinit var noteTitle: TextView
    private lateinit var noteText: TextView

    private lateinit var note: Note
    private var noteIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        noteTitle = findViewById(R.id.note_detail_title)
        noteText = findViewById(R.id.note_detail_text)

        if (intent != null) {
            note = intent.getParcelableExtra(EXTRA_NOTE)
            noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)

            noteTitle.text = note.title
            noteText.text = note.text
        }
    }
}

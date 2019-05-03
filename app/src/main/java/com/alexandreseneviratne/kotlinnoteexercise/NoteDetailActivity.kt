package com.alexandreseneviratne.kotlinnoteexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                Toast.makeText(this, "ACTION_SAVE", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_delete -> {
                Toast.makeText(this, "ACTION_DELETE", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

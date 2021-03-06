package com.alexandreseneviratne.kotlinnoteexercise

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.alexandreseneviratne.kotlinnoteexercise.fragment.ConfirmDeleteDialogFragment
import kotlinx.android.synthetic.main.activity_note_detail.*

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NOTE: String = "note"
        const val EXTRA_NOTE_INDEX: String = "noteIndex"

        const val EDIT_NOTE_REQUEST_CODE: Int = 1

        const val ACTION_SAVE: String = "com.alexandreseneviratne.kotlinnoteexercise.actions.ACTION_SAVE"
        const val ACTION_DELETE: String = "com.alexandreseneviratne.kotlinnoteexercise.actions.ACTION_DELETE"
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
                saveNote()
                return true
            }
            R.id.action_delete -> {
                val dialog = ConfirmDeleteDialogFragment()
                dialog.noteTitle = noteTitle.text.toString()
                dialog.listener = object : ConfirmDeleteDialogFragment.ConfirmDeleteDialogListener {
                    override fun onPositiveListener() {
                        deleteNote()
                    }

                    override fun onNegativeListener() {
                        TODO("nothing specific for the moment")
                    }
                }

                dialog.show(supportFragmentManager, "deleteNote")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun deleteNote() {
        val intent = Intent(ACTION_DELETE)
        intent.putExtra(EXTRA_NOTE, note)
        intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun saveNote() {
        note.title = noteTitle.text.toString()
        note.text = noteText.text.toString()

        val intent = Intent(ACTION_SAVE)
        intent.putExtra(EXTRA_NOTE, note)
        intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)

        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}

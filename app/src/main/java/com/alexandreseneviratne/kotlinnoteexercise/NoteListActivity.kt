package com.alexandreseneviratne.kotlinnoteexercise

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexandreseneviratne.kotlinnoteexercise.adapter.NoteListAdapter
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var notes: MutableList<Note>
    private lateinit var adapter: NoteListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        setSupportActionBar(toolbar)

        note_list_add_fab.setOnClickListener(this)

        notes = mutableListOf()

        notes.add(Note("Hello", "World"))
        notes.add(Note("Why Java ?", "Because Kotlin"))
        notes.add(Note("Amanda", "Alex"))
        notes.add(Note("Papa", "Maman"))

        recyclerView = findViewById(R.id.note_list_recyclerview)
        adapter = NoteListAdapter(notes, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK || data == null) {
            return
        } else {
            when (requestCode) {
                 NoteDetailActivity.EDIT_NOTE_REQUEST_CODE-> processEditNote(data)
            }
        }
    }

    private fun processEditNote(data: Intent) {
        val noteIndex: Int = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)

        when (data.action) {
            NoteDetailActivity.ACTION_SAVE -> {
                val note: Note = data.getParcelableExtra(NoteDetailActivity.EXTRA_NOTE)
                saveNote(note, noteIndex)
            }
            NoteDetailActivity.ACTION_DELETE -> {
                return
            }
        }
    }

    private fun saveNote(note: Note, noteIndex: Int) {
        if (noteIndex < 0) {
            notes.add(0, note)
        } else {
            notes[noteIndex] = note
        }

        adapter.notifyDataSetChanged()
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            showDetail(view.tag as Int)
        } else {
            when (view.id) {
                R.id.note_list_add_fab -> {
                    createNewNote()
                }
            }
        }
    }

    private fun createNewNote() {
        showDetail(-1)
    }

    private fun showDetail(index: Int) {
        val note: Note = if (index < 0) Note() else notes[index]

        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, index)

        startActivityForResult(intent, NoteDetailActivity.EDIT_NOTE_REQUEST_CODE)
    }
}

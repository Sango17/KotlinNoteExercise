package com.alexandreseneviratne.kotlinnoteexercise

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

    override fun onClick(view: View) {
        if (view.tag != null) {
            val index: Int = view.tag as Int
            val note: Note = notes[view.tag as Int]

            Toast.makeText(this, note.title, Toast.LENGTH_SHORT).show()
        }
    }
}

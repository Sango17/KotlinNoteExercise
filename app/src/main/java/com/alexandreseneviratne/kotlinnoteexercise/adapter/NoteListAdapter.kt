package com.alexandreseneviratne.kotlinnoteexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alexandreseneviratne.kotlinnoteexercise.Note
import com.alexandreseneviratne.kotlinnoteexercise.R

class NoteListAdapter(val notes: MutableList<Note>, val itemClickListener: View.OnClickListener):
    RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.note_list_cardview)
        val title: TextView = cardView.findViewById(R.id.note_list_title)
        val text: TextView = cardView.findViewById(R.id.note_list_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item_note, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]

        holder.cardView.tag = position
        holder.cardView.setOnClickListener(itemClickListener)

        holder.title.text = note.title
        holder.text.text = note.text
    }


}
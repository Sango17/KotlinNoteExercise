package com.alexandreseneviratne.kotlinnoteexercise

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NoteUnitTest {
    @Test
    fun createNoteWithTitle() {
        // Create a new Note instance, with the title "Alex"
        val note: Note = Note("Alex")

        // Check the title of the note
        assertEquals("Alex", note.title)
    }

    @Test
    fun createNoteWithTitleAndText() {
        // Create a new Note instance, with the title "Alex" and the text "Amanda"
        val note: Note = Note("Alex", "Amanda")

        // Check the title of the note
        assertEquals("Alex", note.title)

        // Check the text of the note
        assertEquals("Amanda", note.text)
    }

    @Test
    fun modifyNoteTitle() {
        // Create a new Note instance, with the title "Alex"
        val note: Note = Note("Alex")

        // Modify the note's title by putting "Amanda"
        note.title = "Amanda"

        // Check that the title of the note contains "Amanda"
        assertEquals("Amanda", note.title)
    }

    @Test
    fun modifyNoteText() {
        // Create a new Note instance, with the title "Alex" and with the text "Amanda"
        val note: Note = Note("Alex","Amanda")

        // Modify the note's text by putting "Amanda"
        note.text = "Alex"

        // Check that the text of the note contains "Amanda"
        assertEquals("Alex", note.text)
    }
}

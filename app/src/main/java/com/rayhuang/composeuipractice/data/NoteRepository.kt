package com.rayhuang.composeuipractice.data

import com.rayhuang.composeuipractice.model.Note
import io.reactivex.rxjava3.core.Observable

interface NoteRepository {
    fun getAll(): Observable<List<Note>>
}

class InMemoryNoteRepository(): NoteRepository {
    private val allNotes = listOf(
        Note.createRandomNote()
    )

    override fun getAll(): Observable<List<Note>> {
        return Observable.just(allNotes)
    }
}
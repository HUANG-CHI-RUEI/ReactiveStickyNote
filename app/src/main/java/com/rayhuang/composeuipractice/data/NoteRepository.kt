package com.rayhuang.composeuipractice.data

import com.rayhuang.composeuipractice.model.Note
import io.reactivex.rxjava3.core.Observable

interface NoteRepository {
    fun getAll(): Observable<List<Note>>
    fun putNote(note: Note)
}


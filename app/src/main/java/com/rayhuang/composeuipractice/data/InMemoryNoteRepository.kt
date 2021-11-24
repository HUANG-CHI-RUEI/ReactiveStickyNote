package com.rayhuang.composeuipractice.data

import com.rayhuang.composeuipractice.model.Note
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.ConcurrentHashMap

class InMemoryNoteRepository(): NoteRepository {

    private val notesSubject = BehaviorSubject.create<List<Note>>()
    private val noteMap = ConcurrentHashMap<String, Note>()

    init {
        val initNote = Note.createRandomNote()
        noteMap[initNote.id] = initNote
        notesSubject.onNext(noteMap.elements().toList())
    }

    override fun getAll(): Observable<List<Note>> {
        return notesSubject.hide()
    }

    override fun putNote(newNote: Note) {
        noteMap[newNote.id] = newNote
        notesSubject.onNext(noteMap.elements().toList())
    }
}
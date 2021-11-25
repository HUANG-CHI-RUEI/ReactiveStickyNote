package com.rayhuang.composeuipractice.domain

import androidx.lifecycle.ViewModel
import com.rayhuang.composeuipractice.data.NoteRepository
import com.rayhuang.composeuipractice.model.Position
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.*

class BoardViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    val allNotes = noteRepository.getAll()

    private val disposableBag = CompositeDisposable()
    
    fun moveNote(noteId: String, delta: Position) {
        Observable.just(Pair(noteId, delta))
            .withLatestFrom(allNotes) { (noteId, delta), notes ->
                val currentNote = notes.find { note -> note.id == noteId}
                Optional.ofNullable(currentNote?.copy(position = currentNote.position + delta))
            }
            .mapOptional {it}
            .subscribe  { newNote ->
                noteRepository.putNote(newNote)
            }
            .addTo(disposableBag)
    }
}
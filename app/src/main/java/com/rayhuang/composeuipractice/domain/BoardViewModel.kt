package com.rayhuang.composeuipractice.domain

import androidx.lifecycle.ViewModel
import com.rayhuang.composeuipractice.data.NoteRepository

class BoardViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    val allNotes = noteRepository.getAll()
}
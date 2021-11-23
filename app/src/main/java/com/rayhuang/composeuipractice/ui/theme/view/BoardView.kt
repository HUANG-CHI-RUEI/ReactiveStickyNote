package com.rayhuang.composeuipractice.ui.theme.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rayhuang.composeuipractice.StickyNote
import com.rayhuang.composeuipractice.domain.BoardViewModel
import com.rayhuang.composeuipractice.model.Note

@Composable
fun BoardView(boardViewModel: BoardViewModel) {
    val notes by boardViewModel.allNotes.subscribeAsState(initial = emptyList())

    Box(Modifier.fillMaxSize()) {
        notes.forEach { note ->
            StickyNote(note = note)
        }
    }
}

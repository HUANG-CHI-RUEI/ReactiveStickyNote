package com.rayhuang.composeuipractice.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rayhuang.composeuipractice.domain.BoardViewModel
import com.rayhuang.composeuipractice.model.Note
import com.rayhuang.composeuipractice.model.Position


@Composable
fun BoardView(boardViewModel: BoardViewModel) {
    val notes by boardViewModel.allNotes.subscribeAsState(initial = emptyList())

    Box(Modifier.fillMaxSize()) {
        notes.forEach { note ->
            val onNotePositionChanged: (Position) -> Unit = {delta ->
                boardViewModel.moveNote(note.id, delta)
            }
            StickyNote(
                modifier = Modifier.align(Alignment.Center),
                onPositionChanged = onNotePositionChanged,
                note = note)
        }
    }
}


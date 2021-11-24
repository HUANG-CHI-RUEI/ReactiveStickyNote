package com.rayhuang.composeuipractice.ui.theme.view

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rayhuang.composeuipractice.model.Note
import com.rayhuang.composeuipractice.model.Position

@Composable
fun StickyNote(
    modifier: Modifier = Modifier,
    onPositionChanged: (Position) -> Unit = {},
    note: Note
) {

    Surface(
        modifier
            .offset(x = note.position.x.dp, y = note.position.y.dp)
            .size(108.dp, 108.dp),
        color = Color(note.color.color),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .pointerInput(note.id) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        onPositionChanged(Position(dragAmount.x, dragAmount.y))
                    }
                }
            .padding(16.dp)
        ) {
            Text(text = note.text, style = MaterialTheme.typography.h5)
        }
    }
}



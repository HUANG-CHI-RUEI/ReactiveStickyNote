package com.rayhuang.composeuipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rayhuang.composeuipractice.model.Note
import com.rayhuang.composeuipractice.ui.theme.ComposeUIPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUIPracticeTheme {

            }
        }
    }
}

@Composable
fun StickyNote(note: Note) {
    Surface(
        Modifier
            .offset(x = note.position.x.dp, y = note.position.y.dp)
            .size(108.dp, 108.dp),
        color = Color(note.color.color),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
        ) {
            Text(text = note.text, style = MaterialTheme.typography.h5)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StickyNotePreview() {
    Box(Modifier.fillMaxSize()) {
        StickyNote(Note.createRandomNote())
        StickyNote(Note.createRandomNote())
    }
}

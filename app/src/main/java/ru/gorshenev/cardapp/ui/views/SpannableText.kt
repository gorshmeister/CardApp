package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun SpannableText(text: String, onClick: () -> Unit, fontSize: TextUnit = 14.sp) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Blue, textDecoration = TextDecoration.Underline)) {
            append(text)
        }
    }
    Text(
        text = annotatedString,
        modifier = Modifier.clickable { onClick() },
        fontSize = fontSize,
        textAlign = TextAlign.Center
    )
}

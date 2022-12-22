package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.toSize
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardState

@Composable

fun OutlinedTextFieldWithDropdownMenu(
    query: State<String>,
    state: State<CardState>,
    onValueChanged: (String) -> Unit,
    onItemMenuClick: (String) -> Unit
) {
    val textFieldSize = remember { mutableStateOf(Size.Zero) }
    val expanded = remember { mutableStateOf(false) }
    val imageVector =
        if (expanded.value) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown

    Column() {
        OutlinedTextFieldWithError(
            value = query.value,
            onValueChange = onValueChanged,
            placeholder = { Text(text = stringResource(R.string.write_Bin)) },
            maxLines = 1,
            isError = query.value.length > 8 || state.value.error != null,
            errorIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Rounded.Warning),
                    contentDescription = null
                )
            },
            errorMessage = {
                if (query.value.length > 8) {
                    Text(text = stringResource(R.string.Error8))
                } else if (state.value.error != null) {
                    Text(text = "Error: ${state.value.error.toString()}")
                }
                expanded.value = !expanded.value
            },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize.value = coordinates.size.toSize()
                },
            trailingIcon = {
                Icon(
                    imageVector = imageVector,
                    contentDescription = "",
                    modifier = Modifier.clickable { expanded.value = !expanded.value })
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .background(color = Color.White)
                .width(with(LocalDensity.current) { textFieldSize.value.width.toDp() })
        ) {
            state.value.cardsHistory.forEach() { cardNumber ->
                DropdownMenuItem(onClick = {
                    onItemMenuClick(cardNumber)
                    expanded.value = !expanded.value
                }) { Text(text = cardNumber) }
            }
        }

    }
}

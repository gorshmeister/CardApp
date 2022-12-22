package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardState
import ru.gorshenev.cardapp.ui.CardUi

@Composable
fun HomeScreen(
    query: State<String>,
    state: State<CardState>,
    onValueChanged: (String) -> Unit,
    onButtonClick: () -> Unit,
    onNumberClick: () -> Unit,
    onCountryClick: () -> Unit,
    onUrlClick: () -> Unit,
    onItemMenuClick: (String) -> Unit
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            OutlinedTextFieldWithDropdownMenu(
                query = query,
                state = state,
                onValueChanged = onValueChanged,
                onItemMenuClick = onItemMenuClick
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                onClick = onButtonClick,
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .weight(1f)
            ) { Text(text = stringResource(R.string.get_info), textAlign = TextAlign.Center) }
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (state.value.isLoading && state.value.error == null) CircularProgressIndicator(
            modifier = Modifier
                .size(64.dp)
                .padding(top = 25.dp)
                .align(CenterHorizontally), strokeWidth = 6.dp
        )
        else if (state.value.card != CardUi.emptyCard()) {
            CardItem(
                item = state.value.card,
                needRefresh = state.value.needRefreshCard,
                onCallClick = onNumberClick,
                onMapClick = onCountryClick,
                onUrlClick = onUrlClick,
                onRefreshClick = onButtonClick
            )
        }
    }
}

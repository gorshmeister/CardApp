package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardUi

@Composable
fun CardColumnFirst(modifier: Modifier, item: CardUi) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.scheme_network),
                color = Color.DarkGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            Text(text = item.scheme)
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(R.string.brand), color = Color.DarkGray, fontSize = 12.sp)
            Text(text = item.brand)
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.card_number),
                color = Color.DarkGray,
                fontSize = 12.sp
            )
            Row() {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.length),
                        fontSize = 10.sp,
                        color = Color.DarkGray
                    )
                    Text(text = item.numberLength)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.luhn),
                        fontSize = 10.sp,
                        color = Color.DarkGray
                    )
                    Text(
                        text = if (item.luhnCheckStatus) stringResource(id = R.string.yes)
                        else stringResource(id = R.string.no)
                    )
                }
            }
        }
    }
}
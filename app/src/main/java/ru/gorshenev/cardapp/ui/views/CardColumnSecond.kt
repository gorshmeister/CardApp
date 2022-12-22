package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardUi

@Composable
fun CardColumnSecond(modifier: Modifier, item: CardUi, onMapClick: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        ) {
            Text(text = stringResource(R.string.type), color = Color.DarkGray, fontSize = 12.sp)
            Text(text = item.type)
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(R.string.prepaid), color = Color.DarkGray, fontSize = 12.sp)
            Text(
                text = if (item.cardPrepaidStatus) stringResource(id = R.string.yes)
                else stringResource(id = R.string.no)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(R.string.country), color = Color.DarkGray, fontSize = 12.sp)
            Row() {
                Text(text = item.countryEmoji)
                SpannableText(text = item.countryName, onClick = onMapClick)
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.numeric),
                        color = Color.DarkGray,
                        fontSize = 10.sp
                    )
                    Text(text = item.countryNumeric, fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.currency),
                        color = Color.DarkGray,
                        fontSize = 10.sp
                    )
                    Text(text = item.countryCurrency, fontSize = 10.sp)
                }
            }
            Row() {
                Text(
                    text = stringResource(R.string.latitude),
                    fontSize = 10.sp,
                    color = Color.DarkGray
                )
                Text(text = item.countryLatitude, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.longitude),
                    fontSize = 10.sp,
                    color = Color.DarkGray
                )
                Text(text = item.countryLongitude, fontSize = 10.sp)
            }
        }
    }
}
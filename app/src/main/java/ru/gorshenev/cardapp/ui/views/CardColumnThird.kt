package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardUi

@Composable
fun CardColumnThird(
    modifier: Modifier,
    item: CardUi,
    needRefresh: Boolean,
    onUrlClick: () -> Unit,
    onCallClick: () -> Unit,
    onRefreshClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = stringResource(R.string.bank), color = Color.DarkGray, fontSize = 12.sp)
            Text(text = item.bankName, fontSize = 12.sp, textAlign = TextAlign.Center)

            Text(text = item.bankCity, fontSize = 12.sp)
            SpannableText(text = item.bankUrl, onUrlClick, fontSize = 12.sp)
            SpannableText(text = item.bankPhone, onCallClick, fontSize = 12.sp)

            if (needRefresh) {
                Row(
                    Modifier.padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.refresh),
                        contentDescription = "",
                        modifier = Modifier.clickable { onRefreshClick() })
                }
            }
        }
    }
}
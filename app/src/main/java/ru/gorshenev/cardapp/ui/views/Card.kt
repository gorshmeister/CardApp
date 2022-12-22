package ru.gorshenev.cardapp.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.gorshenev.cardapp.R
import ru.gorshenev.cardapp.ui.CardUi

@Composable
fun CardItem(
    item: CardUi,
    needRefresh: Boolean,
    onCallClick: () -> Unit,
    onMapClick: () -> Unit,
    onUrlClick: () -> Unit,
    onRefreshClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(6.dp),
        elevation = 8.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.design),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Box() {
            Row(Modifier.padding(start = 10.dp)) {
                CardColumnFirst(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1.5f),
                    item = item
                )

                CardColumnSecond(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f),
                    item = item,
                    onMapClick = onMapClick
                )

                CardColumnThird(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f),
                    item = item,
                    needRefresh = needRefresh,
                    onUrlClick = onUrlClick,
                    onCallClick = onCallClick,
                    onRefreshClick = onRefreshClick
                )
            }
        }
    }
}

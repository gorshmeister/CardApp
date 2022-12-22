package ru.gorshenev.cardapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.gorshenev.cardapp.Utils.appComponent
import ru.gorshenev.cardapp.ui.CardUi
import ru.gorshenev.cardapp.ui.CardViewModel
import ru.gorshenev.cardapp.ui.ViewModelFactory
import ru.gorshenev.cardapp.ui.theme.CardAppTheme
import ru.gorshenev.cardapp.ui.views.HomeScreen
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelFactory<CardViewModel>

    private val viewModel: CardViewModel by viewModels { factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.appComponent.inject(this)

        setContent {
            CardAppTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        HomeScreen(
                            query = viewModel.query,
                            state = viewModel.state,
                            onValueChanged = { newQuery -> viewModel.query.value = newQuery },
                            onButtonClick = { viewModel.loadCard(viewModel.query.value) },
                            onNumberClick = { call(viewModel.state.value.card.bankPhone) },
                            onCountryClick = { openMap(viewModel.state.value.card) },
                            onUrlClick = { openWebPage(viewModel.state.value.card.bankUrl) },
                            onItemMenuClick = { itemNumber ->
                                viewModel.query.value = itemNumber
                                viewModel.getHistoryCard(itemNumber)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun call(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openMap(cardUi: CardUi) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:${cardUi.countryLatitude},${cardUi.countryLongitude}")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse("http://$url")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
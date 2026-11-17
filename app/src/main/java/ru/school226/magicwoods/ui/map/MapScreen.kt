package ru.school226.magicwoods.ui.map

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MapScreen(viewModel: MapViewModel = viewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text("Вы находитесь в точке [${state.x}, ${state.y}]")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { viewModel.move(0, -1) }
            ) {
                Text("Вверх")
            }
            Row {
                Button(
                    onClick = { viewModel.move(-1, 0) }
                ) {
                    Text("Влево")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { viewModel.move(1, 0) }
                ) {
                    Text("Вправо")
                }
            }
            Button(
                onClick = { viewModel.move(0, 1) }
            ) {
                Text("Вниз")
            }
        }
    }
}

package com.example.botnavc.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*;
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.botnavc.domain.model.Config
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.botnavc.repository.MyDataState

@Composable
fun ConfigView(vm: ConfigViewModel = viewModel()) {
    val cfg = vm.config.observeAsState()
    return when (cfg.value) {
        is Nothing -> {
            Text("nothing")
        }
        is MyDataState.Success<Config> -> {
            val config = (cfg.value as MyDataState.Success<Config>).data;
            val ipTxt = "IP ${config?.ipaddress}"
            val macTxt = "Mac ${config?.mac}"
            val nameTxt = "${config?.name}"
            val modelTxt = "Model ${config?.model}"
            val timeTxt = "Local Time ${config?.localtime}"
            val timezoneTxt = "Timezone ${config?.timezone}"
            var txtStyle = TextStyle(
                fontSize = TextUnit.Sp(18),
            );
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {

                Column {
                    Text(
                        text = nameTxt, style = TextStyle(
                            fontSize = TextUnit.Sp(22),
                        )
                    )
                    Text(
                        text = modelTxt, style = TextStyle(
                            fontSize = TextUnit.Sp(16),
                            color = Color.DarkGray
                        )
                    )
                    Text("") //@todo spacer
                    Text(text = ipTxt, style = txtStyle)
                    Text(text = macTxt, style = txtStyle)
                    Text(text = timeTxt, style = txtStyle)
                    Text(text = timezoneTxt, style = txtStyle)
                    Text("") //@todo spacer
                    Button(
                        onClick = { /*@TODO implement*/ },
                        colors = ButtonConstants.defaultButtonColors(
                            backgroundColor = Color.Red
                        )
                    ) {
                        Text("Disconnect")
                    }
                }
            }
        }
        is MyDataState.Error -> {
            Text("Error :(")
        }
        is MyDataState.Loading -> {
            Text("Lade")
        }
        else -> {
            Text("no idea")
        }
    }

}
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.*
import androidx.compose.ui.awt.awtEventOrNull
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.InputMode
import androidx.compose.ui.input.InputModeManager
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import java.awt.event.KeyEvent
import java.time.LocalTime

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val focusRequester = FocusRequester()

    MaterialTheme {
        Row {
            Button(modifier = Modifier.focusable(false), onClick = {
                text = "Hello, Desktop!"
            }) {
                Text(text)
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.focusRequester(focusRequester).onFocusChanged {
                    println("$it -- hasFocus: ${it.hasFocus} -- isFocused: ${it.isFocused}")
                    if (!it.isFocused) focusRequester.requestFocus()
                })
        }

    }
}

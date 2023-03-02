package com.example.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
actual fun PlatformButton(
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource,
    content: @Composable RowScope.() -> Unit
) {
    Row {
        Text("Todo")
        content()
    }
}

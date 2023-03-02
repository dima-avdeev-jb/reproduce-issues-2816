package com.example.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

expect fun getPlatformName(): String

@Composable
expect fun PlatformButton(
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
)

// workaround:
//@Composable
//fun PlatformButton(
//    onClick: () -> Unit,
//    content: @Composable RowScope.() -> Unit,
//) = PlatformButton(
//    onClick = onClick,
//    interactionSource = remember { MutableInteractionSource() },
//    content = content,
//)

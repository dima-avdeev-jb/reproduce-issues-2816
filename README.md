## Bug https://github.com/JetBrains/compose-jb/issues/2816

### Reproduce
`./gradlew desktop:run`

## Workaround
Don't use default arguments in **expect** declaration
```Kotlin
@Composable
expect fun PlatformButton(
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
)
```

And create second overloaded function:
```Kotlin
@Composable
fun PlatformButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) = PlatformButton(
    onClick = onClick,
    interactionSource = remember { MutableInteractionSource() },
    content = content,
)
```

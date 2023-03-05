package com.example.quotes.core.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
        .clip(RoundedCornerShape(100))
        // .fillMaxWidth()
        .background(
            if (isSystemInDarkTheme())
                Color.White.copy(alpha = .54F) else
                Color.Black.copy(alpha = .24F)
        ),
    hint: String = "Search",
    onSearchParamChange: (String) -> Unit,
    onSearchClick: (String) -> Unit
) {
    Box(modifier = modifier.height(54.dp)) {
        var searchParam: String by remember { mutableStateOf("") }

        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current

        TextField(
            value = searchParam,
            onValueChange = { newValue ->
                searchParam = if (newValue.trim().isNotEmpty()) newValue else ""
                onSearchParamChange(newValue)
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester = focusRequester),
            singleLine = true,
            placeholder = {
                Text(
                    text = hint,
                    color = if (isSystemInDarkTheme())
                        Color.White else
                        Color.Black,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (isSystemInDarkTheme())
                    Color.White.copy(alpha = .24F) else
                    Color.Black.copy(alpha = .24F),
                textColor = if (isSystemInDarkTheme())
                    Color.White else
                    Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                trailingIconColor = if (isSystemInDarkTheme())
                    Color.White else
                    Color.Black,
            ), keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick(searchParam)
                    focusManager.clearFocus()
                }
            ),
            trailingIcon = {
                Row {
                    AnimatedVisibility(visible = searchParam.trim().isNotEmpty()) {
                        IconButton(
                            onClick = {
                                focusManager.clearFocus()
                                searchParam = ""
                                onSearchParamChange(searchParam)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null,
                                tint = if(isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            onSearchClick(searchParam)
                            focusManager.clearFocus()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = if(isSystemInDarkTheme()) Color.White else Color.Black
                        )
                    }
                }
            }
        )
    }
}

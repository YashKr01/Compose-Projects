package com.example.composeplayground.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import com.example.composeplayground.R
import com.example.composeplayground.ui.theme.INFO_ICON_SIZE
import com.example.composeplayground.ui.theme.SMALL_PADDING
import com.example.composeplayground.ui.theme.titleColor

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color = MaterialTheme.colors.primary,
    bigText: String,
    smallText: String,
    textColor: Color
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(end = SMALL_PADDING).size(INFO_ICON_SIZE),
            painter = icon,
            contentDescription = "Info icon",
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.overline.fontSize,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colors.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colors.titleColor,
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InfoBoxPreviewDark() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colors.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colors.titleColor,
    )
}
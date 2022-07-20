package com.example.composeplayground.data.models

import androidx.compose.ui.graphics.Color
import com.example.composeplayground.ui.theme.HighPriorityColor
import com.example.composeplayground.ui.theme.LowPriorityColor
import com.example.composeplayground.ui.theme.MediumPriorityColor
import com.example.composeplayground.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    IGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}
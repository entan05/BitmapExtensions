package jp.team.ework.bitmapextensions.core

import android.graphics.Color

data class ColorValue(
    val alpha: Int,
    val red: Int,
    val green: Int,
    val blue: Int
) {
    companion object {
        fun of(colorInt: Int): ColorValue = ColorValue(
            Color.alpha(colorInt),
            Color.red(colorInt),
            Color.green(colorInt),
            Color.blue(colorInt)
        )
    }
}

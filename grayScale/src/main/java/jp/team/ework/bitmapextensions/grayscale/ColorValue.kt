package jp.team.ework.bitmapextensions.grayscale

import android.graphics.Color

internal data class ColorValue(
    val alpha: Int,
    val red: Int,
    val green: Int,
    val blue: Int
) {
    companion object {
        internal fun of(colorInt: Int): ColorValue = ColorValue(
            Color.alpha(colorInt),
            Color.red(colorInt),
            Color.green(colorInt),
            Color.blue(colorInt)
        )
    }
}

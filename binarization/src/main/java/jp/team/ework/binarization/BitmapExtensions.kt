package jp.team.ework.binarization

import android.graphics.Bitmap
import android.graphics.Color
import jp.team.ework.bitmapextensions.core.ColorValue
import jp.team.ework.bitmapextensions.grayscale.grayScale

fun Bitmap.binarization(threshold: Int = 128): Bitmap {
    val black = Color.BLACK
    val white = Color.WHITE

    val grayImage = grayScale()

    val pixels = IntArray(grayImage.width * grayImage.height)
    grayImage.getPixels(pixels, 0, grayImage.width, 0, 0, grayImage.width, grayImage.height)

    for (x in 0 until grayImage.width) {
        for (y in 0 until grayImage.height) {
            val index = x + (y * grayImage.width)
            val cv = ColorValue.of(pixels[index])
            pixels[index] = if (cv.red > threshold) white else black
        }
    }

    return Bitmap.createBitmap(pixels, grayImage.width, grayImage.height, Bitmap.Config.ARGB_8888)
}

package jp.team.ework.blur

import android.graphics.Bitmap
import android.graphics.Color
import jp.team.ework.bitmapextensions.core.ColorValue

fun Bitmap.blur(radius: Int = 4): Bitmap {
    val pixels = IntArray(width * height)
    getPixels(pixels, 0, width, 0, 0, width, height)
    val result = IntArray(pixels.size)

    var alpha: Int
    var redPram: Int
    var greenParam: Int
    var blueParam: Int
    var count: Int

    for (x in 0 until width) {
        for (y in 0 until height) {
            alpha = 0
            redPram = 0
            greenParam = 0
            blueParam = 0
            count = 0

            val xMin = if (x - radius >= 0) x - radius else 0
            val xMax = if (x + radius < width) x + radius else width
            val yMin = if (y - radius >= 0) y - radius else 0
            val yMax = if (y + radius < height) y + radius else height

            for (targetX in xMin until xMax) {
                for (targetY in yMin until yMax) {
                    ColorValue.of(pixels[targetX + (targetY * width)]).also {
                        alpha += it.alpha
                        redPram += it.red
                        greenParam += it.green
                        blueParam += it.blue
                    }
                    count++
                }
            }

            alpha /= count
            redPram /= count
            greenParam /= count
            blueParam /= count

            result[x + (y * width)] = Color.argb(alpha, redPram, greenParam, blueParam)
        }
    }

    return Bitmap.createBitmap(result, width, height, Bitmap.Config.ARGB_8888)
}

package jp.team.ework.bitmapextensions.mosaic

import android.graphics.Bitmap
import android.graphics.Color
import jp.team.ework.bitmapextensions.core.ColorValue

/**
 * 平均プーリング(モザイク化)
 */
fun Bitmap.averagePooling(sizeWidth: Int = 8, sizeHeight: Int = 8): Bitmap {
    val pixels = IntArray(width * height)
    getPixels(pixels, 0, width, 0, 0, width, height)

    (0 until width).chunked(sizeWidth).forEach { xChunk ->
        (0 until height).chunked(sizeHeight).forEach { yChunk ->
            var alpha = 0
            var redPram = 0
            var greenParam = 0
            var blueParam = 0

            var count = 0
            xChunk.forEach { x ->
                yChunk.forEach { y ->
                    ColorValue.of(pixels[x + (y * width)]).also {
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
            xChunk.forEach { x ->
                yChunk.forEach { y ->
                    pixels[x + (y * width)] = Color.argb(alpha, redPram, greenParam, blueParam)
                }
            }
        }
    }

    return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888)
}

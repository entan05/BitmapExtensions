package jp.team.ework.bitmapextensions.grayscale

import android.graphics.Bitmap

/**
 * グレースケール手法種別
 */
enum class GrayScaleType {
    /** 中間値法 */
    MiddleValue,

    /** NTSC係数による加重平均法 */
    @Suppress("SpellCheckingInspection")
    NtscCoef,

    /** HDTV係数による加重平均と補正 */
    @Suppress("SpellCheckingInspection")
    ItuCoef,
}

/**
 * グレースケール
 * @param type グレースケール手法
 * @return グレースケール化されたBitmap
 */
fun Bitmap.grayScale(type: GrayScaleType = GrayScaleType.ItuCoef): Bitmap {
    val pixels = IntArray(width * height)
    getPixels(pixels, 0, width, 0, 0, width, height)

    val grayFunc: (Int) -> Int = when (type) {
        GrayScaleType.MiddleValue -> ::grayScaleMiddleValue
        GrayScaleType.NtscCoef -> ::grayScaleNtscCoef
        GrayScaleType.ItuCoef -> ::grayScaleItuCoef
    }

    for (x in 0 until width) {
        for (y in 0 until height) {
            pixels[x + (y * width)] = grayFunc(pixels[x + (y * width)])
        }
    }

    return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888)
}

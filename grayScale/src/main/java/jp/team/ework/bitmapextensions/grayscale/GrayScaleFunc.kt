package jp.team.ework.bitmapextensions.grayscale

import android.graphics.Color
import kotlin.math.pow

// 元ネタ
// https://ofo.jp/osakana/cgtips/grayscale.phtml

// 中間値法
// https://ofo.jp/osakana/cgtips/grayscale.phtml#id1
internal fun grayScaleMiddleValue(pixel: Int): Int {
    val cv = ColorValue.of(pixel)

    val gray = (maxOf(cv.red, cv.green, cv.blue) + minOf(cv.red, cv.green, cv.blue)) / 2
    return Color.argb(cv.alpha, gray, gray, gray)
}

// NTSC係数による加重平均法
// https://ofo.jp/osakana/cgtips/grayscale.phtml#id2
@Suppress("SpellCheckingInspection")
internal fun grayScaleNtscCoef(pixel: Int): Int {
    val cv = ColorValue.of(pixel)

    val gray = ((2 * cv.red) + (4 * cv.green) + cv.blue) / 7
    return Color.argb(cv.alpha, gray, gray, gray)
}

// HDTV係数による加重平均と補正
// https://ofo.jp/osakana/cgtips/grayscale.phtml#id3
@Suppress("SpellCheckingInspection")
internal fun grayScaleItuCoef(pixel: Int): Int {
    val cv = ColorValue.of(pixel)

    val x = 2.2
    val red = (cv.red.toDouble() / 255).pow(x) * 0.222015
    val green = (cv.green.toDouble() / 255).pow(x) * 0.706655
    val blue = (cv.blue.toDouble() / 255).pow(x) * 0.071330

    val gray = ((red + green + blue).pow(1 / x) * 255).toInt()
    return Color.argb(cv.alpha, gray, gray, gray)
}

package jp.team.ework.bitmapextensions.sample.fragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.content.res.AppCompatResources
import jp.team.ework.bitmapextensions.grayscale.grayScale
import jp.team.ework.bitmapextensions.sample.R
import jp.team.ework.bitmapextensions.sample.base.BaseFragment

class GrayScaleSampleFragment: BaseFragment() {
    companion object {
        fun new() = GrayScaleSampleFragment()
    }

    override fun createImage(): Bitmap? {
        context?.let { context ->
            val bitmap =
                (AppCompatResources.getDrawable(context, R.drawable.lenna) as BitmapDrawable).bitmap
            return bitmap.grayScale()
        }

        return null
    }
}

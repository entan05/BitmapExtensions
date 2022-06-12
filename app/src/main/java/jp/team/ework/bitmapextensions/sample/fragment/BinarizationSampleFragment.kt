package jp.team.ework.bitmapextensions.sample.fragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.content.res.AppCompatResources
import jp.team.ework.binarization.binarization
import jp.team.ework.bitmapextensions.sample.R
import jp.team.ework.bitmapextensions.sample.base.BaseFragment

class BinarizationSampleFragment: BaseFragment() {
    companion object {
        fun new() = BinarizationSampleFragment()
    }

    override fun createImage(): Bitmap? {
        context?.let { context ->
            val bitmap =
                (AppCompatResources.getDrawable(context, R.drawable.lenna) as BitmapDrawable).bitmap
            return bitmap.binarization()
        }

        return null
    }
}

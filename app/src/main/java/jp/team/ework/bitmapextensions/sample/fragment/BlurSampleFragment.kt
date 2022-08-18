package jp.team.ework.bitmapextensions.sample.fragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.content.res.AppCompatResources
import jp.team.ework.bitmapextensions.sample.R
import jp.team.ework.bitmapextensions.sample.base.BaseFragment
import jp.team.ework.blur.blur

class BlurSampleFragment: BaseFragment() {
    companion object {
        fun new() = BlurSampleFragment()
    }

    override fun createImage(): Bitmap? {
        context?.let { context ->
            val bitmap =
                (AppCompatResources.getDrawable(context, R.drawable.lenna) as BitmapDrawable).bitmap
            return bitmap.blur()
        }

        return null
    }
}

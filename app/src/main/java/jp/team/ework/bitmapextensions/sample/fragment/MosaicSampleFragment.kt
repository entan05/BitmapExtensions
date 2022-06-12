package jp.team.ework.bitmapextensions.sample.fragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.content.res.AppCompatResources
import jp.team.ework.bitmapextensions.mosaic.averagePooling
import jp.team.ework.bitmapextensions.sample.R
import jp.team.ework.bitmapextensions.sample.base.BaseFragment

class MosaicSampleFragment: BaseFragment() {
    companion object {
        fun new() = MosaicSampleFragment()
    }

    override fun createImage(): Bitmap? {
        context?.let { context ->
            val bitmap =
                (AppCompatResources.getDrawable(context, R.drawable.lenna) as BitmapDrawable).bitmap
            return bitmap.averagePooling()
        }

        return null
    }
}

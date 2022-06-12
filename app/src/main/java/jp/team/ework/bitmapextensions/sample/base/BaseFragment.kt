package jp.team.ework.bitmapextensions.sample.base

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import jp.team.ework.bitmapextensions.sample.R

abstract class BaseFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView() {
        view?.findViewById<View>(R.id.fragment_background)?.setOnClickListener {
            // do nothing
        }

        createImage()?.let { bitmap ->
            view?.findViewById<ImageView>(R.id.after_image)?.setImageBitmap(bitmap)
        }
    }

    abstract fun createImage(): Bitmap?
}

package jp.team.ework.bitmapextensions.sample

import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import jp.team.ework.bitmapextensions.mosaic.averagePooling

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.processed_image).let { imageView ->
            val bitmap = (getDrawable(R.drawable.lenna) as BitmapDrawable).bitmap
            imageView.setImageBitmap(bitmap.averagePooling())
        }
    }
}

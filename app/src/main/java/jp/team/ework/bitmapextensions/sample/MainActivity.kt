package jp.team.ework.bitmapextensions.sample

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import jp.team.ework.bitmapextensions.mosaic.averagePooling

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.processed_image).let { imageView ->
            val bitmap =
                (AppCompatResources.getDrawable(this, R.drawable.lenna) as BitmapDrawable).bitmap
            imageView.setImageBitmap(bitmap.averagePooling())
        }
    }
}

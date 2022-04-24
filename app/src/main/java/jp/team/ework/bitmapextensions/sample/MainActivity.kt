package jp.team.ework.bitmapextensions.sample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import jp.team.ework.bitmapextensions.sample.base.BaseFragment
import jp.team.ework.bitmapextensions.sample.fragment.GrayScaleSampleFragment
import jp.team.ework.bitmapextensions.sample.fragment.MosaicSampleFragment

class MainActivity: AppCompatActivity() {
    private enum class ListItem(val rawValue: String) {
        GrayScale("GrayScale"),
        Mosaic("Mosaic");

        companion object {
            fun getNameList() = values().map { it.rawValue }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ListView>(R.id.list_view)?.let { listView ->
            val adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, ListItem.getNameList())
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                getFragment(ListItem.values().getOrNull(position))?.let { showFragment(it) }
            }
        }
    }

    private fun getFragment(item: ListItem?): BaseFragment? = when (item) {
        ListItem.GrayScale -> GrayScaleSampleFragment.new()
        ListItem.Mosaic -> MosaicSampleFragment.new()
        else -> null
    }

    private fun showFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .addToBackStack(null).commit()
    }
}

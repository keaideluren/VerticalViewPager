package com.luren.verticalviewpager

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val views = ArrayList<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.RED)
        colors.add(Color.BLUE)
        colors.add(Color.GRAY)
        colors.add(Color.GREEN)
        colors.add(Color.YELLOW)
        colors.add(Color.CYAN)
        for (i in 0..5) {
            val textView = TextView(this@MainActivity)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

            textView.gravity = Gravity.CENTER
            textView.setTextColor(Color.BLACK)
            textView.text = "这是$i"
            textView.setBackgroundColor(colors[i])
            views.add(textView)
        }
        vvp_pager.setAdapter(object : VerticalPagerAdapter() {
            override fun getCount(): Int {
                return 6
            }

            override fun isViewFromObject(view: View, anyThing: Any): Boolean {
                return view == anyThing
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                container.addView(views[position])
                return views[position]
            }

            override fun destroyItem(container: ViewGroup, position: Int, anyThing: Any) {
                container.removeView(views[position])
            }
        })
    }

    var current = 0
    fun clickclickclick(v: View) {
        vvp_pager.currentItem = ++current
        if (current >= 5) {
            current = -1
        }
    }

    fun toPage2(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}

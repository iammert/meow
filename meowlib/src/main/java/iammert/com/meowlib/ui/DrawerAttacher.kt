package iammert.com.meowlib.ui

import android.app.Activity
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import iammert.com.meowlib.R

/**
 * Created by mertsimsek on 23/01/2018.
 */
class DrawerAttacher constructor(private val activity: Activity?) {

    fun attach() {
        val drawerLayout = DrawerLayout(activity)
        val layoutParamDrawerLayout = DrawerLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        layoutParamDrawerLayout.gravity = Gravity.END
        val frameLayout = FrameLayout(activity)
        frameLayout.id = R.id.container
        frameLayout.layoutParams = layoutParamDrawerLayout
        drawerLayout.addView(frameLayout)
        activity!!.addContentView(drawerLayout, layoutParamDrawerLayout)
        activity.fragmentManager.beginTransaction().add(R.id.container, MeowFragment()).commit()
    }
}
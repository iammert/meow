package iammert.com.meowlib.ui

import android.app.Activity
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import iammert.com.meowlib.R
import iammert.com.meowlib.model.MeowConfig

/**
 * Created by mertsimsek on 23/01/2018.
 */
class DrawerAttacher constructor(private val activity: Activity?, private val config: MeowConfig) {

    fun attach() {
        val content: FrameLayout = activity!!.window.decorView.findViewById<View>(android.R.id.content) as FrameLayout
        val actualView = content.getChildAt(0)

        content.removeAllViews()

        val drawerLayout = DrawerLayout(activity)
        if (actualView != null) {
            drawerLayout.addView(actualView)
        }

        val layoutParamDrawerLayout = DrawerLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        layoutParamDrawerLayout.gravity = Gravity.END

        val frameLayout = FrameLayout(activity)
        frameLayout.id = R.id.container
        frameLayout.layoutParams = layoutParamDrawerLayout
        drawerLayout.addView(frameLayout)

        activity.addContentView(drawerLayout, layoutParamDrawerLayout)

        activity.fragmentManager.beginTransaction().add(R.id.container, MeowFragment.newInstance(config)).commit()
    }
}
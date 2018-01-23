package iammert.com.meowlib.ui

import android.app.Activity
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import iammert.com.meowlib.R

/**
 * Created by mertsimsek on 23/01/2018.
 */
class DrawerAttacher constructor(private val activity: Activity?) {

    fun attach() {
        val rootView = activity!!.window.decorView.findViewById<View>(android.R.id.content)


        val int = (rootView as ViewGroup).childCount
        Log.v("TEST", "child: " + int)

//
//
//        val drawerLayout = DrawerLayout(activity)
//        val layoutParamDrawerLayout = DrawerLayout.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
//        layoutParamDrawerLayout.gravity = Gravity.END
//        drawerLayout.layoutParams = layoutParamDrawerLayout
//        drawerLayout.addView(rootView)
//
//        val frameLayout = FrameLayout(activity)
//        frameLayout.id = R.id.container
//        drawerLayout.addView(frameLayout)
//
//        activity.setContentView(drawerLayout)
//
//        activity.fragmentManager.beginTransaction().add(R.id.container, MeowFragment()).commit()
    }
}
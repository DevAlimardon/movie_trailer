package uz.infinityandro.moviestream.util

import android.app.Activity
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class Slider(var banner: ViewPager2, var activity: Activity):TimerTask() {
    override fun run() {
        activity.runOnUiThread(object :Runnable{
            override fun run() {
                if(banner.currentItem<6){
                    banner.setCurrentItem(banner.currentItem+1)
                }else{
                    banner.setCurrentItem(0)
                }
            }

        })
    }
}
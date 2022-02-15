package uz.infinityandro.moviestream.util

import android.content.Context
import android.view.animation.Interpolator
import android.widget.Scroller
import uz.infinityandro.moviestream.app.App

class CostomSpeed:Scroller(App.instance) {
    private var mDuration=0
    fun CustomScroller(context: Context, duration: Int) {
        mDuration = duration
    }
    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        super.startScroll(startX, startY, dx, dy, mDuration)

    }
}
package com.devindie.stopusingshoppee.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.devindie.stopusingshoppee.R

/**
 * Tracking User Open
 */
class HabitTrackerView : FrameLayout {
    constructor(context: Context) : super(context){
        initView(context)
    }

    private fun initView(context: Context) {
        inflate(context,R.layout.habit_tracker_view,this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        initView(context)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){
        initView(context)
    }


}
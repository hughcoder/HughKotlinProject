package com.hugh.hughlotlin.ui.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import java.util.jar.Attributes

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */
class StateButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.support.v7.appcompat.R.attr.buttonStyle) : AppCompatButton(context, attrs, defStyleAttr) {

    // text color
    private var mNormalTextColor = 0
    private var mPressedTextColor = 0
    private var mUnableTextColor = 0

    lateinit var mTextColorStateList: ColorStateList

    //animation duration
    private var mDuration = 0;

    //radius
    private var mRadius =0f
    private var mRound: Boolean =false

    //stroke
    private var mStrokeDashWidth = 0f
    private var mStrokeDashGap = 0f
    private var mNormalStrokeWidth = 0
    private var mPressedStrokeWidth = 0
    private var mUnableStrokeWidth = 0
    private var mNormalStrokeColor = 0
    private var mPressedStrokeColor = 0
    private var mUnableStrokeColor = 0

    //background color
    private var mNormalBackgroundColor = 0
    private var mPressedBackgroundColor = 0
    private var mUnableBackgroundColor = 0

    private var mNormalBackground: GradientDrawable? = null
    private var mPressedBackground: GradientDrawable? = null
    private var mUnableBackground: GradientDrawable? = null

    private var states: Array<IntArray?>? = null

    lateinit var mStateBackground: StateListDrawable


}
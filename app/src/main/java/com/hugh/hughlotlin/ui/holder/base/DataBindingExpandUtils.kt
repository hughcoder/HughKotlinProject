package com.hugh.hughlotlin.ui.holder.base

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.graphics.Point
import android.view.View
import android.widget.EditText
import android.widget.ImageView

import android.widget.TextView

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */

class DataBindingExpandUtils {
    companion object {

//        /**
//         * 高斯模糊图片加载
//         */
//        @BindingAdapter("image_blur")
//        fun loadImageBlur(view: ImageView, url: String?) {
//            CommonUtils.loadImageBlur(view, url ?: "")
//        }
//
//        /**
//         * 圆形用户头像加载
//         */
//        @BindingAdapter("userHeaderUrl", "userHeaderSize", requireAll = false)
//        fun loadImage(view: ImageView, url: String?, size: Int = 50) {
//            CommonUtils.loadUserHeaderImage(view, url ?: "", Point(size.dp, size.dp))
//        }
//
//        /**
//         * webView url加载拓展
//         */
//        @BindingAdapter("webViewUrl")
//        fun webViewUrl(view: GSYWebViewContainer?, url: String?) {
//            view?.apply {
//                webView.isVerticalScrollBarEnabled = false
//                webView.loadUrl(url)
//            }
//
//        }
//
//        /**
//         * markdown数据处理显示
//         */
//        @BindingAdapter("markdownText", "style", requireAll = false)
//        fun markdownText(view: TextView?, text: String?, style: String? = "default") {
//            view?.apply {
//                Markwon.setMarkdown(view, MarkDownConfig.getConfig(view.context), text ?: "")
//            }
//        }
//
//        /**
//         * EditText 按键监听
//         */
//        @BindingAdapter("keyListener")
//        fun editTextKeyListener(view: EditText?, listener: View.OnKeyListener) {
//            view?.apply {
//                this.setOnKeyListener(listener)
//            }
//        }
//
//        /**
//         * Iconics ImageView 图标加载
//         */
//        @BindingAdapter("iiv_icon", "iiv_color", requireAll = false)
//        fun editTextKeyListener(view: IconicsImageView?, value: String?, colorId: Int?) {
//            if (view == null || value == null) {
//                return
//            }
//            val drawable = IconicsDrawable(view.context)
//                    .icon(value)
//            colorId?.apply {
//                drawable.color(colorId)
//            }
//            view.icon = drawable
//        }
    }
}

/**
 * 加载 DataBinding 的拓展适配器
 */


class HughDataBindingComponent : DataBindingComponent {
  //  override fun getCompanion(): DataBindingExpandUtils.Companion = DataBindingExpandUtils
}
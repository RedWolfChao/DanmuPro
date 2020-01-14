package com.redolf.danmupro

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.blankj.utilcode.util.ScreenUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /* 弹幕相关 */
    private lateinit var mDanmu001Listener: MainAnimListener
    private lateinit var mDanmu002Listener: MainAnimListener
    private lateinit var mDanmu003Listener: MainAnimListener

    private lateinit var mAnim001: ObjectAnimator
    private lateinit var mAnim002: ObjectAnimator
    private lateinit var mAnim003: ObjectAnimator

    @Suppress("PrivatePropertyName")
    private val SCREEN_WIDTH = ScreenUtils.getScreenWidth().toFloat()
    /* 弹幕相关 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDanmakuView()
    }


    /**
     * 初始化弹幕控件
     */
    private fun initDanmakuView() {

        mStartBtn.setOnClickListener {
            startDanMu()
        }
        mStopBtn.setOnClickListener {
            stopDanMu()
        }
        //
        mDanmu001Listener = object : MainAnimListener() {
            override fun onAnimationRepeat(animator: Animator) {
                super.onAnimationRepeat(animator)
                setDanmuContent(mDanmuLayout001, mDanmuTv001)
            }
        }

        mDanmu002Listener = object : MainAnimListener() {
            override fun onAnimationRepeat(animator: Animator) {
                super.onAnimationRepeat(animator)
                setDanmuContent(mDanmuLayout002, mDanmuTv002)
            }
        }


        mDanmu003Listener = object : MainAnimListener() {
            override fun onAnimationRepeat(animator: Animator) {
                super.onAnimationRepeat(animator)
                setDanmuContent(mDanmuLayout003, mDanmuTv003)
            }
        }
        //
        setDanmuContent(mDanmuLayout001, mDanmuTv001)
        setDanmuContent(mDanmuLayout002, mDanmuTv002)
        setDanmuContent(mDanmuLayout003, mDanmuTv003)
        //
        mAnim001 =
            ObjectAnimator.ofFloat(mDanmuLayout001, "translationX", SCREEN_WIDTH, -SCREEN_WIDTH)
                .apply {
                    duration = RandomUtil.getNum(12_000, 20_000).toLong()
                    repeatMode = ValueAnimator.RESTART
                    repeatCount = ValueAnimator.INFINITE
                    addListener(mDanmu001Listener)
                }
        mAnim002 =
            ObjectAnimator.ofFloat(mDanmuLayout002, "translationX", SCREEN_WIDTH, -SCREEN_WIDTH)
                .apply {
                    duration = RandomUtil.getNum(12_000, 20_000).toLong()
                    repeatMode = ValueAnimator.RESTART
                    repeatCount = ValueAnimator.INFINITE
                    addListener(mDanmu002Listener)
                }
        mAnim003 =
            ObjectAnimator.ofFloat(mDanmuLayout003, "translationX", SCREEN_WIDTH, -SCREEN_WIDTH)
                .apply {
                    duration = RandomUtil.getNum(12_000, 20_000).toLong()
                    repeatMode = ValueAnimator.RESTART
                    repeatCount = ValueAnimator.INFINITE
                    addListener(mDanmu003Listener)
                }

    }


    private fun setDanmuContent(cardView: CardView, tv: TextView) {
        cardView.setBackgroundResource(Constants.DANMU_BG[RandomUtil.getNum(Constants.DANMU_BG.size)])
        cardView.background.alpha = Constants.DANMU_ALPHA
        tv.text = Constants.DANMU_CONTENT[RandomUtil.getNum(Constants.DANMU_CONTENT.size)]
    }

    /**
     * 弹幕开始展示
     */
    private fun startDanMu() {
        if (mDanmuLayout001.visibility != View.VISIBLE) {
            mDanmuLayout001.visibility = View.VISIBLE
            mDanmuLayout002.visibility = View.VISIBLE
            mDanmuLayout003.visibility = View.VISIBLE
            mAnim001.start()
            mAnim002.start()
            mAnim003.start()
        }
    }

    /**
     * 弹幕结束
     */
    private fun stopDanMu() {
        if (mDanmuLayout001.visibility != View.INVISIBLE) {
            mDanmuLayout001.visibility = View.INVISIBLE
            mDanmuLayout002.visibility = View.INVISIBLE
            mDanmuLayout003.visibility = View.INVISIBLE
            if (mAnim001.isStarted) {
                mAnim001.cancel()
            }
            if (mAnim002.isStarted) {
                mAnim002.cancel()
            }
            if (mAnim003.isStarted) {
                mAnim003.cancel()
            }
        }
    }

    open inner class MainAnimListener : Animator.AnimatorListener {

        override fun onAnimationStart(animator: Animator) {

        }

        override fun onAnimationEnd(animator: Animator) {

        }

        override fun onAnimationCancel(animator: Animator) {

        }

        override fun onAnimationRepeat(animator: Animator) {

        }
    }
}

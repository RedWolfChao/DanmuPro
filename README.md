### Android 动画实现弹幕效果

**弹幕库可以用[bilibili的弹幕库]("https://github.com/bilibili/ijkplayer")实现,但是此文不是**



**原理是采用 ObjectAnimator 移动View做出效果**

```kotlin
ObjectAnimator.ofFloat(mDanmuLayout002, "translationX", SCREEN_WIDTH, -SCREEN_WIDTH)
```



**核心代码就这一块**

```kotlin
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
```

**代码中引用了[常用工具类]("https://blankj.com/2016/07/31/android-utils-code/")库**

```gradle
implementation 'com.blankj:utilcode:1.26.0'
```
package com.githubyss.sample_architecture.mvp_optimized

import com.githubyss.sample_architecture.DataCenterModel


/**
 * MvpOptimizedPresenter
 *
 * 通过接口 IView，连接 P 与 V （面向接口编程）。
 * 这样这个 P 就成为一个通用的 P，不但可以给 Activity 用，也可以给 Fragment、自定义 View 等使用。
 * 还方便测试，可以做一个假的 V，测试 P 的逻辑。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:41:22
 */
class MvpOptimizedPresenter(private val iView: IView) {
    fun init() {
        // 在 P 中调度 M
        val data = DataCenterModel.getData()

        // 在 P 中调度 V
        iView.showData(data)
    }

    interface IView {
        fun showData(data: List<String>)
    }
}

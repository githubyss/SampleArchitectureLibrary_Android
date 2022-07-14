package com.githubyss.sample_architecture.mvp

import com.githubyss.sample_architecture.DataCenterModel


/**
 * MvpActivityPresenter
 * 在 P 中，进行数据的操作指挥，进行视图的更新指挥，但是具体怎么操作数据、怎么更新视图，都是在 M 和 V 中进行的。
 * P 不关心 M 和 V 中的细节，它只是一个调度器一样的存在。
 *
 * 但是这个 P 的模板里，指定的 V 是一个具体的 Activity，灵活性欠缺，所以可以将 P 中的 V 抽象出来。
 * 抽象后的 MVP 架构详见 [com.githubyss.sample_architecture.mvp_optimized.MvpOptimizedPresenter]。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:29:18
 */
class MvpActivityPresenter(private val activity: MvpActivity) {
    fun init() {
        // 在 P 中与 M 交互
        val data = DataCenterModel.getData()

        // 在 P 中与 V 交互
        activity.showData(data)
    }
}

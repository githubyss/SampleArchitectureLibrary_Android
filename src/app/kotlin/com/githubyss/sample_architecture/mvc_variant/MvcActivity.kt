package com.githubyss.sample_architecture.mvc_variant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.DataCenterModel
import com.githubyss.sample_architecture.R


/**
 * MvcActivity
 * MVC 架构中，Activity 就是 Controller。
 * 将 MVC 中的 V 拆出来，让 C 调度 M、V。
 *
 * MVC 架构中，V 的显示，需要 C 的具体指挥，C 对 V 的干涉太多，当界面很复杂的时候，就会造成 C 的膨胀。
 * 如果 C 能将 M 的数据，交给 V，让 V 自己指挥显示，就可以减轻 C 的负担，于是就引入了 MVP 架构。
 *
 * MVP 架构详见 [com.githubyss.sample_architecture.mvp.MvpActivity]。
 *
 * 关于 MVC 和 MVP 的区别：
 * 有人说 MVP 切断了 V 与 M 的连接。但是我们用 MVC 写代码的时候，并没有将 V 与 M 连接，更新 M 更新 V，依然通过 C 来指挥。
 * 还有人说，MVP 通过抽出 P，解决了 MVC 架构中最令人诟病的 C 与 V 过度紧密的问题。但是通过将 V 抽出来，也可以做到解耦 C 与 V，详见 [com.githubyss.sample_architecture.mvc_variant.MvcActivity]。
 *
 * 实际上，MVC 这个说法，起源于 Web 开发框架 Struts，用户点击某个链接，浏览器响应用户点击，Web 程序的调度器修改浏览数据，跳转到目标页面，完成一次 MVC 流程。
 * 而在 Android 开发中，是没有类似 Struts 这种框架的，Android 里的框架是人为定义的。
 * 由于基于 Activity 视图操作、数据处理的这种开发结构，跟 Web 的 MVC 比较类似，于是，就硬将向 Web 的 MVC 上凑，将这种结构成为 MVC。
 * 而后来经过优化出现的 MVP 才更符合 Web 框架里的 MVC 架构，但是由于先前定下来的 Android MVC 已经固化，所以只能给这个优化版的 MVC 取名 MVP。
 * 所以，严格来说，Android MVP 架构，才是 Web MVC 架构，而 Android MVC 架构，是不严谨的 Web MVC 架构。
 *
 * 而 Android MVC 与 Android MVP 本质上没有区别：
 * MVC 是把 V 单独拆出来，Activity 作为 C 调度 M、V
 * MVP 是把 C 单独拆出来，Activity 作为 V 的一部分，与 M 一起，被 P 调度。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:57:54
 */
class MvcActivity : AppCompatActivity() {
    lateinit var mvcView: MvcView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 C 中渲染 V
        setContentView(R.layout.samparch_activity_mvc)
        mvcView = findViewById(R.id.mvc_view)

        // 在 C 中与 M 交互
        val data = DataCenterModel.getData()

        // 在 C 中与 V 交互
        mvcView.showData(data)
    }
}

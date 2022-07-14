package com.githubyss.sample_architecture.mvc

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.DataCenterModel
import com.githubyss.sample_architecture.R


/**
 * MvcActivity
 * MVC 架构中，Activity 就是 Controller。
 *
 * MVC 架构中，V 的显示，需要 C 的具体指挥，C 对 V 的干涉太多，当界面很复杂的时候，就会造成 C 的膨胀。
 * 如果 C 能将 M 的数据，交给 V，让 V 自己指挥显示，就可以减轻 C 的负担，于是就引入了 MVP 架构。
 *
 * MVP 架构详见 [com.githubyss.sample_architecture.mvp.MvpActivity]。
 *
 * 关于 MVC 和 MVP 的区别：
 * 有人说 MVP 切断了 V 与 M 的连接。但是我们用 MVC 写代码的时候，并没有将 V 与 M 连接，更新 M 更新 V，依然通过 C 来指挥。
 * 还有人说，MVP 通过抽出 P，解决了 MVC 架构中最令人诟病的 C 与 V 过度紧密的问题。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 14:37:52
 */
class MvcActivity : AppCompatActivity(/*R.layout.samparch_activity_mvc*/) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 C 中渲染 V
        setContentView(R.layout.samparch_activity_mvc)

        // 在 C 中与 M 交互
        val data = DataCenterModel.getData()

        // 在 C 中与 V 交互
        findViewById<EditText>(R.id.et_username).setText(data[0])
        findViewById<EditText>(R.id.et_password).setText(data[1])
    }
}

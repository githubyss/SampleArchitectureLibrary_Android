package com.githubyss.sample_architecture.mvvm

import android.widget.EditText
import com.githubyss.sample_architecture.DataCenterModel


/**
 * MvvmViewModel
 * 作用相当于 MVP 的 Presenter。
 *
 * 这个 ViewModel 与 Google 提供 ViewModel 是不一样的。
 * 这里的 ViewModel 只是一个命名，是 MVVM 框架中的一个部分，提供了数据双向绑定功能。
 * 而 Google 提供的 ViewModel 提供了一个暂存数据的功能，具有生命周期特性，可以在页面转屏等变化时，Activity 销毁了，但是页面的数据还保存在 ViewModel 中。
 *
 * Google 的 DataBinding 才是用来实现 MVVM 的框架，可以做到 xml 布局与数据的双向绑定。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 17:19:14
 */
class MvvmViewModel(private val etUsername: EditText, private val etPassword: EditText) {
    var username: StringAttr = StringAttr()
    var password: StringAttr = StringAttr()

    init {
        // 在 VM 中绑定 M、V
        ViewBinder.bind(etUsername, username)
        ViewBinder.bind(etPassword, password)
    }

    fun init() {
        // 在 P 中调度 M
        val data: List<String> = DataCenterModel.getData()
        username.value = data[0]
        password.value = data[1]
    }
}

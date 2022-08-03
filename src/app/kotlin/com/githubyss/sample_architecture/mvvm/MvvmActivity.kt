package com.githubyss.sample_architecture.mvvm

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.R


/**
 * MvvmActivity
 * MVVM 就是 MVP + 数据绑定，是框架而不是架构。
 *
 * MVC、MVP 提供一种规则，架构属性比较强，满足这种规范，就可以说是这种架构。
 * MVVM 是提供的一种开发便利，更偏向功能性，所以框架属性更强。MVVM 实质上是 MVP 架构的一种。
 *
 * Android 程序里的数据，可以分为三类：
 * 1、外部数据：数据库、文件等程序外的数据；
 * 2、内存数据：变量；
 * 3、表现数据：界面展示的数据。
 *
 * 在数据绑定之前，内存数据和表现数据是没有绑定的，当改变表现数据时，内存数据是不会改变的。
 * 而加入数据绑定后，表现数据的改变，会同步更新内存数据，甚至可以同步更新外部数据，而后两种数据的改变，也会同步表现在表现数据上。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 17:09:07
 */
class MvvmActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        setContentView(R.layout.samparch_activity_mvvm)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        // 连接 V 与 VM
        MvvmViewModel(etUsername, etPassword)
    }
}

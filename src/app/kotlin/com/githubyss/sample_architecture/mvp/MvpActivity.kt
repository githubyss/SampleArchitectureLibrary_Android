package com.githubyss.sample_architecture.mvp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.R


/**
 * MvpActivity
 * MVP 架构中，Activity 作为 View 的一部分。
 * 将 MVC 中的 C 拆出来成为 P，让 P 调度 M、V。
 *
 * V 完全掌控视图的操作。
 * 所有视图显示的细节，都在 V 中完成。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:20:53
 */
class MvpActivity : AppCompatActivity() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        setContentView(R.layout.samparch_activity_mvp)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        // 连接 V 与 P
        MvpActivityPresenter(this).init()
    }

    fun showData(data: List<String>) {
        etUsername.setText(data[0])
        etPassword.setText(data[1])
    }
}

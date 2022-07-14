package com.githubyss.sample_architecture.mvp_optimized

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.R


/**
 * MvpOptimizedActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:40:46
 */
class MvpOptimizedActivity : AppCompatActivity(), MvpOptimizedPresenter.IView {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        setContentView(R.layout.samparch_activity_mvp)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        // 连接 V 与 P
        MvpOptimizedPresenter(this).init()
    }

    override fun showData(data: List<String>) {
        etUsername.setText(data[0])
        etPassword.setText(data[1])
    }
}

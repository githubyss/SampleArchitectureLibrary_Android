package com.githubyss.sample_architecture.mvp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.R


/**
 * MvpActivity
 * MVP 架构中，Activity 作为 View 的一部分。
 *
 * V 完全掌控视图的操作。
 * 所有视图显示的细节，都在 V 中完成。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:20:53
 */
class MvpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        setContentView(R.layout.samparch_activity_mvc)

        // 在 V 中与 P 进行交互
        MvpActivityPresenter(this).init()
    }

    fun showData(data: List<String>) {
        findViewById<EditText>(R.id.et_username).setText(data[0])
        findViewById<EditText>(R.id.et_password).setText(data[1])
    }
}

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        setContentView(R.layout.samparch_activity_mvc)

        // 在 V 中与 P 进行交互
        MvpOptimizedPresenter(this).init()
    }

    override fun showData(data: List<String>) {
        findViewById<EditText>(R.id.et_username).setText(data[0])
        findViewById<EditText>(R.id.et_password).setText(data[1])
    }
}

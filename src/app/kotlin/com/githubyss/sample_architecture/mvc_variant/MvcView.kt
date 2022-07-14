package com.githubyss.sample_architecture.mvc_variant

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import com.githubyss.sample_architecture.R


/**
 * MvcView
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 16:01:47
 */
class MvcView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText

    override fun onFinishInflate() {
        // 在 V 中渲染 V
        super.onFinishInflate()
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
    }

    fun showData(data: List<String>) {
        etUsername.setText(data[0])
        etPassword.setText(data[1])
    }
}

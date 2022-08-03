package com.githubyss.sample_architecture.old

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.githubyss.sample_architecture.DataCenterModel
import com.githubyss.sample_architecture.R


/**
 * OldActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 14:37:52
 */
class OldActivity : AppCompatActivity(/*R.layout.samparch_activity_mvc*/) {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 C 中渲染 V
        setContentView(R.layout.samparch_activity_old)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        // 在 C 中与 M 交互
        val data = DataCenterModel.data

        // 在 C 中与 V 交互
        etUsername.setText(data[0])
        etPassword.setText(data[1])
    }
}

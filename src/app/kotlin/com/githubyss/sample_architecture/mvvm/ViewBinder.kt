package com.githubyss.sample_architecture.mvvm

import android.text.TextUtils
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.githubyss.common.kit.util.logD


/**
 * ViewBinder
 * 视图绑定工具类
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 22:25:43
 */
object ViewBinder {
    fun bind(et: EditText, stringAttr: StringAttr) {
        et.doAfterTextChanged {
            if (!TextUtils.equals(stringAttr.value, it)) {
                stringAttr.value = it.toString()
                logD(msg = "表现数据通知内存改变 >> $it")
            }
        }

        stringAttr.onChange = {
            if (!TextUtils.equals(et.text, it)) {
                et.setText(it)
                logD(msg = "内存通知表现数据改变 >> $it")
            }
        }
    }
}

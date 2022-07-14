package com.githubyss.sample_architecture.mvvm


/**
 * StringAttr
 * 对于不能赋值、不能监听的数据，可以将数据包起来，使实际要用的数据，作为包装类里的值 value。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 17:34:48
 */
class StringAttr {
    var value: String? = null
        set(value) {
            field = value
            onChange(value)
        }

    var onChange: (newValue: String?) -> Unit = {}
}

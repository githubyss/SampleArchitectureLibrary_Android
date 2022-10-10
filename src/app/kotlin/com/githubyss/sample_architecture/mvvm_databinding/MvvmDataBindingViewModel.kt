package com.githubyss.sample_architecture.mvvm_databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githubyss.common.kit.util.logD
import com.githubyss.sample_architecture.DataCenterModel


/**
 * MvvmDataBindingViewModel
 * 使用 Google 提供的 ViewModel、LiveData 实现更便捷安全的数据绑定。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 22:32:43
 */
class MvvmDataBindingViewModel : ViewModel() {
    val username: LiveData<String> get() = _username
    private val _username: MutableLiveData<String> = MutableLiveData<String>("")

    val password: LiveData<String> get() = _password
    private val _password: MutableLiveData<String> = MutableLiveData<String>("")

    init {
        initData()
    }

    private fun initData() {
        // 在 VM 中调度 M
        val data: List<String> = DataCenterModel.data

        // setValue() 特性：
        // 1.此方法只能在主线程里调用
        _username.value = data[0]

        // postValue() 特性：
        // 1.可以在其他线程中调用。
        // 2.如果在主线程执行发布的任务之前多次调用此方法，则仅将分配最后一个值。
        // 3.如果同时调用 .postValue("a") 和 .setValue("b")，一定是值 b 被值 a 覆盖。
        _password.postValue(data[1])
    }

    fun onButtonClick() {
        logD(msg = "更新数据")
        DataCenterModel.changeData()
    }
}

package com.githubyss.sample_architecture.mvvm_databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.githubyss.mobile.common.kit.util.logD
import com.githubyss.sample_architecture.databinding.SamparchActivityMvvmDatabindingBinding


/**
 * MvvmDataBindingActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 22:32:25
 */
class MvvmDataBindingActivity : AppCompatActivity() {
    private lateinit var binding: SamparchActivityMvvmDatabindingBinding

    // 直接使用方法 ViewModelProvider(ViewModelStoreOwner).get(ViewModelClass<T>) 获取 ViewModel 实例。
    // 实际上这样写会崩溃，因为此时页面还没有渲染出来。
    // private val mvvmVm0: MvvmDataBindingViewModel = ViewModelProvider(this).get(MvvmDataBindingViewModel::class.java)

    // 懒加载使用方法 ViewModelProvider(ViewModelStoreOwner).get(ViewModelClass<T>) 获取 ViewModel 实例。在首次使用到 ViewModel 实例的时候，才进行实例化，可以达到优化内存的目的。
    private val mvvmVm1: MvvmDataBindingViewModel by lazy { ViewModelProvider(this).get(MvvmDataBindingViewModel::class.java) }

    // 使用 ComponentActivity 的扩展函数 viewModels<ViewModelClass>() 获取 ViewModel 实例。在首次使用到 ViewModel 实例的时候，才进行实例化，可以达到优化内存的目的。实际上是对 lazy { ViewModelProvider(ViewModelStoreOwner).get(Class<T>) } 方式的封装。
    private val mvvmVm2: MvvmDataBindingViewModel by viewModels<MvvmDataBindingViewModel>()

    private val mvvmVm by lazy { mvvmVm2 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在 V 中渲染 V
        // 使用方法 inflate(LayoutInflater) 获取布局的 binding 实例。
        binding = SamparchActivityMvvmDatabindingBinding.inflate(layoutInflater)
        // 将根视图 Root View 渲染到系统 View 上。
        setContentView(binding.root)

        // 另一种渲染方式
        // binding = DataBindingUtil.setContentView(this, R.layout.samparch_activity_mvvm_databinding)

        // 连接 V 与 VM
        // 如果要在 xml 中使用 LiveData，需要把 lifecycleOwner 赋给 binding，Activity 中就用 this
        binding.lifecycleOwner = this
        // 通过 binding 对 xml 中的 ViewModel 进行数据绑定。
        // 通俗地说，获取 MvvmDataBindingViewModel 的实例，传给 xml 中 <variable /> 中声明的变量 mvvmVm
        binding.mvvmVm = mvvmVm

        // 观察内存数据的变动
        mvvmVm.username.observe(this) {
            logD(msg = "username: $it")
        }

        mvvmVm.password.observe(this, Observer<String> {
            logD(msg = "password: $it")
        })

        // {
        //     logD(msg = "password: $it")
        // }
    }

    override fun onDestroy() {
        // 页面销毁的时候，移除对数据的观察，以防内存泄露。
        mvvmVm.username.removeObservers(this)
        mvvmVm.password.removeObservers(this)

        super.onDestroy()
    }
}

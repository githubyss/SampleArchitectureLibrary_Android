package com.githubyss.sample_architecture

import com.githubyss.mobile.common.kit.base.application.BaseApplication
import kotlin.properties.Delegates


class SamparchApplication : BaseApplication() {

    /** ****************************** Companion ****************************** */

    companion object {
        var instance: SamparchApplication by Delegates.notNull()
            private set

        private val TAG: String = SamparchApplication::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

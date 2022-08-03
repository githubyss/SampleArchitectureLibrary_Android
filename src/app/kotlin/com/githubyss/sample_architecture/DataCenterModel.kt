package com.githubyss.sample_architecture


/**
 * DataCenterModel
 *
 * M 完全掌控数据的操作。
 * 所有的数据处理的细节，都在 M 中完成。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/14 15:32:19
 */
object DataCenterModel {
    val data = arrayListOf<String>("githubyss", "12345")

    fun changeData() {
        data[1] += "="
    }

    fun updateData(newData: List<String>) {
        data.clear()
        data.addAll(newData)
    }
}

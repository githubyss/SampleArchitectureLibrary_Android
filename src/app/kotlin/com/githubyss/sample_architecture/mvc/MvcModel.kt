package com.githubyss.sample_architecture.mvc

class MvcModel {
    var data=1;

    fun processData() {
        data++
        View.showData(data)
    }
}

class View{
    val controller
}

class Controller{
    val model:MvcModel=...

    fun onViewClicked(): Unit {
        model.processData()
    }
}

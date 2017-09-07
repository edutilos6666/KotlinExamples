package com.edutilos.test1

class Worker {
    var id: Long? = null
    var name: String? = null
    var age: Int? = null
    var wage: Double? = null
    var active: Boolean? = null

    constructor(id:Long , name:String, age:Int, wage:Double, active:Boolean) {
        this.id = id
        this.name = name
        this.age = age
        this.wage = wage
        this.active = active
    }

    constructor() {

    }

    override fun toString(): String {
        return "Worker(id=$id, name=$name, age=$age, wage=$wage, active=$active)"
    }


}
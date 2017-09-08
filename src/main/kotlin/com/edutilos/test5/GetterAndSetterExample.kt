package com.edutilos.test5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

object GetterAndSetterExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test3()
    }




    private fun test3() {
        var p = Person3(1L, "foo", 10, 100.0, true)
        val listener = PropertyChangeListener { event ->
            println("${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
        p.addPropertyChangeListener(listener)

        p.age = 20
        p.name = "new_foo"
        p.removePropertyChangeListener(listener)
        p.wage = 200.0
    }

    open class PropertyChangeAware {
        protected val changeSupport:PropertyChangeSupport = PropertyChangeSupport(this)

        fun addPropertyChangeListener(listener:PropertyChangeListener) {
            changeSupport.addPropertyChangeListener(listener)
        }

        fun removePropertyChangeListener(listener:PropertyChangeListener) {
            changeSupport.removePropertyChangeListener(listener)
        }
    }


    class Person3(id:Long , name:String, age:Int, wage:Double, active:Boolean):PropertyChangeAware() {
        var id:Long = id
          get() = field
        set(value) {
            val oldValue = field
            field = value
            changeSupport.firePropertyChange("id", oldValue, value)
        }

        var name:String = name
          get() = field
          set(value) {
              val oldValue = field
              field = value
              changeSupport.firePropertyChange("name", oldValue , value)
          }

        var age:Int = age
          get() = field
          set(value) {
              val oldValue = field
              field = value
              changeSupport.firePropertyChange("age", oldValue , value)
          }

        var wage:Double = wage
          get() = field
          set(value)  {
              val oldValue = field
              field = value
              changeSupport.firePropertyChange("wage", oldValue, value)
          }

        var active:Boolean = active
          get() = field
          set(value) {
              val oldValue = field
              field = value
              changeSupport.firePropertyChange("active", oldValue, value)
          }
    }





    private fun test2() {
        var p = Person2(1, "foo", 10, 100.0, true)
        println(p)

        p.id = 2
        p.name = "bar"
        p.age = 20
        p.wage = 200.0
        p.active = false
        println("${p.id}, ${p.name}, ${p.age}, ${p.wage}, ${p.active}")
    }

    class Person2(id:Long , name:String , age:Int, wage:Double, active:Boolean) {
        var id:Long = id
          get() = field
          set(value) {
              field = value
          }


        var name:String = name
          get() = field
          set(value) {
              field = value
          }

        var age:Int = age
          get()  = field
          set(value) {
              field = value
          }


        var wage:Double = wage
          get() = field
          set(value) {
              field = value
          }


        var active:Boolean = active
          get() = field
          set(value) {
              field = value
          }


        override fun toString():String {
            return "$id , $name , $age, $wage, $active"
        }
    }



    private fun test1() {
        var p1 = Person1()
        p1.id = 1L
        p1.name = "foo"
        p1.age = 10
        p1.wage = 100.0
        p1.active = true
        println(p1.toString())
        println("${p1.id}, ${p1.name}, ${p1.age}, ${p1.wage}, ${p1.active}")
    }
    class Person1 {
    /*    private var _id:Long = 0
        private var _name:String = ""
        private var _age:Int = 0
        private var _wage:Double = 0.0*/

        var id:Long = 0
          get() = field
          set(value) {
              field = value
          }


        var name:String = ""
         get() = field
         set(value)  {
             field = value
         }

        var age:Int = 0
          get() = field
          set(value)  {
              field = value
          }


        var wage:Double = 0.0
          get() = field
          set(value) {
              field = value
          }

        var active:Boolean = false
           get() = field
           set(value) {
               field = value
           }


        override fun toString():String {
            return "$id, $name, $age, $wage, $active"
        }

    }
}

package com.edutilos.test5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport


object ObservablePropertyExample2 {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }


    private fun test1() {
        val p = Person(1, "foo", 10, 100.0, false)
        println(p.toString())
        val listener = PropertyChangeListener { event ->
            println("${event.propertyName} changed from ${event.oldValue} ${event.newValue}")
        }
        p.addPropertyChangeListener(listener)
        p.id = 2
        p.name = "new foo"
        p.age = 20
        p.removePropertyChangeListener(listener)
        p.wage = 200.0
        p.active = true
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


   open class ObservableProperty<T>(val propertyName:String,
                                    var propertyValue:T,
                                    val changeSupoprt:PropertyChangeSupport)  {
       fun getValue():T = propertyValue
       fun setValue(newValue:T) {
           val oldValue = propertyValue
           propertyValue = newValue
           changeSupoprt.firePropertyChange(propertyName, oldValue, propertyValue)
       }
   }

    class Person(id:Long , name:String , age:Int, wage:Double, active:Boolean):
      PropertyChangeAware() {
        private val idProperty = ObservableProperty<Long>("id", id, changeSupport)
        private val nameProperty = ObservableProperty<String>("name", name, changeSupport)
        private val ageProperty = ObservableProperty<Int>("age", age, changeSupport)
        private val wageProperty = ObservableProperty<Double>("wage", wage, changeSupport)
        private val activeProperty = ObservableProperty<Boolean>("active", active, changeSupport)

        var id:Long
           get() = idProperty.getValue()
           set(value) {
               idProperty.setValue(value)
           }


        var name:String
           get() = nameProperty.getValue()
           set(value) {
               nameProperty.setValue(value)
           }

        var age:Int
           get() = ageProperty.getValue()
           set(value) {
               ageProperty.setValue(value)
           }

        var wage:Double
           get() = wageProperty.getValue()
           set(value) {
               wageProperty.setValue(value)
           }


        var active:Boolean
           get() = activeProperty.getValue()
           set(value) {
               activeProperty.setValue(value)
           }



        override fun toString():String {
            return "$id, $name , $age, $wage, $active"
        }

    }
}

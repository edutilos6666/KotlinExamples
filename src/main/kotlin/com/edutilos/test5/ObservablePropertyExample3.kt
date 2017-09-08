package com.edutilos.test5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty


object ObservablePropertyExample3 {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }


    private fun test1() {
      var p = Person(1, "foo", 10, 100.0, false)
      val listener = PropertyChangeListener { event->
           println("${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
      }
      p.addPropertyChangeListener(listener)
      p.id = 2
        p.name = "new_foo"
        p.age = 20
        p.removePropertyChangeListener(listener)
        p.wage = 200.0
        p.active = true

    }

    open class PropertyChangeAware {
        protected val changeSupport = PropertyChangeSupport(this)

        fun addPropertyChangeListener(listener:PropertyChangeListener) {
            changeSupport.addPropertyChangeListener(listener)
        }

        fun removePropertyChangeListener(listener:PropertyChangeListener) {
            changeSupport.removePropertyChangeListener(listener)
        }
    }



    class ObservableProperty<T>(var propertyValue:T, val changeSupport:PropertyChangeSupport) {
         operator fun getValue(p:Person , prop:KProperty<*>):T = propertyValue
         operator fun setValue(p:Person , prop:KProperty<*>, newValue:T) {
              val oldValue = propertyValue
              propertyValue = newValue
              changeSupport.firePropertyChange(prop.name, oldValue, propertyValue)
          }
    }


    class Person(id:Long , name:String, age:Int, wage:Double, active:Boolean):
            PropertyChangeAware() {
         var id:Long by ObservableProperty<Long>(id, changeSupport)
         var name:String by ObservableProperty<String> (name, changeSupport)
          var age:Int by ObservableProperty<Int> (age, changeSupport)
        var wage:Double by ObservableProperty<Double>(wage, changeSupport)
        var active:Boolean by ObservableProperty<Boolean>(active, changeSupport)


        override fun toString():String {
            return "$id , $name, $age, $wage, $active"
        }
    }


}

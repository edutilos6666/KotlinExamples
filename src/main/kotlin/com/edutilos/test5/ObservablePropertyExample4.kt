package com.edutilos.test5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


object ObservablePropertyExample4 {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }


    private fun test1() {
        val p = Person(1, "foo", 10, 100.0, true)
        val listener = PropertyChangeListener { event->
            println("${event.propertyName} changes from ${event.oldValue} to ${event.newValue}")
        }

        p.addPropertyChangeListener(listener)
        p.id = 2
        p.name = "new_foo"
        p.age = 20
        p.removePropertyChangeListener(listener)
        p.wage = 200.0
        p.active = false
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


    class Person(id:Long , name:String , age:Int, wage:Double, active:Boolean):PropertyChangeAware()  {
        var id:Long by Delegates.observable(id){
            prop:KProperty<*>, oldValue:Long , newValue:Long ->
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }

        val nameObserver = {prop:KProperty<*>, oldValue:String, newValue:String ->
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }

        var name:String by Delegates.observable(name, nameObserver)

        var age:Int by Delegates.observable(age) {
            prop:KProperty<*>, oldValue:Int, newValue:Int ->
              changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }


        var wage:Double by Delegates.observable(wage) {
            prop:KProperty<*>, oldValue:Double, newValue:Double->
              changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }

        var active:Boolean by Delegates.observable(active) {
            prop:KProperty<*>, oldValue:Boolean, newValue:Boolean->
              changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }


        override fun toString(): String {
            return "$id, $name, $age, $wage, $active"
        }

    }
}

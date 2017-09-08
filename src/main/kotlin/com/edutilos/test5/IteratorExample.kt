package com.edutilos.test5

import java.time.LocalDate
import java.time.LocalTime


object IteratorExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test2()
    }


   operator fun ClosedRange<LocalTime>.iterator():Iterator<LocalTime> =
       object: Iterator<LocalTime>  {
           var current = start

          override fun hasNext():Boolean {
              return current <= endInclusive
          }

           override fun next():LocalTime {
               current = current.plusMinutes(1)
               return current
           }
       }


    private fun test2() {
        var lt1 = LocalTime.of(10, 10, 10)
        var lt2 = lt1.plusMinutes(10)
        var rangeLT = lt1..lt2
        for(lt in rangeLT) {
            println(lt)
        }
    }









   /*operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
            object:  Iterator<LocalDate> {
                var current = start
                override fun hasNext(): Boolean {
                    return current <= endInclusive
                }

                override fun next(): LocalDate {
                    current = current.plusDays(1)
                    return current
                }
            }


    private fun test1() {
        var newYear = LocalDate.ofYearDay(2017, 10)
        var startYear = newYear.minusDays(5)
        var range = startYear..newYear
        for(ld in range) {
            println(ld)
        }
    }*/

}
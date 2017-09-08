package com.edutilos.test6


object RemovingDuplicateExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test3()
    }

    enum class OS {WINDOWS , MAC, LINUX, IOS, ANDROID}
    data class SiteVisit(val path:String , val duration:Double, val os:OS)
    val log = listOf(
            SiteVisit("/", 10.0, OS.WINDOWS),
            SiteVisit("/foo", 20.0, OS.LINUX),
            SiteVisit("/bar", 30.0, OS.WINDOWS),
            SiteVisit("/bim", 40.0, OS.WINDOWS),
            SiteVisit("/pako", 50.0, OS.LINUX),
            SiteVisit("/edutilos", 60.0, OS.MAC)
    )


    private fun test3() {
        fun avgDesktop():Double {
            return log.filter {it.os in setOf(OS.WINDOWS, OS.LINUX, OS.MAC)}
                    .map {it.duration}
                    .average()

        }
        println("avg desktop = ${avgDesktop()}")
    }

    private fun test2() {
        fun avg(os:OS):Double {
            return log.filter {it.os == os}
                    .map {it.duration}
                    .average()

        }

        println("avg linux = ${avg(OS.LINUX)}")
        println("avg windows = ${avg(OS.WINDOWS)}")

    }

    private fun test1() {


       val avgWindows = log.filter { it.os == OS.WINDOWS}
               .map {it.duration}
               .average()

        val avgLinux = log.filter {it.os == OS.LINUX}
                .map {it.duration}
                .average()

        println("avgWindows = $avgWindows")
        println("avgLinux = $avgLinux")

    }
}


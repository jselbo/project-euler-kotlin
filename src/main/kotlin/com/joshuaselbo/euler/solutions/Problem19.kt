package com.joshuaselbo.euler.solutions

import java.util.*

fun problem19() {
    var sunCount = 0

    // Start January 1, 1900 (Monday)
    val cal = GregorianCalendar(1900, GregorianCalendar.JANUARY, 1)
    cal.add(GregorianCalendar.YEAR, 1)
    var done = false
    while (!done) {
        if (cal[GregorianCalendar.DAY_OF_MONTH] == 1 &&
            cal[GregorianCalendar.DAY_OF_WEEK] == GregorianCalendar.SUNDAY
        ) sunCount++
        cal.add(GregorianCalendar.DAY_OF_MONTH, 1)
        done =
            cal[GregorianCalendar.YEAR] == 2000
                    && cal[GregorianCalendar.MONTH] == GregorianCalendar.DECEMBER
                    && cal[GregorianCalendar.DAY_OF_MONTH] == 1
    }

    println(sunCount)
}

package com.joshuaselbo.euler.solutions

fun problem28() {
    val grid = Array(1001) { IntArray(1001) }
    grid[500][500] = 1

    var counter = 1
    var row = 500
    var column = 500
    var direction = 1

    while (!(row == 0 && column == 1000)) {
        if (direction == 0) {
            grid[--row][column] = ++counter
            if (grid[row][column + 1] == 0) direction = 1
        } else if (direction == 1) {
            grid[row][++column] = ++counter
            if (grid[row + 1][column] == 0) direction = 2
        } else if (direction == 2) {
            grid[++row][column] = ++counter
            if (grid[row][column - 1] == 0) direction = 3
        } else {
            grid[row][--column] = ++counter
            if (grid[row - 1][column] == 0) direction = 0
        }
    }

    var sum = 0
    for (i in grid.indices) sum += grid[i][i]
    for (i in grid.indices) sum += grid[i][grid.size - 1 - i]

    // Because middle "1" is counted twice
    sum--
    println(sum)
}

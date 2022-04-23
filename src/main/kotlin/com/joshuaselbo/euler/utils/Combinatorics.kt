package com.joshuaselbo.euler.utils

/**
 * Generates a list of combinations of [n] entries of [items].
 *
 * e.g. com.joshuaselbo.euler.utils.allCombinations([1, 2, 3], 2) -> [ [1,2], [1,3], [2,3] ]
 */
fun <T> allCombinations(items: List<T>, n: Int): List<List<T>> {
    require(n >= 1 && n <= items.size)

    val accumulator = mutableListOf<List<T>>()
    allCombinationsInternal(accumulator, emptyList(), items, n)
    return accumulator
}

private fun <T> allCombinationsInternal(accumulator: MutableList<List<T>>, chosen: List<T>, candidates: List<T>, n: Int) {
    val end = candidates.size - n
    for (i in 0..end) {
        if (n == 1) {
            // Base case
            accumulator.add(chosen + candidates[i])
        } else {
            val newChosen = chosen + candidates[i]
            val newCandidates = candidates.subList(i+1, candidates.size)

            allCombinationsInternal(accumulator, newChosen, newCandidates, n - 1)
        }
    }
}
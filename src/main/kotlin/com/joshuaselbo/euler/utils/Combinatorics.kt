package com.joshuaselbo.euler.utils

/**
 * Generates a list of combinations of [n] entries of [items].
 *
 * e.g. allCombinations([1, 2, 3], 2) -> [ [1,2], [1,3], [2,3] ]
 */
fun <T> allCombinations(items: List<T>, n: Int): List<List<T>> {
    require(n >= 1 && n <= items.size)

    val combinations = mutableListOf<List<T>>()
    allCombinationsInternal(emptyList(), items, n) { combinations.add(it) }
    return combinations
}

/** Iterates through combinations of [n] entries of [items] by invoking [visitor] for each combination. */
fun <T> iterateCombinations(items: List<T>, n: Int, visitor: (List<T>) -> Unit) {
    require(n >= 1 && n <= items.size)
    allCombinationsInternal(emptyList(), items, n, visitor)
}

private fun <T> allCombinationsInternal(chosen: List<T>, candidates: List<T>, n: Int, visitor: (List<T>) -> Unit) {
    val end = candidates.size - n
    for (i in 0..end) {
        if (n == 1) {
            // Base case
            visitor(chosen + candidates[i])
        } else {
            val newChosen = chosen + candidates[i]
            val newCandidates = candidates.subList(i+1, candidates.size)

            allCombinationsInternal(newChosen, newCandidates, n - 1, visitor)
        }
    }
}

// TODO could add an "n" permute version later
/** Generates a list of permutations of [items]. */
fun <T> allPermutations(items: List<T>): List<List<T>> {
    val permutations = mutableListOf<List<T>>()
    permuteInternal(emptyList(), items) { permutations.add(it) }
    return permutations
}

/** Iterates through permutations of [items] by invoking [visitor] for each combination. */
fun <T> iteratePermutations(items: List<T>, visitor: (List<T>) -> Unit) {
    permuteInternal(emptyList(), items, visitor)
}

private fun <T> permuteInternal(frozenItems: List<T>, itemsToPermute: List<T>, visitor: (List<T>) -> Unit) {
    if (itemsToPermute.size == 1) {
        // Base case
        visitor(frozenItems + itemsToPermute)
    } else {
        for (i in itemsToPermute.indices) {
            val remainingItemsToPermute = itemsToPermute.subList(0, i) + itemsToPermute.subList(i+1, itemsToPermute.size)
            permuteInternal(frozenItems + itemsToPermute[i], remainingItemsToPermute, visitor)
        }
    }
}

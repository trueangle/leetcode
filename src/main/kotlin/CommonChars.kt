import kotlin.math.min

/**
 * Given a string array words,
 * return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */


fun main() {
    val input = arrayOf("cool", "lock", "cook")
    val input1 = arrayOf("bella", "label", "roller")
    println(commonChars(input1))
}

fun commonChars(words: Array<String>): List<String> {
    val occ = mutableMapOf<Char, Int>()
    val word = words[0]
    val result = mutableListOf<String>()

    for (char in word) {
        if (occ[char] == null) {
            occ[char] = word.count { it == char }
        }
    }

    occ.forEach { char, charCount ->
        var contains = true
        var count = charCount

        for (i in 1 until words.size) {
            val curCount = words[i].count { it == char }

            if (curCount == 0) {
                contains = false
                break
            }

            val localCount = min(count, curCount)
            count = min(charCount, localCount)
        }

        if (contains) {
            repeat(count) {
                result.add(char.toString())
            }
        }
    }

    return result
}
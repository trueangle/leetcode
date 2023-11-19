/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

fun main() {
    val input = arrayOf("ab", "a")
    println(longestCommonPrefix(input))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = ""

    for (k in 0 until strs[0].length) {
        val char = strs[0][k]

        if(strs.all { k < it.length && it[k] == char }) {
            prefix += char
        } else {
            return prefix
        }
    }

    return prefix
}
/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */

fun main() {
    val charArray = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    val charArray2 = charArrayOf('h', 'e', 'l', 'l', 'o')
    println(reverseString(charArray))
    println(reverseString(charArray2))
}

fun reverseString(s: CharArray): CharArray {
    var (i, j) = 0 to s.size - 1
    while (i <= j) {
        val temp = s[i]
        s[i] = s[j]
        s[j] = temp
        i++
        j--
    }

    return s
}
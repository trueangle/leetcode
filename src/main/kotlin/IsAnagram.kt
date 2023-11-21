/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


 */

fun main() {
    println(isAnagram("anagram", "nagaram"))
}

fun isAnagram(s: String, t: String): Boolean {

    if(s.length != t.length) return false
    
    val dict = hashMapOf<Char, Int>()

    s.forEach {
        if(dict[it] == null) {
            dict[it] = 1
        } else {
            dict[it] = dict[it]!! + 1
        }
    }

    t.forEach {
        if(dict[it] != null) {
            dict[it] = dict[it]!! - 1
        } else {
            return false
        }
    }

    return dict.values.all {it == 0}
}
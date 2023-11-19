/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */
//  [1,2,3,4,5,6,7]
// [
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val nums2 = intArrayOf(-1, -100, 3, 99)
    rotate(nums, 3)
    rotate(nums2, 2)
    println(nums.map { it.toString() })
    println(nums2.map { it.toString() })
}

fun rotate(nums: IntArray, k: Int): Unit {
    val size = nums.size
    var shift = 0
    var prev = nums[size - 1]
    var index = 0
    while (shift < k) {
        val temp = nums[index]
        nums[index] = prev
        prev = temp
        index++
        if (index == nums.size) {
            prev = nums[index - 1]
            index = 0
            shift++
        }
    }
}
/**
 *
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

 */
fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    println(nums.map { it.toString() })
}

fun moveZeroes(nums: IntArray): Unit {
    var shift = 0
    val size = nums.size
    for (i in nums.indices) {
        if (nums[i] == 0) {
            shift++
        } else {
            nums[i - shift] = nums[i]
        }
    }

    for (i in 1..shift) {
        nums[size - i] = 0
    }
}
import kotlin.math.absoluteValue

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
O(n) constraint

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
[9,1,0,16,100]
[0,1,9,16,100]
After sorting, it becomes [0,1,9,16,100].


Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
[4,9,9,49,121]
[4,9,9,49,121]

 */

fun OptimalSortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var left = 0
    var right = nums.size - 1
    var count = right

    while (left <= right) {
        val leftNum = nums[left].absoluteValue
        val rightNum = nums[right].absoluteValue

        when {
            leftNum < rightNum -> {
                result[count] = rightNum * rightNum
                right--
            }
            else -> {
                result[count] = leftNum * leftNum
                left++
            }
        }

        count--
    }

    return result
}

fun main() {
    val nums = intArrayOf(-4, -1, 0, 3, 10)
    OptimalSortedSquares(nums).map { print("$it ") }

    val haystack = "232"
    val needle = "213"

}

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var k = -1

    for (i in nums.indices) {
        if (nums[i] < 0) k++
        nums[i] = nums[i] * nums[i]
    }

    return when {
        k == nums.size - 1 -> {
            nums.reverse()
            nums
        }
        k >= 0 -> {
            var j = k // [k, 0]
            var i = k + 1 // [k+1, n)
            var index = 0

            while (i < nums.size && j >= 0) {
                if (nums[i] > nums[j]) {
                    result[index++] = nums[j--]
                } else {
                    result[index++] = nums[i++]
                }
            }

            while (i < nums.size) result[index++] = nums[i++]
            while (j > -1) result[index++] = nums[j--]

            result
        }
        else -> {
            nums
        }
    }
}
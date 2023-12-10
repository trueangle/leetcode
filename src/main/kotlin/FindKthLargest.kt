import java.util.PriorityQueue

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */

fun main() {
    val arr = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println(findKthLargest(arr, 4))

    // print 4 largest numbers
    println(findNLargestNumbers(arr, 4).joinToString(separator = ","))
    println(findNMinimumNumbers(arr, 4).joinToString(separator = ","))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val queue = PriorityQueue<Int>(k)

    for (i in 0 until k) {
        queue.offer(nums[i])
    }

    for (i in k until nums.size) {
        if (nums[i] > queue.peek()) {
            queue.poll()
            queue.offer(nums[i])
        }
    }

    return queue.peek()
}

fun findNLargestNumbers(nums: IntArray, n: Int): IntArray {
    val queue = PriorityQueue<Int>(n)

    for (i in 0 until n) {
        queue.offer(nums[i])
    }

    for (i in n until nums.size) {
        if (nums[i] > queue.peek()) {
            queue.poll()
            queue.offer(nums[i])
        }
    }

    return queue.toIntArray()
}

fun findNMinimumNumbers(nums: IntArray, n: Int): IntArray {

    val comp = compareBy<Int> { -it }
    val queue = PriorityQueue(comp)

    for (i in 0 until n) {
        queue.offer(nums[i])
    }

    for (i in n until nums.size) {
        if (nums[i] < queue.peek()) {
            queue.poll()
            queue.offer(nums[i])
        }
    }

    return queue.toIntArray()
}
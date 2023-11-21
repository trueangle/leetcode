import java.util.PriorityQueue

fun main() {
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
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
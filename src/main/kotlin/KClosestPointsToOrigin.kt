import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 */


fun main() {
    val input = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2))
    val k = 1

    println(kClosest(input, k).map { "[${it[0]},${it[1]}]" })
}

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    points.sortBy {
        distance(
            x1 = 0,
            x2 = it[0],
            y1 = 0,
            y2 = it[1]
        )
    }

    return points.take(k).toTypedArray()
}

private fun distance(x1: Int, y1: Int, x2: Int, y2: Int): Double =
    sqrt((x1.toDouble() - x2.toDouble()).pow(2) + (y1.toDouble() - y2.toDouble()).pow(2))
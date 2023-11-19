/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

fun main() {

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    //val mergedNode = ListNode()
    var node1 = list1
    var node2 = list2

    if (node1 == null && node2 == null) return null

    val mergedHead: ListNode = if (node1!!.`val` < node2!!.`val`) {
        ListNode(node1.`val`)
    } else {
        ListNode(node2.`val`)
    }

    var current = mergedHead
    do {
        val node = ListNode(0)

        if (node1!!.`val` <= node2!!.`val`) {
            node.`val` = node1.`val`
            node1 = node1.next
        } else {
            node.`val` = node2.`val`
            node2 = node2.next
        }

        current.next = node
        current = node

    } while (node1 != null && node2 != null)

    while (node1 != null) {
        val node = ListNode(node1.`val`)
        current.next = node
        current = node
    }

    while (node2 != null) {
        val node = ListNode(node2.`val`)
        current.next = node
        current = node
    }


    return mergedHead
}
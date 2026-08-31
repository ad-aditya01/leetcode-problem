/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        while (curr.next != null) {

            ListNode next = curr.next;

            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                } 
                else {
                    // Minimum distance is between consecutive critical points
                    minDistance = Math.min(
                        minDistance,
                        index - previousCritical
                    );

                    // Maximum distance is between
                    // first critical point and current critical point
                    maxDistance = index - firstCritical;
                }

                previousCritical = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        // Fewer than 2 critical points
        if (maxDistance == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}
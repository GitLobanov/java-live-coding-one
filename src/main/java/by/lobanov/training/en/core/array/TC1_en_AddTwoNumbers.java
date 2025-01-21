package by.lobanov.training.en.core.array;

import java.util.Arrays;
import java.util.List;

/**
 * Difficulty: medium
 * <br>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <br>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <br>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class TC1_en_AddTwoNumbers {

    public static void main(String[] args) {
        // Example test case
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // Represents 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // Represents 465

        ListNode result = addTwoNumbers(l1, l2);

        // Print result
        printList(result); // Expected output: 7 -> 0 -> 8
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry value

            // Add the values from l1 and l2, if present
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate new digit and carry
            carry = sum / 10;
            int digit = sum % 10;

            // Create new node for the current digit
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

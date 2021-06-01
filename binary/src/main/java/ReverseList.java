import java.util.List;

/**
 * @author Ruimin Wu
 * @date 2021-06-01 22:55
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    class ListNode {
        ListNode next;
    }

}

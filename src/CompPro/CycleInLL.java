package CompPro;




public class CycleInLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode dc(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                ListNode demo  = head;

                while (demo != p1){
                    demo = demo.next;
                    p1 = p2.next;
                }
                return demo;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = head.next;

        ListNode res = dc(head);
        System.out.println(res.val);
    }

}

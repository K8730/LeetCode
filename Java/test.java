public class test {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;
        b = new ListNode(888);

        System.out.println(a.next.val);
        System.out.println(b);

        System.out.println("====");

    }
}

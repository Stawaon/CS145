public class TestClass {
    public static void main(String[] args) {
        /* ListNode list = new ListNode();
        String[] wordList1 = {"word", "test", "whatever"};
        list.data = wordList1;
        list.next = new ListNode();
        String[] wordList2 = {"blah", "meh", "hmm"};
        list.next.data = wordList2;
        list.next.next = new ListNode();
        String[] wordList3 = {"yahoo", "whamo", "kapow"};
        list.next.next.data = wordList3;
        list.next.next.next = null;

        ListNode current = list;
        while (current != null) {
            for (int i = 0; current.data.length > i; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            current = current.next;
        } */
        PhonebookManager Bellingham = new PhonebookManager();
        PhonebookManager Centralia = new PhonebookManager();
        Bellingham.add("Noah", "Watson", "2408 Xenia St", "Bellingham", "360-550-5944");
        Bellingham.add("Emily", "Lekberg", "2408 Xenia St", "Bellingham", "360-979-0055");
        Bellingham.add("Kevin", "Watson", "214 Pearl St", "Centralia", "360-820-4564");
        
        Bellingham.swapBooks(2, Centralia);
        
        Bellingham.printPhonebook();
        System.out.println();
        Centralia.printPhonebook();



    }
}
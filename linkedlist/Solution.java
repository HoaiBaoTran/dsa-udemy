public class Solution {
    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList(10);
        myLinkedList.append(5);
        myLinkedList.append(16);

        System.out.println(myLinkedList);

        myLinkedList.prepend(1);
        System.out.println(myLinkedList);

        myLinkedList.insert(2, 99);
        System.out.println(myLinkedList);

        myLinkedList.remove(2);
        System.out.println(myLinkedList);

        myLinkedList.reverse();
        System.out.println(myLinkedList);

        // DoublyLinkedList myLinkedList = new DoublyLinkedList(10);
        // myLinkedList.append(5);
        // myLinkedList.append(16);

        // System.out.println(myLinkedList);
        // System.out.println(myLinkedList.printNext());

        // myLinkedList.prepend(1);
        // System.out.println(myLinkedList);
        // System.out.println(myLinkedList.printNext());

        // myLinkedList.insert(2, 99);
        // System.out.println(myLinkedList);
        // System.out.println(myLinkedList.printNext());

        // myLinkedList.remove(2);
        // System.out.println(myLinkedList);
        // System.out.println(myLinkedList.printNext());

    }

}
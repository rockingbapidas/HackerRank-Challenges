import java.util.*;

public class HackerRankLinkedList {

    public static void main(String[] args) {
        
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return false;

        SinglyLinkedListNode slowPointer = head;
        SinglyLinkedListNode fastPointer = head.next;

        while (slowPointer != fastPointer) {
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return true;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null)
            return -1;

        int firstNodeLength = 0;
        SinglyLinkedListNode firstNode = head1;
        while (firstNode != null) {
            firstNodeLength++;
            firstNode = firstNode.next;
        }

        int secondNodeLength = 0;
        SinglyLinkedListNode scondNode = head2;
        while (scondNode != null) {
            secondNodeLength++;
            scondNode = scondNode.next;
        }

        SinglyLinkedListNode first = head1;
        SinglyLinkedListNode second = head2;

        if (firstNodeLength > secondNodeLength) {
            int diff = firstNodeLength - secondNodeLength;
            for (int i = 0; i < diff; i++) {
                first = first.next;
            }
        } else {
            int diff = secondNodeLength - firstNodeLength;
            for (int i = 0; i < diff; i++) {
                second = second.next;
            }
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first.data;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode previous = null;
        DoublyLinkedListNode current = head;
        while (current != null) {
            DoublyLinkedListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (!isEmptyDoublyLinkedList(head)) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

            DoublyLinkedListNode current = head;

            int i = 0;
            while (current.data < data) {
                i++;
                if (current.next == null) {
                    newNode.prev = current;
                    current.next = newNode;
                    return head;
                }
                current = current.next;
            }

            if (i == 0) {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
                return head;
            }

            DoublyLinkedListNode previous = current.prev;
            DoublyLinkedListNode last = current;

            last.prev = newNode;
            newNode.next = last;

            newNode.prev = previous;
            previous.next = newNode;
        } else {
            head = new DoublyLinkedListNode(data);
        }
        return head;
    }

    static boolean isEmptyDoublyLinkedList(DoublyLinkedListNode head) {
        return lengthDoublyLinkedList(head) == 0;
    }

    static int lengthDoublyLinkedList(DoublyLinkedListNode head) {
        if (head != null) {
            int i = 0;
            DoublyLinkedListNode current = head;
            while (current != null) {
                current = current.next;
                i++;
            }
            return i;
        }
        return 0;
    }

    static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (!isEmptySinglyLinkedList(head)) {
            int size = lengthSinglyLinkedList(head);
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

            if (position > size)
                return null;

            if (position == size) {
                SinglyLinkedListNode current = head;
                outerloop: while (true) {
                    if (current.next == null)
                        break outerloop;
                    current = current.next;
                }
                current.next = newNode;
                return head;
            }

            if (position == 0) {
                SinglyLinkedListNode next = head;
                newNode.next = next;
                head = newNode;
                return head;
            }

            int i = 0;
            SinglyLinkedListNode current = head;
            SinglyLinkedListNode last = head;
            while (i != position) {
                current = last;
                last = current.next;
                i++;
            }
            newNode.next = last;
            current.next = newNode;
        } else {
            head = new SinglyLinkedListNode(data);
        }
        return head;
    }

    static boolean isEmptySinglyLinkedList(SinglyLinkedListNode head) {
        return lengthSinglyLinkedList(head) == 0;
    }

    static int lengthSinglyLinkedList(SinglyLinkedListNode head) {
        if (head != null) {
            int i = 0;
            SinglyLinkedListNode current = head;
            while (current != null) {
                current = current.next;
                i++;
            }
            return i;
        }
        return 0;
    }

    static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
}
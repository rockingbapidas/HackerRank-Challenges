import java.io.*;
import java.util.*;

public class ThirtyDaysCode {
    private static final Scanner scan = new Scanner(System.in);
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {
        // helloWorld();
        // dataTypes();
        // operators();
        // conditionalStatements();
        // classVsInstance();
        // loops();
        // letsReview();
        // arrays();
        // recursion();
        // binaryNumbers();
        // inheritance();
        // abstractClasses();
        // scope();
        // linkedList();
        // exceptionsStringToInteger();
        // new Calculator().power(2, 4);
        // System.out.println(new Calculator2().divisorSum(1));
        // sorting();

        // Printer<Integer> intPrinter = new Printer<Integer>();
        // Printer<String> stringPrinter = new Printer<String>();
        // intPrinter.printArray(new Integer[]{1, 2, 3});
        // stringPrinter.printArray(new String[]{"Hello", "World"});

        // getHeight(root);
        // levelOrder(root);
        
    }

    public static Node removeDuplicates(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.data == head.next.data){
            head.next = head.next.next;
            removeDuplicates(head);
        } else {
            removeDuplicates(head.next);
        }
        return head;
    }

    public static void levelOrder(Node2 root){
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node2 current = queue.remove();
            System.out.print(current.data + " ");
            if (current.left != null) 
                queue.add(current.left);
            if (current.right != null) 
                queue.add(current.right);
        }
    }

    public static int getHeight(Node2 root){
        if(root == null)
            return -1;

        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
  
    public static Node2 insert2(Node2 root,int data){
        if(root == null) {
            return new Node2(data);
        } else {
            Node2 cur;
            if(data <= root.data){
                cur = insert2(root.left, data);
                root.left = cur;
            } else {
                cur = insert2(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static class Node2 {
        Node2 left, right;
        int data;
        Node2(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Printer <T> {

        /**
        *    Method Name: printArray
        *    Print each element of the generic array on a new line. Do not return anything.
        *    @param A generic array
        **/
        public void printArray(T[] A) {
            for(int i = 0; i < A.length; i++) {
                System.out.println(A[i]);
            }
        }
    }

    public static void sorting() {
        int n = 3;
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = scan.nextInt();
        }
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }
            if (numberOfSwaps == 0) {
                break;
            }
            totalSwaps += numberOfSwaps;
        }
        System.out.println("Array is sorted in "+ totalSwaps +" swaps.");
        if(n > 1) {
            System.out.println("First Element: "+ a[0]);
            System.out.println("Last Element: "+ a[n - 1]);
        } else {
            System.out.println("First Element: "+ a[0]);
        }
    }

    interface AdvancedArithmetic{
        int divisorSum(int n);
    }

    public static class Calculator2 implements AdvancedArithmetic {

        @Override
        public int divisorSum(int n) {
            int sum = 0;
            for(int i = 1; i <= n; i++) {
                if (n % i == 0){
                    sum += i;
                }
            }
            return sum;
        }
    }

    public static class QueuesStacks {

        private Stack<Character> myStack = new Stack<Character>();
        private Queue<Character> myQueue = new LinkedList<>();

        public void pushCharacter(char c) {
            myStack.add(c);
        }

        public void enqueueCharacter(char c) {
            myQueue.add(c);
        }

        public char popCharacter() {
            return myStack.pop();
        }

        public char dequeueCharacter() {
            char c = myQueue.peek();
            myQueue.remove();
            return c;
        }
    }

    public static class Calculator {

        public int power(int base, int power) throws Exception {
            if(base < 0 || power < 0){
                throw new Exception("n and p should be non-negative");
            }
            return (int) Math.pow(base, power);
        }
    }

    public static void exceptionsStringToInteger() {
        String S = scan.next();
        try {
            int value = Integer.parseInt(S);
            System.out.println(value);
        } catch(Exception exception) {
            System.out.println("Bad String");
        }
    }

    public static void linkedList() {
        Node head = null;
        int N = scan.nextInt();

        while(N-- > 0) {
            int ele = scan.nextInt();
            head = insert(head,ele);
        }
        display(head);
        scan.close();
    }

    public static  Node insert(Node head,int data) {
        Node newNode = new Node(data);
        if(head != null) {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else {
            head = newNode;
        }
        return head;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    static void scope() {
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();
        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
    }

    public static class Difference {
        private int[] elements;
        public int maximumDifference;

        Difference(int[] arr) {
            this.elements = arr;
        }

        public void computeDifference() {
            for (int i = 0; i < elements.length; i++) {
                int element = elements[i];
                for (int j = i + 1; j < elements.length; j++) {
                    int difference = Math.abs(element - elements[j]);
                    if (maximumDifference < difference) {
                        maximumDifference = difference;
                    }
                }
            }
        }
    }

    static void abstractClasses() {
        String title = scan.nextLine();
        String author = scan.nextLine();
        int price = scan.nextInt();
        scan.close();
        Book book = new MyBook(title, author, price);
        book.display();
    }

    public static abstract class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        abstract void display();
    }

    public static class MyBook extends Book {
        private int price;

        MyBook(String title, String author, int price) {
            super(title, author);
            this.price = price;
        }

        @Override
        void display() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }

    static void inheritance() {
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();
        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }

    public static class Person1 {
        protected String firstName;
        protected String lastName;
        protected int idNumber;

        // Constructor
        public Person1(String firstName, String lastName, int identification) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = identification;
        }

        // Print person data
        public void printPerson() {
            System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
        }
    }

    public static class Student extends Person1 {
        private int[] testScores;

        public Student(String firstName, String lastName, int identification, int[] testScores) {
            super(firstName, lastName, identification);
            this.testScores = testScores;
        }

        public char calculate() {
            int sum = 0;
            int n = testScores.length;
            for (int i = 0; i < n; i++) {
                sum = sum + testScores[i];
            }
            Character grade = new Character('O');
            int avg = sum / n;
            if (avg >= 90 && avg <= 100) {
                grade = 'O';
            } else if (avg >= 80 && avg < 90) {
                grade = 'E';
            } else if (avg >= 70 && avg < 80) {
                grade = 'A';
            } else if (avg >= 55 && avg < 70) {
                grade = 'P';
            } else if (avg >= 40 && avg < 55) {
                grade = 'D';
            } else {
                grade = 'T';
            }
            return grade;
        }
    }

    static void hourglassSum() {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scan.nextLine().split(" ");
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        ArrayList<Integer> new_arr = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum = sum + arr[i + 1][j + 1];
                sum = sum + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                new_arr.add(sum);
            }
        }
        Collections.sort(new_arr);
        int hourglassSum = new_arr.get(new_arr.size() - 1);
        System.out.println(hourglassSum);
        scan.close();
    }

    static void binaryNumbers() {
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int remainder = 0, maxCount = 0, lastMaxCount = 0;
        while (n > 0) {
            remainder = n % 2;
            n = n / 2;
            if (remainder == 1) {
                maxCount++;
                if (maxCount >= lastMaxCount)
                    lastMaxCount = maxCount;
            } else {
                maxCount = 0;
            }
        }
        System.out.println(lastMaxCount);
        scan.close();
    }

    static void recursion() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scan.close();
    }

    static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    static void dictionariesAndMap() {
        int n = scan.nextInt();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int phone = scan.nextInt();
            map.put(name, phone);
        }
        while (scan.hasNext()) {
            String s = scan.next();
            if (map.containsKey(s)) {
                System.out.println(s + "=" + map.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        scan.close();
    }

    static void arrays() {
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        scan.close();
    }

    static void letsReview() {
        scan.nextLine();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            char[] arr = s.toCharArray();
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    even.append(arr[i]);
                } else {
                    odd.append(arr[i]);
                }
            }
            System.out.println(even + " " + odd);
        }
        scan.close();
    }

    static void loops() {
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        scan.close();
    }

    static void classVsInstance() {
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int age = scan.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        scan.close();
    }

    public static class Person {
        private int age;

        public Person(int initialAge) {
            if (initialAge < 0) {
                age = 0;
                System.out.println("Age is not valid, setting age to 0.");
            } else {
                age = initialAge;
            }
        }

        public void amIOld() {
            if (age >= 0 && age < 13) {
                System.out.println("You are young.");
            } else if (age >= 13 && age < 18) {
                System.out.println("You are a teenager.");
            } else {
                System.out.println("You are old.");
            }
        }

        public void yearPasses() {
            age = age + 1;
        }
    }

    static void conditionalStatements() {
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = "";
        int rem = n % 2;
        if (rem == 0) {
            if (n >= 2 && n <= 5) {
                result = "Not Weird";
            } else if (n >= 6 && n <= 20) {
                result = "Weird";
            } else {
                result = "Not Weird";
            }
        } else {
            result = "Weird";
        }
        System.out.println(result);
        scan.close();
    }

    static void operators() {
        double meal_cost = scan.nextDouble();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        double tip = (tip_percent * meal_cost / 100);
        double tax = (tax_percent * meal_cost / 100);
        int total = (int) Math.round(meal_cost + tip + tax);
        System.out.println(total);

        scan.close();
    }

    static void dataTypes() {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        int num = scan.nextInt();
        double dNum = scan.nextDouble();
        scan.nextLine();
        String str = scan.nextLine();

        System.out.println(num + i);
        System.out.println(dNum + d);
        System.out.println(s + str);

        scan.close();
    }

    static void helloWorld() {
        String inputString = scan.nextLine();
        scan.close();
        System.out.println("Hello, World. \n" + inputString);
    }
}
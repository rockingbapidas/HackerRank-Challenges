import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // runningTimeAndComplexity();
        // nestedLogic();

        // TestWithEmptyArray();
        // TestWithUniqueValues();
        // TestWithExactlyTwoDifferentMinimums();
        // System.out.println("OK");

        // regexPatterns();

        // bitwiseAnd();
    }

    public static void bitwiseAnd() {
        int t = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scan.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            if(((k - 1) | k) > n && k % 2 == 0){
                System.out.println(k - 2);
            } else {
                System.out.println(k - 1);               
            }
        }

        scan.close();
    }

    public static void regexPatterns() {
        int N = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> names = new ArrayList<>();
        String emailRegEx = ".+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegEx);

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scan.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            Matcher matcher = pattern.matcher(emailID);
            if(matcher.find()) {
                names.add(firstName);
            }
        }

        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) { 
                if (names.get(i).compareTo(names.get(j)) > 0) {
                    String temp = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }

        for (String string : names) {
            System.out.println(string);
        }

        scan.close();
    }

    public static void TestWithEmptyArray() {
        try {
            int[] seq = TestDataEmptyArray.get_array();
            int result = minimum_index(seq);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Exception wasn't thrown as expected");
    }

    public static void TestWithUniqueValues() {
        int[] seq = TestDataUniqueValues.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        Integer[] tmp = new Integer[seq.length];
        for (int i = 0; i < seq.length; ++i) {
            tmp[i] = Integer.valueOf(seq[i]);
        }
        if (!((new LinkedHashSet<Integer>(Arrays.asList(tmp))).size() == seq.length)) {
            throw new AssertionError("not all values are unique");
        }

        int expected_result = TestDataUniqueValues.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void TestWithExactlyTwoDifferentMinimums() {
        int[] seq = TestDataExactlyTwoDifferentMinimums.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        int[] tmp = seq.clone();
        Arrays.sort(tmp);
        if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
            throw new AssertionError("there are not exactly two minimums in the array");
        }

        int expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static class TestDataEmptyArray {
        public static int[] get_array() {
            // complete this function
            return new int[]{};
        }
    }

    public static class TestDataUniqueValues {
        public static int[] get_array() {
            // complete this function
            return new int[]{1, 2};
        }

        public static int get_expected_result() {
            // complete this function
            return 0;
        }
    }

    public static class TestDataExactlyTwoDifferentMinimums {
        public static int[] get_array() {
            // complete this function
            return new int[]{1, 1};
        }

        public static int get_expected_result() {
            // complete this function
            return 0;
        }
    }

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    public static void nestedLogic() {
        int AD = scan.nextInt();
        int AM = scan.nextInt();
        int AY = scan.nextInt();

        int ED = scan.nextInt();
        int EM = scan.nextInt();
        int EY = scan.nextInt();

        int totalHackos = 0;

        if(AY > EY) {
            totalHackos = 10000;
        } else  {
            if(AM > EM && AY == EY) {
                totalHackos = (AM - EM) * 500;
            } else if(AD > ED && AM == EM) {
                totalHackos = (AD - ED) * 15;
            }
        }
        System.out.print(totalHackos);
    }

    public static void runningTimeAndComplexity() {
        scan.nextInt();
        while(scan.hasNext()) {
            int num = scan.nextInt();
            if(num == 1) {
                System.out.println("Not prime");
                continue;
            }
            boolean flag = false;
            for(int i = 2; i <= num / 2; i++) {
                if(num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }

    public static void linkedListDeletion() {
        Node head = null;
        int T = scan.nextInt();
        while(T-- > 0){
            int ele = scan.nextInt();
            head = insert(head,ele);
        }
        head = removeDuplicates(head);
        display(head);
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

    public static void binaryTree() {
        int T = scan.nextInt();
        Node2 root = null;
        while(T-- > 0){
            int data = scan.nextInt();
            root = insert2(root,data);
        }
        levelOrder(root);
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

    public static void binarySearchTree() {
        int T = scan.nextInt();
        Node2 root = null;
        while(T-- > 0){
            int data = scan.nextInt();
            root = insert2(root,data);
        }
        int height = getHeight(root);
        System.out.println(height);
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

    public static void display2(Node2 head){
        Node2 start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.right;
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

    public static void generics() {
        int n = scan.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scan.nextInt();
        }

        n = scan.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scan.next();
        }
        
        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
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

    public static void interfaces() {
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator2(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
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

    interface AdvancedArithmetic{
        int divisorSum(int n);
    }

    public static void queuesAndStackes() {
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        QueuesStacks p = new QueuesStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." );
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

    public static void moreException() {
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int p = scan.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
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

    public static void abstractClasses() {
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

    public static void inheritance() {
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

    public static void hourglassSum() {
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

    public static void binaryNumbers() {
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

    public static void recursion() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scan.close();
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void dictionariesAndMap() {
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

    public static void arrays() {
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

    public static void letsReview() {
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

    public static void loops() {
        int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        scan.close();
    }

    public static void classVsInstance() {
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

    public static void conditionalStatements() {
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

    public static void operators() {
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

    public static void dataTypes() {
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

    public static void helloWorld() {
        String inputString = scan.nextLine();
        scan.close();
        System.out.println("Hello, World. \n" + inputString);
    }
}
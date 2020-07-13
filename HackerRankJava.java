import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HackerRankJava {
    public static void main(String[] args) {
        currencyFormatter();
    }

    public static void currencyFormatter() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    public static void javaDateTime() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);
        
        bufferedWriter.write(res);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        /*
         * Complete the 'findDay' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. INTEGER month
         *  2. INTEGER day
         *  3. INTEGER year
         */
    
        public static String findDay(int month, int day, int year) {
            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, day);
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
            return simpleDateformat.format(cal.getTime()).toUpperCase();
        }
    
    }

    public static void intToString() {
        try {
            Scanner in = new Scanner(System.in);
            int n = in .nextInt();
            in.close();
            String s = Integer.toString(n);
            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (Exception e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    public static void staticInitializer(){
		if(flag){
			int area = B * H;
			System.out.print(area);
		}
	}

    static boolean flag = true; 
    static int B,H;
    static {
        Scanner scan = new Scanner(System.in);
        B = scan.nextInt(); 
        scan.nextLine(); 
        H = scan.nextInt(); 
        scan.close(); 
        if(B > 0 && H > 0){ 
            flag = true;
        } else if((B <= 0 && H >= 0) || (B >= 0 && H <= 0)){ 
            flag = false; 
            System.out.println("java.lang.Exception: Breadth and height must be positive"); 
        } else { 
            flag = false; 
            System.out.println("java.lang.Exception: Breadth and height must be positive"); 
        }
    }

    public static void endOfFile() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(scan.hasNext()){
            i++;
            System.out.println(i + " " + scan.nextLine());
        }
        scan.close();
    }

    public static void dataTypes() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                if(x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) 
                System.out.println("* byte");

                if(x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) 
                System.out.println("* short");

                if(x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) 
                System.out.println("* int");

                System.out.println("* long");
            } catch(Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }

    public static void loop2(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int last = 0;
            int current = 1;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(last == 0)
                last += a + (current * b);
                else
                last += current * b;
                result.append(last + " ");
                current = current + current;
            }
            System.out.println(result);
        }
        in.close();
    }

    public static void loop() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }
        scanner.close();
    }

    public static void ouputFormatting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i = 0; i < 3; i++){
            String s1 = sc.next();
            int x = sc.nextInt();
            
            String str = String.format("%-15s", s1);
            String in = String.format("%03d", x);
            System.out.println(str + in);
        }
        System.out.println("================================");
        sc.close();
    }

    public static void stdInstdOut2() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    public static void ifElse() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(N % 2 != 0) {
            System.out.println("Weird");
        } else if(N % 2 == 0 && N >= 2 && N <= 5) {
            System.out.println("Not Weird");
        } else if(N % 2 == 0 && N >= 6 && N <= 20) {
            System.out.println("Weird");
        } else if(N % 2 == 0 && N > 20) {
            System.out.println("Not Weird");
        } else {
            System.out.println("Weird");
        }
        scanner.close();
    }

    public static void stdInstdOut() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void helloWorld() {
        System.out.println("Hello, World.");
        System.out.println("Hello, Java.");
    }
}
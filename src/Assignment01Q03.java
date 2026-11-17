public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int a = 0; int b = 1; int c = 0; //c is initialized with placeholder value
        int numOdd = 0;

        for (int i = 0; i < x; i++) {
            System.out.print(b);
            if (b % 2 != 0) {
                numOdd++;
            }
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
            c = a + b;
            a = b;
            b = c;
        }
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("\nThe number of odd numbers is: " + numOdd);
    }
}

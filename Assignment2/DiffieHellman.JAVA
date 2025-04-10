import java.util.Scanner;

class DiffieHellman {
    
    private static int  power(int base, int exponent, int mod) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = (result * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a prime number (P): ");
        int P = scanner.nextInt();

        System.out.print("Enter a primitive root of P (G): ");
        int G = scanner.nextInt();

        System.out.print("Enter private key (A): ");
        int  a = scanner.nextInt();

        System.out.print("Enter private key (B): ");
        int b = scanner.nextInt();

        
        int x = power(G, a, P);
        int  y = power(G, b, P);

        
        int  ka = power(y, a, P); 
        int kb = power(x, b, P); 

        
        System.out.println("\nPublicly Shared Values:");
        System.out.println("P (Prime Number): " + P);
        System.out.println("G (Primitive Root): " + G);
        System.out.println("A's Public Key: " + x);
        System.out.println("B's Public Key: " + y);
        System.out.println("\nSecret Keys:");
        System.out.println("A's Secret Key: " + ka);
        System.out.println("B's Secret Key: " + kb);

        
    }
}

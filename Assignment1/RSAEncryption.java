/*
Name : Ahire Harshada Banichand
Class : TY - A
PRN NO : UIT22F1004
Batch : T1 

ASSIGNMENT NO : 02

TITLE : Implement  the RSA algorithm for key generation and cipher verification

*/
                                   
import java.util.Scanner;

class SimpleRSA {
    
    static int powerMod(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1)  
                result = (result * base) % mod;

            exp = exp >> 1; 
            base = (base * base) % mod; 
        }
        return result;
    }

   
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    
    static int modInverse(int e, int phi) {
        for (int d = 2; d < phi; d++) {
            if ((d * e) % phi == 1)
                return d;
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter first prime number (p): ");
        int p = scanner.nextInt();

        System.out.print("Enter second prime number (q): ");
        int q = scanner.nextInt();

        
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        
        int e;
        while (true) {
            System.out.print("Enter public exponent (e) such that 1 < e < φ(n) and GCD(e, φ(n)) = 1: ");
            e = scanner.nextInt();

            if (e > 1 && e < phi && gcd(e, phi) == 1) {
                break;
            } else {
                System.out.println("Invalid e. It must be coprime with φ(n). Try again.");
            }
        }

        
        int d = modInverse(e, phi);
        if (d == -1) {
            System.out.println("Error: Could not compute private key.");
            return;
        }

        
        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        
        System.out.print("Enter message to encrypt (M < n): ");
        int M = scanner.nextInt();

        if (M >= n) {
            System.out.println("Error: Message must be smaller than n.");
            return;
        }

        
        int C = powerMod(M, e, n);
        System.out.println("Encrypted Message: " + C);

        
        int decrypted = powerMod(C, d, n);
        System.out.println("Decrypted Message: " + decrypted);
    }
}

/* 
output :

Enter first prime number (p): 7 
Enter second prime number (q): 11
Enter public exponent (e) such that 1 < e < φ(n) and GCD(e, φ(n)) = 1: 7
Public Key (e, n): (7, 77)
Private Key (d, n): (43, 77)
Enter message to encrypt (M < n): 9
Encrypted Message: 37
Decrypted Message: 9

 */

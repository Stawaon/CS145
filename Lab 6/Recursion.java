// Noah Watson
// CS 145
// 5/21/24
// Purpose: Understand  recursion in java. Explain funtionality or mystery method. Fixed sum method. Print a pascal's triangle with recursive methods.

public class Recursion {
    
    public Recursion() {
    }
    
    // method multiplies int a and int b.
    public int mystery(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a + mystery(a, b - 1);
        }
    }

    // method calculates the sum of int n, and all preceding numbers to 0
    public int sum(int n) {
        if (n > 0) { 
            return n + sum(n - 1); // keeps adding to sum number of times equal to n
        } else {
            return 0; // if n is 0 or negative, no sum
        }
    }

    // method prints a pascal's triangle with given number of rows, in triangle structure. (for the most part)
    public void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
          for (int k = 0; k < n - i; k++) {
            System.out.print(" "); // print space for triangle 
          }
          for (int j = 0; j <= i; j++) { // loop prints/calculates values of numbers in row i
            System.out.print(pascal(i, j) + " ");
          }
          System.out.println();
        }
    }
    
    // method calculates values at row i, column j
    private int pascal(int i, int j) {
        if (j == 0 || j == i) { // left and right sides of triangle
          return 1;
        } else {
          return pascal(i - 1, j - 1) + pascal(i - 1, j); // non-side numbers
        }
    }
    
}

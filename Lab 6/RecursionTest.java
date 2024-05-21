public class RecursionTest {
    public static void main(String[] args) {
        Recursion solve = new Recursion();
        
        System.out.println(solve.mystery(5, 5));
        System.out.println(solve.sum(4));
        solve.printTriangle(6);
    }

}

/* Exercise 1 
Output breakdown:
Given example int a = 5, and int b = 5, each recursion of method appears as follows
5 + (5, 4)
5 + 5 + (5, 3)
5 + 5 + 5 + (5, 2)
5 + 5 + 5 + 5 + (5, 1)
5 + 5 + 5 + 5 + 5 = 25
*/

/*  Exercise 2
Halting condition if (n == 0) does not work.
if n is less than 0 the method will recur infinitely.
return n + sum(n) also does not work.
calling the recursion this way, the value of n never changes, and the method will recur inifinitely.
To fix:
Halting condition is changed to if (n > 0),
now in the if, return n + sum(n - 1);
now in the else, return 0;
*/
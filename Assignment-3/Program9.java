import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
int term1 = 0;
int  term2 = 1;
System.out.println("Fibonacci Series upto 100:");

for(int i = 0; i<=100 ;i++)
{
System.out.print(term1 + " ");
int sum = term1 + term2;
term1 = term2;
term2 = sum;
}
}
}

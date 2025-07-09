import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
Scanner ob = new Scanner(System.in);
System.out.println("Enter the number: ");
int num = ob.nextInt();
int original = num;
int armstrong = num;
int n = 0;
int sum = 0;
while(num!=0)
{
int a = num%10;
num = num/10;
n++;
}

while(armstrong != 0)
{
int b = armstrong % 10;
int c = (int)Math.pow(b,n);
sum = sum + c;
armstrong = armstrong/10;
}


if(sum == original)
{
System.out.println(original + " is an Armstrong number.");
}
else
{
System.out.println(original + " is not an Armstrong number.");
}
}
}

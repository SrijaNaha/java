public class Assignment3
{
public static void main(String [] args)
{
char temp = 'A';
for( int i = 1; i<=5; i++)
{
for(int j = 1; j<=i; j++)
{
System.out.print(temp + " ");
temp++;
}
System.out.println();
 temp = 'A';
}
}
}

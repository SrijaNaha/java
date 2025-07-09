public class Assignment3
 {
public static void main(String[] args) 
{
        
String red = "\u001B[31m";
String reset = "\u001B[0m";
int m = 0;

for (int i = 1; i <= 5; i++) 
{
for (int j = 1; j <= i+m; j++) 
{
if(i!=1 && j==1)
{
System.out.print(red + "* " + reset);
}
else
{
System.out.print("* ");
}
}
m++;
System.out.println();
}
}
}

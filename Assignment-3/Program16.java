public class Assignment3 {
public static void main(String[] args) {
int rows = 5;

for (int i = 0; i < rows; i++) 
{
for (int s = 0; s < i; s++)
 {
 System.out.print("  "); // Two spaces for alignment
 }

for (int j = 0; j < rows - i; j++) 
{
System.out.print((char)('A' + j) + " ");
}
System.out.println();
 }
 }
 }

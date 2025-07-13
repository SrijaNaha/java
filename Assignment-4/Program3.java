import java.util.*;
class Area
{
float Radius1;
float Radius2;
float Height;
final  float PI = 3.14f;
float CylinderArea;
float CircleArea;

public float areaOfCircle(float Radius1)
{
 CircleArea = PI*(float)Math.pow(Radius1,2);
return CircleArea;
}

public float areaOfCylinder(float Radius2,float Height)
{
 CylinderArea = (2*PI*(float)Math.pow(Radius2,2)) + (2*PI*Radius2*Height);
return CylinderArea;
}

public void Display()
{
System.out.println("The area of circle is: " + CircleArea);
}
public void Display1()
{
System.out.println("The area of cylinder is: " + CylinderArea);
}
}

public class Assignment4
{
public static void main(String [] args)
{
Scanner ob = new Scanner(System.in);
Area circle = new Area();
System.out.println("Enter the radius of circle: ");
float Radius1 = ob.nextFloat();

Area cylinder = new Area();
System.out.println("Enter the radius of cylinder: ");
 float Radius2 = ob.nextFloat();
System.out.println("Enter the height of cylinder: ");
 float Height = ob.nextFloat();

circle.areaOfCircle( Radius1);
cylinder.areaOfCylinder( Radius2, Height);
circle.Display();
cylinder.Display1();
}
}

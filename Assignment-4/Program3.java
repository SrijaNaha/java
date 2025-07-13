import java.util.*;

class Flight
{
String Flight_Number;
String Destination;
float Distance;
float Fuel;


public void feedInfo()
{
Scanner ob = new Scanner(System.in);
System.out.println("Enter Flight Number: ");
Flight_Number = ob.nextLine();
System.out.println("Enter Destination: ");
Destination = ob.nextLine();
System.out.println("Enter Distance: ");
Distance = ob.nextFloat();
}

public void calFuel()
{
if(Distance <=1000)
{
Fuel = 500;
}
else if( Distance >1000 && Distance<=2000)
{
Fuel = 1100;
}
else
{
Fuel = 2200;
}
}

public void showInfo()
{
System.out.println("Flight No.: " + Flight_Number);
System.out.println("Destination: " + Destination);
System.out.println("Distance(in Kms): " + Distance);
System.out.println("Fuel(in Kgs) " + Fuel);        
}
}

public class Assignment4
{
public static void main(String [] args)
{
Flight F1 = new Flight();
F1.feedInfo();
F1.calFuel();
F1.showInfo();
}
}


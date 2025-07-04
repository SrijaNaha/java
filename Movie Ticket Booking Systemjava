import java.util.*;

class Movie {
private String title;
private int id;
private String time;
private boolean[] seats = new boolean[30];
private String description;

    Movie(String title, int id, String time, String description) {
        this.title = title;
        this.id = id;
        this.time = time;
        this.description = description;
    }

    String getDesc() {
        return description;
    }

    String getMname() {
        return title;
    }

    int getMid() {
        return id;
    }

    String getMtime() {
        return time;
    }

    boolean[] getMseats() {
        return seats;
    }

    void bookMseats(int seatNumber) {
        seats[seatNumber] = true;
    }

    void cancelMseats(int seatNumber) {
        seats[seatNumber] = false;
    }

    boolean isMseatBooked(int seatNumber) {
        return seats[seatNumber];
    }
}

class Booking {
    private String Username;
    private int Movieid;
    private int seat;

    Booking(String Username, int Movieid, int seat) {
        this.Username = Username;
        this.Movieid = Movieid;
        this.seat = seat;
    }

    String getUsername() {
        return Username;
    }

    int getMovieId() {
        return Movieid;
    }

    int getBseats() {
        return seat;
    }
}

class User {
private String username;
private String password;

User(String username, String password) {
this.username = username;
this.password = password;
}

String getUserName() {
return username;
    }

boolean Check(String p) {
return password.equals(p);
}
}

class AdminService {
static void AdminMenu() {
Scanner sc = new Scanner(System.in);
System.out.println("Admin Menu: ");
while (true) {
System.out.println("1.Add new Movie & Show timing.\n2.Update Movie Detail. \n3.Delete Movie from the list.\n4.View all Booking \n5.Logout");
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1: MovieBookingSys.AddMovie(); break;
case 2: MovieBookingSys.UpdateMovie(); break;
case 3: MovieBookingSys.DeleteMovie(); break;
case 4: MovieBookingSys.ViewBookings(); break;
case 5: return;
default: System.out.println("Invalid input!! Try again");
}
}
}
}

class UserService {
static void UserMenu(String user) {
Scanner sc = new Scanner(System.in);
while (true) {
System.out.println("1.View Movies.\n2.View Details. \n3.Book a Seat. \n4.Cancel Bookings \n5.Logout");
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1: MovieBookingSys.ViewMovies(); break;
case 2: MovieBookingSys.ViewDetails(); break;
case 3: MovieBookingSys.SeatBooking(user); break;
case 4: MovieBookingSys.cancelBooking(user); break;
case 5: return;
default: System.out.println("Invalid input!! Try again");
}
}
}
}

public class MovieBookingSys 
{
static Scanner sc = new Scanner(System.in);
 static User[] user = new User[200];
 static Movie[] Movies = new Movie[20];
  static Booking[] book = new Booking[120];
  static int usercount = 0;
  static int bookingCount = 0;
  static int Moviescount = 5;

public static void main(String[] args) 
{
user[usercount++] = new User("Admin", "Admin@#123");
Movies[0] = new Movie("Interstellar", 1, "6:00 PM", "Sci-fi/Drama:Space expedition through a wormhole in search of a new home for humanity.");
Movies[1] = new Movie("Inception", 2, "3:30 PM", "Action/Thriller:Explores dreams, the subconscious mind and corporate espionage.");
Movies[2] = new Movie("The Dark Knight", 3, "5:00 PM", "Action/Crime:Batman battles the Joker in a fight for Gotham's soul.");
Movies[3] = new Movie("Avengers: Endgame", 4, "9:00 PM", "Superhero/Action:Earth’s heroes assemble to reverse Thanos’s catastrophic snap.");
Movies[4] = new Movie("Titanic", 5, "7:15 PM", "Romance/Drama:A tragic love story unfolds aboard the doomed Titanic ship.");
 System.out.print("\n------Welcome to Cinepass-------");
  while (true) {
  System.out.println("\n1. Login\n2. Register\n3. Exit");
  int choice = sc.nextInt();
  sc.nextLine();
  switch (choice) {
  case 1: login(); break;
  case 2: register(); break;
  case 3: System.exit(0);
  default: System.out.println("Invalid choice.");
  }
  }
  }

static void login() {
System.out.print("Are you admin? (Yes/No): ");
boolean isAdmin = sc.nextLine().equalsIgnoreCase("Yes");

System.out.print("Enter Username: ");
String uname = sc.nextLine();
System.out.print("Enter Password: ");
String pass = sc.nextLine();

int j = findUser(uname);
if (j != -1 && user[j].Check(pass)) {
if (isAdmin && uname.equalsIgnoreCase("Admin")) {
AdminService.AdminMenu();
} 
else if (!isAdmin && !uname.equalsIgnoreCase("Admin")) {
UserService.UserMenu(uname);
}
else {
System.out.println("Login failed. Check Role.");
}
} 
else {
System.out.println("Invalid credentials.");
}
}

static void register() {
System.out.print("Enter new username: ");
String username = sc.nextLine();
if (findUser(username) != -1) {
System.out.println("Username already exists.");
return;
}
System.out.print("Enter password: ");
String pass = sc.nextLine();

user[usercount++] = new User(username, pass);
System.out.println("Registration successful!!");
}

static int findUser(String username) {
for (int i = 0; i < usercount; i++) {
if (user[i] != null && user[i].getUserName().equalsIgnoreCase(username)) {
return i;
}
}
return -1;
}

static int findMid(int id) {
for (int i = 0; i < Moviescount; i++) {
if (Movies[i].getMid() == id) {
return i;
}
}
return -1;
}

static void AddMovie() {
System.out.print("Enter Movie Title: ");
String title = sc.nextLine();
System.out.print("Enter Show Time: ");
String time = sc.nextLine();
System.out.print("Enter Movie id: ");
int id = sc.nextInt();
sc.nextLine();
System.out.print("Enter Movie Description(Brief): ");
String description = sc.nextLine();
Movies[Moviescount++] = new Movie(title, id, time, description);
System.out.println("Movie Added to the list");
}

static void UpdateMovie() {
System.out.print("Enter the movie id: ");
int id = sc.nextInt();
sc.nextLine();
int j = findMid(id);
if (j != -1) {
System.out.print("Enter new movie name: ");
String title = sc.nextLine();
System.out.print("Enter new Show Time: ");
String time = sc.nextLine();
System.out.print("Enter new Movie id: ");
int newId = sc.nextInt();
sc.nextLine();
System.out.print("Enter new Movie Description(Brief): ");
  String description = sc.nextLine();
  Movies[j] = new Movie(title, newId, time, description);
  System.out.println("Movie Updated in the list");
  } 
else {
System.out.println("Movie not found");
}
}

  static void DeleteMovie() {
  System.out.print("Enter the movie id: ");
  int id = sc.nextInt();
  int j = findMid(id);
  if (j != -1) {
  for (int i = j; i < Moviescount - 1; i++) {
  Movies[i] = Movies[i + 1];
  }
  Moviescount--;
  } 
  else {
  System.out.println("Movie not found");
  }
  }

  static void ViewBookings() {
  System.out.println("List of Bookings:");
  for (int i = 0; i < bookingCount; i++) {
  Booking b = book[i];
  System.out.println("Username: " + b.getUsername() + ", Movie Id: " + b.getMovieId() + ", Seat: " + b.getBseats());
  }
  }

static void ViewMovies() {
System.out.println("Ongoing Movies:");
for (int i = 0; i < Moviescount; i++) {
Movie m = Movies[i];
System.out.println("\nMovie Name: " + m.getMname() + "\nDescription: " + m.getDesc() + "\nId: " + m.getMid() + "\nTiming: " + m.getMtime());
}
}

static void ViewDetails() {
System.out.print("Enter Movie id: ");
int id = sc.nextInt();
int j = findMid(id);
if (j != -1) {
Movie m = Movies[j];
System.out.println("Movie Name: " + m.getMname());
System.out.println("Description: " + m.getDesc());
System.out.println("Show Time: " + m.getMtime());
} 
else {
System.out.println("Error!!...Cannot find details");
}
}

static void SeatBooking(String user) {
System.out.print("Enter the Movie id: ");
int id = sc.nextInt();
int j = findMid(id);
if (j != -1) {
System.out.println("------Seat Layout------ ");
System.out.println("Booked = BK ");
for (int i = 0; i < 30; i++) {
if (Movies[j].isMseatBooked(i)) {
System.out.print("[BK] ");
} 
else {
System.out.print(String.format("[%2d] ", i));
}
if ((i + 1) % 6 == 0) System.out.println();
}
System.out.print("Enter the seat no. to book: ");
int seatNumber = sc.nextInt();
if (!Movies[j].isMseatBooked(seatNumber)) 
{
Movies[j].bookMseats(seatNumber);
book[bookingCount++] = new Booking(user, id, seatNumber);
System.out.println("Booked Successfully.");
} 
else {
System.out.println("Cannot Book Seat!!");
}
} 
else {
  System.out.println("Movie not found");
  }
  }

static void cancelBooking(String user) {
System.out.print("Enter the Movie id: ");
int id = sc.nextInt();
System.out.print("Enter the seat no. to cancel: ");
int seatNumber = sc.nextInt();
for (int i = 0; i < bookingCount; i++) {
Booking b = book[i];
if (b.getUsername().equals(user) && b.getMovieId() == id && b.getBseats() == seatNumber) {
int k = findMid(id);
if (k != -1) {
Movies[k].cancelMseats(seatNumber);
for (int m = i; m < bookingCount - 1; m++) {
book[m] = book[m + 1];
}
bookingCount--;
System.out.println("Booking Cancelled");
return;
}
}
}
System.out.println("Booking Not Found!");
}
}

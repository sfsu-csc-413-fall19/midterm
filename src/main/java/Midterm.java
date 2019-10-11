import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Midterm {
  public static void main(String[] args){
    // Question 1 Factory Pattern
    // Uncomment the code below and write the appropriate classes to make it work
    /*
    UNCOMMENT THIS
    Animal goose = AnimalFactory.create("Goose");
    Animal dog = AnimalFactory.create("Dog");
    Animal cow = AnimalFactory.create("Cow");

    goose.makeSound(); // Honk
    dog.makeSound(); // Woof
    cow.makeSound(); // mooo
     */

    // Question 2 Builder Pattern
    // Uncomment the code below and write the appropriate classes to make it work
    /*
    RobotBuilder builder = new RobotBuilder();
    builder.setRam(1000);
    builder.setStorage(10000);
    builder.setWheels(2);
    builder.setName("Robo Ron");
    Robot robot = builder.build();

    builder = new RobotBuilder();
    builder.setName("Robo Rene");
    builder.setRam(500);
    builder.setStorage(15000);
    Robot robot2 = builder.build();
     */

    // Question 3
    // Read the demo json file in
    // Create a dto to map it, using gson
    // Print all the values

    // Question 4
    // Make a thread and fetch 2 values simultaneously
    // Fetch value of http://brianparra.com/sfsu/value1.json
    // and http://brianparra.com/sfsu/value2.json
    // Print the sum

    // Question 5
    String dummyData = "Lorem ipsum dolor sit amet,"
        + " consectetur adipiscing elit, sed do"
        + " eiusmod tempor incididunt ut labore et"
        + " dolore magna aliqua. Ut enim ad minim veniam,"
        + " quis nostrud exercitation ullamco laboris nisi "
        + "ut aliquip ex ea commodo consequat."
        + " Duis aute irure dolor in reprehenderit "
        + "in voluptate velit esse cillum dolore "
        + "eu fugiat nulla pariatur. Excepteur "
        + "sint occaecat cupidatat non proident,"
        + " sunt in culpa qui officia deserunt "
        + "mollit anim id est laborum.";
    List<String> words = Arrays.asList(dummyData.split(" "));
    // Use streams to do this process:
    // Remove all words with the letter t
    // Remove all punctuation
    // strip all consonants from every word
    // convert to count of letters
    // Collect to a set
    // print the number of unique letter counts
  }
}

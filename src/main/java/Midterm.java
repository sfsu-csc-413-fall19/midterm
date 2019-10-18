import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import question1.Animal;
import question1.AnimalFactory;
import question1.Goose;
import question2.Robot;
import question2.RobotBuilder;
import question3.QuestionDto;
import question4.RestWorker;

public class Midterm {
  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    // Question 1 Factory Pattern
    // Uncomment the code below and write the appropriate classes to make it work
    Animal goose = AnimalFactory.create("Goose");
    Animal dog = AnimalFactory.create("Dog");
    Animal cow = AnimalFactory.create("Cow");

    goose.makeSound(); // Honk
    dog.makeSound(); // Woof
    cow.makeSound(); // mooo

    // Question 2 Builder Pattern

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


    // Question 3
    // Read the demo json file in
    // Create a dto to map it, using gson
    // Print all the values
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader("src/midterm.json"));
    JsonParser jsonParser = new JsonParser();
    JsonObject obj = jsonParser.parse(br).getAsJsonObject();

    QuestionDto questionDto = gson.fromJson(obj, QuestionDto.class);
    System.out.println(questionDto.message);

    // Question 4
    // Make a thread and fetch 2 values simultaneously
    // Fetch value of http://brianparra.com/sfsu/value1.json
    // and http://brianparra.com/sfsu/value2.json
    // Print the sum
    RestWorker restWorker1 = new RestWorker("http://brianparra.com/sfsu/value1.json");
    RestWorker restWorker2 = new RestWorker("http://brianparra.com/sfsu/value2.json");
    Thread thread1 = new Thread(restWorker1);
    Thread thread2 = new Thread(restWorker2);
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println(restWorker1.getValue() + restWorker2.getValue());

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
    Set<Integer> answer = words.stream()
        .filter(word -> !word.contains("t"))
        .map(str -> str.replaceAll("[.,]", ""))
        .map(str -> str.replaceAll("(?i)[b-df-hj-np-tv-z]", ""))
        .map(str -> str.length())
        .collect(Collectors.toSet());
    System.out.println(answer.size());
  }
}

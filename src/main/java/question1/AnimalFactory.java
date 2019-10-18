package question1;

public class AnimalFactory {
  public static Animal create(String type){
    switch (type){
      case "Goose":
        return new Goose();
      case "Dog":
        return new Dog();
      case "Cow":
        return new Cow();
      default:
        return null;
    }
  }
}

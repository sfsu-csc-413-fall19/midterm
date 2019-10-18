package question2;

public class RobotBuilder {
  private Integer ram;
  private Integer storage;
  private Integer wheels;
  private String name;

  public Robot build(){
    return new Robot(ram, storage, wheels, name);
  }

  public void setRam(Integer ram) {
    this.ram = ram;
  }

  public void setStorage(Integer storage) {
    this.storage = storage;
  }

  public void setWheels(Integer wheels) {
    this.wheels = wheels;
  }

  public void setName(String name) {
    this.name = name;
  }
}

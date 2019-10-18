package question3;

public class QuestionDto {
  public final String message;
  public final Boolean isJsonCool;
  public final String department;
  public final Integer course;

  public QuestionDto(String message, Boolean isJsonCool, String department, Integer course) {
    this.message = message;
    this.isJsonCool = isJsonCool;
    this.department = department;
    this.course = course;
  }
}

package Navigation.src.ca.mcgill.ecse211;

public interface UltrasonicController {

  public void processUSData(int distance);

  public int readUSDistance();
}

package view;

import java.util.ArrayList;

public interface OutputModule
{
  /**
   * Calls the Finch to go forward about 6 inches.
   */
  public void go_forward();

  /**
   * Calls the Finch to go backward about 6 inches.
   */
  public void go_backward();

  /**
   * Calls the Finch to rotate counter-clockwise about 30 degrees.
   */
  public void rotate_left();

  /**
   * Calls the Finch to rotate clockwise about 30 degrees.
   */
  public void rotate_right();

  /**
   * Calls the Finch to play song using the Robot’s buzzer.
   * 
   * @param song a string comprised of letters from A to G.
   */
  public void play_song(String song);

  /**
   * Calls the Finch to play file using the computer’s speakers.
   * 
   * @param file a WMA song file.
   */
  public void play_file(String song);

  /**
   * Returns true if an object is on the right, false otherwise
   *
   * @return true if object is on the right, false otherwise
   */
  public boolean is_obstacle_on_right();

  /**
   * Returns true if an object is not on the right, false otherwise
   *
   * @return true if no object is on the right, false otherwise
   */
  public boolean is_obstacle_not_on_right();

  /**
   * Returns true if an object is on the left, false otherwise
   *
   * @return true if object is on the left, false otherwise
   */
  public boolean is_obstacle_on_left();

  /**
   * Returns true if an object is not on the left, false otherwise
   *
   * @return true if no object is on the left, false otherwise
   */
  public boolean is_obstacle_not_on_left();

  /**
   * Returns true if the beak is pointed up, false otherwise
   *
   * @return true if the beak is pointed up, false otherwise
   */
  public boolean is_beak_up();

  /**
   * Returns true if the beak is pointed down, false otherwise
   *
   * @return true if the beak is pointed down, false otherwise
   */
  public boolean is_beak_down();
  
  public void setColors(ArrayList<String> colors);
  
  public ArrayList<String> getColors();
}

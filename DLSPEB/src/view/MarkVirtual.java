package view;

import java.util.ArrayList;
import java.util.List;

import builder.InstructorProgram;

/**
 * Provides methods to execute actions through Finch Robot.
 */
public class MarkVirtual implements OutputModule
{
  private String filename;
  private ArrayList<String> colors;
  private List<String> commands;
  private Virtual world;
  private String stepOrRun;
  
  /**
   * 
   * @param filename
   * @param world
   * @param stepOrRun either "step" or "run". anything else is treated as run.
   */
  public MarkVirtual(String filename, Virtual world, String stepOrRun)
  {
    this.filename = filename;
    colors = null;
    commands = new ArrayList<String>();
    this.world = world;
    if (stepOrRun.equals("step"))
      this.stepOrRun = "step";
    else
      this.stepOrRun = "run";
  }
  
  /**
   * Calls the Finch to go forward about 6 inches.
   */
  public void go_forward()
  {
    System.out.println("go_forward");
    if (stepOrRun.equals("run"))
      commands.add("go_forward");
    else
      world.forward();
  }

  /**
   * Calls the Finch to go backward about 6 inches.
   */
  public void go_backward()
  {
    System.out.println("go_backward");
    if (stepOrRun.equals("run"))
      commands.add("go_backward");
    else
      world.backward();
  }

  /**
   * Calls the Finch to rotate counter-clockwise about 30 degrees.
   */
  public void rotate_left()
  {
    System.out.println("rotate_left");
    if (stepOrRun.equals("run"))
      commands.add("rotate_left");
    else
      world.rotate_left();
  }

  /**
   * Calls the Finch to rotate clockwise about 30 degrees.
   */
  public void rotate_right()
  {
    System.out.println("rotate_right");
    if (stepOrRun.equals("run"))
      commands.add("rotate_right");
    else
      world.rotate_right();
  }

  /**
   * Calls the Finch to play song using the Robot’s buzzer.
   * 
   * @param song a string comprised of letters from A to G.
   */
  public void play_song(String song)
  {
    System.out.println("play_song");
    if (stepOrRun.equals("run"))
      commands.add("play_song" + song);
    else
      world.play_song(song);
  }

  /**
   * Calls the Finch to play file using the computer’s speakers.
   * 
   * @param file a WMA song file.
   */
  public void play_file(String song)
  {
    System.out.println("Playing " + song);
    if (stepOrRun.equals("run"))
      commands.add("play_file " + song);
    else
      world.play_file(song);
  }

  /**
   * Returns true if an object is on the right, false otherwise
   *
   * @return true if object is on the right, false otherwise
   */
  public boolean is_obstacle_on_right()
  {
    return world.is_obstacle_on_right();
  }

  /**
   * Returns true if an object is not on the right, false otherwise
   *
   * @return true if no object is on the right, false otherwise
   */
  public boolean is_obstacle_not_on_right()
  {
    return world.is_obstacle_not_on_right();
  }

  /**
   * Returns true if an object is on the left, false otherwise
   *
   * @return true if object is on the left, false otherwise
   */
  public boolean is_obstacle_on_left()
  {
    return world.is_obstacle_on_left();
  }

  /**
   * Returns true if an object is not on the left, false otherwise
   *
   * @return true if no object is on the left, false otherwise
   */
  public boolean is_obstacle_not_on_left()
  {
    return world.is_obstacle_not_on_left();
  }

  /**
   * Returns true if the beak is pointed up, false otherwise
   *
   * @return true if the beak is pointed up, false otherwise
   */
  public boolean is_beak_up()
  {
    return true;
  }

  /**
   * Returns true if the beak is pointed down, false otherwise
   *
   * @return true if the beak is pointed down, false otherwise
   */
  public boolean is_beak_down()
  {
    return false;
  }
  
  /**
   * Calls Virtual.
   */
  public void done(InstructorProgram ip)
  {
    System.out.println("Called done.");
    String[] args = new String[commands.size()];
    for (int i = 0; i < commands.size(); i++)
    {
      args[i] = commands.get(i);
    }
    ip.f.setVisible(true);
    virtualdriver.main(args);
    System.out.println("Finished done");
  }
  
  public void setColors(ArrayList<String> colors)
  {
    this.colors = colors;
  }
  
  public ArrayList<String> getColors()
  {
    return colors;
  }
}
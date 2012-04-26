package builder;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;

import view.MarkVirtual;
import view.OutputModule;
import view.Virtual;

import exceptions.InvalidOutputModuleException;

/**
 * Stores and executes an Instructor Program.
 */
public class InstructorProgram
{
  private ArrayList<String> program;
  private OutputModule outputModule;
  public Virtual world;
  public JFrame f;
  
  public InstructorProgram()
  {
    program = null;
    outputModule = null;
  }
  
  /**
   * Decides whether to output to Finch or Virtual.
   * 
   * @param method Chooses what output module to use when running 
   *  commands. Either “Finch” or “Virtual”
   * @throws InvalidOutputModule if method is not “Finch”, “Virtual”
   */
  public OutputModule outputMethod(String method, String filename, String stepOrRun) throws InvalidOutputModuleException, FileNotFoundException
  {
    if (method.equals("Finch"))
    {
    	//outputModule = new Finch();
    }
    else if (method.equals("Virtual"))
    {
    	
      System.out.println("Hello. Virtual. JON. Smooth");
      //outputModule = new Virtual(filename);
      f = new JFrame("Virtual Dance");
      world = new Virtual("map.txt");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(700, 700);
      f.setVisible(true);
      f.add(world);
      outputModule = world;
    }
    else if (method.equals("MarkVirtual"))
    {
      System.out.println("Creating a MarkVirtual");
      
      System.out.println("Hello. Virtual. JON. Smooth");
      //outputModule = new Virtual(filename);
      f = new JFrame("Virtual Dance");
      world = new Virtual("coords.txt");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(700, 700);
      if (stepOrRun.equals("step"))
        f.setVisible(true);
      else
        f.setVisible(false);
      f.add(world);      
      outputModule = new MarkVirtual(filename, world, stepOrRun);
    }
    return outputModule;
  }
  
  public void setProgram(ArrayList<String> program)
  {
    this.program = program;
  }

  /**
   * Runs through the entire program.
   */
  public void run()
  {
    outputModule.setColors(program);
  }
}
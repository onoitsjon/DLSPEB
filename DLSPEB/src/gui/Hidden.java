package gui;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import exceptions.IdentifierAlreadyInUseException;
import exceptions.InvalidOutputModuleException;
import exceptions.InvalidStatementException;

import builder.*;
import view.*;

public class Hidden 
{
	public static void main(String[] args)
	{
		  GUI.hideWindow();
	      InstructorProgram ip = new InstructorProgram();
	      DancerProgram dp = new DancerProgram();
	      OutputModule om = null;
	      try {
	        om = ip.outputMethod("MarkVirtual", "Hi", "step");
	        dp.outputMethod(om);
	      } catch (FileNotFoundException e) {
	      } catch (InvalidOutputModuleException e) {
	      }
	      
	      ArrayList<String> colors = new ArrayList<String>();
	      colors.add("green");
	      colors.add("blue");
	      colors.add("red");
	      ip.setProgram(colors);
	      
	      ArrayList<String> program = new ArrayList<String>();
	 //     program.add("define hi");
	 //     program.add("if is_obstacle_on_left");
	 //     program.add("rotate_left");
	 //     program.add("rotate_right");
	      program.add("repeat 15 times");
	      program.add("go_backward");
	      program.add("endRepeat");
	   //   program.add("endif");
	   //   program.add("enddefine");
	  //    program.add("go_forward");
	  //    program.add("set blue to");
	  //    program.add("hi");
	  //    program.add("endset");
	 //     program.add("perform blue");
	      try
	      {
	        dp.setProgram(program);
	      } catch (IdentifierAlreadyInUseException e) {
	      }
	      catch (InvalidStatementException e) {
	      }
	      dp.run(ip);
	}
}

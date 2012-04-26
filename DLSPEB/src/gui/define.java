package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author - Kashif Qureshi
 */

public class define
{
	private static JTextField macroName;
	private static JFrame f;
	private static String[] masterCommands = {"instructor", "black", "blue", "cyan", "dark gray ", "gray", "light gray", "green", "magenta", "orange", "pink", "red", "white", "yellow", "delete line"};
	private static String[] dancerCommands = {"dancer", "define", "repeat", "if", "while", "set", "perform", "go_backward", "go_forward", "rotate_left", "rotate_right", "play_song", "play_file", " delete line"};
		
	
	static class WL implements WindowListener 
	{
		private Component component;
	    WL(Component component) {
	        this.component = component;
	    }

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			define.hidden();
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static void hidden()
	{
		GUI.windowClosed();
	}
	
  static class ShowPopupActionListener implements ActionListener {
    private Component component;
    ShowPopupActionListener(Component component) {
      this.component = component;
    }

    public synchronized void actionPerformed(ActionEvent actionEvent) 
    {
    	String text = macroName.getText();
    	text = text.trim();
    	if(GUI.contains(masterCommands, text) == true)
    	{
    		macroName.setText("You cannot use a color for a macro name");
    	//	macroName.setText("");
    	}
    	else if(GUI.contains(dancerCommands, text) == true)
    	{
    		macroName.setText("You cannot use a dancer command for a macro name");
    	}
    	else if(text.compareTo("") != 0 && text.compareTo("You cannot use a color for a macro name") != 0)
    	{
    		GUI.define(text, true);
    		f.setVisible(false);
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("");
    Container a = f.getContentPane();

    WindowListener www = new WL(f);
    ActionListener actionListener = new ShowPopupActionListener(f);

    JButton start = new JButton("Use this macro name");
    start.addActionListener(actionListener);
    start.setMnemonic(KeyEvent.VK_U);
    
    macroName = new JTextField();
    a.add(macroName);

    a.add(start, BorderLayout.PAGE_END);
    a.add(macroName, BorderLayout.PAGE_START);
    
    f.addWindowListener(www);
    f.setSize(300, 85);
    f.setVisible(true);
  }
}

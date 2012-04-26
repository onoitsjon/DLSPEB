package gui;
import gui.Set.ShowPopupActionListener;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Kashif Qureshi
 */

public class Perform 
{
	private static boolean macro = false;
	private static boolean c = false;
	private static String condition;
	private static JFrame f;
	private static String[] funcs;
	
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
			Perform.hidden();
			
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
    	String AE = actionEvent.getActionCommand();
   	
    	if(AE.compareTo("comboBoxChanged") == 0)
    	{
    		JComboBox selection = (JComboBox)actionEvent.getSource();
    		condition = (String)selection.getSelectedItem();
    	}
    	
    	else if(AE.compareTo("Click to set this color") == 0)
    	{
    		if(condition == null)
    		{
    			condition = "black";
    		}

    		GUI.perform(condition, true);
    		f.setVisible(false);
    		
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("");
    Container a = f.getContentPane();

    WindowListener www = new WL(f);
    ActionListener actionListener = new ShowPopupActionListener(f);
    String[] colors = {"black", "blue", "cyan", "dark gray", "gray", "light gray", "green", "magenta", "orange", "pink", "red", "white", "yellow"};

    funcs = args;
    JComboBox c = new JComboBox(colors);
    c.addActionListener(actionListener);
    
    JButton use = new JButton("Click to set this color");
    use.addActionListener(actionListener);
    
    a.add(c, BorderLayout.PAGE_END);
    a.add(use, BorderLayout.PAGE_START);
    
    f.addWindowListener(www);
    f.setSize(300, 85);
    f.setVisible(true);
    f.setResizable(false);
  }

}

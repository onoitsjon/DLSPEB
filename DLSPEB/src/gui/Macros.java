package gui;
import gui.Set.ShowPopupActionListener;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Kashif Qureshi
 */
public class Macros 
{
	private static boolean macro = false;
	private static String condition;
	private static JFrame f;
	private static String[] funcs = new String[100];
	
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
			Macros.hidden();
			
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
    	
    	else if(AE.compareTo("Click to set this macro") == 0)
    	{
    		if(condition == null)
    		{
    			condition = funcs[0];
    		}
    		GUI.macroSet(condition);
    		Set.setContinue(true);
    		f.setVisible(false);
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("Set a macro");
    Container a = f.getContentPane();
    System.out.println("Macros main");

    int counter = 0;
    while(counter <= args.length -1 && args[counter] != null)
    {
    	System.out.println("args: " + args[counter]);
    	funcs[counter] = args[counter];
    	counter++;
    	System.out.println(counter);
    }
    
    WindowListener www = new WL(f);
    ActionListener actionListener = new ShowPopupActionListener(f);
    JComboBox c = new JComboBox(args);
    c.addActionListener(actionListener);
    
    JButton use = new JButton("Click to set this macro");
    use.addActionListener(actionListener);
    
    a.add(c, BorderLayout.PAGE_END);
    a.add(use, BorderLayout.PAGE_START);
    
    f.addWindowListener(www);
    f.setSize(300, 85);
    f.setVisible(true);
  }
}

package gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author - Kashif Qureshi
 */

public class loop
{
	private static String condition;
	private static JFrame f;
	
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
			loop.hidden();
			
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
    	
    	if(AE.compareTo("Click to use this conditional") == 0)
    	{
    		if(condition == null)
    		{
    			condition = "is_obstacle_on_right";
    		}
    		GUI.wile(condition, true);
    		f.setVisible(false);
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("");
    Container a = f.getContentPane();

    ActionListener actionListener = new ShowPopupActionListener(f);
    WindowListener www = new WL(f);
    String[] conditions = {"is_obstacle_on_right    ", "is_obstacle_not_on_right", "is_obstacle_on_left     ", "is_obstacle_not_on_left ", "is_beak_up              ", "is_beak_down            "};
    
    JComboBox c = new JComboBox(conditions);
    c.addActionListener(actionListener);
    
    JButton use = new JButton("Click to use this conditional");
    use.addActionListener(actionListener);
    
 /**   JRadioButton or = new JRadioButton("or");
    JRadioButton nor = new JRadioButton("No or");
    
    ButtonGroup k = new ButtonGroup();
    k.add(or);
    k.add(nor);
    or.addActionListener(actionListener);
    nor.addActionListener(actionListener);
    a.add(or, BorderLayout.EAST);
    a.add(nor, BorderLayout.CENTER);*/
    
    a.add(c, BorderLayout.PAGE_END);
    a.add(use, BorderLayout.PAGE_START);
 
    f.addWindowListener(www);
    f.setSize(300, 125);
    f.setVisible(true);
  }
}

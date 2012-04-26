package gui;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

import builder.DancerProgram;

public class temp extends JFrame implements ActionListener {
	private static JTextArea masterBox;
	private static JTextArea dancerBox;
	private static JTextArea lines;
	private static JTextArea lines2;
	private static Container window;
	private static String cmd;
	private JFileChooser fc = new JFileChooser();
	private PopupFactory fact = PopupFactory.getSharedInstance();
	private ArrayList masterTree = new ArrayList();
	private ArrayList dancerTree = new ArrayList();
	private JButton undoB;
	private JButton redoB;
	private static JTextField masterLines;
	private static JTextField dancerLines;
	private static JComboBox master;
	private static JComboBox dancer;
	private String[] masterCommands = {" instructor", " black     ", " blue      ", " cyan      ", " dark gray ", " gray      ", " light gray", " green     ", " magenta   ", " orange    ", " pink      ", " red       ", " white     ", " yellow    ", " delete line"};
	private String[] dancerCommands = {" dancer", " define                     ", " repeat x times             ", " if                         ", " while                      ", " set                        ", " perform                    ", " go_backward                ", " go_forward                 ", " rotate_left                ", " rotate_right               ", " play_song                  ", " play_file                  ", " delete line"};
	private static String assistance;
	private static int loc;
	private static int aLine;
	private static int staticMTL;
	private static int staticDTL;
	private int mTotalLines = 0;
	private int dTotalLines = 0; 
	private boolean undo = false;
	private boolean redo = false;
	private boolean isCommand = false;
	private static boolean assist = false;
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public void actionPerformed(ActionEvent e)
    {
    	String event = e.getActionCommand();
    	if(event.compareTo("Save instructor") == 0)
    	{
    		String masterFile = masterBox.getText();
    		
            int returnVal = fc.showSaveDialog(window);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                System.out.println("Saving: " + file.getName() + ". \n" );
            } else {
                //log.append("Save command cancelled by user. \n");
            }
          //  log.setCaretPosition(log.getDocument().getLength());
    	}
    	
    	if(event.compareTo("Save dancer") == 0)
    	{
            int returnVal = fc.showSaveDialog(window);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
             //   log.append("Saving: " + file.getName() + ". \n" );
            } else {
                //log.append("Save command cancelled by user. \n");
            }
          //  log.setCaretPosition(log.getDocument().getLength());
    	}
    	
    	if(event.compareTo("Load dancer") == 0)
    	{
    		System.out.println("Load dancer");
    	}
    	
    	if(event.compareTo("Load instructor") == 0)
    	{
    		System.out.println("Load instructor");
    	}
    	
    	if(event.compareTo("Undo") == 0)
    	{
    		redo = true;
    		redoB.setEnabled(true);
    		System.out.println("Undo");
    	}
    	
    	if(event.compareTo("Redo") == 0)
    	{
    		System.out.println("Redo");
    	}
    	
    	if(event.compareTo("Step") == 0)
    	{
    		System.out.println("Step");
    	}
    	
    	if(event.compareTo("Run") == 0)
    	{
    		int totalLines = masterBox.getLineCount();
    		int counter = 0;
    		int startOffset;
    		while (counter <= totalLines)
    		{
    			try
    			{
    				startOffset = masterBox.getLineStartOffset(counter);
    				String temp = masterBox.getText(startOffset, 11);
    				temp.trim();
    				masterTree.add(counter, temp);
    			}
    			catch(BadLocationException ugh)
    			{
    				
    			}
    			counter++;
    		}
    		
    		counter = 0;
    		while(counter <= masterTree.size() -1)
    		{
    			System.out.println("Master tree element " + counter + " is " + masterTree.get(counter));
    			counter++;
    		}
    		
    		totalLines = dancerBox.getLineCount();
    		counter = 0;
    		while(counter <= totalLines)
    		{
    			try
    			{
    				startOffset = dancerBox.getLineStartOffset(counter);
    				String temp = dancerBox.getText(startOffset, 28);
    				temp.trim();
    				dancerTree.add(counter, temp);
    			}
    			catch(BadLocationException ok)
    			{
    				
    			}
    			counter++;
    		}
    		counter = 0;
    		while(counter <= dancerTree.size() - 1)
    		{
    			System.out.println("Dancer arraylist element " + counter + " is " + dancerTree.get(counter));
    			counter++;
    		}
    		
    		DancerProgram a = new DancerProgram();
    		masterTree.clear();
    		dancerTree.clear();
    	}
    	
    	if(event.compareTo("Stop") == 0)
    	{
    		System.out.println("Stop");
    	}
    		
    	if(event.compareTo("comboBoxChanged") == 0)
    	{
    		undo = true;
    		undoB.setEnabled(true);
    	System.out.println(event);
		JComboBox selection = (JComboBox)e.getSource();
		String command = (String)selection.getSelectedItem();
		
		System.out.println(dancerLines.getText());
		System.out.println(dTotalLines);
		System.out.println(command + " " + contains(masterCommands, command));
		
		int location = 0;
		Integer num = new Integer(masterLines.getText());
		num = num - 1;
		
		Integer num2 = new Integer(dancerLines.getText());
		num2 = num2 - 1;
		
		int index = selection.getSelectedIndex();
		
		// Master command only
		if(contains(masterCommands, command) && !contains(dancerCommands, command) && command.compareTo(" instructor") != 0)
		{
			try{
				location = masterBox.getLineStartOffset(num.intValue());
				}
				catch(BadLocationException be)
				{
					System.out.println("wassup");
				}
			System.out.println("A " + command);
			Integer lineNum = new Integer(masterLines.getText());
			
			if(lineNum <= mTotalLines) // Insert to line in middle of code
			{
				if(command.compareTo(" delete line") == 0)
				{
					System.out.println("SC3");
					if(lineNum == 1)
					{
						String temp = masterBox.getText();
						masterBox.setText("");
						masterBox.append(temp);
					}
					
					try
					{
						String temp = masterBox.getText(0, location);
						masterBox.setText("");
						masterBox.append(temp);
					}
					catch (BadLocationException ble)
					{
						
					}
					
				}
				else
				{
				System.out.println("D");
				if(lineNum == 1)
				{
					String temp = masterBox.getText();
					masterBox.setText("");
					masterBox.append(command + "\n");
					masterBox.append(temp);
				}
				else 
				{
					masterBox.insert("\n", location);
					masterBox.insert(command, location);
				}
			}}
			
			else // Insert to line at end of code
			{
				masterBox.append(command);
				masterBox.append("\n");
			}
			
			lineNum = lineNum - 1;
			mTotalLines++;
			staticMTL++; 
			lineNum = mTotalLines + 1;
			masterLines.setText(lineNum.toString());		
			master.setSelectedIndex(0);
		}
		else if(contains(masterCommands, command) && command.compareTo(" instructor") != 0 && masterCommands.length > index && command.equals(masterCommands[index])) // Master command that dancer also has
		{
			System.out.println("A master?");
			try{
				location = masterBox.getLineStartOffset(num.intValue());
				}
				catch(BadLocationException be)
				{
					System.out.println("wassup");
				}
			if(masterCommands.length > index && command.equals(masterCommands[index]))
			{
				System.out.println("B " + command);
				Integer lineNum = new Integer(masterLines.getText());
				System.out.println("Obtained line number " + lineNum);
				
				if(lineNum <= mTotalLines)
				{
					if(command.compareTo(" delete line") == 0)
					{
						int offset = 0;
						int offset2 = 0;
						String temp = "";
						System.out.println("SC4");
						if(lineNum == 1)
						{
							try{
								offset = masterBox.getLineEndOffset(0);
								System.out.println("1");
								int totalLines = masterBox.getLineCount();
								totalLines = totalLines - 2;
								System.out.println(totalLines);
								temp = masterBox.getText(offset, (11*totalLines));
								System.out.println("2");
							}
							catch(BadLocationException ble)
							{
								
							}

							System.out.println("Temp? " + temp);
							masterBox.setText("");
							masterBox.append(temp);
							masterBox.append("\n");
							mTotalLines--;
							mTotalLines--;
							staticMTL = staticMTL -2;
						}
						
						
						else if(lineNum == mTotalLines)
						{
							try
							{
								int aNum = lineNum - 1;
								offset = masterBox.getLineStartOffset(aNum);
								temp = masterBox.getText(0, offset);
								masterBox.setText("");
								masterBox.append(temp);
								mTotalLines--;
								mTotalLines--;
								staticMTL = staticMTL - 2;
							}
							catch(BadLocationException ble)
							{
								
							}
						}
						
						else if(lineNum < mTotalLines)
						{
							try
							{
								int aNum = lineNum - 1;
								offset = masterBox.getLineStartOffset(aNum);
								temp = masterBox.getText(0, offset);
								
								System.out.println("temp" + temp);
								
								offset2 = masterBox.getLineEndOffset(aNum);
								int totalLines = masterBox.getLineCount();
								totalLines = totalLines - 2;
								String temp2 = masterBox.getText(offset2, (11*(totalLines-aNum)));
								System.out.println(temp2);
								masterBox.setText("");
								masterBox.append(temp);
								masterBox.append(temp2);
								masterBox.append("\n");
								mTotalLines = mTotalLines - 2;
								staticMTL = staticMTL - 2;
							}
							catch (BadLocationException ble)
							{
								System.out.println("Bad location");
							}
						}
						
					}
					else{
					if(lineNum < 1)
					{
						System.out.println("Don't be an idiot");
					}
					System.out.println("C");
					if(lineNum == 1)
					{
						String temp = masterBox.getText();
						masterBox.setText("");
						masterBox.append(command + "\n");
						masterBox.append(temp);
					}
					else
					{
						System.out.println("flag");
						masterBox.insert("\n", location);
						masterBox.insert(command, location);
					}
				}}
				
				else
				{
					masterBox.append(command);
					masterBox.append("\n");
				}
				
				lineNum = lineNum - 1;
				mTotalLines++;
				staticMTL++;
				lineNum = mTotalLines + 1;
				masterLines.setText(lineNum.toString());
				master.setSelectedIndex(0);
			}}
			else if(contains(dancerCommands, command) && !contains(masterCommands, command) && command.compareTo(" dancer") != 0) // Dancer command 
			{
				System.out.println("Here?");
				try{
					location = dancerBox.getLineStartOffset(num2.intValue());
					}
					catch(BadLocationException be)
					{
						System.out.println("wassup");
					}
				System.out.println("Z " + command);
				Integer lineNum = new Integer(dancerLines.getText());
				loc = location;
				
				if(command.compareTo(" repeat x times             ") == 0)
				{
					aLine = lineNum;
					System.out.println("SC");
					window.setVisible(false);
					TextFieldListener.main(masterCommands);
					dTotalLines = dTotalLines + 2;
					
				}
				
				else if(command.compareTo(" set                        ") == 0)
				{
					aLine = lineNum;
					window.setVisible(false);
					Set.main(masterCommands);
					dTotalLines = dTotalLines + 2;
				}
				
				else if(command.compareTo(" if                         ") == 0)
				{
					aLine = lineNum;
					window.setVisible(false);
					conditional.main(masterCommands);
					dTotalLines = dTotalLines + 3;
				}
				
				else if(command.compareTo(" define                     ") == 0)
				{
					aLine = lineNum;
					window.setVisible(false);
					define.main(masterCommands);
					dTotalLines = dTotalLines + 2;
				}
				
				else if(command.compareTo(" while                      ") == 0)
				{
					aLine = lineNum;
					window.setVisible(false);
					loop.main(masterCommands);
					dTotalLines = dTotalLines + 2;
				}
				
				else{
				
				if(lineNum <= dTotalLines) // Insert to line in middle of code
				{
					if(command.compareTo(" delete line") == 0)
					{
						int offset = 0;
						int offset2 = 0;
						String temp = "";
						System.out.println("CS4 " + lineNum);
						if(lineNum == 1)
						{
							try{
								offset = dancerBox.getLineEndOffset(0);
								int totalLines = dancerBox.getLineCount();
								totalLines = totalLines - 2;
								System.out.println(totalLines);
								temp = dancerBox.getText(offset, (11*totalLines));
								System.out.println("2");
							}
							catch(BadLocationException ble)
							{
								System.out.println("ok...");
							}

							System.out.println("Temp? " + temp);
							dancerBox.setText("");
							dancerBox.append(temp);
							dancerBox.append("\n");
							dTotalLines--;
							dTotalLines--;
							staticDTL = staticDTL -2;
						}
						
						
						else if(lineNum == dTotalLines)
						{
							try
							{
								int aNum = lineNum - 1;
								offset = dancerBox.getLineStartOffset(aNum);
								temp = dancerBox.getText(0, offset);
								dancerBox.setText("");
								dancerBox.append(temp);
								dTotalLines--;
								dTotalLines--;
								staticDTL = staticDTL - 2;
							}
							catch(BadLocationException ble)
							{
								
							}
						}
						
						else if(lineNum < dTotalLines)
						{
							try
							{
								int aNum = lineNum - 1;
								offset = dancerBox.getLineStartOffset(aNum);
								temp = dancerBox.getText(0, offset);
								
								System.out.println(temp);
								
								offset2 = dancerBox.getLineEndOffset(aNum);
								int totalLines = dancerBox.getLineCount();
								totalLines = totalLines - 2;
								String temp2 = dancerBox.getText(offset2, (11*(totalLines-aNum)));
								System.out.println(temp2);
								dancerBox.setText("");
								dancerBox.append(temp);
								dancerBox.append(temp2);
								dancerBox.append("\n");
								dTotalLines = dTotalLines - 2;
								staticDTL = staticDTL - 2;
							}
							catch (BadLocationException ble)
							{
								System.out.println("Bad location");
							}
						}
						
					}
					// delete end
					
					System.out.println("W");
					if(lineNum == 1)
					{
						String temp = dancerBox.getText();
						dancerBox.setText("");
						dancerBox.append(command + "\n");
						dancerBox.append(temp);
					}
					else 
					{
						dancerBox.insert("\n", location);
						dancerBox.insert(command, location);
					}
				}
				
				else // Insert to line at end of code
				{
					dancerBox.append(command);
					dancerBox.append("\n");
				}
				
				lineNum = lineNum - 1;
				dTotalLines++;
				staticDTL++;
				lineNum = dTotalLines + 1;
				dancerLines.setText(lineNum.toString());		
				dancer.setSelectedIndex(0);
				}}
			
			else if(command.compareTo(" dancer") != 0) // Dancer command that master also has
			{
				try{
					location = dancerBox.getLineStartOffset(num2.intValue());
					}
					catch(BadLocationException be)
					{
						System.out.println("wassup");
					}
				if(dancerCommands.length >= index && command.equals(dancerCommands[index]))
				{
					System.out.println("Y " + command);
					Integer lineNum = new Integer(dancerLines.getText());
					System.out.println("lineNum " + lineNum + " dtl " + dTotalLines);
					
					if(lineNum <= dTotalLines)
					{
						if(command.compareTo(" delete line") == 0)
						{
							int offset = 0;
							int offset2 = 0;
							String temp = "";
							System.out.println("CS4 " + lineNum);
							if(lineNum == 1)
							{
								try{
									String textToDelete = dancerBox.getText(0, 28);
									System.out.println("Going to delete " + textToDelete);
									offset = dancerBox.getLineEndOffset(0);
									int totalLines = dancerBox.getLineCount();
									totalLines = totalLines - 2;
									System.out.println(totalLines);
									temp = dancerBox.getText(offset, (28*totalLines));
									String isCmd = textToDelete.substring(0, 5);
									
								}
								catch(BadLocationException ble)
								{
									System.out.println("ok?");
								}
								
								System.out.println("Temp? " + temp);
								dancerBox.setText("");
								dancerBox.append(temp);
								dancerBox.append("\n");
								dTotalLines--;
								dTotalLines--;
								staticDTL = staticDTL -2;
							}
							
							
							else if(lineNum == dTotalLines)
							{
								try
								{
									int aNum = lineNum - 1;
									offset = dancerBox.getLineStartOffset(aNum);
									temp = dancerBox.getText(0, offset);
									dancerBox.setText("");
									dancerBox.append(temp);
									dTotalLines--;
									dTotalLines--;
									staticDTL = staticDTL - 2;
								}
								catch(BadLocationException ble)
								{
									
								}
							}
							
							else if(lineNum < dTotalLines)
							{
								try
								{
									int aNum = lineNum - 1;
									offset = dancerBox.getLineStartOffset(aNum);
									temp = dancerBox.getText(0, offset);
									
									System.out.println(temp);
									
									offset2 = dancerBox.getLineEndOffset(aNum);
									int totalLines = dancerBox.getLineCount();
									totalLines = totalLines - 2;
									String temp2 = dancerBox.getText(offset2, (28*(totalLines-aNum)));
									System.out.println(temp2);
									dancerBox.setText("");
									dancerBox.append(temp);
									dancerBox.append(temp2);
									dancerBox.append("\n");
									dTotalLines = dTotalLines - 2;
									staticDTL = staticDTL - 2;
								}
								catch (BadLocationException ble)
								{
									System.out.println("Bad location A");
								}
							}
							
						}
						if(lineNum < 1 || lineNum > dTotalLines)
						{
							System.out.println("Don't be an idiot");
						}
						System.out.println("X");
						if(lineNum == 1 && command.compareTo(" delete line") != 0)
						{
							String temp = dancerBox.getText();
							dancerBox.setText("");
							dancerBox.append(command + "\n");
							dancerBox.append(temp);
						}
						else if(command.compareTo(" delete line") != 0)
						{
							System.out.println("Dancer flag");
							dancerBox.insert("\n", location);
							dancerBox.insert(command, location);
						}
					}
					
					else if(command.compareTo(" delete line") != 0)
					{
						dancerBox.append(command);
						dancerBox.append("\n");
					}
					
					lineNum = lineNum - 1;
					dTotalLines++;
					staticDTL++;
					lineNum = dTotalLines + 1;
					dancerLines.setText(lineNum.toString());	
					dancer.setSelectedIndex(0);
				}				
			}
		
		}   	
    }
    
    public temp(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
	pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	if (shouldFill) {
	//natural height, maximum width
	c.fill = GridBagConstraints.HORIZONTAL;
	}

	JScrollPane jsp = new JScrollPane();
	masterBox = new JTextArea(45, 45);
	masterBox.setEditable(false);

	lines = new JTextArea("1");
		lines.setBackground(Color.LIGHT_GRAY);
	lines.setEditable(false);

	masterBox.getDocument().addDocumentListener(new DocumentListener(){
		public String getText(){
			int caretPosition = masterBox.getDocument().getLength();
			Element root = masterBox.getDocument().getDefaultRootElement();
			String text = "1" + System.getProperty("line.separator");
			for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
				text += i + System.getProperty("line.separator");
			}
			return text;
		}
		
		public void changedUpdate(DocumentEvent de) {
			lines.setText(getText());
		}

		
		public void insertUpdate(DocumentEvent de) {
			lines.setText(getText());
		}

		
		public void removeUpdate(DocumentEvent de) {
			lines.setText(getText());
		}

	});

	jsp.getViewport().add(masterBox);
	jsp.setRowHeaderView(lines);
	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	if (shouldWeightX) {
	c.weightx = 0.5;
	}
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 3;
	pane.add(jsp, c);

	//
		JScrollPane jsp2 = new JScrollPane();
		dancerBox = new JTextArea(45, 45);
		dancerBox.setEditable(false);

		lines2 = new JTextArea("1");
 		lines2.setBackground(Color.LIGHT_GRAY);
		lines2.setEditable(false);
 
		dancerBox.getDocument().addDocumentListener(new DocumentListener(){
			public String getText(){
				int caretPosition = dancerBox.getDocument().getLength();
				Element root = dancerBox.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");
				for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
					text += i + System.getProperty("line.separator");
				}
				return text;
			}
			
			public void changedUpdate(DocumentEvent de) {
				lines2.setText(getText());
			}
 
			
			public void insertUpdate(DocumentEvent de) {
				lines2.setText(getText());
			}
 
			
			public void removeUpdate(DocumentEvent de) {
				lines2.setText(getText());
			}
 
		});
 
	jsp2.getViewport().add(dancerBox);
	jsp2.setRowHeaderView(lines2);
	jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	c.gridx = 2;
	c.gridy = 3;
	pane.add(jsp2, c);
	
	JButton saveI = new JButton("Save instructor");
	saveI.setBackground(new Color(200, 150, 200));
    saveI.setVerticalTextPosition(AbstractButton.CENTER);
    saveI.setHorizontalTextPosition(AbstractButton.LEADING); 
    saveI.setMnemonic(KeyEvent.VK_I);
    saveI.addActionListener(this);
    c.gridx = 0;
    c.gridy = 0;
    pane.add(saveI, c);
    
    undoB = new JButton("Undo");
	undoB.setBackground(new Color(255, 255, 0));
	undoB.setVerticalTextPosition(AbstractButton.CENTER);
	undoB.setHorizontalTextPosition(AbstractButton.LEADING); 
	undoB.setMnemonic(KeyEvent.VK_U);
	undoB.addActionListener(this);
	undoB.setEnabled(false);
	c.gridx = 3;
	pane.add(undoB, c);
	
    JButton step2 = new JButton("Step");
    step2.setBackground(Color.cyan);
    step2.setVerticalTextPosition(AbstractButton.CENTER);
    step2.setHorizontalTextPosition(AbstractButton.LEADING); 
    step2.setMnemonic(KeyEvent.VK_S);
    step2.addActionListener(this);
	c.gridx = 0;
	c.gridy = 5;
	pane.add(step2, c);
	
    JButton stop2 = new JButton("Stop");
    stop2.setBackground(Color.red);
    stop2.setVerticalTextPosition(AbstractButton.CENTER);
    stop2.setHorizontalTextPosition(AbstractButton.LEADING); 
    stop2.setMnemonic(KeyEvent.VK_T);
    stop2.addActionListener(this);
	c.gridx = 1;
	c.gridy = 5;
	pane.add(stop2, c);
	
    JButton run2 = new JButton("Run");
    run2.setBackground(Color.green);
    run2.setVerticalTextPosition(AbstractButton.CENTER);
    run2.setHorizontalTextPosition(AbstractButton.LEADING); 
    run2.setMnemonic(KeyEvent.VK_T);
    run2.addActionListener(this);
	c.gridx = 2;
	c.gridy = 5;
	pane.add(run2, c);
	
    JButton saveD = new JButton("Save dancer");
    saveD.setBackground(new Color(200, 150, 200));
    saveD.setVerticalTextPosition(AbstractButton.CENTER);
    saveD.setHorizontalAlignment(AbstractButton.CENTER);
    saveD.setMnemonic(KeyEvent.VK_D);
    saveD.addActionListener(this);
    c.gridx = 2;
    c.gridy = 0;
    pane.add(saveD, c);

    JButton loadD = new JButton("Load dancer");
    loadD.setBackground(new Color(0, 206, 209));
    loadD.setVerticalTextPosition(AbstractButton.CENTER);
    loadD.setHorizontalAlignment(AbstractButton.CENTER);
    loadD.setMnemonic(KeyEvent.VK_O);
    loadD.addActionListener(this);
    c.gridy = 1;
    c.gridx = 2;
    pane.add(loadD, c);
    
    JButton loadI = new JButton("Load instructor");
    loadI.setBackground(new Color(0, 206, 209));
    loadI.setVerticalTextPosition(AbstractButton.CENTER);
    loadI.setHorizontalAlignment(AbstractButton.CENTER);
    loadI.setMnemonic(KeyEvent.VK_A);
    loadI.addActionListener(this);
    c.gridx = 0;
    pane.add(loadI, c);
    
    redoB = new JButton("Redo");
    redoB.setBackground(new Color(255, 255, 0));
    redoB.setVerticalTextPosition(AbstractButton.CENTER);
    redoB.setHorizontalTextPosition(AbstractButton.LEADING); 
    redoB.setMnemonic(KeyEvent.VK_R);
    redoB.addActionListener(this);
	c.gridx = 3;
	redoB.setEnabled(false);
	pane.add(redoB, c);
	
    
	master = new JComboBox(masterCommands);
	master.setSelectedIndex(0);
	master.addActionListener(this);
	c.gridx = 0;
	c.gridy = 6;
	pane.add(master, c);

	dancer = new JComboBox(dancerCommands);
	dancer.setSelectedIndex(0);
	dancer.addActionListener(this);
	c.gridx = 2;
	c.gridy = 6;
	pane.add(dancer, c);

	JLabel m = new JLabel("Instructor");
	c.gridx = 0;
	c.gridy = 2;
	pane.add(m, c);
	
	JLabel d = new JLabel("Dancer");
	c.gridx = 2;
	pane.add(d, c);
	
	masterLines = new JTextField("1");
	masterLines.addActionListener(this);
	c.gridx = 0;       
	c.gridy = 7;     
	pane.add(masterLines, c);
	
	dancerLines = new JTextField("1");
	dancerLines.addActionListener(this);
	c.gridx = 2;
	pane.add(dancerLines, c);
    window = pane;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Dance Learning Simulation Programming Environment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        GUI newContentPane = new GUI(frame.getContentPane());

        //Display the window.
        frame.setSize(1600, 1600);
        frame.setVisible(true);
    }

    private static boolean contains(String[] array, String key)
    {
    	int counter = 0;
    	while(counter < array.length)
    	{
    		if(array[counter].compareTo(key) == 0)
    		{
    			return true;
    		}
    		counter++;
    	}
    	return false;
    }
    
    public static void define(String thanks, boolean condition)
    {
    	assist = condition;
    	if(condition)
    	{
    		System.out.println("aLine " + aLine + " staticDTL " + staticDTL);
    		if(aLine <= staticDTL) // Insert to line in middle of code
    		{
    			System.out.println("D");
    			if(aLine == 1)
    			{
    				String temp = dancerBox.getText();
    				dancerBox.setText("");
    				dancerBox.append(" define " + thanks + "\n" + " endDefine                  " + "\n");
    				dancerBox.append(temp);
    			}
    			else 
    			{
    				dancerBox.insert("\n", loc);
    				dancerBox.insert(" define " + thanks + "\n" + " endDefine                  ", loc);
    			}
    		}
		
    		else // Insert to line at end of code
    		{
    			dancerBox.append(" define " + thanks + "\n" + " endDefine                  ");
    			dancerBox.append("\n");
    		}
		
     		if(aLine == 1)
     			aLine = aLine - 1;
    		staticDTL = staticDTL + 2;	
    		aLine = staticDTL + 1;
    		Integer t = new Integer(aLine);
    		System.out.println("Integer t " + t);
    		String temp = new String(t.toString());
    		dancerLines.setText(temp);		
    		dancer.setSelectedIndex(0);
    		window.setVisible(true);		
    		assistance = thanks;
    		System.out.println("Thanks");
    	}
    }
    
    public static void conditional(String condition, boolean cond)
    {
    	assist = cond;
    	if(cond)
    	{
    		System.out.println("aLine " + aLine + " staticDTL " + staticDTL);
     		if(aLine <= staticDTL) // Insert to line in middle of code
    		{
    			System.out.println("D");
    			if(aLine == 1)
    			{
    				String temp = dancerBox.getText();
    				dancerBox.setText("");
    				dancerBox.append(" if " + condition + "\n" + " else                       " + "\n" + " endIf                       " + "\n");
    				dancerBox.append(temp);
    			}
    			else 
    			{
    				dancerBox.insert("\n", loc);
    				dancerBox.insert(" if " + condition + "\n" + " else                       " + "\n" + " endIf                       ", loc);
    			}
    		}
    		
    		else // Insert to line at end of code
    		{
    			dancerBox.append(" if " + condition + "\n" + " else                       " + "\n" + " endIf                       ");
    			dancerBox.append("\n");
    		}
    		
     		if(aLine == 1)
     			aLine = aLine - 1;
    		staticDTL = staticDTL + 3;	
    		aLine = staticDTL + 1;
    		Integer t = new Integer(aLine);
    		System.out.println("Integer t " + t);
    		String temp = new String(t.toString());
    		dancerLines.setText(temp);		
    		dancer.setSelectedIndex(0);
        	window.setVisible(true);   	
        	assistance = condition;   		
    	}
    }
    
    public static void wile(String condition, boolean cond)
    {
    	assist = cond;
    	if(cond)
    	{
    		System.out.println("aLine " + aLine + " staticDTL " + staticDTL);
     		if(aLine <= staticDTL) // Insert to line in middle of code
    		{
    			System.out.println("D");
    			if(aLine == 1)
    			{
    				String temp = dancerBox.getText();
    				dancerBox.setText("");
    				dancerBox.append(" while " + condition + "\n" + " endWhile                         " + "\n");
    				dancerBox.append(temp);
    			}
    			else 
    			{
    				dancerBox.insert("\n", loc);
    				dancerBox.insert(" while " + condition + "\n" + " endWhile                    ", loc);
    			}
    		}
    		
    		else // Insert to line at end of code
    		{
    			dancerBox.append(" while " + condition + "\n" + " endWhile                    ");
    			dancerBox.append("\n");
    		}
    		
     		if(aLine == 1)
     			aLine = aLine - 1;
    		staticDTL = staticDTL + 2;	
    		aLine = staticDTL + 1;
    		Integer t = new Integer(aLine);
    		System.out.println("Integer t " + t);
    		String temp = new String(t.toString());
    		dancerLines.setText(temp);		
    		dancer.setSelectedIndex(0);
        	window.setVisible(true);   	
        	assistance = condition;   	
    	}
    }
    
    public static void set(String thx, boolean condition)
    {
    	assist = condition;
    	if(condition)
    	{
    	System.out.println("aLine " + aLine + " staticDTL " + staticDTL);
 		if(aLine <= staticDTL) // Insert to line in middle of code
		{
			System.out.println("D");
			if(aLine == 1)
			{
				String temp = dancerBox.getText();
				dancerBox.setText("");
				dancerBox.append(" set " + thx + " to                " + "\n" + " endSet                      " + "\n");
				dancerBox.append(temp);
			}
			else 
			{
				dancerBox.insert("\n", loc);
				dancerBox.insert(" set " + thx + " to                " + "\n" + " endSet                      ", loc);
			}
		}
		
		else // Insert to line at end of code
		{
			dancerBox.append(" set " + thx + " to                " + "\n" + " endSet                      ");
			dancerBox.append("\n");
		}
		
 		if(aLine == 1)
 			aLine = aLine - 1;
		staticDTL = staticDTL + 2;	
		aLine = staticDTL + 1;
		Integer t = new Integer(aLine);
		System.out.println("Integer t " + t);
		String temp = new String(t.toString());
		dancerLines.setText(temp);		
		dancer.setSelectedIndex(0);
    	window.setVisible(true);   	
    	assistance = thx;
    	}   	
    }
    
    public static void assist(String thanks, boolean condition)
    {
    	assist = condition;
    	if(condition)
    	{
    	System.out.println("aLine " + aLine + " staticDTL " + staticDTL);
 		if(aLine <= staticDTL) // Insert to line in middle of code
		{
			System.out.println("D");
			if(aLine == 1)
			{
				String temp = dancerBox.getText();
				dancerBox.setText("");
				dancerBox.append(" repeat " + thanks + " times             " + "\n" + " endRepeat                   " + "\n");
				dancerBox.append(temp);
			}
			else 
			{
				dancerBox.insert("\n", loc);
				dancerBox.insert(" repeat " + thanks + " times             " + "\n" + " endRepeat                   ", loc);
			}
		}
		
		else // Insert to line at end of code
		{
			dancerBox.append(" repeat " + thanks + " times             " + "\n" + " endRepeat                   ");
			dancerBox.append("\n");
		}
		
 		if(aLine == 1)
 			aLine = aLine - 1;
		staticDTL = staticDTL + 2;	
		aLine = staticDTL + 1;
		Integer t = new Integer(aLine);
		System.out.println("Integer t " + t);
		String temp = new String(t.toString());
		dancerLines.setText(temp);		
		dancer.setSelectedIndex(0);
    	window.setVisible(true);   	
    	assistance = thanks;
    	}
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
// GetInfo Class
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//***********************************************************************
//***********************************************************************
//*****   ELDER/Turkoanje/Barkochba/Pancho  VERSION   NEW 06/2014   *****
//*****   Range testing for getInt and getDouble      	            *****                        
//*****   Allows for use of tabbing with escape sequencing          ***** 
//*****                                                             ***** 
//*****   ELDER/Turkoanje/Barkochba         VERSION   NEW 10/2009   *****
//*****   Contains a resizeable getList (min 200 x 200)             *****                        
//*****                                                             ***** 
//***********************************************************************
//***********************************************************************


 /**
  *This class is meant to simplify the task of getting input.
  *It was made to allow students to get input before they learn about JOptionPane
  *or other similiar methods.  It also does not require any classes outside the 
  *Java Standard Class Library (i.e. no author/text specific classes), and helps create
  *a smooth introduction to using class methods.
  *
  *NOTE: THIS CLASS DOES NOT ACCOMODATE IF IMPROPER INPUT IS GIVEN!
  */ 
  	
public class GetInfo
{
		/**
		 *default constructor--not used
		 */
		public GetInfo()
		{
		}
		
		/**
		 *Creates a pop-up input window and returns the input as a string.
		 *
		 *@param str the question to be asked
		 *@return String--the answer provided by the user
		 */
		public static String getString(String str)
		{
			String input= JOptionPane.showInputDialog(str);
			return input;
		}
		
		/**
		 *Creates a pop-up input window and returns the input as an int.
		 *
		 *@param str the question to be asked
		 *@return int--the answer provided by the user
		 */
		public static int getInt(String str) throws NumberFormatException
		{
			String input= getString(str);
			int output = -99999;
			
			try {
				output=Integer.parseInt(input);
				if(output < -99999 || output > 1000000){
					output = -99999;
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException excObj) {
				showMessage("Illegal input - Please enter an integer!");
			}
			finally {
				return output;
			}
		}
		
		/**
		 *Creates a pop-up input window and returns the input as a double.
		 *
		 *@param str the question to be asked
		 *@return double--the answer provided by the user
		 */
		public static double getDouble(String str) throws NumberFormatException
		{			
			String input= getString(str);
			double output = -99999.0;
			
			try {
				output=Double.parseDouble(input);
				if(output < -99999.0 || output > 1000000.0){
					output = -99999.0;
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException excObj) {
				showMessage("Illegal input - Please enter a double!");
			}
			finally {
				return output;
			}
		}
		
		/**
		 *Creates a pop-up input window and returns the input as a char.
		 *
		 *@param str the question to be asked
		 *@return char--the answer provided by the user
		 */
		public static char getChar(String str)
		{
			String input= getString(str);
			char output= input.charAt(0);
			return output;
		}
		
		/**
		 *Creates a pop-up input window and returns the input as a float.
		 *
		 *@param str the question to be asked
		 *@return float--the answer provided by the user
		 */
		public static float getFloat(String str)
		{
			String input= getString(str);
			float output=Float.parseFloat(input);
			return output;
		}
		
		/**
		 *Creates a pop-up input window and returns the input as a long.
		 *
		 *@param str the question to be asked
		 *@return long--the answer provided by the user
		 */
		public static long getLong(String str)
		{
			String input= getString(str);
			long output=Long.parseLong(input);
			return output;
		}
		
		
		//------------Revised Version--------------------------------
		
		 //Creates a pop-up window that displays a given message.
		 
		 public static void showMessage(String str){
		 	//Shows Message
		 	//JOptionPane.showMessageDialog(null, str);
		 	JTextArea text = new JTextArea(str);
         	text.setBorder(null);
         	text.setOpaque(false);
		 	text.setEditable(false);
		 	text.setColumns(30);
         	JOptionPane.showMessageDialog(null, text);
		 		
		 	/*Example Of Use:
		 	 *
		 	 *int choice = Info.showMessage([Message(String)]);
		 	 *
		 	 */
		 }
		 
		 
		 
		 //Creates a Yes/No Pop-Up window and returns a boolean value.
		 //Will exit program if someone closes the window.
		 
		 public static boolean getYesNo(String str){
		 	//Instantiates possible choices
		 	String[] choices = {"Yes", "No"};
		 	
		 	//Runs window and declares "option" with the choice
		 	int option = JOptionPane.showOptionDialog(null, str, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, null);
			
			//Exits program if use closes the window
			if (option < 0){
				System.exit(0);
				return false;
			}
			
			//Returns boolean value instead of an int
		 	if (option == 0){
		 		return true;
		 	}
		 	else{
		 		return false;
		 	}
		 	
		 	/*Example Of Use:
		 	 *
		 	 *boolean choice = GetInfo.getYesNo([Message(String)]);
		 	 *
		 	 *if (choice){
		 	 *  [Command Line];
		 	 *}
		 	 *else{
		 	 *  [Command Line];
		 	 *}
		 	 *
		 	 */
		 }
		 
		 
		 
		 //Creates a Pop-Up window with adjustable options.
		 //Int refers to options repectivly starting at 0.
		 //Will exit program if someone closes the window.
		 
		 public static int getOption(String str, String[] choices){
		 	//Runs window and declares "option" with the choice
		 	int option = JOptionPane.showOptionDialog(null, str, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, null);
		 	
		 	//Returns choice but exits program if user closes the window
		 	if(option >= 0){
		 		return option;
		 	}
		 	else{
		 		System.exit(0);
		 		return option;
		 	}
		 	
		 	/*Example Of Use:
		 	 *
		 	 *String[] options = {[Option1(String)], [Option2(String)], ect...};
		 	 *
		 	 *int choice = GetInfo.getOption([Message(String)],options);
		 	 *
		 	 *if (choice == 0){
		 	 *	[Command Line];
		 	 *}
		 	 *if (choice == 1){
		 	 *  [Command Line];
		 	 *}
		 	 *
		 	 *You can also use a switch to make it easier to determine between the choice:
		 	 *
		 	 *switch (choice)
		 	 *	case 0:
		 	 *		[Command Line];
		 	 *		break;
		 	 *	case 1:
		 	 *		[Command Line];
		 	 *		break;
		 	 *	ect...
		 	 *
		 	 */
		 }
		 
		 
		 //Provides a list to make a selection and returns the selection.
		 //Selection is returned by int respectivly.
		 public static JList list;
		 public static int select;
		 public static int getList(String str, Object[] data){
		 	JFrame frame = new JFrame();
		 	list = new JList(data);
			list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(5);
			
			JScrollPane listScroller = new JScrollPane(list);

//  Changed 10/09/2009
			listScroller.setPreferredSize(new Dimension(200, 200));
			
			JPanel btnpanel = new JPanel();
			JPanel msgpanel = new JPanel();
			
			select = -1;
			
			JLabel label = new JLabel(str);
			msgpanel.add(label);
			
			JButton btn = new JButton("Ok");
			btnpanel.add(btn);
			btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				select = list.getSelectedIndex();
				
			}
			
			
		});
		
		

			
			frame.add(listScroller);
			frame.add(btnpanel,BorderLayout.SOUTH);
			frame.add(msgpanel,BorderLayout.NORTH);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//changed 10/09/2009			
			frame.setResizable(true);
			frame.pack();
			frame.setVisible(true);
			
			while (select < 0){
			}
			
			frame.dispose();
			return select;
			
			
			/*Example Of Use:
		 	 *
		 	 *String[] options = {[Option1(String)], [Option2(String)], ect...};
		 	 *
		 	 *int choice = GetInfo.getList([Message(String)],options);
		 	 *
		 	 *if (choice == 0){
		 	 *	[Command Line];
		 	 *}
		 	 *if (choice == 1){
		 	 *  [Command Line];
		 	 *}
		 	 *
		 	 *You can also use a switch to make it easier to determine between the choice:
		 	 *
		 	 *switch (choice)
		 	 *	case 0:
		 	 *		[Command Line];
		 	 *		break;
		 	 *	case 1:
		 	 *		[Command Line];
		 	 *		break;
		 	 *	ect...
		 	 *
		 	 */
		 }
		 






		 //Provides a scroller to make a selection and returns the selection.
		 //Selection is returned by int.
		 public static int scroll;
		 public static boolean accept;
		 public static int getSlider(String str, int min, int max){
		 	JFrame frame = new JFrame();
			JPanel btnpanel = new JPanel();
			JPanel msgpanel = new JPanel();
			JSlider slider = new JSlider(min, max);
			
			accept = false;
			
			
			JLabel label = new JLabel(str);
			msgpanel.add(label);
			
			JButton btn = new JButton(Integer.toString(slider.getValue()));
			btnpanel.add(btn);
			btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				accept = true;
				
			}
			
			
		});
		
		

			
			frame.add(slider);
			frame.add(btnpanel,BorderLayout.SOUTH);
			frame.add(msgpanel,BorderLayout.NORTH);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setResizable(false);
			frame.setSize(350,150);
			frame.setVisible(true);
			
			while (!accept){
				btn.setText(Integer.toString(slider.getValue()));
			}
			
			frame.dispose();
			return slider.getValue();
			
			
			/*Example Of Use:
		 	 *
		 	 *int amount = GetInfo.getSlider([Message(String)],[Minimum(Int)],[Maximum(Int)]);
		 	 *
		 	 */
		 }

}
 
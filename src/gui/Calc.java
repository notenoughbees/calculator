package gui;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calc {

	private JFrame frame;
	private JTextField screen_working_expression;
	private JTextField screen_answer;
	private Integer DEFAULT_PADDING = 5;
	private Dimension DEFAULT_LABEL_SIZE = new Dimension(64, 0);
	private Dimension DEFAULT_BUTTON_SIZE = new Dimension(64, 32);
	private Boolean is_shift = false;
	private String working_expression = "";
	private Double answer;
	private JTextField screen_options;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//================ LEVEL 1 ================
		//frame for window
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//================ LEVEL 2 ================ Parent: frame
		//top screen for calculator
		JPanel panel_screen = new JPanel();
		frame.getContentPane().add(panel_screen);
		panel_screen.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_screen.setPreferredSize(new Dimension(340, 90));
		
		//================ LEVEL 3 ================ Parent: panel_screen
		screen_working_expression = new JTextField();
		screen_working_expression.setHorizontalAlignment(SwingConstants.LEFT);
		screen_working_expression.setEditable(false);
		screen_working_expression.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_screen.add(screen_working_expression);
		
		screen_answer = new JTextField();
		screen_answer.setHorizontalAlignment(SwingConstants.RIGHT);
		screen_answer.setEditable(false);
		screen_answer.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_screen.add(screen_answer);
		screen_answer.setColumns(10);
		
		screen_options = new JTextField();
		screen_options.setFont(new Font("Tahoma", Font.PLAIN, 16));
		screen_options.setEditable(false);
		panel_screen.add(screen_options);
		screen_options.setColumns(10);
				
		//================ LEVEL 2 ================ Parent: frame
		//panel to hold buttons and labels for the calculator
		JPanel panel_lower = new JPanel();
		frame.getContentPane().add(panel_lower);
		panel_lower.setLayout(new FlowLayout());
		panel_lower.setPreferredSize(new Dimension(360, 200));
				
				
		//================ LEVEL 3 ================ Parent: panel_lower
		//buttons for calculator
		JPanel panel_buttons1 = new JPanel();
		panel_lower.add(panel_buttons1);
		panel_buttons1.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		//labels for buttons
		JPanel panel_labels1 = new JPanel();
		panel_lower.add(panel_labels1);
		panel_labels1.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel panel_buttons2 = new JPanel();
		panel_lower.add(panel_buttons2);
		panel_buttons2.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel panel_buttons3 = new JPanel();
		panel_lower.add(panel_buttons3);
		panel_buttons3.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel panel_buttons4 = new JPanel();
		panel_lower.add(panel_buttons4);
		panel_buttons4.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel panel_buttons5 = new JPanel();
		panel_lower.add(panel_buttons5);
		panel_buttons5.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		

		
		
		
		//================ LEVEL 4 ================ Parent: panel_buttonsX, panel_labelsX
		JButton btn_shift = new JButton("SHIFT");
		//Set the preferred size of the first button in every row. Each row gets its own grid, so
		//  we must do this for each one, and as the sizes of every component in a grid layout will
		//  be the same size, we only have tho set the size for one of the components in the grid.
		btn_shift.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_shift.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_shift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! is_shift) {
					is_shift = true;
					screen_options.setText("SHIFT: ON");
				}
				else {
					is_shift = false;
					// remove the text saying that Shift is on
					screen_options.setText("");
				}
			}
		});
		btn_shift.setBackground(new Color(240, 230, 140));
		panel_buttons1.add(btn_shift);
		
		JButton btnNewButton_7_1 = new JButton("");
		btnNewButton_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_1.setBackground(new Color(220, 220, 220));
		panel_buttons1.add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("");
		btnNewButton_7_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_2.setBackground(new Color(220, 220, 220));
		panel_buttons1.add(btnNewButton_7_2);
		
		JButton btnNewButton_7_3 = new JButton("");
		btnNewButton_7_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_3.setBackground(new Color(220, 220, 220));
		panel_buttons1.add(btnNewButton_7_3);
		
		JButton btnNewButton_7_4 = new JButton("");
		btnNewButton_7_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_4.setBackground(new Color(220, 220, 220));
		panel_buttons1.add(btnNewButton_7_4);
		
		JLabel lbl_7 = new JLabel("");
		lbl_7.setPreferredSize(DEFAULT_LABEL_SIZE);
		panel_labels1.add(lbl_7);
		
		JLabel lbl_8 = new JLabel("");
		panel_labels1.add(lbl_8);
		
		JLabel lbl_9 = new JLabel("");
		panel_labels1.add(lbl_9);
		
		JLabel lbl_del = new JLabel("CE");
		panel_labels1.add(lbl_del);
		
		JLabel lbl_ca = new JLabel("");
		panel_labels1.add(lbl_ca);
		
		JButton btn_7 = new JButton("7");
		btn_7.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_7.setBackground(new Color(245, 245, 245));
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_7.getText());
			}
		});
		
		JButton btn_8 = new JButton("8");
		btn_8.setBackground(new Color(245, 245, 245));
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_8.getText());
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setBackground(new Color(245, 245, 245));
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_9.getText());
			}
		});
		
		JButton btn_del = new JButton("DEL");
		btn_del.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_del);
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! is_shift) {
					System.out.println("[ DEL ]");
					try {
						// remove the last char from working_expression
						// (https://www.javatpoint.com/how-to-remove-last-character-from-string-in-java)
						screen_working_expression.setText(working_expression.substring(0, working_expression.length()-1));
						working_expression = screen_working_expression.getText();
						}
					//if DEL is pressed when there is nothing to delete:
					catch(StringIndexOutOfBoundsException e1)
					{}
				}
				
				else {
					System.out.println("[ CE ]");
					is_shift = false;
					screen_options.setText("");
				}
			}
		});
		btn_del.setBackground(Color.PINK);
		btn_del.setToolTipText("Backspace");
		
		JButton btn_ca = new JButton("CA");
		btn_ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression = "";
				screen_working_expression.setText("");
				screen_answer.setText("");
			}
		});
		btn_ca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_ca);
		btn_ca.setBackground(new Color(250, 128, 114));
		btn_ca.setToolTipText("Clear All");
		
		JButton btn_4 = new JButton("4");
		btn_4.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_4.setBackground(new Color(245, 245, 245));
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_4.getText());
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setBackground(new Color(245, 245, 245));
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_5.getText());
			}
		});
		
		JButton btn_6 = new JButton("6");
		btn_6.setBackground(new Color(245, 245, 245));
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_6.getText());
			}
		});
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.setBackground(new Color(220, 220, 220));
		btn_multiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_multiply);
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_multiply.getText());
			}
		});
		
		JButton btn_divide = new JButton("/");
		btn_divide.setBackground(new Color(220, 220, 220));
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_divide);
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_divide.getText());
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_1.setBackground(new Color(245, 245, 245));
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_1.getText());
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setBackground(new Color(245, 245, 245));
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_2.getText());
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setBackground(new Color(245, 245, 245));
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_3.getText());
			}
		});
		
		JButton btn_plus = new JButton("+");
		btn_plus.setBackground(new Color(220, 220, 220));
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_plus);
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_plus.getText());
			}
		});
		
		JButton btn_minus = new JButton("-");
		btn_minus.setBackground(new Color(220, 220, 220));
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_minus);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_minus.getText());
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_0.setBackground(new Color(245, 245, 245));
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_0.getText());
			}
		});
		
		JButton btn_decimal = new JButton(".");
		btn_decimal.setBackground(new Color(245, 245, 245));
		btn_decimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btn_decimal);
		btn_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtnContentsToWorkingExpression(btn_decimal.getText());
			}
		});
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(new Color(220, 220, 220));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setBackground(new Color(220, 220, 220));
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btnNewButton_8);
		
		JButton btn_equals = new JButton("=");
		btn_equals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btn_equals);
		btn_equals.setBackground(new Color(153, 204, 255));
		btn_equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				// (http://javaluator.sourceforge.net/en/doc/tutorial.php)
				
				/*
				 * Additional resources...
				 * Methods for this: https://www.baeldung.com/java-evaluate-math-expression-string
				 * Reason to use Javaluator: https://stackoverflow.com/q/3422673/8042538
				 * Nashorn JS Engine is removed in JDK15: https://stackoverflow.com/q/67731926/8042538,
				 * 		so we *can't* use the Java scripting API to do this
				 * Javaluator: can use Maven
				 * - https://learnjava.co.in/how-to-add-maven-dependencies-via-eclipse/
				 * - https://learnjava.co.in/how-to-create-a-maven-project-in-eclipse/
				 * - https://wasiqb.github.io/blogs/mavenproject-vs-javaproject
				 * Or can just download & add the library manually:
				 * - https://stackoverflow.com/q/2824515/8042538	<--
				 */
				
				// Create a new evaluator
			    DoubleEvaluator evaluator = new DoubleEvaluator();
			    
			    // Evaluate the working_expression
			    try {
			    	answer = evaluator.evaluate(working_expression);
			    	// Output the result to screen_answer
				    //   The answer must first be converted from double to string
				    String output = String.valueOf(answer); // (https://stackoverflow.com/a/15530411/8042538)
				    screen_answer.setText(output);
			    }
			    // if "=" is pressed before anything else, then don't display anything on screen_answer
			    catch(IllegalArgumentException e1) {
			    }
			    
			    // add the "=" to the working expression (unless there is already an "=" there), and display
			    try {
			    	String working_expression_last_char = working_expression.substring(0, working_expression.length()-1);
				    if(working_expression_last_char != "=")
				    	{
				    	working_expression += btn_equals.getText();
					    screen_working_expression.setText(working_expression);
				    	}
			   		}
			    // if "=" is pressed before anything else, then don't display anything on screen_working_expression
			    catch(StringIndexOutOfBoundsException e1) {
			    	}
			    
			}
		});
	}
	
	
	/**
	 * The standard action for a button: add the text shown on that button to the current expression.
	 * @param btnText
	 */
	private void addBtnContentsToWorkingExpression(String btnText) {
		working_expression += btnText;
		screen_working_expression.setText(working_expression);
	}

}
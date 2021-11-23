package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Calc {

	private JFrame frame;
	private String working_expression = "";
	private Double answer;
	private JTextField screen_working_expression;
	private JTextField screen_answer;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1, 8, 8));
		
		JPanel panel_screen = new JPanel();
		frame.getContentPane().add(panel_screen);
		panel_screen.setLayout(new GridLayout(2, 1, 0, 0));
		
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
				
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(5, 5, 8, 8));
		
		JButton btn_shift = new JButton("SHIFT");
		btn_shift.setBackground(new Color(240, 230, 140));
		panel_buttons.add(btn_shift);
		
		JLabel lbl_9 = new JLabel("New label");
		panel_buttons.add(lbl_9);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_buttons.add(lblNewLabel);
		
		JLabel lbl_DEL = new JLabel("CE");
		panel_buttons.add(lbl_DEL);
		
		JLabel lbl_CA = new JLabel("New label");
		panel_buttons.add(lbl_CA);
		
		JButton btn_7 = new JButton("7");
		btn_7.setBackground(new Color(245, 245, 245));
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_7.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_8 = new JButton("8");
		btn_8.setBackground(new Color(245, 245, 245));
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_8.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setBackground(new Color(245, 245, 245));
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_9.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_del = new JButton("DEL");
		btn_del.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_del);
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btn_del.setBackground(Color.PINK);
		btn_del.setToolTipText("Backspace");
		
		JButton btn_ca = new JButton("CA");
		btn_ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_ca);
		btn_ca.setBackground(Color.PINK);
		btn_ca.setToolTipText("Clear All");
		
		JButton btn_4 = new JButton("4");
		btn_4.setBackground(new Color(245, 245, 245));
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_4.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setBackground(new Color(245, 245, 245));
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_5.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_6 = new JButton("6");
		btn_6.setBackground(new Color(245, 245, 245));
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_6.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.setBackground(new Color(220, 220, 220));
		btn_multiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_multiply);
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_multiply.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_divide = new JButton("/");
		btn_divide.setBackground(new Color(220, 220, 220));
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_divide);
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_divide.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setBackground(new Color(245, 245, 245));
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_1.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setBackground(new Color(245, 245, 245));
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_2.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setBackground(new Color(245, 245, 245));
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_3.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_plus = new JButton("+");
		btn_plus.setBackground(new Color(220, 220, 220));
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_plus);
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_plus.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_minus = new JButton("-");
		btn_minus.setBackground(new Color(220, 220, 220));
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_minus);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_minus.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setBackground(new Color(245, 245, 245));
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_0.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btn_decimal = new JButton(".");
		btn_decimal.setBackground(new Color(245, 245, 245));
		btn_decimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_decimal);
		btn_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_decimal.getText();
				screen_working_expression.setText(working_expression);
			}
		});
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBackground(new Color(220, 220, 220));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBackground(new Color(220, 220, 220));
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btnNewButton_8);
		
		JButton btn_equals = new JButton("=");
		btn_equals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_equals);
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

}

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

public class Calc {

	private JFrame frame;
	private String working_expression = "";
	private JTextField screen;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1, 8, 8));
		
		JPanel panel_screen = new JPanel();
		frame.getContentPane().add(panel_screen);
		panel_screen.setLayout(new GridLayout(1, 1, 0, 0));
		
		screen = new JTextField();
		screen.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_screen.add(screen);
				
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(4, 5, 8, 8));
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_7.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_8.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_9.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_DEL = new JButton("DEL");
		btn_DEL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_DEL);
		btn_DEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remove the last char from working_expression
				// (https://www.javatpoint.com/how-to-remove-last-character-from-string-in-java)
				screen.setText(working_expression.substring(0, working_expression.length()-1));
				working_expression = screen.getText();
			}
		});
		btn_DEL.setBackground(Color.PINK);
		btn_DEL.setToolTipText("Backspace");
		
		JButton btn_CE = new JButton("CE");
		btn_CE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_CE);
		btn_CE.setBackground(Color.PINK);
		btn_CE.setToolTipText("Clear Entry");
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_4.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_5.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_6.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_multiply);
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_multiply.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_divide = new JButton("/");
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_divide);
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_divide.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_1.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_2.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_3.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_plus = new JButton("+");
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_plus);
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_plus.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_minus = new JButton("-");
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_minus);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_minus.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_0.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btn_decimal = new JButton(".");
		btn_decimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btn_decimal);
		btn_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_expression += btn_decimal.getText();
				screen.setText(working_expression);
			}
		});
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
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
			    Double answer = evaluator.evaluate(working_expression);
			    // Ouput the result to the screen
			    String output = String.valueOf(answer); // (https://stackoverflow.com/a/15530411/8042538)
			    screen.setText(output);
			}
		});
	}

}

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

public class Calc {

	private JFrame frame;
	private String working_equation = "";
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
		panel_screen.add(screen);
				
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(4, 5, 8, 8));
		
		JButton btn_7 = new JButton("7");
		panel_buttons.add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_7.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_8 = new JButton("8");
		panel_buttons.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_8.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_9 = new JButton("9");
		panel_buttons.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_9.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_DEL = new JButton("DEL");
		panel_buttons.add(btn_DEL);
		btn_DEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remove the last char from working_equation
				// https://www.javatpoint.com/how-to-remove-last-character-from-string-in-java
				screen.setText(working_equation.substring(0, working_equation.length()-1));
				working_equation = screen.getText();
			}
		});
		btn_DEL.setBackground(Color.PINK);
		btn_DEL.setToolTipText("Backspace");
		
		JButton btn_CE = new JButton("CE");
		panel_buttons.add(btn_CE);
		btn_CE.setBackground(Color.PINK);
		btn_CE.setToolTipText("Clear Entry");
		
		JButton btn_4 = new JButton("4");
		panel_buttons.add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_4.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_5 = new JButton("5");
		panel_buttons.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_5.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_6 = new JButton("6");
		panel_buttons.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_6.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_multiply = new JButton("*");
		panel_buttons.add(btn_multiply);
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_multiply.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_divide = new JButton("/");
		panel_buttons.add(btn_divide);
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_divide.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_1 = new JButton("1");
		panel_buttons.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_1.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_2 = new JButton("2");
		panel_buttons.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_2.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_3 = new JButton("3");
		panel_buttons.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_3.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_plus = new JButton("+");
		panel_buttons.add(btn_plus);
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_plus.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_minus = new JButton("-");
		panel_buttons.add(btn_minus);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_minus.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_0 = new JButton("0");
		panel_buttons.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_0.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btn_decimal = new JButton(".");
		panel_buttons.add(btn_decimal);
		btn_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_decimal.getText();
				screen.setText(working_equation);
			}
		});
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_buttons.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_buttons.add(btnNewButton_8);
		
		JButton btn_equals = new JButton("=");
		panel_buttons.add(btn_equals);
		btn_equals.setBackground(new Color(153, 204, 255));
		btn_equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				//working_equation = (int) working_equation;
				//screen.setText(working_equation);			//cast to a double
			}
		});
	}

}

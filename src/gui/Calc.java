package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc {

	private JFrame frame;
	private String working_equation = "";

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
		frame.getContentPane().setLayout(new GridLayout(4, 5, 8, 8));
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working_equation += btn_7.getText();
				System.out.println(working_equation);
			}
		});
		frame.getContentPane().add(btn_7);
		
		JButton btn_8 = new JButton("8");
		frame.getContentPane().add(btn_8);
		
		JButton btn_9 = new JButton("9");
		frame.getContentPane().add(btn_9);
		
		JButton btn_DEL = new JButton("DEL");
		btn_DEL.setBackground(Color.PINK);
		btn_DEL.setToolTipText("Backspace");
		frame.getContentPane().add(btn_DEL);
		
		JButton btn_CE = new JButton("CE");
		btn_CE.setBackground(Color.PINK);
		btn_CE.setToolTipText("Clear Entry");
		frame.getContentPane().add(btn_CE);
		
		JButton btn_6 = new JButton("6");
		frame.getContentPane().add(btn_6);
		
		JButton btn_5 = new JButton("5");
		frame.getContentPane().add(btn_5);
		
		JButton btn_4 = new JButton("4");
		frame.getContentPane().add(btn_4);
		
		JButton btn_multiply = new JButton("*");
		frame.getContentPane().add(btn_multiply);
		
		JButton btn_divide = new JButton("\u00F7");
		frame.getContentPane().add(btn_divide);
		
		JButton btn_1 = new JButton("1");
		frame.getContentPane().add(btn_1);
		
		JButton btn_2 = new JButton("2");
		frame.getContentPane().add(btn_2);
		
		JButton btn_3 = new JButton("3");
		frame.getContentPane().add(btn_3);
		
		JButton btn_add = new JButton("+");
		frame.getContentPane().add(btn_add);
		
		JButton btn_subtract = new JButton("-");
		frame.getContentPane().add(btn_subtract);
		
		JButton btn_0 = new JButton("0");
		frame.getContentPane().add(btn_0);
		
		JButton btn_decimal = new JButton(".");
		frame.getContentPane().add(btn_decimal);
		
		JButton btnNewButton_7 = new JButton("New button");
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btn_equals = new JButton("=");
		btn_equals.setBackground(new Color(153, 204, 255));
		frame.getContentPane().add(btn_equals);
	}

}

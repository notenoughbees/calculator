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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CalcWindow {
	private JFrame frame;
	private JTextField screen_working_expr;
	private JTextField screen_answer;
	private Integer DEFAULT_PADDING = 5;
	private Dimension DEFAULT_LABEL_SIZE = new Dimension(64, 0);
	private Dimension DEFAULT_BUTTON_SIZE = new Dimension(64, 32);
	private Boolean is_shift = false;
	private Integer calculationMethod = 1;
	private String working_expr = "";
	private DoubleEvaluator evaluator = new DoubleEvaluator();
	private Double answer;
	private JTextField screen_options;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcWindow window = new CalcWindow();
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
	public CalcWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//================ LEVEL 1 ================
		//frame for window
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//================ LEVEL 2 ================ Parent: frame
		//menu area
		JPanel panel_menu = new JPanel();
		frame.getContentPane().add(panel_menu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_menu.add(menuBar);
		
		//configuration menu
		JMenu configMenu = new JMenu("Configure");
		configMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(configMenu);
		
		//calculation submenu
		JMenu CalculationSubmenu = new JMenu("Calculation Method");
		CalculationSubmenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		configMenu.add(CalculationSubmenu);
		
		JRadioButtonMenuItem CalculationOption1 = new JRadioButtonMenuItem("Behave like Microsoft Windows calculator", new ImageIcon(CalcWindow.class.getResource("/img/windows.png")));
		CalculationOption1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption1);
		CalculationOption1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				calculationMethod = 1;
				//this file
			}
		});
		CalculationOption1.setSelected(true);
		
		JRadioButtonMenuItem CalculationOption2 = new JRadioButtonMenuItem("Show answer after each button clicked");
		CalculationOption2.setIcon(new ImageIcon(CalcWindow.class.getResource("/img/afterEveryButton.png")));
		CalculationOption2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption2);
		CalculationOption2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculationMethod = 2;
				//expressions_v1 file
				//todo: DISABLE THE "=" BUTTON
			}
		});
		
		JRadioButtonMenuItem CalculationOption3 = new JRadioButtonMenuItem("Show answer after each operator clicked");
		CalculationOption3.setIcon(new ImageIcon(CalcWindow.class.getResource("/img/afterOperatorsOnly.png")));
		CalculationOption3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption3);
		CalculationOption3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculationMethod = 3;
			}
		});
		
		ButtonGroup CalculationGroup = new ButtonGroup();
		CalculationGroup.add(CalculationOption1);
		CalculationGroup.add(CalculationOption2);
		CalculationGroup.add(CalculationOption3);
		
		
		//decimals submenu
		JMenu DecimalsSubmenu = new JMenu("Decimal Precision");
		DecimalsSubmenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		configMenu.add(DecimalsSubmenu);
		
		//decmals sub-submenu #1
		JMenu DecimalsSubmenu1 = new JMenu("Precision");
		DecimalsSubmenu1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu.add(DecimalsSubmenu1);
		
		JRadioButtonMenuItem DecimalsSubmenu1Option1 = new JRadioButtonMenuItem("0");
		DecimalsSubmenu1Option1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option1);
		DecimalsSubmenu1Option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option2 = new JRadioButtonMenuItem("1");
		DecimalsSubmenu1Option2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option2);
		DecimalsSubmenu1Option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option3 = new JRadioButtonMenuItem("2");
		DecimalsSubmenu1Option3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option3);
		DecimalsSubmenu1Option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option4 = new JRadioButtonMenuItem("3");
		DecimalsSubmenu1Option4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option4);
		DecimalsSubmenu1Option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option5 = new JRadioButtonMenuItem("4");
		DecimalsSubmenu1Option5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option5);
		DecimalsSubmenu1Option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		DecimalsSubmenu1Option5.setSelected(true);
		
		JRadioButtonMenuItem DecimalsSubmenu1Option6 = new JRadioButtonMenuItem("8");
		DecimalsSubmenu1Option6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option6);
		DecimalsSubmenu1Option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option7 = new JRadioButtonMenuItem("Custom");
		DecimalsSubmenu1Option7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option7);
		DecimalsSubmenu1Option7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		ButtonGroup DecimalsSubmenu1Group = new ButtonGroup();
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option1);
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option2);
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option3);
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option4);
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option5);
		DecimalsSubmenu1Group.add(DecimalsSubmenu1Option6);
				
		//decmals sub-submenu #2
		JMenu DecimalsSubmenu2 = new JMenu("Method");
		DecimalsSubmenu2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu.add(DecimalsSubmenu2);
		
		JRadioButtonMenuItem DecimalsSubmenu2Option1 = new JRadioButtonMenuItem("Decimal Places");
		DecimalsSubmenu2Option1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu2.add(DecimalsSubmenu2Option1);
		DecimalsSubmenu2Option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		DecimalsSubmenu2Option1.setSelected(true);
		
		JRadioButtonMenuItem DecimalsSubmenu2Option2 = new JRadioButtonMenuItem("Significant Figures");
		DecimalsSubmenu2Option2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu2.add(DecimalsSubmenu2Option2);
		DecimalsSubmenu2Option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		ButtonGroup DecimalsSubmenu2Group = new ButtonGroup();
		DecimalsSubmenu2Group.add(DecimalsSubmenu2Option1);
		DecimalsSubmenu2Group.add(DecimalsSubmenu2Option2);
		
		
		
		
		
		
		
		
		
		//top screen for calculator
		JPanel panel_screen = new JPanel();
		frame.getContentPane().add(panel_screen);
		panel_screen.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_screen.setPreferredSize(new Dimension(340, 90));
		
		//================ LEVEL 3 ================ Parent: panel_screen
		screen_working_expr = new JTextField();
		screen_working_expr.setHorizontalAlignment(SwingConstants.LEFT);
		screen_working_expr.setEditable(false);
		screen_working_expr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_screen.add(screen_working_expr);
		
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
		panel_lower.setPreferredSize(new Dimension(360, 400)); //TODO: increase second val when add more components
				
				
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
				//TODO: button action listeners are here
				doButtonClick(btn_7.getText(), false);
				//addToWorkingExpression(btn_7.getText());
			}
		});
		
		JButton btn_8 = new JButton("8");
		btn_8.setBackground(new Color(245, 245, 245));
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_8.getText(), false);
				//addToWorkingExpression(btn_8.getText());
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setBackground(new Color(245, 245, 245));
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons2.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_9.getText(), false);
				//addToWorkingExpression(btn_9.getText());
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
						// remove the last char from working_expr
						// (https://www.javatpoint.com/how-to-remove-last-character-from-string-in-java)
						screen_working_expr.setText(working_expr.substring(0, working_expr.length()-1));
						working_expr = screen_working_expr.getText();
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
				working_expr = "";
				screen_working_expr.setText("");
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
				doButtonClick(btn_4.getText(), false);
				//addToWorkingExpression(btn_4.getText());
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setBackground(new Color(245, 245, 245));
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_5.getText(), false);
				//addToWorkingExpression(btn_5.getText());
			}
		});
		
		JButton btn_6 = new JButton("6");
		btn_6.setBackground(new Color(245, 245, 245));
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_6.getText(), false);
				//addToWorkingExpression(btn_6.getText());
			}
		});
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.setBackground(new Color(220, 220, 220));
		btn_multiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_multiply);
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_multiply.getText(), true);
				//displayCurrentAnswer(btn_multiply.getText());
			}
		});
		
		JButton btn_divide = new JButton("/");
		btn_divide.setBackground(new Color(220, 220, 220));
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons3.add(btn_divide);
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_divide.getText(), true);
				//displayCurrentAnswer(btn_divide.getText());
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_1.setBackground(new Color(245, 245, 245));
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_1.getText(), false);
				//addToWorkingExpression(btn_1.getText());
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setBackground(new Color(245, 245, 245));
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_2.getText(), false);
				//addToWorkingExpression(btn_2.getText());
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setBackground(new Color(245, 245, 245));
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_3.getText(), false);
				//addToWorkingExpression(btn_3.getText());
			}
		});
		
		JButton btn_plus = new JButton("+");
		btn_plus.setBackground(new Color(220, 220, 220));
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_plus);
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_plus.getText(), true);
				//displayCurrentAnswer(btn_plus.getText());
			}
		});
		
		JButton btn_minus = new JButton("-");
		btn_minus.setBackground(new Color(220, 220, 220));
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons4.add(btn_minus);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_minus.getText(), true);
				//displayCurrentAnswer(btn_minus.getText());
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_0.setBackground(new Color(245, 245, 245));
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_0.getText(), false);
				//addToWorkingExpression(btn_0.getText());
			}
		});
		
		JButton btn_decimal = new JButton(".");
		btn_decimal.setBackground(new Color(245, 245, 245));
		btn_decimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_buttons5.add(btn_decimal);
		btn_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_decimal.getText(), false);
				//addToWorkingExpression(btn_decimal.getText());
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
			    
			    // Evaluate the working_expr
			    try {
			    	evaluateExpression(working_expr);
			    	
			    }
			    // if "=" is pressed before anything else, then don't display anything on screen_answer
			    catch(IllegalArgumentException e1) {
			    }
			    
			    // add the "=" to the working expression (unless there is already an "=" there), and display
			    try {
			    	String working_expr_last_char = working_expr.substring(working_expr.length()-1);
			    	System.out.println(working_expr_last_char);
				    if(working_expr_last_char != "=")
				    	{
				    	working_expr += btn_equals.getText();
					    screen_working_expr.setText(working_expr);
				    	}
			   		}
			    // if "=" is pressed before anything else, then don't display anything on screen_working_expr
			    catch(StringIndexOutOfBoundsException e1) {
			    	}
			    
			}
		});
	}
	
	
	/**
	 * The standard action for a button: add the text shown on that button to the current expression.
	 * @param btnText
	 */
	private void addToWorkingExpression(String btnText) {
		//System.out.println("addToWorkingExpression RUN");
		working_expr += btnText;
		screen_working_expr.setText(working_expr);
	}
	
	/**
	 * 
	 * @param expression
	 */
	private void evaluateExpression(String expression) {
		answer = evaluator.evaluate(expression);
    	// Output the result to screen_answer
	    //   The answer must first be converted from double to string
	    String output = String.valueOf(answer); // (https://stackoverflow.com/a/15530411/8042538)
	    screen_answer.setText(output);
	}
	
	
	/**
	 * Calculate the current working_expr and display the output to the answer screen.
	 * This method is called when an operator is clicked.
	 * @param btnText
	 */
	private void displayCurrentAnswer(String btnText, Boolean isOperator) {
		if (! isOperator) {
			addToWorkingExpression(btnText);
			evaluateExpression(working_expr);
			//screen_answer.setText(working_expr); //this is included in evaluateExpression ^
		}
		else {
			//if the last char was an operator, thn we need to take it off the expression before evaluating
			addToWorkingExpression(btnText);
			String working_expr_except_last_char = working_expr.substring(0, working_expr.length()-1);
			evaluateExpression(working_expr_except_last_char);
		}
	}

	
	
	
	
	
	

	
	
	
	
	
	/**
	 * The method called by the ActionListener of all number buttons and operator buttons.
	 * @param btnText
	 * @param isOperator: Whether the button clicked was an operator
	 */
	private void doButtonClick(String btnText, Boolean isOperator) {
		//update the working expression after every operator clicked
		//TODO
		if (calculationMethod == 3) {
			if (isOperator) {
				displayCurrentAnswer(btnText, isOperator);
			}
			
			else {
				addToWorkingExpression(btnText);
				//if this is the first number in the expression, display it anyway for convenience
				//if 
			}
		}
		
		//update the working expression after every button clicked
		else if (calculationMethod == 2) {
			displayCurrentAnswer(btnText, isOperator);
			
			//if last char was a number, add "=" to the working expression for clarity
			if (! isOperator) {
				
				screen_working_expr.setText(working_expr + "="); //this does not affect working_expr, only the screen //, so this change is temporary
			}
			
			//because of the last line, if last char was an operator, 
			//  we must remove any potential "=" in the working expression before displaying current answer
			//else if (isOperator) {
			//	System.out.println(working_expr);
			//	String working_expr_last_char = working_expr.substring(working_expr.length() - 1);
			//	//System.out.println("working_expr_last_char: " + working_expr_last_char);
			//	assert(working_expr_last_char == "=");
			//	if (working_expr_last_char == "=") {
			//		System.out.println("!");
			//		//TODO: FIX
			//		String working_expr_excl_last_char = working_expr.substring(0, working_expr.length() - 1);
			//		System.out.println("working_expr_excl_last_char: " + working_expr_excl_last_char);
			//		working_expr = working_expr_excl_last_char += btnText;
			//		screen_working_expr.setText(working_expr);
			//		
			//	}
			//	displayCurrentAnswer(btnText, isOperator);
			//}
		}
		
		//behave like Windows calculator
		//TODO
		else {
			//
		}
		
	}
	
	
	
	
	
	
	
	
	
}
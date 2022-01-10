package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.fathzer.soft.javaluator.DoubleEvaluator;


public class CalcWindow {
	private Integer MAXIMUM_LENGTH = 20;
	public Point mousePos;
	private JFrame frame;
	public static Integer decimalPrecision = 4;
	public static String roundingMethod = "D";
	private JTextField workingExprScreen;
	private JTextField answerScreen;
	private JTextField optionsScreen;
	private Integer DEFAULT_PADDING = 5;
	private Dimension DEFAULT_LABEL_SIZE = new Dimension(64, 0);
	private Dimension DEFAULT_BUTTON_SIZE = new Dimension(64, 32);
	private Boolean isShift = false;
	JButton btnEquals = new JButton("=");
	private Integer calculationMethod = 1;
	private String workingExpr = "";
	private DoubleEvaluator evaluator = new DoubleEvaluator();
	private Double answer;



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
		//TODO
		//frame.setIconImage(new Image(CalcWindow.class.getResource("/img/calculatorIcon.png")));
		Image icon = Toolkit.getDefaultToolkit().getImage("/img/calculatorIcon.png");    
		frame.setIconImage(icon);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//================ LEVEL 2 ================ Parent: frame
		//menu area
		JPanel menuPanel = new JPanel();
		frame.getContentPane().add(menuPanel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuPanel.add(menuBar);
		
		//configuration menu
		JMenu configMenu = new JMenu("Configure");
		configMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(configMenu);
		
		//calculation submenu
		JMenu CalculationSubmenu = new JMenu("Calculation Method");
		CalculationSubmenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		configMenu.add(CalculationSubmenu);
		
		JRadioButtonMenuItem CalculationOption1 = new JRadioButtonMenuItem(
				"Behave like Microsoft Windows calculator", 
				new ImageIcon(CalcWindow.class.getResource("/img/windows.png")));
		// (https://www.demo2s.com/java/java-swing-menu-items-mnemonics-and-accelerators.html)
		CalculationOption1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		CalculationOption1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption1);
		CalculationOption1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculationMethod = 1;
				btnEquals.setEnabled(true);
				btnEquals.setBackground(new Color(153, 204, 255));
			}
		});
		CalculationOption1.setSelected(true);
		
		JRadioButtonMenuItem CalculationOption2 = new JRadioButtonMenuItem(
				"Show answer after any button clicked", 
				new ImageIcon(CalcWindow.class.getResource("/img/afterEveryButton.png")));
		CalculationOption2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		CalculationOption2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption2);
		CalculationOption2.setToolTipText("The answer automatically updates after every button press");
		CalculationOption2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculationMethod = 2;
				//disable the "=" button because the answer will always be automatically calculated in this mode
				btnEquals.setEnabled(false);
				btnEquals.setBackground(Color.LIGHT_GRAY);
				//btnEquals.setVisible(false);
			}
		});
		
		JRadioButtonMenuItem CalculationOption3 = new JRadioButtonMenuItem(
				"Show answer after each operator clicked", 
				new ImageIcon(CalcWindow.class.getResource("/img/afterOperatorsOnly.png")));
		CalculationOption3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		CalculationOption3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalculationSubmenu.add(CalculationOption3);
		CalculationOption3.setToolTipText("Calculates the expression so far every time an operator is clicked");
		CalculationOption3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculationMethod = 3;
				btnEquals.setEnabled(true);
				btnEquals.setBackground(new Color(153, 204, 255));
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
		DecimalsSubmenu1Option1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option1);
		DecimalsSubmenu1Option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 0;
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option2 = new JRadioButtonMenuItem("1");
		DecimalsSubmenu1Option2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option2);
		DecimalsSubmenu1Option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 1;
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option3 = new JRadioButtonMenuItem("2");
		DecimalsSubmenu1Option3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option3);
		DecimalsSubmenu1Option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 2;
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option4 = new JRadioButtonMenuItem("3");
		DecimalsSubmenu1Option4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option4);
		DecimalsSubmenu1Option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 3;
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option5 = new JRadioButtonMenuItem("4");
		DecimalsSubmenu1Option5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option5);
		DecimalsSubmenu1Option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 4;
			}
		});
		DecimalsSubmenu1Option5.setSelected(true);
		
		JRadioButtonMenuItem DecimalsSubmenu1Option6 = new JRadioButtonMenuItem("8");
		DecimalsSubmenu1Option6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option6);
		DecimalsSubmenu1Option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decimalPrecision = 8;
			}
		});
		
		JRadioButtonMenuItem DecimalsSubmenu1Option7 = new JRadioButtonMenuItem("Custom");
		DecimalsSubmenu1Option7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu1Option7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu1.add(DecimalsSubmenu1Option7);
		DecimalsSubmenu1Option7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				MenuCustomWindow customWin = new MenuCustomWindow();
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
		DecimalsSubmenu2Option1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu2Option1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu2.add(DecimalsSubmenu2Option1);
		DecimalsSubmenu2Option1.setToolTipText(
				"For example, 10.456 rounded to 2 decimal places will show as 10.46.");
		DecimalsSubmenu2Option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roundingMethod = "D";
			}
		});
		DecimalsSubmenu2Option1.setSelected(true);
		
		JRadioButtonMenuItem DecimalsSubmenu2Option2 = new JRadioButtonMenuItem("Significant Figures");
		DecimalsSubmenu2Option2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		DecimalsSubmenu2Option2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DecimalsSubmenu2.add(DecimalsSubmenu2Option2);
		DecimalsSubmenu2Option2.setToolTipText(
				"For example, 10.456 rounded to 2 significant figures will show as 10.45.");
		DecimalsSubmenu2Option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roundingMethod = "S";
			}
		});
		
		ButtonGroup DecimalsSubmenu2Group = new ButtonGroup();
		DecimalsSubmenu2Group.add(DecimalsSubmenu2Option1);
		DecimalsSubmenu2Group.add(DecimalsSubmenu2Option2);
		
		
		
		
		
		
		
		
		
		//top screen for calculator
		JPanel screenPanel = new JPanel();
		frame.getContentPane().add(screenPanel);
		screenPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		screenPanel.setPreferredSize(new Dimension(340, 90));
		
		//================ LEVEL 3 ================ Parent: screenPanel
		workingExprScreen = new JTextField();
		workingExprScreen.setHorizontalAlignment(SwingConstants.LEFT);
		workingExprScreen.setEditable(false);
		workingExprScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		screenPanel.add(workingExprScreen);
		
		answerScreen = new JTextField();
		answerScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		answerScreen.setEditable(false);
		answerScreen.setFont(new Font("Tahoma", Font.PLAIN, 32));
		screenPanel.add(answerScreen);
		answerScreen.setColumns(10);
		
		optionsScreen = new JTextField();
		optionsScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		optionsScreen.setEditable(false);
		screenPanel.add(optionsScreen);
		optionsScreen.setColumns(10);
				
		//================ LEVEL 2 ================ Parent: frame
		//panel to hold buttons and labels for the calculator
		JPanel lowerPanel = new JPanel();
		frame.getContentPane().add(lowerPanel);
		lowerPanel.setLayout(new FlowLayout());
		lowerPanel.setPreferredSize(new Dimension(360, 400)); //TODO: increase second val when add more components
				
				
		//================ LEVEL 3 ================ Parent: lowerPanel
		//buttons for calculator
		JPanel buttonPanel_1 = new JPanel();
		lowerPanel.add(buttonPanel_1);
		buttonPanel_1.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		//labels for buttons
		JPanel labelPanel_1 = new JPanel();
		lowerPanel.add(labelPanel_1);
		labelPanel_1.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel buttonPanel_2 = new JPanel();
		lowerPanel.add(buttonPanel_2);
		buttonPanel_2.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel buttonPanel_3 = new JPanel();
		lowerPanel.add(buttonPanel_3);
		buttonPanel_3.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel buttonPanel_4 = new JPanel();
		lowerPanel.add(buttonPanel_4);
		buttonPanel_4.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		JPanel buttonPanel_5 = new JPanel();
		lowerPanel.add(buttonPanel_5);
		buttonPanel_5.setLayout(new GridLayout(1, 5, DEFAULT_PADDING, DEFAULT_PADDING));
		
		

		
		
		
		//================ LEVEL 4 ================ Parent: buttonPanel_X, labelPanel_X
		JButton btnShift = new JButton("SHIFT");
		//Set the preferred size of the first button in every row. Each row gets its own grid, so
		//  we must do this for each one, and as the sizes of every component in a grid layout will
		//  be the same size, we only have tho set the size for one of the components in the grid.
		btnShift.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btnShift.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! isShift) {
					isShift = true;
					optionsScreen.setText("SHIFT: ON");
				}
				else {
					isShift = false;
					// remove the text saying that Shift is on
					optionsScreen.setText("");
				}
			}
		});
		btnShift.setBackground(new Color(240, 230, 140));
		buttonPanel_1.add(btnShift);
		
		JButton btnNewButton_7_1 = new JButton("");
		btnNewButton_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_1.setBackground(new Color(220, 220, 220));
		buttonPanel_1.add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("");
		btnNewButton_7_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_2.setBackground(new Color(220, 220, 220));
		buttonPanel_1.add(btnNewButton_7_2);
		
		JButton btnNewButton_7_3 = new JButton("");
		btnNewButton_7_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_3.setBackground(new Color(220, 220, 220));
		buttonPanel_1.add(btnNewButton_7_3);
		
		JButton btnNewButton_7_4 = new JButton("");
		btnNewButton_7_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7_4.setBackground(new Color(220, 220, 220));
		buttonPanel_1.add(btnNewButton_7_4);
		
		JLabel lbl_7 = new JLabel("");
		lbl_7.setPreferredSize(DEFAULT_LABEL_SIZE);
		labelPanel_1.add(lbl_7);
		
		JLabel lbl_8 = new JLabel("");
		labelPanel_1.add(lbl_8);
		
		JLabel lbl_9 = new JLabel("");
		labelPanel_1.add(lbl_9);
		
		JLabel lblDel = new JLabel("CE");
		lblDel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDel.setForeground(new Color(184, 134, 11));
		labelPanel_1.add(lblDel);
		
		JLabel lblCa = new JLabel("");
		labelPanel_1.add(lblCa);
		
		JButton btn_7 = new JButton("7");
		btn_7.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_7.setBackground(new Color(245, 245, 245));
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_2.add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_7.getText(), false);
				//addToWorkingExpression(btn_7.getText());
			}
		});
		
		JButton btn_8 = new JButton("8");
		btn_8.setBackground(new Color(245, 245, 245));
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_2.add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_8.getText(), false);
				//addToWorkingExpression(btn_8.getText());
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setBackground(new Color(245, 245, 245));
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_2.add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_9.getText(), false);
				//addToWorkingExpression(btn_9.getText());
			}
		});
		
		JButton btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_2.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! isShift) {
					System.out.println("[ DEL ]");
					try {
						// remove the last char from workingExpr
						// (https://www.javatpoint.com/how-to-remove-last-character-from-string-in-java)
						workingExprScreen.setText(workingExpr.substring(0, workingExpr.length()-1));
						workingExpr = workingExprScreen.getText();
						}
					//if DEL is pressed when there is nothing to delete:
					catch(StringIndexOutOfBoundsException e1)
					{}
				}
				
				else {
					System.out.println("[ CE ]");
					isShift = false;
					optionsScreen.setText("");
				}
			}
		});
		btnDel.setBackground(Color.PINK);
		btnDel.setToolTipText("Backspace");
		
		JButton btnCa = new JButton("CA");
		btnCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workingExpr = "";
				workingExprScreen.setText("");
				answerScreen.setText("");
			}
		});
		btnCa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_2.add(btnCa);
		btnCa.setBackground(new Color(250, 128, 114));
		btnCa.setToolTipText("Clear All");
		
		JButton btn_4 = new JButton("4");
		btn_4.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_4.setBackground(new Color(245, 245, 245));
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_3.add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_4.getText(), false);
				//addToWorkingExpression(btn_4.getText());
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setBackground(new Color(245, 245, 245));
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_3.add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_5.getText(), false);
				//addToWorkingExpression(btn_5.getText());
			}
		});
		
		JButton btn_6 = new JButton("6");
		btn_6.setBackground(new Color(245, 245, 245));
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_3.add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_6.getText(), false);
				//addToWorkingExpression(btn_6.getText());
			}
		});
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setBackground(new Color(220, 220, 220));
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_3.add(btnMultiply);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btnMultiply.getText(), true);
				//displayCurrentAnswer(btnMultiply.getText());
			}
		});
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBackground(new Color(220, 220, 220));
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_3.add(btnDivide);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btnDivide.getText(), true);
				//displayCurrentAnswer(btnDivide.getText());
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_1.setBackground(new Color(245, 245, 245));
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_4.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_1.getText(), false);
				//addToWorkingExpression(btn_1.getText());
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setBackground(new Color(245, 245, 245));
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_4.add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_2.getText(), false);
				//addToWorkingExpression(btn_2.getText());
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setBackground(new Color(245, 245, 245));
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_4.add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_3.getText(), false);
				//addToWorkingExpression(btn_3.getText());
			}
		});
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBackground(new Color(220, 220, 220));
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_4.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btnPlus.getText(), true);
				//displayCurrentAnswer(btnPlus.getText());
			}
		});
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBackground(new Color(220, 220, 220));
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_4.add(btnMinus);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btnMinus.getText(), true);
				//displayCurrentAnswer(btnMinus.getText());
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setPreferredSize(DEFAULT_BUTTON_SIZE);
		btn_0.setBackground(new Color(245, 245, 245));
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_5.add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btn_0.getText(), false);
				//addToWorkingExpression(btn_0.getText());
			}
		});
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.setBackground(new Color(245, 245, 245));
		btnDecimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_5.add(btnDecimal);
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doButtonClick(btnDecimal.getText(), false);
				//addToWorkingExpression(btnDecimal.getText());
			}
		});
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(new Color(220, 220, 220));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_5.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setBackground(new Color(220, 220, 220));
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPanel_5.add(btnNewButton_8);
		
		btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEquals.setBackground(new Color(153, 204, 255));
		buttonPanel_5.add(btnEquals);
		btnEquals.addActionListener(new ActionListener() {
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
			    
			    // Evaluate the workingExpr
			    try {
			    	answerScreen.setText(evaluateExpression(workingExpr));
			    }
			    // if "=" is pressed before anything else, then don't display anything on answerScreen
			    catch(IllegalArgumentException e1) {
			    }
			    
			    // now add the "=" to the working expression (unless there is already an "=" there), and display
			    try {
			    	String workingExprLastChar = workingExpr.substring(workingExpr.length()-1);
				    if(workingExprLastChar != "=")
				    	{
				    	workingExpr += btnEquals.getText();
					    workingExprScreen.setText(workingExpr);
				    	}
			   		}
			    // if "=" is pressed before anything else, then don't display anything on workingExprScreen
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
		workingExpr += btnText;
		workingExprScreen.setText(workingExpr);
	}
	
	
	/**
	 * Given a mathematical expression, evaluate it to get an answer, then round it to the correct
	 * precision and with the correct rounding method (decimal places, or significant figures). Return
	 * the rounded answer as a string, and in standard form.
	 * @param expression
	 */
	public String evaluateExpression(String expression) {
		answer = evaluator.evaluate(expression);
		
		//TODO: BUG: doing 0.0 gives NaN (wanted: 0/0 = 0)
		//possible fix: evaluate the expression excl the last character (the 0). if it is 0, then
		//  we know the whole expr was 0/0. Give 0 as result.
		//TODO: doing infinity*0 gives NaN (eg: 1/0*0) (wanted: anything*0 = 0)
		String answerString = null;
		
		System.out.println(answer == Double.NaN);
		System.out.println(String.valueOf(answer) == String.valueOf(Double.NaN));
		
		if (String.valueOf(answer) != String.valueOf(Double.NaN) && answer != Double.POSITIVE_INFINITY)
		{
			//Round the answer to the decimal precision defined in the menu settings
			if (roundingMethod == "S")
			{
				BigDecimal answerBd = new BigDecimal(answer);
				BigDecimal answerRounded = answerBd.round(new MathContext(decimalPrecision));
				//in case answerRounded is in scientific form, convert to standard form (using String.valueOf isn't good enough)
				// (example: rounding 10.2 to 1sf: answerRounded is 1E+1, answerString is 10)
				answerString = answerRounded.toPlainString(); // (https://stackoverflow.com/a/31294907/8042538)
			}
			else //if roundingMethod == "D"
			{
				BigDecimal answerRounded = new BigDecimal(answer).setScale(decimalPrecision, RoundingMode.HALF_UP);
				answerString = String.valueOf(answerRounded); // (https://stackoverflow.com/a/15530411/8042538)
			}
		}
		else
		{
			answerString = String.valueOf(answer);
		}
		System.out.println(answerString);
	    return answerString;
	}
	
	
	/**
	 * Calculate the current workingExpr and display the output to the answer screen.
	 * This method is called when an operator is clicked.
	 * @param btnText
	 */
	private void displayCurrentAnswer(String btnText, Boolean isOperator) {
		String text = "";
		if (! isOperator) {
			addToWorkingExpression(btnText);
			text = evaluateExpression(workingExpr);
		}
		else {
			//if the last char was an operator, then we need to take it off the expression before evaluating
			addToWorkingExpression(btnText);
			String workingExprExceptLastChar = workingExpr.substring(0, workingExpr.length()-1);
			text = evaluateExpression(workingExprExceptLastChar);
		}
		//convert to scientific notation if number is too long
		//TODO: unit tests!!!
		if (text.length() > MAXIMUM_LENGTH)
		{
			Integer coefficient = 0;
			Double num = Double.valueOf(text);
			Integer sign;
			if (num < 10)
			{
				while (num < 10)
				{
					num = num * 10;
					coefficient = coefficient + 1;
				}
				sign = -1;	
			}
			else
			{
				while (num < 10)
				{
					num = num / 10;
					coefficient = coefficient + 1;
				}
				sign = 1;	
			}
			Integer firstDigit = (int) Math.floor(num);
			text = coefficient + "E" + sign * firstDigit;
		}
		answerScreen.setText(text);
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
			
			//if last char was a number, add "=" to the expression on the screen for clarity
			if (! isOperator) {
				//this does not affect workingExpr, only the screen, so this change is temporary
				workingExprScreen.setText(workingExpr + "=");
			}
		}
		
		//behave like Windows calculator
		//TODO (based on the comments under the button action listeners in this file?)
		else {
			//
		}
		
	}
	
	
	
	
	public static void setDecimalPrecision(Integer newDecimalPrecison) 
		{decimalPrecision = newDecimalPrecison;}
	
	public static void setRoundingMethod(String newRoundingMethod) 
		{roundingMethod = newRoundingMethod;}
}
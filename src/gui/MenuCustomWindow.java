package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MenuCustomWindow {
	private JFrame frame;
	private JTextField entry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCustomWindow window = new MenuCustomWindow();
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
	public MenuCustomWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				//TODO: keylistener: listen for specific key
				
				//int keyPressed = e.getKeyCode();
				//if (keyPressed == KeyEvent.VK_ESCAPE) {
				
				//int id = e.getID();
				//if (id == KeyEvent.VK_ESCAPE) {
					
				if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
					closeWindow();
				}
			}
		});
		frame.setTitle("Custom Precision");
		frame.setResizable(false);
		//open the window near the position of the mouse
		//(https://stackoverflow.com/a/9490261/8042538)
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		frame.setLocation((int) mousePos.getX(), (int) mousePos.getY());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
		
		//entry
		entry = new JTextField();
		entry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(entry);
		entry.setColumns(2);
		
		//button
		JButton btnEnter = new JButton("Enter");
		btnEnter.setPreferredSize(new Dimension(64, 32));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer newDecimalPrecision = Integer.valueOf(entry.getText());
				CalcWindow.setDecimalPrecision(newDecimalPrecision);
				closeWindow();
			}
		});
		frame.getContentPane().add(btnEnter);
		
		//resize the window to fit the sizes of the components
		frame.pack();
	}
	
	public void closeWindow() {
		frame.dispose();
	}

}

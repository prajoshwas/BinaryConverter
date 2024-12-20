package welcome;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.MainScreen;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame WelcomeFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.WelcomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		WelcomeFrame = new JFrame();
		WelcomeFrame.setTitle("Welcome");
		WelcomeFrame.setBounds(100, 100, 442, 339);
		WelcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel welcomeScreenLabel = new JLabel("Welcome to our Binary Converter App");
		welcomeScreenLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton startBtn = new JButton("Press here to start conversion");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen ms = new MainScreen();
				
				ms.MainScreenMethod();
	
				WelcomeFrame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(WelcomeFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(welcomeScreenLabel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addComponent(startBtn, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(welcomeScreenLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(startBtn)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		WelcomeFrame.getContentPane().setLayout(groupLayout);
	}

}

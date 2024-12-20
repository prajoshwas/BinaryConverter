package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame MainFrame;
	private JTextField numberInputField;
	private JTextField binaryTxtField;
	private JTextField octalTxtField;
	private JTextField hexTxtField;

	/**
	 * Launch the application.
	 */
	public void MainScreenMethod() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		initializeUI();
		
		JButton convertBtn = new JButton("Convert");
		convertBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		convertBtn.setBounds(200, 168, 132, 37);
		MainFrame.getContentPane().add(convertBtn);
		
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numberFromInput = numberInputField.getText();
				
				if (hasLetters(numberFromInput)) {
					JOptionPane.showMessageDialog(null, "Please enter only valid number(s) !", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					
					binaryTxtField.setText(convertToBinary(numberFromInput));
					convertToHex(numberFromInput);
					convertToOctal(numberFromInput);
				}
			}
		});
	}
	
	private static String convertToBinary(String input) {
		
			double number = Double.valueOf(input);
			
		 	int integerPart = (int) number;
	        double fractionalPart = number - integerPart;

	        String integerBinary = Integer.toBinaryString(integerPart);

	        // Convert fractional part to binary
	        StringBuilder fractionalBinary = new StringBuilder();
	        while (fractionalPart > 0 && fractionalBinary.length() < 10) { // Limit to 10 digits for precision
	            fractionalPart *= 2;
	            int bit = (int) fractionalPart;
	            fractionalBinary.append(bit);
	            fractionalPart -= bit;
	        }

	        return integerBinary + "." + fractionalBinary.toString();

	}
	
	private static String convertToHex(String input) {
			
		return "";
	}
	
	private static String convertToOctal(String input) {
	
		return "";
	}
	
	private static boolean hasLetters(String input) {
		boolean hasLetters = false;
		
		for (char character : input.toCharArray()) {
			if (Character.isLetter(character)) {
				hasLetters = true;
			    break;
			  }
		}
		
		return hasLetters;
	}
	
	private void initializeUI() {
		
		MainFrame = new JFrame();
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setTitle("Binary Converter");
		MainFrame.setBounds(100, 100, 563, 445);
		MainFrame.getContentPane().setLayout(null);
		
		JLabel headerLabel = new JLabel("Binary Converter");
		headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(130, 13, 263, 62);
		MainFrame.getContentPane().add(headerLabel);
		
		numberInputField = new JTextField();
		numberInputField.setHorizontalAlignment(SwingConstants.CENTER);
		numberInputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numberInputField.setText("0");
		numberInputField.setToolTipText("e.g. 40123");
		numberInputField.setBounds(160, 127, 215, 30);
		MainFrame.getContentPane().add(numberInputField);
		numberInputField.setColumns(10);
		
		JLabel commandLabel = new JLabel("Enter a number below to convert");
		commandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		commandLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		commandLabel.setBounds(140, 86, 269, 30);
		MainFrame.getContentPane().add(commandLabel);
		
		JLabel binaryLabel = new JLabel("Binary");
		binaryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		binaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		binaryLabel.setBounds(83, 244, 68, 30);
		MainFrame.getContentPane().add(binaryLabel);
		
		JLabel octalLabel = new JLabel("Octal");
		octalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		octalLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		octalLabel.setBounds(83, 295, 68, 30);
		MainFrame.getContentPane().add(octalLabel);
		
		JLabel hexLabel = new JLabel("Hexadecimal");
		hexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		hexLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hexLabel.setBounds(81, 346, 111, 30);
		MainFrame.getContentPane().add(hexLabel);
		
		binaryTxtField = new JTextField();
		binaryTxtField.setEditable(false);
		binaryTxtField.setEnabled(false);
		binaryTxtField.setToolTipText("e.g. 40123");
		binaryTxtField.setText("0");
		binaryTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		binaryTxtField.setColumns(15);
		binaryTxtField.setBounds(196, 244, 215, 30);
		MainFrame.getContentPane().add(binaryTxtField);
		
		octalTxtField = new JTextField();
		octalTxtField.setEditable(false);
		octalTxtField.setEnabled(false);
		octalTxtField.setText("0");
		octalTxtField.setHorizontalAlignment(SwingConstants.LEFT);
		octalTxtField.setToolTipText("e.g. 40123");
		octalTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		octalTxtField.setColumns(15);
		octalTxtField.setBounds(196, 295, 215, 30);
		MainFrame.getContentPane().add(octalTxtField);
		
		hexTxtField = new JTextField();
		hexTxtField.setEditable(false);
		hexTxtField.setEnabled(false);
		hexTxtField.setToolTipText("e.g. 40123");
		hexTxtField.setText("0");
		hexTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hexTxtField.setColumns(15);
		hexTxtField.setBounds(196, 346, 215, 30);
		MainFrame.getContentPane().add(hexTxtField);
	}
}

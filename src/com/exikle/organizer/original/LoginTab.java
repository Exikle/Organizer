package com.exikle.organizer.original;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginTab extends JFrame implements ActionListener {

	JLabel lblUser = new JLabel("User Name:"), lblPass = new JLabel(
			"Password:"), lblLogin = new JLabel("LOGIN");

	JLabel lblUser2 = new JLabel("User Name:"),
			lblPass2 = new JLabel("Password:"), lblReg = new JLabel(
					"REGISTER");

	JPasswordField txtPass = new JPasswordField("Password"),
			txtPass2 = new JPasswordField("Password");

	JComboBox<String> user = new JComboBox<String>();

	JButton btnLogin = new JButton("LOGIN"), btnReg = new JButton(
			"Register");

	JTextField txtUser = new JTextField("Enter Username");

	String usrnme = "", psswrd = "";

	String[] username, password;

	int indexcount = 0, counter = 0;

	Color c1 = new Color(70, 122, 255), c2 = new Color(255, 0, 0),
			c3 = new Color(0, 255, 0);

	Font f1;

	JPanel pnl1 = new JPanel();

	public static void main(String[] args) throws Exception {
		new LoginTab();
	}

	public LoginTab() throws Exception {
		File f = new File("DS-DIGIT.ttf");
		FileInputStream in = new FileInputStream(f);
		Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);

		user.addActionListener(this);
		user.addItem("Pick Username");
		imports();
		indexcount = (user.getItemCount());
		username = new String[indexcount];
		password = new String[indexcount];
		imports2();
		txtPass.setEchoChar('*');
		txtPass2.setEchoChar('*');

		pnl1.setLayout(null);
		pnl1.add(lblLogin);
		lblLogin.setBounds(125, 25, 300, 50);
		lblLogin.setFont(f1 = dFont.deriveFont(60f));

		pnl1.add(lblReg);
		lblReg.setBounds(75, 275, 300, 50);
		lblReg.setFont(f1 = dFont.deriveFont(60f));

		pnl1.add(lblUser);
		lblUser.setBounds(15, 100, 150, 40);
		lblUser.setFont(f1 = dFont.deriveFont(30f));

		pnl1.add(lblUser2);
		lblUser2.setBounds(15, 350, 150, 40);
		lblUser2.setFont(f1 = dFont.deriveFont(30f));

		pnl1.add(user);
		user.setBounds(150, 100, 225, 40);
		user.setFont(f1 = dFont.deriveFont(25f));

		pnl1.add(txtUser);
		txtUser.setBounds(150, 350, 225, 40);
		txtUser.setFont(f1 = dFont.deriveFont(25f));

		pnl1.add(lblPass);
		lblPass.setBounds(15, 150, 150, 40);
		lblPass.setFont(f1 = dFont.deriveFont(30f));

		pnl1.add(lblPass2);
		lblPass2.setBounds(15, 400, 150, 40);
		lblPass2.setFont(f1 = dFont.deriveFont(30f));

		pnl1.add(txtPass);
		txtPass.setBounds(150, 150, 225, 40);
		txtPass.setFont(f1 = dFont.deriveFont(25f));

		pnl1.add(txtPass2);
		txtPass2.setBounds(150, 400, 225, 40);
		txtPass2.setFont(f1 = dFont.deriveFont(25f));

		pnl1.add(btnLogin);
		btnLogin.setBounds(125, 200, 125, 25);
		btnLogin.setFont(f1 = dFont.deriveFont(25f));
		btnLogin.addActionListener(this);

		pnl1.add(btnReg);
		btnReg.setBounds(100, 450, 175, 25);
		btnReg.setFont(f1 = dFont.deriveFont(25f));
		btnReg.addActionListener(this);

		this.add(pnl1);
		this.setSize(400, 600);
		this.setUndecorated(true);
		this.isUndecorated();
		this.setVisible(true);
		System.out.println("fin");
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == user) {
			System.out.println(user.getSelectedIndex());
		} else if (e.getSource() == btnReg) {
			register();
			do {
				if (user.getItemCount() > 0)
					user.removeItemAt(0);
			} while (user.getItemCount() > 0);
			imports();
			counter = 0;
			indexcount = (user.getItemCount());
			username = new String[indexcount];
			password = new String[indexcount];
			imports2();
		} else if (e.getSource() == btnLogin) {
			usrnme = "" + user.getItemAt(user.getSelectedIndex());
			psswrd = txtPass.getText();
			for (int x = 0; x < indexcount; x++) {
				if ((usrnme.equals(username[x]))
						&& (psswrd.equals(password[x]))) {
					System.out.println("Matches");
					pnl1.setBackground(c3);
					break;
				}
				if ((!usrnme.equals(username[x]))
						&& (!psswrd.equals(password[x]))) {
					System.out.println("NO Matches");
					pnl1.setBackground(c2);
				}
			}
		}
	}

	public void imports() {
		String[] fields; // array to store the "split" line read
		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		File f = new File("LoginInfo.txt"); // variable reprsenting the data file
		// Open the data file
		try {
			in = new BufferedReader(new FileReader(f));
			System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File");
		}
		// Read each line and split to appropriate field variables
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					fields = line.split(":");
					usrnme = fields[0];
					psswrd = fields[1];
				}
			} catch (IOException e) {
				System.out.println("Problem reading data from file");
			}
			if (line != null) {
				user.addItem(usrnme);
			}
		}
		// Close the data file
		try {
			in.close();
			System.out.println("Closing File");
		} catch (IOException e) {
			System.out.println("Problem Closing " + e);
		}
	}

	@SuppressWarnings("deprecation")
	public void register() {
		PrintWriter out = null; // variable representing the PrintWriter
		String line = ""; // variable to read each line from the data file
		// Open the data file
		try {
			// in general we have substituted the word Writer for Reader
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					new File("h:LoginInfo.txt"), true)), true);
			// add ,true parameter to the PrintWriter to FLUSH Buffer with every write line
			// add ,true parameter to the FileWriter for opening as APPEND
			System.out.println("File Opening");
		} catch (IOException e) {
			System.out.println("Problem opening File");
		}
		usrnme = txtUser.getText();
		psswrd = txtPass2.getText();
		line = usrnme + ":" + psswrd;
		out.print("");
		out.println(line); // outputs the contents of the variable 'line' to the file
		out.close(); // Close the data file
		System.out.println("File Closing");
		txtPass2.setText("Password");
		txtUser.setText("Enter Username");
	}

	public void imports2() {
		String[] fields; // array to store the "split" line read
		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		File f = new File("LoginInfo.txt"); // variable reprsenting the data file
		// Open the data file
		try {
			in = new BufferedReader(new FileReader(f));
			System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File");
		}
		// Read each line and split to appropriate field variables
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					fields = line.split(":");
					username[counter] = "";
					username[counter] = "" + fields[0];
					password[counter] = "";
					password[counter] = "" + fields[1];
					counter++;
				}
			} catch (IOException e) {
				System.out.println("Problem reading data from file");
			}
			if (line != null) {
			}
		}
		// Close the data file
		try {
			in.close();
			System.out.println("Closing File");
		} catch (IOException e) {
			System.out.println("Problem Closing " + e);
		}
	}
}
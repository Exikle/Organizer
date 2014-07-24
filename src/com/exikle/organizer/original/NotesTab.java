package com.exikle.organizer.original;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class NotesTab extends JFrame implements ActionListener {

	Border brdr1, brdr2;

	DPnl pnl1 = new DPnl();

	JPanel p2 = new JPanel(), p3 = new JPanel();

	File f;

	FileInputStream in;

	Font dFont;

	Font f1;

	JScrollPane scrlBar1;

	String path = ".", files, fileSelected = "", fileText = "";

	File folder = new File(path);

	File[] listOfFiles = folder.listFiles();

	String[] filename = new String[listOfFiles.length];

	JButton[] list = new JButton[listOfFiles.length];

	int filenum;

	JTextField txtTitle = new JTextField("Title");

	JTextArea txtArea = new JTextArea();

	JScrollPane scrlBar2;

	JButton btnNew = new JButton("New"),
			btnSave = new JButton("Save");

	public static void main(String[] args) throws Exception {
		new NotesTab();
	}

	public NotesTab() throws Exception {
		brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
				BorderFactory.createLineBorder(Color.white));
		brdr2 = new CompoundBorder(brdr1,
				BorderFactory.createLoweredBevelBorder());
		// get digital font from file
		f = new File("DS-DIGIT.ttf");
		in = new FileInputStream(f);
		dFont = Font.createFont(Font.TRUETYPE_FONT, in);
		f1 = dFont.deriveFont(40f);

		btnSave.setFont(f1);
		btnNew.setFont(f1);
		btnSave.addActionListener(this);
		btnNew.addActionListener(this);
		getList();

		p2.setLayout(new GridLayout(filenum, 1));
		for (int x = 0; x < filenum; x++) {
			System.out.println("" + filename[x]);
			list[x] = new JButton("" + filename[x]);
			list[x].setBorder(brdr1);
			list[x].addActionListener(this);
			p2.add(list[x]);
		}
		resetBG();
		p3.setLayout(new BorderLayout());
		p3.add(txtTitle, BorderLayout.NORTH);
		p3.add(txtArea, BorderLayout.CENTER);

		scrlBar1 = new JScrollPane(p2);
		scrlBar2 = new JScrollPane(p3);

		scrlBar1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrlBar1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrlBar2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrlBar2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		pnl1.setLayout(null);

		pnl1.add(scrlBar1);
		scrlBar1.setBounds(25, 25, 350, 225);

		pnl1.add(scrlBar2);
		scrlBar2.setBounds(25, 275, 350, 200);

		pnl1.add(btnNew);
		btnNew.setBounds(25, 500, 150, 50);
		pnl1.add(btnSave);
		btnSave.setBounds(200, 500, 150, 50);

		this.add(pnl1);
		this.setSize(400, 600);
		// this.setUndecorated(true);
		// boolean undecorated = this.isUndecorated();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int x = 0; x < filenum; x++) {
			if (e.getSource() == list[x]) {
				resetBG();
				list[x].setBackground(Color.YELLOW);
				fileSelected = list[x].getText();
				// System.out.println(fileSelected);
				getFile();
			}
		}
		if (e.getSource() == btnNew) {
			txtTitle.setText("Enter Title");
			txtArea.setText("Enter stuff :D");
			resetBG();
		}
		if (e.getSource() == btnSave) {
			fileSelected = txtTitle.getText();// gets title
			fileText = txtArea.getText();// gets stuff in txtx Area
			resetBG();// resets all list bg
			saveFile();// saves title and txtstuff

			getList();// get all txtfiles in folder //need to check size of filenames and list

			resetList();
		}

	}

	public void getList() {
		filenum = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".txt") || files.endsWith(".TXT")) {
					filename[filenum] = listOfFiles[i].getName();
					filenum++;
				}
			}
		}
	}

	class DPnl extends JPanel {

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.BLACK);
			for (int x = 0; x <= 1000; x += 25) {
				g2.drawLine(x, 0, x, 800);
				g2.drawString("" + x, x, 20);
			}
			for (int y = 0; y <= 800; y += 25) {
				g2.drawLine(0, y, 1000, y);
				g2.drawString("" + y, 0, y + 20);
			}
		}
	}

	public void resetBG() {
		for (int x = 0; x < filenum; x++) {
			list[x].setBackground(Color.WHITE);
		}
	}

	public void getFile() {
		String alltext = "";
		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		File f = new File(fileSelected); // variable reprsenting the data file

		try {
			in = new BufferedReader(new FileReader(f));
			// System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			// System.out.println("Problem opening File");
		}
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					alltext = alltext + line + "\n";
				}
			} catch (IOException e) {
				// System.out.println("Problem reading data from file");
			}
			if (line != null) {
				// System.out.println(line);
				fileSelected = fileSelected.replace(".txt", "");
				txtTitle.setText(fileSelected);
				txtArea.setText(alltext);
			}
		}
		try {
			in.close();
			// System.out.println("Closing File");
		} catch (IOException e) {
			// System.out.println("Problem Closing "+e);
		}
	}

	public void saveFile() {
		PrintWriter out = null; // variable representing the PrintWriter
		String line = ""; // variable to read each line from the data file
		// Open the data file
		try {
			// in general we have substituted the word Writer for Reader
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					new File("c:" + fileSelected + ".txt"), false)),
					true);
			// add ,true parameter to the PrintWriter to FLUSH Buffer with every write line
			// add ,true parameter to the FileWriter for opening as APPEND
			System.out.println("File Opening");
		} catch (IOException e) {
			System.out.println("Problem opening File");
		}

		line = fileText;
		out.println("" + line); // outputs the contents of the variable 'line' to the file
		out.close(); // Close the data file
	}

	public void resetList() {
		for (int x = 0; x < filenum; x++) {
			list[x].setText("" + filename[x]);
		}
	}

}
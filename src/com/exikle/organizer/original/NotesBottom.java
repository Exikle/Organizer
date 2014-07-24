package com.exikle.organizer.original;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NotesBottom extends JFrame implements ActionListener {

	JButton btnSave = new JButton("Save");

	public static void main(String[] args) throws Exception {
		new NotesBottom();
	}

	public NotesBottom() throws Exception {
		File f = new File("DS-DIGIT.ttf");
		FileInputStream in = new FileInputStream(f);
		Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
		Font f1 = dFont.deriveFont(70f);

		btnSave.setFont(f1);
		this.add(btnSave);
		this.setLayout(new GridLayout(1, 1));
		this.setUndecorated(true);
		this.isUndecorated();
		this.setSize(400, 100);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}
}
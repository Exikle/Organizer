package com.exikle.organizer.original;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class OrganizerGUI extends JFrame implements ActionListener {

	// Declaration Area
	Border brdr1, brdr2;

	JPanel pnl1;

	LoginTab login = new LoginTab();

	public static void main(String[] args) throws Exception {
		new OrganizerGUI();
	}

	public OrganizerGUI() throws Exception {

		// this.setSize(300,300);
		// this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

}

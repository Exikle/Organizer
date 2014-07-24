package com.exikle.organizer.original;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Clock extends JLabel {

	javax.swing.Timer m_t;

	public Clock() throws Exception {
		File f = new File("DS-DIGIT.ttf");
		FileInputStream in = new FileInputStream(f);
		Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
		Font f1 = dFont.deriveFont(60f);
		Color c1 = new Color(70, 122, 255);

		setFont(f1);
		setForeground(c1);
		// ... Create a 1-second timer.
		m_t = new javax.swing.Timer(1000, new ClockTickAction());
		m_t.start();  // Start the timer
	}

	private class ClockTickAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// ... Get the current time.
			Calendar now = Calendar.getInstance();
			int h = now.get(Calendar.HOUR_OF_DAY), m = now
					.get(Calendar.MINUTE), s = now
					.get(Calendar.SECOND);
			String ampm = "AM", hour, min, sec;

			if (h >= 13) {
				h = h - 12;
				ampm = "PM";
			} else
				ampm = "AM";

			if (h < 10)
				hour = "0" + h;
			else
				hour = "" + h;

			if (m < 10)
				min = "0" + m;
			else
				min = "" + m;

			if (s < 10)
				sec = "0" + s;
			else
				sec = "" + s;

			setText("" + hour + ":" + min + ":" + sec + " " + ampm);
		}
	}
}
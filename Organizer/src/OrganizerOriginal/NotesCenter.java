package OrganizerOriginal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class NotesCenter extends JFrame implements ActionListener{
  Border brdr1, brdr2;
  JPanel  pnl1=new JPanel();
  JTextArea txtArea=new JTextArea(10,30);
  JScrollPane scrlBar = new JScrollPane(txtArea);
  
  public static void main(String[] args)
  {
    new NotesCenter();
  }
  public NotesCenter(){
    brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
                               BorderFactory.createLineBorder(Color.white));
    brdr2 = new CompoundBorder(brdr1, BorderFactory
                                 .createLoweredBevelBorder());
    scrlBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    this.add(scrlBar);
    this.setSize(400,300);
    this.setUndecorated(true);
    boolean undecorated = this.isUndecorated();
    this.setVisible(true);
  }
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}

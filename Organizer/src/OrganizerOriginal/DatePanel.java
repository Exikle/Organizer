package OrganizerOriginal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

//Starter Template
public class DatePanel extends JPanel {
  
  
  JPanel pnl2,pnl3,pnl4,pnl5;
  Border brdr1, brdr2;
  JLabel lblMY, lblD1, lblD2;
  Font font2 = new Font("Monotype Corsiva", Font.ITALIC, 15);
  Font font3 = new Font("Monotype Corsiva", Font.BOLD, 35);
  
  public static void main(String[]args) throws Exception  
  {
    new DatePanel();
  }
  
  public DatePanel()throws Exception  {
    File f = new File("DS-DIGIT.ttf");
    FileInputStream in = new FileInputStream(f);
    Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
    Font f1 = dFont.deriveFont(60f);
    Color c1 = new Color(70,122,255);
    
    brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
                               BorderFactory.createLineBorder(Color.white));
    
    brdr2 = new CompoundBorder(brdr1, BorderFactory
                                 .createLoweredBevelBorder());
    pnl2=new JPanel();
    pnl2.setBackground(c1);
    pnl3=new JPanel();
    pnl4=new JPanel();
    pnl5=new JPanel();
    
    JLabel label1 = new JLabel("Hello World");
    JTextField text1 = new JTextField("Type Here",20);
    JLabel lblMY = new JLabel("", JLabel.CENTER);
    JLabel lblD1 = new JLabel("", JLabel.CENTER);
    JLabel lblD2 = new JLabel("", JLabel.CENTER);
    
    DateFormat dF1 = new SimpleDateFormat("MMM yyyy");
    DateFormat dF2 = new SimpleDateFormat("dd ");
    DateFormat dF3 = new SimpleDateFormat("EEE");
    Date date = new Date();
    
    
    lblMY.setText(dF1.format(date));
    lblMY.setFont(font2);

    
            
        //lblD1.setForeground(Color.green);
    lblD1.setText(dF2.format(date));
    lblD1.setFont(font3);
    
    lblD2.setText(dF3.format(date));
    lblD2.setFont(font2);
    lblD2.setOpaque(false);
    
    pnl2.add(lblMY);
    pnl4.add(lblD1);
    pnl4.setOpaque(false);
    pnl5.add(lblD2);
    pnl5.setOpaque(false);
    

    
    pnl3.setLayout(new BorderLayout());
    pnl3.add(pnl4, BorderLayout.CENTER);
    pnl3.add(pnl5, BorderLayout.SOUTH);
    
    this.setLayout(new BorderLayout());
    this.add(pnl2, BorderLayout.NORTH);
    this.add(pnl3, BorderLayout.CENTER);
    this.setBorder(brdr1);
       
       
    this.setSize(70,80);
//    this.setUndecorated(true);
//    boolean undecorated = this.isUndecorated();
    this.setVisible(true);
    
  }
}

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

public class TopPanel extends JFrame implements ActionListener { 
  //Declaration Area
  Border brdr1, brdr2;
  JPanel pnl2;
  JPanel dpnl = new JPanel();
  DatePanel date = new DatePanel();
  Font font3 = new Font("Monotype Corsiva", Font.BOLD, 30);
  public static void main(String[] args)throws Exception 
  {
    new TopPanel();
  }
  public TopPanel()throws Exception {
  Clock clock = new Clock();
    clock.setBackground(Color.BLACK);
    clock.setOpaque(true);
    pnl2=new JPanel();
    pnl2.setBackground(Color. YELLOW);
    
    dpnl.setLayout(null);
    dpnl.add(date);
    date.setBounds(300,0,100,100);
    dpnl.add(clock);
    clock.setBounds(0,0,300,100);
    
    this.add(dpnl);
    
    this.setSize(400,100);
    this.setUndecorated(true);
    boolean undecorated = this.isUndecorated();
    
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    
  }
  
//  private class RightClicker extends MouseAdapter {  
//    public void mousePressed( MouseEvent e ) {  
//      if ( e.isMetaDown() ) {
//        
//      }
//    }
//  }
  class DrwPnl extends JPanel {
    public void paintComponent(Graphics g) {
      Graphics2D g4 = (Graphics2D)g;
      //This line takes away the jaggedness and smooths out the lines
      g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//      drawGrid Codes
      
      g4.setColor(Color.BLACK);
      for(int x=0;x<=1000;x+=25)
      {
        g4.drawLine(x,0,x,800);
        g4.drawString(""+x,x,20);
      }
      
      for(int y=0;y<=800;y+=25)
      {
        g4.drawLine(0,y,1000,y);
        g4.drawString(""+y,0,y+20);
      }
      
    }
  }
}

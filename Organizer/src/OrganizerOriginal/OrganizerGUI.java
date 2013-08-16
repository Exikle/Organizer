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

public class OrganizerGUI extends JFrame implements ActionListener{
  //Declaration Area
  Border brdr1, brdr2;
  JPanel pnl1;
  LoginTab login= new LoginTab();
  public static void main(String[] args) throws Exception
  {
    new OrganizerGUI();
  }
  public OrganizerGUI() throws Exception {
    
//    this.setSize(300,300);
//    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    
  }
  
}

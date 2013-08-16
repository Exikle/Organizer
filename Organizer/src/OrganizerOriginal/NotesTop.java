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

import java.io.File;

public class NotesTop extends JFrame implements ActionListener{
  Border brdr1, brdr2;
  JPanel  pnl1=new JPanel(), pnl2=new JPanel();
  JScrollPane scrlBar = new JScrollPane(pnl1);
  String path = "."; 
  String files;
  File folder = new File(path);
  File[] listOfFiles = folder.listFiles(); 
  String[] filename = new String[listOfFiles.length];
  JLabel[] list = new JLabel[listOfFiles.length];
  int filenum;
  public static void main(String[] args)
  {
    new NotesTop();
  }
  public NotesTop(){
    getList();
    System.out.println(filenum);
    scrlBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    pnl1.setLayout(new GridLayout(filenum,1));
    System.out.println(""+filenum);
    for (int x=0;x<filenum;x++){
      System.out.println(""+filename[x]);
      list[x]=new JLabel(""+filename[x]);
      pnl1.add(list[x]);
    }
    
    this.add(scrlBar);
    this.setSize(400,200);
//    this.setUndecorated(true);
//    boolean undecorated = this.isUndecorated();
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    
  }
  public void getList(){
    filenum=0;
    for (int i = 0; i < listOfFiles.length; i++){
      if (listOfFiles[i].isFile()){
        files = listOfFiles[i].getName();
        if (files.endsWith(".txt") || files.endsWith(".TXT")){
          System.out.println(listOfFiles[i].getName());
          filename[i] = listOfFiles[i].getName();
          filenum++;
        }
      }
    }
  }
}

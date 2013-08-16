package OrganizerOriginal;
// StarterGUI Template 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class textAreaDemo2 extends JFrame implements ActionListener{ 
  
  JTextArea area1;
  JScrollPane scroller;
  JButton button1;
  
  String [] fields; // array to store the "split" line read
  String fname="",lname=""; // individual field variables 
  int jersey=0; // individual field variable
  
  BufferedReader in=null; //variable representing the bufferedreader
  String line="A B 1"; //variable to read each line from the data file
  File f=new File("LoginInfo.txt"); //variable reprsenting the data file
  
  
  public static void main(String[ ] args) 
  {
    new textAreaDemo2 ();
  }  
  
  public textAreaDemo2 (){
    
    area1=new JTextArea(10,100);
    scroller = new JScrollPane(area1);
    scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    
    
    button1=new JButton("READ");
    button1.addActionListener(this);
    this.setLayout(new GridLayout(2,1));
    this.add(scroller);
    this.add(button1);
    this.setSize(200,200);
    this.setVisible(true);
  }
  
  
  public void actionPerformed(ActionEvent z)
  {
    
        //Open the data file
    try
    {
      in=new BufferedReader(new FileReader(f));
      System.out.println("File Opening");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Problem opening File");
    }
    line="A B 1";
    
    //Read each line and split to appropriate field variables
    while(line!=null)
    {
      try{
        line=in.readLine();
        if (line!=null)
        {
          fields=line.split(":");
          fname=fields[0];
          lname=fields[1];
        }
      }
      catch (IOException e)
      {
        System.out.println("Problem reading data from file");
      }
      
      if (line!=null)
      {
        System.out.println(fname);
        System.out.println(lname);
      }
    } 
    
    
    //Close the data file
    try
    {
      in.close();
      System.out.println("Closing File");
    }
    catch (IOException e)
    {
      System.out.println("Problem Closing "+e);
    }
    
  }
}


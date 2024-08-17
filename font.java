package myText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class font extends JDialog implements ItemListener{ 
	  JPanel p1 = new JPanel();  
	  JPanel p2 = new JPanel();  
	  JPanel p3 = new JPanel();  
	  JPanel p4 = new JPanel(); 
	  JPanel p5 = new JPanel();
	  JComboBox comboBox1 = new JComboBox();  
	  JComboBox comboBox2 = new JComboBox();  
	  JComboBox comboBox3 = new JComboBox();  
	  JLabel lab1=new JLabel("font");  
	  JLabel lab2=new JLabel("format");  
	  JLabel lab3=new JLabel("size");    
	  Font f=new Font("Arial",Font.PLAIN,16);  
	  String name=new String("Calibri"); 
	  int style=1;  
	  int size=12;  
	  public static String name1;
	  public static int style1;
	  public static int size1;
	  
	  String []zixing=new String[]{"plain","italic","bold","italic_bold"};  
	  String []zihao=new String[]{"10","11","12","13","14","15","16","17","18","19","20"};  
	  GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment(); 
	  String [] fontName=ge.getAvailableFontFamilyNames(); 
	  JButton b1=new JButton("color");  
	  JButton b2=new JButton("confirm");  
	  JTextArea a1=new JTextArea();  
	  void set(JTextArea a1){  
	      this.a1=a1;
	  }  
	  public String fname(String name){
		  name1=name;
		  return name1;
	  }
	  public int fstyle(int style){
		  style1=style;
		  return style1;
	  }
	  public int fsize(int size){
		  size1=size;
		  return size1;
	  }
	public font(){  
	      setTitle("font");  
	      setSize(300,360);  
	      Toolkit kit = Toolkit.getDefaultToolkit(); 
	      Dimension screenSize = kit.getScreenSize();
	      setLocation(screenSize.width/6,screenSize.height/6);
	      setLayout(new FlowLayout());  
	      p1.setLocation(100, 200);  
	      lab1.setFont(f); 
	      lab2.setFont(f);  
	      lab3.setFont(f);
	      comboBox1.setModel(new DefaultComboBoxModel(fontName));  
	      comboBox1.setFont(f);  
	      for(int i=1;i<fontName.length;i++){  
	          comboBox1.setSelectedItem(fontName);  
	      }  
	      comboBox2.setModel(new DefaultComboBoxModel(zixing));  
	      comboBox2.setFont(f);  
	      for(int i=1;i<zixing.length;i++){  
 	          comboBox2.setSelectedItem(zixing);   
	      }  
	      comboBox3.setModel(new DefaultComboBoxModel(zihao));  
	      comboBox3.setFont(f);  
	      for(int i=1;i<zihao.length;i++){  
	      comboBox2.setSelectedItem(zihao);  
	      }  	        
	      p1.add(lab1);  
	      p1.add(comboBox1);  
	      p2.add(lab2);  
	      p2.add(comboBox2);  
	      p3.add(lab3);  
	      p3.add(comboBox3);  
	      p4.add(b1);  
	      p5.add(b2);         
	      comboBox1.addItemListener(this);  
	      comboBox2.addItemListener(this);  
	      comboBox3.addItemListener(this);  
	      b1.addActionListener(new MyActionListener3());  
	      b2.addActionListener(new MyActionListener3()); 
	      add(p1);  
	      add(p2);  
	      add(p3);  
	      add(p4); 
	      add(p5); 
	  }  
	      public void itemStateChanged(ItemEvent e) {  
	          if(e.getSource()==comboBox1){  
	              name=comboBox1.getSelectedItem().toString();
	          }  
	          if(e.getSource()==comboBox2){  
	            String s1=comboBox2.getSelectedItem().toString(); 
	            if(s1.equals("bold")){  
	                style=Font.BOLD;  
	            }  
	            if(s1.equals("italic")){  
	                style=Font.ITALIC;  
	            }  
	            if(s1.equals("plain")){  
	                style=Font.PLAIN;  
	            }  
	            if(s1.equals("italic_bold")){  
	            	style=Font.BOLD+Font.ITALIC;  
	            }  
	          }  
	          if(e.getSource()==comboBox3){  
	               String s2=comboBox3.getSelectedItem().toString(); 
	               size=Integer.parseInt(s2);  
	          }  
	      }  
	        
	      class MyActionListener3 implements ActionListener{  
	          public void actionPerformed(ActionEvent e2) {  
	            Font font=new Font(name,style,size);  
	              a1.setFont(font);  
	             fname(name);
	             fstyle(style);
	             fsize(size);
	             
	              if(e2.getActionCommand()=="color"){  
	                  setcolor();  
	              }  
	          }  
	      }  
	       void setcolor(){  
	         Color fontcolor=JColorChooser.showDialog(this,"set color",a1.getForeground());  
	               a1.setForeground(fontcolor);  
	              }  
	    
public static void main (String args[]){
	font f=new font();
 }
}

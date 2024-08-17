package myText;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Search extends JDialog{ 
	private static final long serialVersionUID = 1L;  
	  JLabel l1=new JLabel("find");  
	  JTextField t1=new JTextField(10);  
	  JButton b1=new JButton("find next");  
	  JButton b2=new JButton("cancel");  
	  Font f=new Font("Arial",Font.PLAIN,16);
	  JTextArea a1=new JTextArea();
	  int start=0;
	  int end;
	  int m=-1;
	  void set(JTextArea n){  
	        a1=n;  
	    }  
	  public Search(){  
	      setTitle("find");  
	      setSize(300,120);  
	      setLocation(400,350); 
	      setLayout(new FlowLayout());  
	      b1.setFont(f);  
	      b2.setFont(f);  
	      l1.setFont(f);  
	      add(l1);  
	      add(t1);  
	      add(b1);  
	      add(b2); 
	      b1.addActionListener(new ActionListener(){  
		      public void actionPerformed(ActionEvent e1) {   
		    	    String source=a1.getText();
		    	    String find=t1.getText();
		    	    m=source.indexOf(find,m+1);
		    	    //System.out.println(m);
		    	    if(m==-1) 
	                    JOptionPane.showMessageDialog(null,"none");  
	                else{ 
	                	start=m;
	                	end=start+find.length();
	                	a1.setSelectionStart(start);
	          	        a1.setSelectionEnd(end);
	                }
		      }  
		      } );
	      b2.addActionListener(new ActionListener(){  
	      public void actionPerformed(ActionEvent e1) {  
	          setVisible(false);  
	      }  
	      } );  
	  }  
	  public static void main (String args[]){
		  Search search=new Search();
	  }
	}
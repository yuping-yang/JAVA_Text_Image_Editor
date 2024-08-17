package calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class WindowText extends JFrame implements ActionListener
{
    JTextField tf=new JTextField(10);
    int a=0;   
    String n1,n2;   
    String o="+";   
    String nums[]={"7","8","9","4","5","6","1","2","3","0"};
    String operators[]={"+","-","*","/"};
    JButton b1[]=new JButton[10];
    JButton b2[]=new JButton[4]; 
    JButton b3=new JButton("."); 
    JButton b4=new JButton("Del"); 
    JButton b5=new JButton("C"); 
    JButton b6=new JButton("=");
    JPanel p1=new JPanel();  
    JPanel p2=new JPanel();  
    public WindowText(String s){
	    setTitle(s);
    	setLayout(new BorderLayout());
    	p1.setLayout(new GridLayout(4,3));
    	p2.setLayout(new GridLayout(3,2));
    	tf.setEditable(false);           
	    tf.setHorizontalAlignment(JTextField.RIGHT); 
	    tf.setBackground(Color.white);
    	add(tf,BorderLayout.NORTH);  
    	setBounds(500,200,246,150);  
    	setResizable(false);  
    	setVisible(true);     
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	for(int i=0;i<b1.length;i++)
    	{
    		b1[i]=new JButton(nums[i]);
    		p1.add(b1[i]);
    		b1[i].addActionListener(this); 
    	}
    	for(int i=0;i<b2.length;i++)
    	{
    		b2[i]=new JButton(operators[i]);
    		p2.add(b2[i]);
    		b2[i].addActionListener(this);
    	}   	
    	p1.add(b3);
    	p1.add(b4);
    	p2.add(b5);
    	p2.add(b6);
    	add(p1,BorderLayout.WEST);  
    	add(p2,BorderLayout.EAST);  
        b3.addActionListener(this);        
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
    	for(int i=0;i<b1.length;i++)
    		if(e.getSource()==b1[i])
    		{
    			if(a==1) tf.setText(null); 		
    			String num=tf.getText();
    			tf.setText(num+b1[i].getText());
                a=0;	    			
    		}
    	if(e.getSource()==b3)//小数点
    	{
    		String num=tf.getText();
    	    tf.setText(num+".");
    	    b3.removeActionListener(this);  
    	}
    	for(int i=0;i<b2.length;i++){
    		if(e.getSource()==b2[i])
    		{
    			n1=tf.getText();  
    			tf.setText(null); 
    			o=b2[i].getText(); 
    			b3.addActionListener(this); 
    		}
    	}
    	if(e.getSource()==b4) //删除
		{
			 String s=tf.getText();
			 String ss=s.substring(0,s.length()-1); 
			 tf.setText(ss);
		}
    	if(e.getSource()==b5) //清空
		{
			 tf.setText(null);  //清空文本框
			// b3.addActionListener(this); 
		}
        if(e.getSource()==b6) //等号
        {
        	 n2=tf.getText(); 
        	 double x=Double.parseDouble(n1);
        	 double y=Double.parseDouble(n2);
        	 double s=0;
        	 if(o.equals("+"))s=x+y;
        	 if(o.equals("-"))s=x-y;
        	 if(o.equals("*"))s=x*y;
        	 if(o.equals("/"))s=x/y;
        	 tf.setText(s+"");
        	 a=1; 
    	}  		
    }
}
public class calculator {
	public static void main(String args[]){
	    new WindowText("Calculator");
	}
}

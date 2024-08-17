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

class Change extends JDialog{  
    JLabel l1=new JLabel("find");  
    JLabel l2=new JLabel("replace");  
    JTextField t1=new JTextField(10);  
    JTextField t2=new JTextField(10);  
    JButton b1=new JButton("replace");  
    JButton b2=new JButton("replace all");  
    JButton b3=new JButton("cancel");  
    JTextArea a2=new JTextArea();  
    Font f=new Font("Arial",Font.PLAIN,16);  
  
    void set(JTextArea n){  
        a2=n;  
    }  
    public Change(){  
        setTitle("replace");  
        setSize(500,160);  
        setLocation(300,300);  
        setLayout(new FlowLayout());  
        l1.setFont(f);  
        l2.setFont(f);  
        t1.setFont(f);  
        t2.setFont(f);  
        b1.setFont(f);  
        b2.setFont(f);  
        b3.setFont(f);  
        add(l1);  
        add(t1);  
        add(l2);  
        add(t2);  
        add(b1);  
        add(b2);  
        add(b3);  
        b1.addActionListener(new MyActionListener3());  
        b2.addActionListener(new MyActionListener3());  
        b3.addActionListener(new MyActionListener3());  
    }  
    class MyActionListener3 implements ActionListener{  
          
public void actionPerformed(ActionEvent e2) {  
    int m;  
    String source=a2.getText();  
    String find=t1.getText();  
    String change=t2.getText();  
            if(e2.getActionCommand()=="cancel"){  
                setVisible(false);  
                t1.setText("");  
                t2.setText("");  
            }  
            if(e2.getActionCommand()=="replace"){  
                m=source.indexOf(find,0);  
                String s1=source.substring(0,m);  
                String s2=source.substring(m+find.length());  
                source=s1+change+s2;  
                if(m==-1){  
                    JOptionPane.showMessageDialog(null,"none");  
                }else{  
                    a2.setText(source);  
                }  
            }  
            if(e2.getActionCommand()=="replace all"){  
                m=-change.length();  
                while(true){  
                    m=source.indexOf(find,m+change.length());  
                    if(m==-1)  
                        break;  
                    else{  
                    String s1=source.substring(0,m);  
                    String s2=source.substring(m+find.length());  
                    source=s1+change+s2;  
                    }  
                }  
                a2.setText(source);  
            }  
              
        }  


    }  
      
}
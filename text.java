package myText;
import javax.swing.*;  
import javax.swing.event.DocumentEvent;  
import javax.swing.event.DocumentListener;  

import java.awt.*;  
import java.io.*;  
import java.awt.event.*;  

public class myText extends JFrame implements DocumentListener {   
    JMenuBar menubar=new JMenuBar();  
    JMenu file=new JMenu("file");  
    JMenu edit=new JMenu("edit");  
    JMenu geshi=new JMenu("format");  
    JMenu look =new JMenu("view");
    JMenu help =new JMenu("help");  
    JTextArea wordArea=new JTextArea(); 
    JScrollPane imgScrollPane = new JScrollPane(wordArea);  
    String [] str1={"new","open","save","save as","exit"};  
    String [] str2={"cut","copy","paste","find","replace"};  
    JMenuItem item3=new JMenuItem("font");
    JMenuItem item5=new JMenuItem("info");
    JMenuItem item4=new JMenuItem("info");
    Font f=new Font("Arial",Font.PLAIN,16);
    Search search=new Search(); 
    font myFont=new font();
    Change change=new Change(); 
    Tip tip=new Tip();
    int flag=0; 
    String source="";
	public String name2;
	public int style2;
	public int size2;
	public int s=0;
    public String gd="";
    public String gf="";
    public static void main(String[] args) {  
      JFrame myText=new myText();  
      myText.setVisible(true);      
    }  
    public myText(){ 
       search.set(wordArea);
       change.set(wordArea);  
       myFont.set(wordArea);  
       setTitle("new document");  
       Toolkit kit = Toolkit.getDefaultToolkit();  
       Dimension screenSize = kit.getScreenSize();
       setSize(screenSize.width/2,screenSize.height/2);
       setLocation(screenSize.width/4,screenSize.height/4);
       add(imgScrollPane,BorderLayout.CENTER);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setJMenuBar(menubar);  
       file.setFont(f);  
       edit.setFont(f);  
       geshi.setFont(f);   
       look.setFont(f);
       help.setFont(f);  
       menubar.add(file);  
       menubar.add(edit);  
       menubar.add(geshi);
       menubar.add(look);
       menubar.add(help);  
       wordArea.getDocument().addDocumentListener(this); 
       addWindowListener(new WindowAdapter() {
    	   public void windowClosing(java.awt.event.WindowEvent e) {
    	   exit();
    	   }
    	   });
       for(int i=0;i<str1.length;i++){  //file
          JMenuItem item1= new JMenuItem(str1[i]);  
          item1.addActionListener(new MyActionListener1());  
          item1.setFont(f);  
          file.add(item1);  
       }  
       for(int i=0;i<str2.length;i++){  //edit
          JMenuItem item2= new JMenuItem(str2[i]);  
          item2.addActionListener(new MyActionListener1());  
          item2.setFont(f);  
          edit.add(item2);  
       }  
          item3.setFont(f);
          item3.addActionListener(new MyActionListener1());
          geshi.add(item3);  
          item4.setFont(f);
          item4.addActionListener(new MyActionListener1());
          help.add(item4);
          item5.setFont(f);
          item5.addActionListener(new MyActionListener1());
          look.add(item5);
    }  
    public void changedUpdate(DocumentEvent e) {  
        flag=1;  
    }     
    public void insertUpdate(DocumentEvent e) {  
        flag=1;  
    }  
    public void removeUpdate(DocumentEvent e) {  
        flag=1;  
    }  
    void open(){  
        FileDialog  filedialog=new FileDialog(this,"open",FileDialog.LOAD);  
        filedialog.setVisible(true);
        String path=filedialog.getDirectory();  
        String name=filedialog.getFile();  
        if(path!=null && name!=null){  
             FileInputStream file = null;  
            try {  
                file = new FileInputStream(path+name);  
            } catch (FileNotFoundException e) {                   
            }  
             InputStreamReader put =new InputStreamReader(file);  
             BufferedReader in=new BufferedReader(put);  
             String temp="";  
             String now = null;  
            try {  
                now = (String)in.readLine();  
            } catch (IOException e) {                    
                e.printStackTrace();  
            }  
              while(now!=null){  
                  temp+=now+"\r\n";  
                  try {  
                    now=(String)in.readLine();  
                } catch (IOException e) {                        
                    e.printStackTrace();  
                }  
                   }    
               wordArea.setText(temp);  
        }            
    }  
    void open(String name2,int style2,int size2){  
    	this.name2=name2;
    	this.style2=style2;
    	this.size2=size2;
        FileDialog  filedialog=new FileDialog(this,"open",FileDialog.LOAD);  
        filedialog.setVisible(true); 
        String path=filedialog.getDirectory();  
        String name=filedialog.getFile();  
        if(path!=null && name!=null){  
             FileInputStream file = null;  
            try {  
                file = new FileInputStream(path+name);  
            } catch (FileNotFoundException e) {                    
            }  
             InputStreamReader put =new InputStreamReader(file);  
             BufferedReader in=new BufferedReader(put);  
             String temp="";  
             String now = null;  
            try {  
                now = (String)in.readLine();  
            } catch (IOException e) {                   
                e.printStackTrace();  
            }  
              while(now!=null){  
                  temp+=now+"\r\n";  
                  try {  
                    now=(String)in.readLine();  
                } catch (IOException e) {                        
                    e.printStackTrace();  
                }  
                   }    
               wordArea.setText(temp);  
               Font font=new Font(name2,style2,size2);   
               wordArea.setFont(font);
        }            
    }  
  
    void save(){  
     if(s==1){
    	 //System.out.println("save");
	 if(flag==1){	    
	             OutputStreamWriter out = null;  
	            try {  
	                out = new OutputStreamWriter(new FileOutputStream(gd+gf));
	            } catch (FileNotFoundException e) {  
	                e.printStackTrace();  
	            }  
	            try {     
	                out.write(wordArea.getText());   
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	             flag=0;  
	             try {  
	                out.close();  
	                source=wordArea.getText();  

	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	          } 
	        }
     if(s==0){
    	if(flag==1){
        FileDialog  filedialog=new FileDialog(this,"save",FileDialog.SAVE);  
        filedialog.setVisible(true);  
          if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){  
             OutputStreamWriter out = null;  
            try {  
                out = new OutputStreamWriter(new FileOutputStream(filedialog.getDirectory()+filedialog.getFile()));
                gd=filedialog.getDirectory();
                gf=filedialog.getFile();
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            try {     
                out.write(wordArea.getText());   
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
             flag=0;  
             try {  
                out.close();  
                source=wordArea.getText();  

            } catch (IOException e) {  
                e.printStackTrace();  
            }  
          } 
         s=1;
         //System.out.println(s);
        }
     }
     
}
    void saveother(){  
        FileDialog  filedialog=new FileDialog(this,"save as",FileDialog.SAVE);  
        filedialog.setVisible(true);  
        if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){  
             OutputStreamWriter out = null;  
            try {  
                out = new OutputStreamWriter(new FileOutputStream(filedialog.getDirectory()+filedialog.getFile()));  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            try {  
                out.write(wordArea.getText());  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
             flag=0;  
             try {  
                out.close();  
                source=wordArea.getText();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    void newfile(){  
        if(flag==0){  
            wordArea.setText("");  
        }  
        if(flag==1){  
            int m=  JOptionPane.showConfirmDialog(this,"save the changes?");  
            if(m==0){  
                save();  
                wordArea.setText("");  
            }  
              
            if(m==1){    
                wordArea.setText("");  
                flag=0;  
                }  
        }  
    }  
    
    void exit(){  
        if(flag==0){  
            System.exit(0);  
        }  
        if(flag==1){  
            int m=  JOptionPane.showConfirmDialog(this,"save the changes?");  
            if(m==0){  
                save();  
            }  
            if(m==1){   
                System.exit(0);  
                }  
        }  
    }  
    
    class MyActionListener1 implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
            if(e.getSource()instanceof JMenuItem){  
                if(e.getActionCommand()=="cut"){  
                    wordArea.cut();  
                }  
                if(e.getActionCommand()=="copy"){  
                    wordArea.copy();  
                }  
                if(e.getActionCommand()=="paste"){  
                    wordArea.paste();  
                }  
                if(e.getActionCommand()=="find"){  
                    search.setVisible(true);  
                }  
                if(e.getActionCommand()=="font"){  
                    myFont.setVisible(true);  
                }  
                if(e.getActionCommand()=="replace"){  
                    change.setVisible(true);  
                }  
                if(e.getActionCommand()=="info"){  
                    tip.setVisible(true);  
                }
                if(e.getActionCommand()=="open"){  
                	name2=font.name1;;
                	style2=font.style1;
                	size2=font.size1;
                	if (name2==null) open();
                	else open(name2,style2,size2);                 	
                }  
                if(e.getActionCommand()=="save"){  
                    save();  
                }  
                if(e.getActionCommand()=="save as"){  
                    saveother();  
                } 
                if(e.getActionCommand()=="new"){  
                    newfile();  
                }  
                if(e.getActionCommand()=="exit"){  
                    exit();  
                }  
            }  
              
        }  
             
}  
}  


  



  
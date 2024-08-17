package draw;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.imageio.ImageIO;


class shape implements Serializable
{
	int startx,starty;//mousepressed
	int endx,endy;  //mousedragged
	int flag;  
	public Color color;
	shape(int startx,int starty,int endx,int endy,int flag,Color color)
	{
		this.startx=startx;
		this.starty=starty;
		this.endx=endx;
		this.endy=endy;
		this.flag=flag;
		this.color=color;
	}
}
class tt extends JFrame implements ActionListener
{
	int leftx,lefty;
    int rightx,righty;
	ArrayList<shape>list=new ArrayList<shape>();
	JButton b0=new JButton("save");
	JButton b1=new JButton("rectangle");
	JButton b2=new JButton("circle");
	JButton b3=new JButton("filled rectangle");
	JButton b4=new JButton("filled circle");
	JButton b5=new JButton("line");
	JButton b6=new JButton("eraser");
	JButton b7=new JButton("color");		
	win n=new win();
	int f=0;
	int ff=0;
	public Color cc;
	ObjectInputStream input;
    ObjectOutputStream output;
	tt()
	{
		JPanel p1=new JPanel();
		p1.add(b0);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);		
		add("North",p1);
		add("Center",n);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b0.addActionListener(this);
		setSize(600,400); 
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b0)
			    saveFile();
			if(e.getSource()==b1)
				f=1;			
			if(e.getSource()==b2)
				f=2;
			if(e.getSource()==b3)
				f=3;
			if(e.getSource()==b4)
				f=4;
			if(e.getSource()==b5)
				f=5;
			if(e.getSource()==b6)
				f=6;
			if(e.getSource()==b7)
			{	Color c=new JColorChooser().showDialog(this,"choose color", Color.white);
			 //n.setForeground(c);
			 cc=c;
			}
			
		}

class win extends Canvas implements MouseListener,MouseMotionListener
{
	win()
	{
		setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	public void paint(Graphics g)
	{ //super.paint(g);
		
		if(ff==1) 
		{
			Iterator<shape> iterator =list.iterator(); 
	        while(iterator.hasNext()) {           
	          shape p=(shape)iterator.next() ;      
	       if(p.flag==1)
	       {
	    	   g.setColor(p.color);
	    	   g.drawRect(p.startx,p.starty,p.endx-p.startx,p.endy-p.starty);   
	       }
	       if(p.flag==2)
	       {
	    	   g.setColor(p.color);
	    	   g.drawOval(p.startx,p.starty,p.endx-p.startx,p.endy-p.starty);
	       }
	       if(p.flag==3)
	       {
	    	   g.setColor(p.color);
	    	   g.fillRect(p.startx,p.starty,p.endx-p.startx,p.endy-p.starty);
	       }
	       if(p.flag==4)
	       {
	    	   g.setColor(p.color);
	    	   g.fillOval(p.startx,p.starty,p.endx-p.startx,p.endy-p.starty);
	       }
	       if(p.flag==5)
	       {
	    	   g.setColor(p.color);
	    	   g.drawLine(p.startx,p.starty,p.endx,p.endy);
	       }
	       if(p.flag==6)
	       {
	    	   g.setColor(p.color);
	    	   g.clearRect(p.startx,p.starty,p.endx-p.startx,p.endy-p.starty);
	       }
	      }
		}
		if(f==0)
		{   
			g.setColor(Color.white);
			g.fillRect(0,0,500,400);
		}
		if(f==1)
		{   
			g.setColor(cc);
			g.drawRect(Math.min(leftx, rightx), Math.min(lefty, righty),
					Math.abs(leftx -rightx), Math.abs(lefty - righty));
		}
	    if(f==2)
		{   
	    	g.setColor(cc);
	    	g.drawOval(Math.min(leftx, rightx), Math.min(lefty, righty),
	                Math.abs(leftx -rightx), Math.abs(lefty - righty));
	    }if(f==3)
		{   
			g.setColor(cc);
			g.fillRect(Math.min(leftx, rightx), Math.min(lefty, righty),
					Math.abs(leftx -rightx), Math.abs(lefty - righty));
		}
	    if(f==4)
		{   
	    	g.setColor(cc);
	    	g.fillOval(Math.min(leftx, rightx), Math.min(lefty, righty),
	                Math.abs(leftx -rightx), Math.abs(lefty - righty));
	    }
	    if(f==5)
		{   
	    	g.setColor(cc);
	    	g.drawLine(leftx,lefty,rightx,righty);
	    }
	    if(f==6)
		{   
	    	g.setColor(cc);
	    	g.clearRect(Math.min(leftx, rightx), Math.min(lefty, righty),
	                Math.abs(leftx -rightx), Math.abs(lefty - righty));
	    }
	}
		public void mousePressed(MouseEvent e)
		{
			leftx=e.getX();
			lefty=e.getY();
			ff=1;
			repaint();
		}
		public void mouseReleased(MouseEvent e) 
		{
			rightx=e.getX();
			righty=e.getY();
			list.add (new shape(leftx,lefty,rightx,righty,f,cc)); 
		}
		public void mouseEntered(MouseEvent e){} 
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e){} 
		public void mouseDragged(MouseEvent e) 
		{
		    rightx=e.getX();
		    righty=e.getY();
		    ff=1; 
		    repaint();
		}
		public void mouseMoved(MouseEvent e){} 
	}


public void saveFile() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.CANCEL_OPTION) {
        return;
    }
    File fileName = fileChooser.getSelectedFile();
    fileName.canWrite();
    if (fileName == null || fileName.getName().equals("")) {
        JOptionPane.showMessageDialog(fileChooser, "Invalid File Name",
                "Invalid File Name", JOptionPane.ERROR_MESSAGE);
    } else {
        try {
            fileName.delete();
            FileOutputStream fos = new FileOutputStream(fileName);
            output = new ObjectOutputStream(fos);          
               // output.writeObject(n);
                //output.flush();  
            output.close();
            fos.close();
        } catch(IOException ioe){}
    }
    savePanelAsJpg(fileName,n);
}
public boolean savePanelAsJpg(File file, win n) {  
    Dimension imageSize = n.getSize();  
    BufferedImage image = new BufferedImage(imageSize.width,imageSize.height, BufferedImage.TYPE_INT_RGB);  
    Graphics2D graphics = image.createGraphics();  
    n.paint(graphics);  
    graphics.dispose();  
    try {  
        ImageIO.write(image, "jpg", file);  
    } catch (IOException e) {  
        e.printStackTrace();  
        return false;  
    }  
    return true;  
}  

public void update(Graphics g){

paint(g);
}
}


public class draw {
	public static void main(String args[])
	 {
		 new tt();
	 }
}

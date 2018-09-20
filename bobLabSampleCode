
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class BobLabst
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanelb m = new MyPanelb();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency.

		j.setVisible(true); //allows the frame to be shown.

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
	}

}

class MyPanelb extends JPanel implements ActionListener
{
	
	private Timer time;
	private int x,y;
	private int add;
	
	MyPanelb()
	{
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x=y=600;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawBob(g,x,y);
		
	}
	
	public void drawBob(Graphics g, int x, int y)
	{
		g.setColor(Color.BLACK);
		//head
		g.drawOval(300 + x,100,100,100);
		g.drawOval(325 + x,120,20,20);   //left eyes
		g.fillOval(330 + x,130,10,10);
		g.drawOval(355 + x,120,20,20);   //right eye
		g.fillOval(360 + x,130,10,10);
		
		g.setColor(Color.RED);		  // mouth
		g.drawArc(335 + x,140,30,40,0,-180);
		
		
		//hair
		g.setColor(Color.MAGENTA);
		g.drawLine(350 + x,100,350 + x,50);
		g.drawLine(350 + x,100,340 + x,50);
		g.drawLine(350 + x,100,330 + x,50);
		g.drawLine(350 + x,100,320 + x,50);
		g.drawLine(350 + x,100,310 + x,50);
		g.drawLine(350 + x,100,360 + x,50);
		g.drawLine(350 + x,100,370 + x,50);
		g.drawLine(350 + x,100,380 + x,50);
		g.drawLine(350 + x,100,390 + x,50);
		
		// neck
		g.setColor(Color.BLACK);
		g.drawRect(340 + x,200,20,25);
		
		//body
		g.setColor(Color.YELLOW);
		g.fillRect(300 + x,210,100,180);
	
		// left arm
		g.setColor(Color.BLUE);
		g.fillRect(250 + x,210,50,90);
		g.setColor(Color.WHITE);
		g.fillRect(275 + x,230,25,50);
		
		// right arm
		g.setColor(Color.BLUE);
		g.fillRect(400 + x,210,50,90);
		g.setColor(Color.WHITE);
		g.fillRect(400 + x,230,25,50);
		
		//buttons
		g.setColor(Color.RED);
		g.fillOval(345 + x,220,10,10);
		g.fillOval(345 + x,240,10,10);	
		g.fillOval(345 + x,260,10,10);
		
		//legs
		g.setColor(Color.BLACK);
		g.fillRect(320 + x,390,30,80);
		g.fillRect(360 + x,390,30,80);
		
		//shoes
		g.setColor(Color.BLUE);
		g.fillRect(300 + x,470,50,20);
		g.fillRect(360 + x,470,50,20);
		
		// name
		g.setFont(new Font ("Arial", Font.BOLD, 20));
		g.drawString("BOB", 200 + x,100);
		
		g.setColor(Color.BLACK);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (x >=1200)
			x=1;
			
		x+=add;
		y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;		
			
	
		repaint();
	}
	
}
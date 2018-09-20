import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;

public class blokus
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

class MyPanelb extends JPanel implements ActionListener,MouseListener
{
    //Variables used: x, y
    private Timer time;
    private int x,y;
    private int add;
    GridRects[][] grid = new GridRects[14][14];
    Pieces[] player1 = new Pieces[21];
    Point picked, released;

    MyPanelb()
    {
        addMouseListener(this);
        time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
        setSize(2000, 1500);
        setVisible(true); //it's like calling the repaint method.
        time.start();
        add=1;
        x=y=600;

        for(int t = 0; t< 14; t++)
        {
            for(int s = 0; s<14; s++)
            {
                grid[t][s] = new GridRects(1200+30*t,400+30*s,30,30,0);
                //grid[t][s].drawRect(g);
            }
        }
        int singleLine[][] = new int[5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                singleLine[row][col] = 0;
            }
        }
        singleLine[0][0] = 1;

        player1[0] = new Pieces(100,100, singleLine);

        int doubleLine[][] = new int [5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                doubleLine[row][col] = 0;
            }
        }
        doubleLine[0][0] = 1;
        doubleLine[1][0] = 1;

        player1[1] = new Pieces(150,100, doubleLine);

        int tripleLine[][] = new int [5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                tripleLine[row][col] = 0;
            }
        }
        tripleLine[0][0] = 1;
        tripleLine[1][0] = 1;
        tripleLine[2][0] = 1;

        player1[2] = new Pieces(200,100, tripleLine);

        int tripleL[][] = new int [5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                tripleL[row][col] = 0;
            }
        }
        tripleL[0][0] = 1;
        tripleL[0][1] = 1;
        tripleL[1][0] = 1;

        player1[3] = new Pieces(250,100, tripleL);

        int quadraLine[][] = new int [5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                quadraLine[row][col] = 0;
            }
        }
        quadraLine[0][0] = 1;
        quadraLine[1][0] = 1;
        quadraLine[2][0] = 1;
        quadraLine[3][0] = 1;

        player1[4] = new Pieces(330,100, quadraLine);

        int quadraL[][] = new int [5][3];
        for(int row = 0; row<5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                quadraL[row][col] = 0;
            }
        }
        quadraL[0][0] = 1;
        quadraL[1][0] = 1;
        quadraL[2][0] = 1;
        quadraL[2][1] = 1;

        player1[5] = new Pieces(380,100, quadraL);

        int quadra7[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                quadra7[row][col] = 0;
            }
        }
        quadra7[0][0] = 1;
        quadra7[1][0] = 1;
        quadra7[2][0] = 1;
        quadra7[1][1] = 1;

        player1[6] = new Pieces(460,100, quadra7);

        int quadraSquare[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                quadraSquare[row][col] = 0;
            }
        }
        quadraSquare[0][0] = 1;
        quadraSquare[1][0] = 1;
        quadraSquare[0][1] = 1;
        quadraSquare[1][1] = 1;

        player1[7] = new Pieces(540,100, quadraSquare);

        int quadraZ[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                quadraZ[row][col] = 0;
            }
        }
        quadraZ[0][0] = 1;
        quadraZ[0][1] = 1;
        quadraZ[1][1] = 1;
        quadraZ[1][2] = 1;

        player1[8] = new Pieces(620,100, quadraZ);

        int pentaLine[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaLine[row][col] = 0;
            }
        }
        pentaLine[0][0] = 1;
        pentaLine[1][0] = 1;
        pentaLine[2][0] = 1;
        pentaLine[3][0] = 1;
        pentaLine[4][0] = 1;

        player1[9] = new Pieces(730,100, pentaLine);

        int pentaLongL[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaLongL[row][col] = 0;
            }
        }
        pentaLongL[1][0] = 1;
        pentaLongL[2][0] = 1;
        pentaLongL[3][0] = 1;
        pentaLongL[4][0] = 1;
        pentaLongL[4][1] = 1;

        player1[10] = new Pieces(780,100, pentaLongL);

        int penta23[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                penta23[row][col] = 0;
            }
        }
        penta23[0][0] = 1;
        penta23[1][0] = 1;
        penta23[2][0] = 1;
        penta23[2][1] = 1;
        penta23[3][1] = 1;

        player1[11] = new Pieces(860,100, penta23);

        int pentaSquare[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaSquare[row][col] = 0;
            }
        }
        pentaSquare[0][0] = 1;
        pentaSquare[1][0] = 1;
        pentaSquare[2][0] = 1;
        pentaSquare[1][1] = 1;
        pentaSquare[2][1] = 1;

        player1[12] = new Pieces(940,100, pentaSquare);

        int pentaC[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaC[row][col] = 0;
            }
        }
        pentaC[0][0] = 1;
        pentaC[1][0] = 1;
        pentaC[2][0] = 1;
        pentaC[0][1] = 1;
        pentaC[2][1] = 1;

        player1[13] = new Pieces(100,270, pentaC);

        int penta7[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                penta7[row][col] = 0;
            }
        }
        penta7[0][0] = 1;
        penta7[1][0] = 1;
        penta7[2][0] = 1;
        penta7[3][0] = 1;
        penta7[1][1] = 1;

        player1[14] = new Pieces(180,270, penta7);

        int pentaT[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaT[row][col] = 0;
            }
        }
        pentaT[0][0] = 1;
        pentaT[0][1] = 1;
        pentaT[0][2] = 1;
        pentaT[1][1] = 1;
        pentaT[2][1] = 1;

        player1[15] = new Pieces(260,270, pentaT);

        int pentaL[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaL[row][col] = 0;
            }
        }
        pentaL[0][0] = 1;
        pentaL[1][0] = 1;
        pentaL[2][0] = 1;
        pentaL[2][1] = 1;
        pentaL[2][2] = 1;

        player1[16] = new Pieces(370,270, pentaL);

        int pentaM[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaM[row][col] = 0;
            }
        }
        pentaM[0][0] = 1;
        pentaM[0][1] = 1;
        pentaM[1][1] = 1;
        pentaM[1][2] = 1;
        pentaM[2][2] = 1;

        player1[17] = new Pieces(480,270, pentaM);

        int pentaS[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaS[row][col] = 0;
            }
        }
        pentaS[0][0] = 1;
        pentaS[1][0] = 1;
        pentaS[1][1] = 1;
        pentaS[1][2] = 1;
        pentaS[2][2] = 1;

        player1[18] = new Pieces(590,270, pentaS);

        int pentaTilt[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaTilt[row][col] = 0;
            }
        }
        pentaTilt[0][0] = 1;
        pentaTilt[1][0] = 1;
        pentaTilt[1][1] = 1;
        pentaTilt[1][2] = 1;
        pentaTilt[2][1] = 1;

        player1[19] = new Pieces(700,270, pentaTilt);

        int pentaPlus[][] = new int [5][3];
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col<3; col++)
            {
                pentaPlus[row][col] = 0;
            }
        }
        pentaPlus[0][1] = 1;
        pentaPlus[1][0] = 1;
        pentaPlus[1][1] = 1;
        pentaPlus[1][2] = 1;
        pentaPlus[2][1] = 1;

        player1[20] = new Pieces(810,270, pentaPlus);


    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,2000,1500);
        drawGrid(g,x,y);

    }

    public void drawGrid(Graphics g, int x, int y)
    {
        g.setColor(Color.GRAY);
        //head
        /*g.drawOval(300 + x,100,100,100);
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
        g.fillRect(360 + x,390,30,80);*/

        //shoes
        /*g.fillRect(300 + x,470,50,20);
        g.fillRect(360 + x,470,50,20);*/


        // name
        /*g.setFont(new Font ("Arial", Font.BOLD, 20));
        g.drawString("BOB", 200 + x,100);*/
        for(int t = 0; t< 14; t++)
        {
            for(int s = 0; s<14; s++)
            {
                //grid[t][s] = new GridRects(700+35*t,200+35*s,30,30,0);
                grid[t][s].drawRect(g);
            }
        }
        for(int t = 0; t<player1.length; t++) {
            player1[t].drawPiece(g);
        }
        //g.setColor(Color.BLACK);
    }

    class Pieces
    {
        ArrayList<Rectangle> border = new ArrayList<Rectangle>();
        int [][] pieceIndex = new int[5][3];
        int midXcoor, midYcoor = 0;

        public Pieces(int x, int y, int [][] fromPlayer)
        {
            midXcoor = x;
            midYcoor = y;
            for(int a = 0; a<5; a++)
            {
                for(int b = 0; b<3; b++)
                {
                    pieceIndex[a][b] = fromPlayer[a][b];
                }
            }
        }

        public void drawPiece(Graphics g)
        {
            g.setColor(Color.blue);
            for(int a = 0; a<5; a++)
            {
                for(int b = 0; b<3; b++)
                {
                    if(pieceIndex[a][b] >0)
                    {
                        g.fillRect(midXcoor-30*(1-b),midYcoor-30*(2-a),30,30);
                    }
                }
            }
        }
    }

    class GridRects
    {
        int xcoor, ycoor, width, height;
        int color;
        Rectangle rect;
        GridRects (int x, int y, int w, int h, int c)
        {
            xcoor = x;
            ycoor = y;
            width = w;
            height = h;
            color = c;
            rect = new Rectangle(xcoor,ycoor,width,height);
        }

        public void drawRect(Graphics g)
        {
            g.setColor(Color.gray);
            if(color == 1)
            {
                g.setColor(Color.blue);
            }
            if(color == 2)
            {
                g.setColor(Color.red);
            }
            g.fillRect(xcoor,ycoor,width,height);
        }

    }
    public int[] getSquareIndex(int mouseX, int mouseY)
    {
        int realX = mouseX;
        int realY = mouseY-30;
        if(realX<1200 || realY<400 || realX>1620 || realY>820)
        {
            System.out.println("RealX: "+realX+" RealY: "+realY);
            return new int[] {-1,-1};
        }
        else
        {
            System.out.println("RealX: "+realX+" RealY: "+realY);
            return new int[] {(realX-1200)/30,(realY-400)/30};
        }
    }

    public void mousePressed(MouseEvent e)
    {
        // do some action to distinguish from other methods
        //setBackground(Color.red);
        picked = MouseInfo.getPointerInfo().getLocation();
        int[] squareToChange = getSquareIndex(picked.x, picked.y);
        System.out.println("X: "+squareToChange[0] + " Y: "+squareToChange[1]);
        if(squareToChange[0] > -1 && squareToChange[1] > -1) {
            grid[squareToChange[0]][squareToChange[1]].color = 1;
        }
        System.out.println("Xcoor = "+picked.x);
        System.out.println("Ycoor = "+picked.y);
    }
    public void mouseReleased(MouseEvent e)
    {
        //setBackground(Color.blue);
        released = MouseInfo.getPointerInfo().getLocation();
        int[] squareToChange = getSquareIndex(released.x, released.y);
        if(squareToChange[0] > -1 && squareToChange[1] > -1) {
            grid[squareToChange[0]][squareToChange[1]].color = 0;
        }
        System.out.println(picked.y);
    }
    public void mouseClicked(MouseEvent e)
    {
        //setBackground(Color.green);
        System.out.println("Mouse is Clicked");
    }
    public void mouseEntered(MouseEvent e)
    {
        //setBackground(Color.cyan);
        System.out.println("Mouse is Entered");
    }
    public void mouseExited(MouseEvent e)
    {
        //setBackground(Color.magenta);
        System.out.println("Mouse is Exited");
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

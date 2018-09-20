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
    Player player1, player2; //change
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

        player1 = new Player(0); //change
        player2 = new Player(1); //change
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

        for(int t = 0; t< 14; t++)
        {
            for(int s = 0; s<14; s++)
            {
                //grid[t][s] = new GridRects(700+35*t,200+35*s,30,30,0);
                grid[t][s].drawRect(g);
            }
        }

        g.setColor(Color.WHITE);
        for(int row = 1; row<14; row++){
            g.drawLine(1200, 400+row*30, 1620, 400+row*30);
        }
        for(int col = 0; col<14; col++){
            g.drawLine(1230+col*30, 400, 1230+col*30,820);
        }

        player1.drawPlayerPieces(g); //change
        player2.drawPlayerPieces(g); //change
    }
        //g.setColor(Color.BLACK)

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
        { //change
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

    class Player { //change to the end of the class
        int playerNum, score, piecePicked;
        Pieces[] playerPieces;

        public Player(int a) {
            playerNum = a;
            playerPieces = new Pieces[21];
            createPieces();
        }

        private void createPieces() {
            int singleLine[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    singleLine[row][col] = 0;
                }
            }
            singleLine[0][0] = 1;

            playerPieces[0] = new Pieces(100, 100+500*playerNum, singleLine);

            int doubleLine[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    doubleLine[row][col] = 0;
                }
            }
            doubleLine[0][0] = 1;
            doubleLine[1][0] = 1;

            playerPieces[1] = new Pieces(150, 100+500*playerNum, doubleLine);

            int tripleLine[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    tripleLine[row][col] = 0;
                }
            }
            tripleLine[0][0] = 1;
            tripleLine[1][0] = 1;
            tripleLine[2][0] = 1;

            playerPieces[2] = new Pieces(200, 100+500*playerNum, tripleLine);

            int tripleL[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    tripleL[row][col] = 0;
                }
            }
            tripleL[0][0] = 1;
            tripleL[0][1] = 1;
            tripleL[1][0] = 1;

            playerPieces[3] = new Pieces(250, 100+500*playerNum, tripleL);

            int quadraLine[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    quadraLine[row][col] = 0;
                }
            }
            quadraLine[0][0] = 1;
            quadraLine[1][0] = 1;
            quadraLine[2][0] = 1;
            quadraLine[3][0] = 1;

            playerPieces[4] = new Pieces(330, 100+500*playerNum, quadraLine);

            int quadraL[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    quadraL[row][col] = 0;
                }
            }
            quadraL[0][0] = 1;
            quadraL[1][0] = 1;
            quadraL[2][0] = 1;
            quadraL[2][1] = 1;

            playerPieces[5] = new Pieces(380, 100+500*playerNum, quadraL);

            int quadra7[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    quadra7[row][col] = 0;
                }
            }
            quadra7[0][0] = 1;
            quadra7[1][0] = 1;
            quadra7[2][0] = 1;
            quadra7[1][1] = 1;

            playerPieces[6] = new Pieces(460, 100+500*playerNum, quadra7);

            int quadraSquare[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    quadraSquare[row][col] = 0;
                }
            }
            quadraSquare[0][0] = 1;
            quadraSquare[1][0] = 1;
            quadraSquare[0][1] = 1;
            quadraSquare[1][1] = 1;

            playerPieces[7] = new Pieces(540, 100+500*playerNum, quadraSquare);

            int quadraZ[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    quadraZ[row][col] = 0;
                }
            }
            quadraZ[0][0] = 1;
            quadraZ[0][1] = 1;
            quadraZ[1][1] = 1;
            quadraZ[1][2] = 1;

            playerPieces[8] = new Pieces(620, 100+500*playerNum, quadraZ);

            int pentaLine[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaLine[row][col] = 0;
                }
            }
            pentaLine[0][0] = 1;
            pentaLine[1][0] = 1;
            pentaLine[2][0] = 1;
            pentaLine[3][0] = 1;
            pentaLine[4][0] = 1;

            playerPieces[9] = new Pieces(730, 100+500*playerNum, pentaLine);

            int pentaLongL[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaLongL[row][col] = 0;
                }
            }
            pentaLongL[1][0] = 1;
            pentaLongL[2][0] = 1;
            pentaLongL[3][0] = 1;
            pentaLongL[4][0] = 1;
            pentaLongL[4][1] = 1;

            playerPieces[10] = new Pieces(780, 100+500*playerNum, pentaLongL);

            int penta23[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    penta23[row][col] = 0;
                }
            }
            penta23[0][0] = 1;
            penta23[1][0] = 1;
            penta23[2][0] = 1;
            penta23[2][1] = 1;
            penta23[3][1] = 1;

            playerPieces[11] = new Pieces(860, 100+500*playerNum, penta23);

            int pentaSquare[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaSquare[row][col] = 0;
                }
            }
            pentaSquare[0][0] = 1;
            pentaSquare[1][0] = 1;
            pentaSquare[2][0] = 1;
            pentaSquare[1][1] = 1;
            pentaSquare[2][1] = 1;

            playerPieces[12] = new Pieces(940, 100+500*playerNum, pentaSquare);

            int pentaC[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaC[row][col] = 0;
                }
            }
            pentaC[0][0] = 1;
            pentaC[1][0] = 1;
            pentaC[2][0] = 1;
            pentaC[0][1] = 1;
            pentaC[2][1] = 1;

            playerPieces[13] = new Pieces(100, 270+500*playerNum, pentaC);

            int penta7[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    penta7[row][col] = 0;
                }
            }
            penta7[0][0] = 1;
            penta7[1][0] = 1;
            penta7[2][0] = 1;
            penta7[3][0] = 1;
            penta7[1][1] = 1;

            playerPieces[14] = new Pieces(180, 270+500*playerNum, penta7);

            int pentaT[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaT[row][col] = 0;
                }
            }
            pentaT[0][0] = 1;
            pentaT[0][1] = 1;
            pentaT[0][2] = 1;
            pentaT[1][1] = 1;
            pentaT[2][1] = 1;

            playerPieces[15] = new Pieces(260, 270+500*playerNum, pentaT);

            int pentaL[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaL[row][col] = 0;
                }
            }
            pentaL[0][0] = 1;
            pentaL[1][0] = 1;
            pentaL[2][0] = 1;
            pentaL[2][1] = 1;
            pentaL[2][2] = 1;

            playerPieces[16] = new Pieces(370, 270+500*playerNum, pentaL);

            int pentaM[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaM[row][col] = 0;
                }
            }
            pentaM[0][0] = 1;
            pentaM[0][1] = 1;
            pentaM[1][1] = 1;
            pentaM[1][2] = 1;
            pentaM[2][2] = 1;

            playerPieces[17] = new Pieces(480, 270+500*playerNum, pentaM);

            int pentaS[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaS[row][col] = 0;
                }
            }
            pentaS[0][0] = 1;
            pentaS[1][0] = 1;
            pentaS[1][1] = 1;
            pentaS[1][2] = 1;
            pentaS[2][2] = 1;

            playerPieces[18] = new Pieces(590, 270+500*playerNum, pentaS);

            int pentaTilt[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaTilt[row][col] = 0;
                }
            }
            pentaTilt[0][0] = 1;
            pentaTilt[1][0] = 1;
            pentaTilt[1][1] = 1;
            pentaTilt[1][2] = 1;
            pentaTilt[2][1] = 1;

            playerPieces[19] = new Pieces(700, 270+500*playerNum, pentaTilt);

            int pentaPlus[][] = new int[5][3];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    pentaPlus[row][col] = 0;
                }
            }
            pentaPlus[0][1] = 1;
            pentaPlus[1][0] = 1;
            pentaPlus[1][1] = 1;
            pentaPlus[1][2] = 1;
            pentaPlus[2][1] = 1;

            playerPieces[20] = new Pieces(810, 270+500*playerNum, pentaPlus);
        }

        public void drawPlayerPieces(Graphics g) {
            if (playerNum == 0) {
                g.setColor(Color.blue);
            } else if (playerNum == 1) {
                g.setColor(Color.red);
            }
            for (int i = 0; i < playerPieces.length; i++) {
                playerPieces[i].drawPiece(g);
            }

        }

    } // end of changes

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


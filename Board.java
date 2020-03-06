import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board
{
    Square[][] squares;
    JButton[][] buttons;
    GridLayout grid;
    JFrame frame;
    JPanel panel;

    public Board()
    {
        grid = new GridLayout(5, 5);
        frame = new JFrame("Hoppers");
        panel = new JPanel();
        frame.setSize(760, 760);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(grid);
        squares = new Square[5][5];
        buttons = new JButton[5][5];

        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                squares[x][y] = new Square(x, y, ((5*y)+x+1)%2);
                buttons[x][y] = new JButton(squares[x][y].getImage());
                buttons[x][y].setIcon(squares[x][y].getImage());
                panel.add(buttons[x][y]);
            }
        }

        changeImage(2,2,2);
        changeImage(4,2,2);
        changeImage(3,3,2);
        changeImage(1,5,2);
        changeImage(3,5,4);
        changeImage(5,5,2);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }


    /**
    *method changes square object and its button representation
    *@param imageType must be between 0 and 5 inclusive
    */
    private void changeImage(int x, int y, int imageType){
        squares[x-1][y-1].setImage(imageType);
        buttons[x-1][y-1].setIcon(squares[x-1][y-1].getImage());
    }
}
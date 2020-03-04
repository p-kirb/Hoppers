import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board
{
    public Board()
    {
        GridLayout grid = new GridLayout(5, 5);
        JFrame frame = new JFrame("Hoppers");
        JPanel panel = new JPanel();
        frame.setSize(760, 760);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(grid);  
        Square[][] squares = new Square[5][5];
        JButton[][] buttons = new JButton[5][5];

        ImageIcon i = new ImageIcon("resources/Water.png");

        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                squares[x][y] = new Square(x, y);
                buttons[x][y] = new JButton(i);
                buttons[x][y].setIcon(i);
                panel.add(buttons[x][y]);
            }
        }
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
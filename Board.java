import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    Square[][] squares;
    JButton[][] buttons;
    GridLayout grid;
    JFrame frame;
    JPanel panel;
    Square selected;

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
                buttons[x][y].addActionListener(this);
                panel.add(buttons[x][y]);
            }
        }
        changeImage(1,1,2);
        changeImage(3,1,2);
        changeImage(2,2,2);
        changeImage(0,4,2);
        changeImage(2,4,4);
        changeImage(4,4,2);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    /**
    *method changes square object and its button representation
    *@param imageType must be between 0 and 5 inclusive
    */
    public void changeImage(int x, int y, int imageType){
        squares[x][y].setImage(imageType);
        buttons[x][y].setIcon(squares[x][y].getImage());
    }

    /**
    *loops through buttons array and sets the icon to the icon of the image
    */
    public void update(){
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                buttons[x][y].setIcon(squares[x][y].getImage());
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        //System.out.println(selected.getX()+ ","+ selected.getY());
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                if(e.getSource() == buttons[x][y]){
                    if (squares[x][y].getImageValue() == 0){
                        return;
                    }
                    if (selected == null){
                        if(squares[x][y].getImageValue() == 1){
                            return;
                        }
                        selected = squares[x][y];
                        selected.setImage(selected.getImageValue()+1);
                        update();
                        return;
                    }
                    //swaps values
                    selected.setImage(selected.getImageValue()-1);
                    selected.moveTo(squares[x][y]);
                    selected = null;
                    update();
                    return;
                }
            }
        }
    }
}
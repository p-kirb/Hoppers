import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class Board implements ActionListener
{
    Square[][] squares;
    JButton[][] buttons;
    GridLayout grid;
    JFrame frame;
    JPanel panel;
    Square selected;
    Date start;
    Date end;
    
    public Board(int levelNo)
    {
        grid = new GridLayout(5, 5);
        frame = new JFrame("Hoppers - Level " + levelNo);
        panel = new JPanel();
        frame.setSize(760, 760);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(grid);
        squares = new Square[5][5];
        buttons = new JButton[5][5];

        //had to be in a try catch block because otherwise
        //errors when compiling saying Exceptions need to be
        //caught
        char[] level = new char[13];
        String line = "init";
        try{
            BufferedReader reader = new BufferedReader(new FileReader("resources/levels.txt"));
            for (int i = 0; i < levelNo; i++){  //reads each line into buffer "line" variable
                line = reader.readLine();       //stops when levelNo is reached
            }
            level = line.toCharArray();
        }
        catch(Exception e){
        }
        int count = 0;
        int x, y;
        for (int i = 0; i < 25; i++)
        {
            x = i%5;
            y = (i/5);
            if(i%2==0){
                squares[x][y] = new Square(x, y, (Character.getNumericValue(level[count])));
                count++;
            }
            else{
                squares[x][y] = new Square(x, y, 0);
            }
            buttons[x][y] = new JButton(squares[x][y].getImage());
            buttons[x][y].setIcon(squares[x][y].getImage());
            buttons[x][y].addActionListener(this);
            panel.add(buttons[x][y]);
        }
        frame.setContentPane(panel);
        frame.setVisible(true);
        start = new Date();
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
    *and also displays win if game is won
    */
    public void update(){
        boolean green = false;
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                buttons[x][y].setIcon(squares[x][y].getImage());
                if (squares[x][y].getImageValue() == 2){green = true;}
            }
        }
        if (!green){
            end = new Date();
            long time = (end.getTime() - start.getTime()) / 1000;
            String message = "You won! It took you " + time + " seconds.";
            JOptionPane.showMessageDialog(frame, message);
            }
    }

    /**
    *removes the frog found in between the jumping frog and the target
    *@return true if a green frog has been jumped (i.e. valid move made), false otherwise
    */
    public boolean removeJumped(Square sq1, Square sq2){
        int avgX = (sq1.getX() + sq2.getX()) / 2;
        int avgY = (sq1.getY() + sq2.getY()) / 2;
        if (squares[avgX][avgY].getImageValue() == 2){
            changeImage(avgX, avgY, 1);
            return true;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e)
    {
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                if(e.getSource() == buttons[x][y]){
                    if (squares[x][y].getImageValue() == 0){
                        if (selected != null){
                            selected.setImage(selected.getImageValue()-1);
                            selected = null;
                            update();
                        }
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
                    if(removeJumped(squares[x][y], selected)){
                        selected.setImage(selected.getImageValue()-1);
                        selected.moveTo(squares[x][y]);
                        selected = null;
                    }
                    update();
                    return;
                }
            }
        }
    }

}
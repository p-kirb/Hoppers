import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu implements ActionListener
{
    JFrame frame;
    JPanel panel;
    //JLabel text;
    JComboBox options;
    JButton button;
    BorderLayout border;
    public Menu()
    {
        frame = new JFrame("Hoppers");
        panel = new JPanel();
        border = new BorderLayout(0, 20);   //arguments are horizontal and vertical gap size respectively (in px)
        frame.setSize(300, 150);
        frame.setResizable(false);
        panel.setLayout(border);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Please select a level", SwingConstants.CENTER);  //second argument center aligns text
        panel.add(text, border.NORTH);
        options = new JComboBox();          //dropdown list
        for (int i = 1; i < 41; i++){
            options.addItem(i);             //causes warning about unsafe operations when compiling but is working
        }
        panel.add(options, border.CENTER);
        button = new JButton("OK");
        button.addActionListener(this);
        panel.add(button, border.SOUTH);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        int choice = (int)options.getSelectedItem();    //gets item from drop down list and converts to an int
        Board board = new Board(choice);
        frame.dispose();
    }

}
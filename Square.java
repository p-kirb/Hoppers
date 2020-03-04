import javax.swing.*;

public class Square
{
    private int x, y;
    ImageIcon image;
    private boolean greenFrog = false;
    private boolean redFrog = false;
    private boolean pad = false;
    private boolean water = false;
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
        //setImage(opt);
    }
/*
    public void setImage(String opt)
    {
        switch (opt){
            case "greenfrog": image = new ImageIcon("resources/GreenFrog.png"));
                greenFrog = true
            break;
            case "redfrog": image = ImageIcon("resources/RedFrog.png"));
            break;
            case "pad": image = ImageIcon("resources/LilyPad.png"));
            break;
            default: image = ImageIcon("resources/Water.png"));
        }
    }
*/
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
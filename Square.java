import javax.swing.*;

public class Square
{
    private int x, y;
    private static ImageIcon[] images = {
    new ImageIcon("resources/Water.png"),
    new ImageIcon("resources/LilyPad.png"),
    new ImageIcon("resources/GreenFrog.png"),
    new ImageIcon("resources/GreenFrog2.png"),
    new ImageIcon("resources/RedFrog.png"),
    new ImageIcon("resources/RedFrog2.png")
    };



    /**
    * squaretype represents the image: 0 = water,
    * 1 = pad, 2 = greenfrog, 3 = greenfrog2,
    * 4 = redfrog, 5 = redfrog2
    */
    private int imageValue;
    public Square(int x, int y, int type)
    {
        this.x = x;
        this.y = y;
        imageValue = type;
    }


    public void moveTo(Square alt)
    {

    }

    /**
    * Changes image value
    * @param opt value can only be 0-3 inclusive
    */
    public void setImage(int opt)
    {
        imageValue = opt;
    }

    /**
    * Returns image
    */
    public ImageIcon getImage()
    {
        return images[imageValue];
    }

    public int getImageValue()
    {
        return imageValue;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
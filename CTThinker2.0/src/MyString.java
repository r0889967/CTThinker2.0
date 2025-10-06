import java.awt.*;

public class MyString {
    private final Color color;
    private final String text;
    private final int textSize;
    private final int x;
    private final int y;

    MyString(Color color,String text,int textSize,int x,int y){
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.setFont(new Font("Times New Roman",Font.PLAIN,textSize));
        g.drawString(text,x,y);
    }
}

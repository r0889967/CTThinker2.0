import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MyString {
    private Color color = Color.BLACK;
    private final String text;
    private int textSize = 20;
    private final int x;
    private final int y;

    MyString(Color color,String text,int textSize,int x,int y){
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
    }

    MyString(String text,int textSize,int x,int y){
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
    }

    MyString(String text,int x,int y){
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.setFont(new Font("Times New Roman",Font.PLAIN,textSize));
        g.drawString(text,x,y);
    }
}

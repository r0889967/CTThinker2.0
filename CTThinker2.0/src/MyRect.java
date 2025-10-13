import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MyRect {
    private Color color = Color.lightGray;
    private String text;
    private final int textSize;
    private boolean dragable = false;
    private boolean markable = false;
    private int x;
    private int y;
    private final int width;
    private final int height;
    private boolean marked = false;
    private Runnable function = ()->{};

    MyRect(Color color,String text,int textSize,boolean dragable,boolean markable,int x, int y, int width, int height,Runnable function) {
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.dragable = dragable;
        this.markable = markable;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.function = function;
    }

    MyRect(Color color,String text,int textSize,int x, int y, int width, int height,Runnable function) {
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.function = function;
    }

    MyRect(Color color,String text,int textSize,boolean markable,int x, int y, int width, int height) {
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.markable = markable;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    MyRect(String text,int textSize,boolean markable,int x, int y, int width, int height) {
        this.text = text;
        this.textSize = textSize;
        this.markable = markable;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    MyRect(String text,int textSize,int x, int y, int width, int height) {
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    MyRect(String text,int textSize,int x, int y, boolean dragable,int width, int height) {
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
        this.dragable = dragable;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        if (marked){
            g.setColor(Color.cyan);
            g.fillRect(x-15,y-15,width+30,height+30);
        }
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.PLAIN,textSize));
        g.drawString(text, x, y+textSize);
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void toggleMarked() {
        if(markable) {
            marked = !marked;
        }
    }

    public boolean isMarked() {
        return marked;
    }

    public void drag(int newx, int newy) {
        if (dragable) {
            x = newx - this.width/2;
            y = newy - this.height/2;
            if (x<0){
                x = 0;
            }
            if(x>1200-width){
                x = 1200-width;
            }
            if (y<0){
                y = 0;
            }
            if(y>800-height){
                y = 800-height;
            }
        }
    }

    public void executeFunction(){
        function.run();
    }
}

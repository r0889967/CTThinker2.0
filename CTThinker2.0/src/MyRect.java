import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MyRect {
    private Color color = Color.lightGray;
    private final String text;
    private final int textSize;
    private boolean dragable = false;
    private boolean markable = false;
    private int x;
    private int y;
    private final int width;
    private final int height;
    private boolean marked = false;
    private Runnable function = ()->{};
    private boolean locked = false;

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

    MyRect(Color color,String text,int textSize,int x, int y, int width, int height,Runnable function,boolean locked) {
        this.color = color;
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.function = function;
        this.locked = locked;
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
            x = newx - 35;
            y = newy - 35;
        }
    }

    public void executeFunction(){
        function.run();
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        System.out.println("unlocked");
        locked = false;
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    protected final ArrayList<MyRect> buttons;
    protected final ArrayList<MyString> texts;
    private final int width = 1200;
    private final int height = 800;

    MyPanel(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        this.setSize(width,height);
        this.buttons = buttons;
        this.texts = texts;
        this.setFocusable(true);
        this.addMouseListener(new MyMouseListener(this,buttons));
        this.addMouseMotionListener(new MyMouseMotionListener(this,buttons));

    }

    public void addText(Color color,String text,int textSize,int x,int y){
        this.texts.add(new MyString(color,text,textSize,x,y));
    }

    public void addText(String text,int textSize,int x,int y){
        this.texts.add(new MyString(text,textSize,x,y));
    }

    public void addText(String text,int x,int y){
        this.texts.add(new MyString(text,x,y));
    }

    public void addButton(Color color,String text,int textSize,int x, int y, int width, int height,Runnable function){
        this.buttons.add(new MyRect(color,text,textSize,x,y,width,height,function));
    }

    public void addButton(Color color,String text,int textSize,boolean markable,int x, int y, int width, int height){
        this.buttons.add(new MyRect(color,text,textSize,markable,x,y,width,height));
    }

    public void addButton(String text,int textSize,boolean markable,int x, int y, int width, int height){
        this.buttons.add(new MyRect(text,textSize,markable,x,y,width,height));
    }

    public void addButton(String text,int textSize,int x, int y, int width, int height){
        this.buttons.add(new MyRect(text,textSize,x,y,width,height));
    }

    public void reset(){

    }

    public boolean isAnswerCorrect() {
        return true;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        for (MyRect button : buttons) {
            button.draw(g);
        }
        for (MyString text : texts) {
            text.draw(g);
        }
    }

    @Override
    public void repaint(){
        super.repaint();
    }
}

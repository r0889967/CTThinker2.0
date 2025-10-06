import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    private final ArrayList<MyRect> buttons;
    private final ArrayList<MyString> texts;
    private int width = 1200;
    private int height = 800;

    MyPanel(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        this.setSize(width,height);
        this.buttons = buttons;
        this.texts = texts;
        this.addMouseListener(new MyMouseListener(this,buttons));
        this.addMouseMotionListener(new MyMouseMotionListener(this,buttons));
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

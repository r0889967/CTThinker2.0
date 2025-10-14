import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
    }

    public void addText(String text,int textSize,int x,int y){
        this.texts.add(new MyString(text,textSize,x,y));
    }

    public void addTextsToLevel(String path,int textsize,int x_offset,int y_offset,int spacing) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            this.addText(text,textsize,x_offset,y_offset+i*spacing);
            i++;
        }
    }

    public void addButton(Color color,String text,int textSize,int x, int y, int width, int height,Runnable function){
        this.buttons.add(new MyRect(color,text,textSize,x,y,width,height,function));
    }

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

    public void repaint(){
        super.repaint();
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class MyPanel extends JPanel {
    private final ArrayList<MyRect> buttons;
    private final ArrayList<MyString> texts;
    private ArrayList<MyRect> answers = new ArrayList<>();
    private boolean checksAnswer = false;
    private int width = 1200;
    private int height = 800;

    MyPanel(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        this.setSize(width,height);
        this.buttons = buttons;
        this.texts = texts;
        this.addMouseListener(new MyMouseListener(this,buttons));
        this.addMouseMotionListener(new MyMouseMotionListener(this,buttons));
    }

    MyPanel(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<MyRect> answers) {
        this.setSize(width,height);
        this.buttons = buttons;
        this.texts = texts;
        this.answers = answers;
        this.checksAnswer = true;
        this.addMouseListener(new MyMouseListener(this,buttons));
        this.addMouseMotionListener(new MyMouseMotionListener(this,buttons));
    }

    public boolean isAnswerCorrect() {
        ArrayList<MyRect> marked = new ArrayList<>();
        for (MyRect button : buttons) {
            if (button.isMarked()) {
                marked.add(button);
            }
        }
        return marked.equals(answers);
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
        if(checksAnswer && isAnswerCorrect()){
            MyString correctAnswer = new MyString(Color.green,"The answer is correct",30,550,730);
            correctAnswer.draw(g);
        }

    }

    @Override
    public void repaint(){
        super.repaint();
    }
}

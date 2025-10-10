import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelPanelTypeB extends MyPanel {
    private String answer = "";

    LevelPanelTypeB(ArrayList<MyRect> buttons, ArrayList<MyString> texts, String answer) {
        super(buttons, texts);
        this.answer = answer;
        this.addKeyListener(new MyKeyListener(this,buttons.get(2)));
    }

    public boolean isAnswerCorrect() {
        return buttons.get(2).getText().equals(answer);
    }

    public void reset(){
        buttons.get(2).setText("");
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(isAnswerCorrect()){
            MyString correctAnswer = new MyString(Color.green,"The answer is correct, you may proceed to the next level.",30,300,730);
            correctAnswer.draw(g);
        }else{
            g.setColor(Color.black);
            g.fillRect(1050,700,150,60);
        }
    }
}

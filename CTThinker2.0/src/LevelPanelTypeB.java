import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelPanelTypeB extends MyPanel {
    private String answer;

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

    private void addAnswer(String answer) {
        this.answer = answer;
    }

    public void addSimpleAnswer(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = scanner.nextLine();
        this.addAnswer(text);
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

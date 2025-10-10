import java.awt.*;
import java.util.ArrayList;

public class LevelPanelTypeA extends MyPanel{
    private ArrayList<Integer> answers = new ArrayList<>();

    LevelPanelTypeA(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<Integer> answers) {
        super(buttons, texts);
        this.answers = answers;
    }

    public boolean isAnswerCorrect() {
        for (int i=2;i<this.buttons.size();i++) {
            if (buttons.get(i).isMarked()) {
                if (!answers.contains(i-2)){
                    return false;
                }
            }else{
                if(answers.contains(i-2)){
                    return false;
                }
            }
        }
        return true;
    }

    public void addAnswer(int answerIdx){
        this.answers.add(answerIdx);
    }

    public void reset(){
        for (MyRect button : this.buttons) {
            if (button.isMarked()) {
                button.toggleMarked();
            }
        }
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

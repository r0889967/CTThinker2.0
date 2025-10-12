import java.awt.*;
import java.util.ArrayList;

public class LevelPanelTypeC extends MyPanel{
    private ArrayList<Integer> answer;


    LevelPanelTypeC(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<Integer> answer) {
        super(buttons, texts);
        this.answer = answer;
    }

    public boolean isAnswerCorrect() {
        for(int i = 1; i < answer.size(); i++) {
            System.out.println(answer.size());
            if(buttons.get(answer.get(i)+2).getX()<buttons.get(answer.get(i-1)+2).getX()) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public void reset(){
    }

    public void addAnswer(int buttonSeqNum) {
        answer.add(buttonSeqNum);
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

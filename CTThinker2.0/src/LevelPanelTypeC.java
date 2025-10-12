import java.awt.*;
import java.util.ArrayList;

public class LevelPanelTypeC extends MyPanel{
    private ArrayList<Integer> answer;


    LevelPanelTypeC(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<Integer> answer) {
        super(buttons, texts);
        this.answer = answer;
    }

    public boolean isAnswerCorrect() {
        for(int i = 3; i < answer.size(); i++) {
            if(buttons.get(answer.get(i-2)).getX()<buttons.get(answer.get(i-3)).getX()) {
                return false;
            }
        }
        return true;
    }

    public void reset(){

    }

    public void addAnswer(int index,int buttonSeqNum) {
        int n = answer.size();
        if(n<index){
            answer.add(n,buttonSeqNum);
        }else{
            answer.add(index,buttonSeqNum);
        }
        System.out.println(answer);
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

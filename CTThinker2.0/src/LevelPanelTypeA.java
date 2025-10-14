import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelPanelTypeA extends LevelPanel{
    private final ArrayList<Integer> answers;

    LevelPanelTypeA(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<Integer> answers) {
        super(buttons, texts);
        this.answers = answers;
    }

    public void addButton(String text,int textSize,boolean markable,int x, int y, int width, int height){
        this.buttons.add(new MyRect(text,textSize,markable,x,y,width,height));
    }

    public void addButton(Color color,String text,int textSize,boolean markable,int x, int y, int width, int height){
        this.buttons.add(new MyRect(color,text,textSize,markable,x,y,width,height));
    }

    public void addOptionButtonsToLevelHorizontal(String path, int x_offset, int y_offset, int spacing, int b_width, int b_height) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.charAt(text.length()-1)=='*') {
                this.addButton(text.substring(0,text.length()-1), 20, true, x_offset + i * spacing, y_offset, b_width, b_height);
                this.addAnswer(i);
            }else{
                this.addButton(text, 20, true, x_offset + i * spacing, y_offset, b_width, b_height);
            }
            i++;
        }
    }

    public void addOptionButtonsToLevelVertical(String path, int x_offset, int y_offset, int spacing, int b_width, int b_height) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.charAt(text.length()-1)=='*') {
                this.addButton(text.substring(0,text.length()-1), 20, true, x_offset, y_offset+ i * spacing, b_width, b_height);
                this.addAnswer(i);
            }else{
                this.addButton(text, 20, true, x_offset, y_offset+ i * spacing, b_width, b_height);
            }
            i++;
        }
    }

    public void addOptionButtonsToLevelCustom(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            String[] text_splits = text.split("-");
            Color color;
            if(text_splits[1].equals("g")){
                color = Color.lightGray;
            }else{
                color = Color.white;
            }
            if (text_splits[0].charAt(text_splits[0].length()-1)=='*') {
                this.addButton(color,text_splits[0].substring(0,text_splits[0].length()-1), Integer.parseInt(text_splits[2]), true,
                        Integer.parseInt(text_splits[3]), Integer.parseInt(text_splits[4]), Integer.parseInt(text_splits[5]), Integer.parseInt(text_splits[6]));
                this.addAnswer(i);
            }else{
                this.addButton(color,text_splits[0], Integer.parseInt(text_splits[2]), true,
                        Integer.parseInt(text_splits[3]), Integer.parseInt(text_splits[4]), Integer.parseInt(text_splits[5]), Integer.parseInt(text_splits[6]));
            }
            i++;
        }
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

    public void paint(Graphics g){
        super.paint(g);
        if(isAnswerCorrect()){
            MyString correctAnswer = new MyString(Color.green,"The answer is correct, you may proceed to the next level.",30,300,730);
            correctAnswer.draw(g);
        }else{
            g.setColor(Color.white);
            g.fillRect(1050,700,150,60);
        }
    }


}

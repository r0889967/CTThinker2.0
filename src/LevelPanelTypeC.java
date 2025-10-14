import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelPanelTypeC extends LevelPanel{
    private ArrayList<Integer> correctOrder;
    private ArrayList<int[]> initialPoses = new ArrayList();


    LevelPanelTypeC(ArrayList<MyRect> buttons, ArrayList<MyString> texts, ArrayList<Integer> correctOrder) {
        super(buttons, texts);
        this.correctOrder = correctOrder;
        this.addMouseMotionListener(new MyMouseMotionListener(this,buttons));
    }

    private void addButton(String text,int textSize,int x, int y, boolean dragable,int width, int height){
        this.buttons.add(new MyRect(text,textSize,x,y,dragable,width,height));
    }

    public void addDragableButtonsToLevelH(String path, int x_offset, int y_offset, int spacing, int b_width, int b_height) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = "";
        int i = 0;
        ArrayList<Integer> order = new ArrayList<>();
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            String[] text_split = text.split("-");
            this.addButton(text_split[0], 20, x_offset + i * spacing, y_offset,true, b_width, b_height);
            int[] initialPos = {x_offset + i * spacing, y_offset};
            this.initialPoses.add(initialPos);
            order.add(Integer.parseInt(text_split[1]));
            i++;
        }
        this.addCorrectOrder(order);
    }

    public boolean isAnswerCorrect() {
        for(int i = 1; i < correctOrder.size(); i++) {
            MyRect first = buttons.get(correctOrder.get(i-1)+2);
            MyRect second = buttons.get(correctOrder.get(i)+2);

            if(second.getX()<first.getX()+ first.getWidth()) {
                return false;
            }
        }
        return true;
    }

    public void reset(){
        for(int i=2; i < buttons.size(); i++) {
            int x = initialPoses.get(i-2)[0]+buttons.get(i).getWidth()/2;
            int y = initialPoses.get(i-2)[1]+buttons.get(i).getHeight()/2;
            buttons.get(i).drag(x,y);
        }
    }

    public void addCorrectOrder(ArrayList<Integer> correctOrder) {
        this.correctOrder = correctOrder;
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

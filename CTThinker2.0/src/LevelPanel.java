import java.awt.*;
import java.util.ArrayList;

public class LevelPanel extends MyPanel{
    LevelPanel(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        super(buttons, texts);
    }

    public void reset(){

    }

    public boolean isAnswerCorrect() {
        return true;
    }


}

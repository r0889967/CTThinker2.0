import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    private int width = 1200;
    private int height = 800;
    MyPanel panel;
    ArrayList<MyPanel> panels = new ArrayList<>();

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("CTThinker2.0");
        initializeHomeScreen();
        initializeInfoScreen();
        initializeLevelSelectionScreen();
    }

    private void switchPanel(MyPanel newPanel) {
        this.remove(panel);
        panel = newPanel;
        this.add(panel);
        this.repaint();
    }


    public void initializeHomeScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        MyRect startButton = new MyRect(Color.green,"Start game",30,false,false,
                400,400,150,60,()->switchPanel(panels.get(2)));

        MyRect infoButton = new MyRect(Color.blue,"Info",30,false,false,
                400,500,150,60,()->switchPanel(panels.get(1)));

        MyRect quitButton = new MyRect(Color.red,"Quit game",30,false,false,
                400,600,150,60, this::dispose);

        buttons.add(startButton);buttons.add(infoButton);buttons.add(quitButton);

        ArrayList<MyString> texts = new ArrayList<>();
        MyString welcome1 = new MyString(Color.black,"Welcome to CTThinker2.0",75,0,75);
        MyString welcome2 = new MyString(Color.black,"Great tool to improve your critical thinking skills",30,0,110);

        texts.add(welcome1);texts.add(welcome2);

        panel = new MyPanel(buttons,texts);
        panels.add(panel);
        this.add(panel);
    }

    public void initializeInfoScreen(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        MyRect mainMenuButton = new MyRect(Color.blue,"Main menu",30,false,false,
                24,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

        ArrayList<MyString> texts = new ArrayList<>();
        MyString infoHeader = new MyString(Color.black,"Info about this tool",75,0,75);
        MyString info1 = new MyString(Color.black,"CTThinker2.0 is a tool to teach students important CT skills.",30,0,110);
        MyString info2 = new MyString(Color.black,"There are in total 5 modules with 15 levels each.",30,0,140);
        MyString info3 = new MyString(Color.black,"Module 1 focuses on abstraction.",30,0,170);
        MyString info4 = new MyString(Color.black,"Module 2 focuses on decomposition.",30,0,200);
        MyString info5 = new MyString(Color.black,"Module 3 focuses on pattern regonization.",30,0,230);
        MyString info6 = new MyString(Color.black,"Module 4 focuses on algorithmic thinking.",30,0,260);
        MyString info7 = new MyString(Color.black,"Module 5 combines the 4 previous aspects together.",30,0,290);

        texts.add(infoHeader);
        texts.add(info1);texts.add(info2);texts.add(info3);texts.add(info4);
        texts.add(info5);texts.add(info6);texts.add(info7);

        MyPanel infoPanel = new MyPanel(buttons,texts);
        panels.add(infoPanel);
    }

    public void initializeLevelSelectionScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        MyRect mainMenuButton = new MyRect(Color.blue,"Main menu",30,false,false,
                24,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

        ArrayList<MyString> texts = new ArrayList<>();
        MyString selectALevel = new MyString(Color.black,"Select a level",75,0,75);
        texts.add(selectALevel);

        MyPanel levelSelectionPanel = new MyPanel(buttons,texts);
        panels.add(levelSelectionPanel);

    }


}

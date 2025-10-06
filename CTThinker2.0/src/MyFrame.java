import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    private int width = 1200;
    private int height = 800;
    private MyPanel panel;
    private final ArrayList<MyPanel> panels = new ArrayList<>();
    private int levelNumber = 1;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("CTThinker2.0");
        initializeHomeScreen();
        initializeInfoScreen();
        initializeLevelSelectionScreen();
        initializeLevel1();initializeLevel2();initializeLevel3();initializeLevel4();initializeLevel5();
        initializeLevel6();initializeLevel7();initializeLevel8();initializeLevel9();initializeLevel10();
    }

    private void switchPanel(MyPanel newPanel) {
        this.remove(panel);
        panel = newPanel;
        this.add(panel);
        this.repaint();
    }


    public void initializeHomeScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();


        MyRect startButton = new MyRect(Color.green,"Start game",30,false,false,
                500,400,150,60,()->switchPanel(panels.get(2)));

        MyRect infoButton = new MyRect(Color.orange,"Info",30,false,false,
                500,500,150,60,()->switchPanel(panels.get(1)));

        MyRect quitButton = new MyRect(Color.red,"Quit game",30,false,false,
                500,600,150,60, this::dispose);

        buttons.add(startButton);buttons.add(infoButton);buttons.add(quitButton);

        MyString welcome1 = new MyString(Color.black,"Welcome to CTThinker2.0",75,0,75);
        MyString welcome2 = new MyString(Color.black,"Great tool to improve your critical thinking skills",30,0,110);

        texts.add(welcome1);texts.add(welcome2);

        panel = new MyPanel(buttons,texts);
        panels.add(panel);
        this.add(panel);
    }

    public void initializeInfoScreen(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        MyRect mainMenuButton = new MyRect(Color.orange,"Main menu",30,false,false,
                0,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

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
        ArrayList<MyString> texts = new ArrayList<>();

        MyRect mainMenuButton = new MyRect(Color.orange,"Main menu",30,false,false,
                0,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

        MyString selectALevel = new MyString(Color.black,"Select a level",75,0,75);
        texts.add(selectALevel);

        String[] moduleTitles = {"Abstraction","Decomposition","Pattern regonization","Algorithmic thinking","Mixed"};
        for(int i=0;i<5;i++) {
            for(int j=0;j<15;j++) {
                int finalI = i;
                int finalJ = j;
                MyRect levelButton = new MyRect(new Color(0,162,232),String.valueOf(i*15+j+1),30,false,false,
                        70*j,i*125+115,60,60,()->switchPanel(panels.get(finalI *15+ finalJ +3)));
                buttons.add(levelButton);
            }

            MyString moduleHeader = new MyString(Color.black,"Module "+(i+1)+": "+ moduleTitles[i],30,0,i*125+110);
            texts.add(moduleHeader);
        }

        MyPanel levelSelectionPanel = new MyPanel(buttons,texts);
        panels.add(levelSelectionPanel);
    }

    public void initializeLevelBaseElems(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        MyRect exitButton = new MyRect(Color.red,"Exit level",30,false,false,
                0,700,150,60,()->switchPanel(panels.get(2)));
        buttons.add(exitButton);

        MyString levelName = new MyString(Color.black,"Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }
    
    public void initializeLevel1(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel2(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel3(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel4(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel5(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel6(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel7(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel8(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel9(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel10(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }


}

import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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


        MyRect startButton = new MyRect(Color.green,"Start game",30,
                500,400,150,60,()->switchPanel(panels.get(2)));

        MyRect infoButton = new MyRect(Color.orange,"Info",30,
                500,500,150,60,()->switchPanel(panels.get(1)));

        MyRect quitButton = new MyRect(Color.red,"Quit game",30,
                500,600,150,60, this::dispose);

        buttons.add(startButton);buttons.add(infoButton);buttons.add(quitButton);

        MyString welcome1 = new MyString("Welcome to CTThinker2.0",75,0,75);
        MyString welcome2 = new MyString("Great tool to improve your critical thinking skills",0,110);

        texts.add(welcome1);texts.add(welcome2);

        panel = new MyPanel(buttons,texts);
        panels.add(panel);
        this.add(panel);
    }

    public void initializeInfoScreen(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        MyRect mainMenuButton = new MyRect(Color.orange,"Main menu",30,
                0,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

        MyString infoHeader = new MyString("Info about this tool",75,0,75);
        MyString info1 = new MyString("CTThinker2.0 is a tool to teach students important CT skills.",30,0,110);
        MyString info2 = new MyString("There are in total 5 modules with 15 levels each.",0,130);
        MyString info3 = new MyString("Module 1 focuses on abstraction.",0,150);
        MyString info4 = new MyString("Module 2 focuses on decomposition.",0,170);
        MyString info5 = new MyString("Module 3 focuses on pattern regonization.",0,190);
        MyString info6 = new MyString("Module 4 focuses on algorithmic thinking.",0,210);
        MyString info7 = new MyString("Module 5 combines the 4 previous aspects together.",0,230);

        texts.add(infoHeader);
        texts.add(info1);texts.add(info2);texts.add(info3);texts.add(info4);
        texts.add(info5);texts.add(info6);texts.add(info7);

        MyPanel infoPanel = new MyPanel(buttons,texts);
        panels.add(infoPanel);
    }

    public void initializeLevelSelectionScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        MyRect mainMenuButton = new MyRect(Color.orange,"Main menu",30,
                0,700,150,60,()->switchPanel(panels.get(0)));
        buttons.add(mainMenuButton);

        MyString selectALevel = new MyString("Select a level",75,0,75);
        texts.add(selectALevel);

        String[] moduleTitles = {"Abstraction","Decomposition","Pattern regonization","Algorithmic thinking","Mixed"};
        for(int i=0;i<5;i++) {
            for(int j=0;j<15;j++) {
                int finalI = i;
                int finalJ = j;
                MyRect levelButton = new MyRect(new Color(0,162,232),String.valueOf(i*15+j+1),30,
                        70*j,i*125+115,60,60,()->switchPanel(panels.get(finalI *15+ finalJ +3)));
                buttons.add(levelButton);
            }

            MyString moduleHeader = new MyString("Module "+(i+1)+": "+ moduleTitles[i],0,i*125+110);
            texts.add(moduleHeader);
        }

        MyPanel levelSelectionPanel = new MyPanel(buttons,texts);
        panels.add(levelSelectionPanel);
    }

    public void initializeLevelBaseElems(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->switchPanel(panels.get(2)));
        buttons.add(exitButton);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }
    
    public void initializeLevel1(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyString L1 = new MyString("Sarah had lost her 4 balls while she was playing outside yesterday, " +
                "so she decided to for look them.",220,30);
        MyString L2 = new MyString("First she found her red ball when she fell into a hole. " +
                "As she continued to look for the other balls,",220,50);
        MyString L3 = new MyString("a random bird flew by. She soon walked deep into the forest, " +
                "and a bunch of creepy-looking trees scared her very badly.",220,70);
        MyString L4 = new MyString("After some more walking, she finally found the yellow ball under a stone.",220,90);
        MyString L5 = new MyString("While looking for the green ball, she came across a abandoned hut filled with many spiders.",20,220,110);
        MyString L6 = new MyString("One spider suddenly jumped out of the hut and climbed onto her, " +
                "causing her to panic and ran into a birch.",220,130);
        MyString L7 = new MyString("When she hit the birch, the green ball fell from the birch and onto her head, " +
                "a bear in the distance looked confused at her, ",220,150);
        MyString L8 = new MyString("wondering what was going on. She searched for the last ball, " +
                "which was the blue ball. She walked across a pond, ",220,170);
        MyString L9 = new MyString("eventually stopping at the foot of a hill, " +
                "where she found the blue ball and walked back home.",220,190);
        MyString question = new MyString("What elements played no role with helping Sarah look for the balls? " +
                "Please mark the correct boxes below.",220,230);

        MyRect opt1 = new MyRect("The hole",20,true,0,260,120,40);
        MyRect opt2 = new MyRect("The bird",20,true,130,260,120,40);
        MyRect opt3 = new MyRect("The scary trees",20,true,260,260,120,40);
        MyRect opt4 = new MyRect("The stone",20,true,390,260,120,40);
        MyRect opt5 = new MyRect("The spider",20,true,520,260,120,40);
        MyRect opt6 = new MyRect("The birch",20,true,650,260,120,40);
        MyRect opt7 = new MyRect("The bear",20,true,780,260,120,40);
        MyRect opt8 = new MyRect("The pond",20,true,910,260,120,40);

        buttons.add(opt1);buttons.add(opt2);buttons.add(opt3);buttons.add(opt4);buttons.add(opt5);
        buttons.add(opt6);buttons.add(opt7);buttons.add(opt8);

        texts.add(L1);texts.add(L2);texts.add(L3);texts.add(L4);
        texts.add(L5);texts.add(L6);texts.add(L7);texts.add(L8);
        texts.add(L9);texts.add(question);

        ArrayList<MyRect> answers = new ArrayList<>();
        answers.add(opt2);answers.add(opt3);answers.add(opt7);answers.add(opt8);

        MyPanel level = new MyPanel(buttons,texts, answers);
        panels.add(level);
    }

    public void initializeLevel2(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElems(buttons,texts);

        MyString l1 = new MyString("There are 6 letters which are A,B,C,D,E and F, and your job is to arrange these letters, " +
                "but you can't",220,30);
        MyString l2 = new MyString("just do it your own way, as there are restrictions for each letter.",220,50);
        MyString l3 = new MyString("A must be on the right side of C and E.",220,70);
        MyString l4 = new MyString("B cannot lay between D and F.",220,90);
        MyString l5 = new MyString("C must be directly next to B or D.",220,110);
        MyString l6 = new MyString("D cannot be directly next to F.",220,130);
        MyString l7 = new MyString("E must be on the 4th, 5th or 6th place.",220,150);
        MyString l8 = new MyString("F must be directly next to a vowel.",220,170);

        MyString question = new MyString("What are the correct ways to arrange the letters? Please mark the correct boxes below.",220,210);

        MyRect opt1 = new MyRect("BDCFEA",20,true,0,260,100,40);;;;;
        MyRect opt2 = new MyRect("CEAFDB",20,true,120,260,100,40);
        MyRect opt3 = new MyRect("EACBFD",20,true,240,260,100,40);
        MyRect opt4 = new MyRect("BEDCFA",20,true,360,260,100,40);
        MyRect opt5 = new MyRect("ABCDEF",20,true,480,260,100,40);
        MyRect opt6 = new MyRect("FAEBDC",20,true,600,260,100,40);
        MyRect opt7 = new MyRect("CBDEFA",20,true,720,260,100,40);;;;;
        MyRect opt8 = new MyRect("BFCDEA",20,true,840,260,100,40);
        MyRect opt9 = new MyRect("DBCFEA",20,true,960,260,100,40);
        MyRect opt10 = new MyRect("CBDEAF",20,true,1080,260,100,40);;;;;

        buttons.add(opt1);buttons.add(opt2);buttons.add(opt3);buttons.add(opt4);
        buttons.add(opt5);buttons.add(opt6);buttons.add(opt7);buttons.add(opt8);
        buttons.add(opt9);buttons.add(opt10);

        texts.add(l1);texts.add(l2);texts.add(l3);texts.add(l4);
        texts.add(l5);texts.add(l6);texts.add(l7);texts.add(l8);texts.add(question);

        ArrayList<MyRect> answers = new ArrayList<>();
        answers.add(opt1);answers.add(opt7);answers.add(opt10);

        MyPanel level = new MyPanel(buttons,texts,answers);
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

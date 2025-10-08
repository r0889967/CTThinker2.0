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
        panel = new MyPanel(buttons,texts);
        panels.add(panel);

        panel.addButton(Color.green,"Start game",30, 500,400,150,60,()->switchPanel(panels.get(2)));
        panel.addButton(Color.orange,"Info",30, 500,500,150,60,()->switchPanel(panels.get(1)));
        panel.addButton(Color.red,"Quit game",30, 500,600,150,60, this::dispose);

        panel.addText("Welcome to CTThinker2.0",75,0,75);
        panel.addText("Great tool to improve your critical thinking skills",30,0,110);
        panel.addText("Click on the info button for more information",30,0,140);

        this.add(panel);
    }

    public void initializeInfoScreen(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        MyPanel infoPanel = new MyPanel(buttons,texts);
        panels.add(infoPanel);

        infoPanel.addButton(Color.orange,"Main menu",30, 0,700,150,60,()->switchPanel(panels.get(0)));

        infoPanel.addText("Info about this tool",75,0,75);
        infoPanel.addText("CTThinker2.0 is a tool to teach students important CT skills.",30,0,100);
        infoPanel.addText("There are in total 5 modules with 15 levels each.",30,0,130);
        infoPanel.addText("Module 1 focuses on abstraction: identifying relevant information in a problem.",30,0,160);
        infoPanel.addText("Module 2 focuses on decomposition: dividing a problem into multiple subproblems that are easier to solve.",30,0,190);
        infoPanel.addText("Module 3 focuses on pattern regonization: finding structures or similarities between problems.",30,0,220);
        infoPanel.addText("Module 4 focuses on algorithmic thinking: constructing a systematic way of solving a problem.",30,0,250);
        infoPanel.addText("Module 5 combines the 4 previous aspects together, fostering CT skills.",30,0,280);

    }

    public void initializeLevelSelectionScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        MyPanel levelSelectionPanel = new MyPanel(buttons,texts);
        panels.add(levelSelectionPanel);

        levelSelectionPanel.addButton(Color.orange,"Main menu",30, 0,700,150,60,()->switchPanel(panels.get(0)));


        levelSelectionPanel.addText("Select a level",75,0,75);

        String[] moduleTitles = {"Abstraction","Decomposition","Pattern regonization","Algorithmic thinking","Mixed"};
        for(int i=0;i<5;i++) {
            for(int j=0;j<15;j++) {
                int finalI = i;
                int finalJ = j;

                levelSelectionPanel.addButton(new Color(0,162,232),String.valueOf(i*15+j+1),30,
                        70*j,i*125+115,60,60,()->{

                        switchPanel(panels.get(finalI *15+ finalJ +3));

                        },true);
            }

            levelSelectionPanel.addText("Module "+(i+1)+": "+ moduleTitles[i],30,0,i*125+110);
        }
        buttons.get(1).unlock();
    }

    public void initializeLevelBaseElems(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->switchPanel(panels.get(2)));
        buttons.add(exitButton);

        int next = levelNumber+3;

        MyRect nextLevelButton = new MyRect(Color.blue,"Next level",30,
                1050,700,150,60,()->{
            if(panels.get(next-1).isAnswerCorrect()){
                switchPanel(panels.get(next));
            }
        });

        buttons.add(nextLevelButton);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }
    
    public void initializeLevel1(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        MyPanel level = new MyPanel(buttons,texts, answers);
        panels.add(level);

        initializeLevelBaseElems(buttons,texts);

        level.addText("Sarah had lost her 4 balls while she was playing outside yesterday, " +
                "so she decided to for look them.",220,30);
        level.addText("First she found her red ball when she fell into a hole. " +
                "As she continued to look for the other balls,",220,50);
        level.addText("a random bird flew by. She soon walked deep into the forest, " +
                "and a bunch of creepy-looking trees scared her very badly.",220,70);
        level.addText("After some more walking, she finally found the yellow ball under a stone.",220,90);
        level.addText("While looking for the green ball, she came across a abandoned hut filled with many spiders.",20,220,110);
        level.addText("One spider suddenly jumped out of the hut and climbed onto her, " +
                "causing her to panic and ran into a birch.",220,130);
        level.addText("When she hit the birch, the green ball fell from the birch and onto her head, " +
                "a bear in the distance looked confused at her, ",220,150);
        level.addText("wondering what was going on. She searched for the last ball, " +
                "which was the blue ball. She walked across a pond, ",220,170);
        level.addText("eventually stopping at the foot of a hill, " +
                "where she found the blue ball and walked back home.",220,190);
        level.addText("What elements played no role with helping Sarah look for the balls? " +
                "Please mark the correct boxes below.",220,230);

        level.addButton("The hole",20,true,0,260,120,40);
        level.addButton("The bird",20,true,130,260,120,40);
        level.addButton("The scary trees",20,true,260,260,120,40);
        level.addButton("The stone",20,true,390,260,120,40);
        level.addButton("The spider",20,true,520,260,120,40);
        level.addButton("The birch",20,true,650,260,120,40);
        level.addButton("The bear",20,true,780,260,120,40);
        level.addButton("The pond",20,true,910,260,120,40);

        level.addAnswer(1);
        level.addAnswer(2);
        level.addAnswer(6);
        level.addAnswer(7);
    }

    public void initializeLevel2(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        MyPanel level = new MyPanel(buttons,texts,answers);
        panels.add(level);

        initializeLevelBaseElems(buttons,texts);

        level.addText("There are 6 letters which are A,B,C,D,E and F, and your job is to arrange these letters, " +
                "but you can't",220,30);
        level.addText("just do it your own way, as there are restrictions for each letter.",220,50);
        level.addText("A must be on the right side of C and E.",220,70);
        level.addText("B cannot lay between D and F.",220,90);
        level.addText("C must be directly next to B or D.",220,110);
        level.addText("D cannot be directly next to F.",220,130);
        level.addText("E must be on the 4th, 5th or 6th place.",220,150);
        level.addText("F must be directly next to a vowel.",220,170);

        level.addText("What are the correct ways to arrange the letters? Please mark the correct boxes below.",220,210);

        level.addButton("BDCFEA",20,true,0,260,100,40);;;;;
        level.addButton("CEAFDB",20,true,120,260,100,40);
        level.addButton("EACBFD",20,true,240,260,100,40);
        level.addButton("BEDCFA",20,true,360,260,100,40);
        level.addButton("ABCDEF",20,true,480,260,100,40);
        level.addButton("FAEBDC",20,true,600,260,100,40);
        level.addButton("CBDEFA",20,true,720,260,100,40);;;;;
        level.addButton("BFCDEA",20,true,840,260,100,40);
        level.addButton("DBCFEA",20,true,960,260,100,40);
        level.addButton("CBDEAF",20,true,1080,260,100,40);;;;;

        level.addAnswer(0);
        level.addAnswer(6);
        level.addAnswer(9);
    }

    public void initializeLevel3(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        MyPanel level = new MyPanel(buttons,texts,answers);
        panels.add(level);

        initializeLevelBaseElems(buttons,texts);

        level.addText("This level is very easy, just calculate 5-2=?. Please mark the correct box.",220,30);

        level.addButton("1",20,true,0,260,100,40);
        level.addButton("2",20,true,120,260,100,40);
        level.addButton(Color.white,"3",75,true,190,0,100,75);
        level.addButton("4",20,true,240,260,100,40);
        level.addButton("5",20,true,360,260,100,40);
        level.addButton("6",20,true,480,260,100,40);

        level.addAnswer(2);
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

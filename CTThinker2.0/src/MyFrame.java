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


                        });
            }

            levelSelectionPanel.addText("Module "+(i+1)+": "+ moduleTitles[i],30,0,i*125+110);
        }
    }

    public void initializeLevelBaseElemsA(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->switchPanel(panels.get(2)));
        buttons.add(exitButton);

        int next = levelNumber+3;

        MyRect nextLevelButton = new MyRect(Color.green,"Next level",30,
                1050,700,150,60,()->{
            if(panels.get(next-1).isAnswerCorrect()){
                switchPanel(panels.get(next));
            }
        });

        buttons.add(nextLevelButton);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }

    public void initializeLevelBaseElemsB(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->switchPanel(panels.get(2)));
        buttons.add(exitButton);

        int next = levelNumber+3;

        MyRect nextLevelButton = new MyRect(Color.green,"Next level",30,
                1050,700,150,60,()->{
            if(panels.get(next-1).isAnswerCorrect()){
                switchPanel(panels.get(next));
            }
        });

        buttons.add(nextLevelButton);

        MyRect inputPrompt = new MyRect("",30,0,300,600,50);
        buttons.add(inputPrompt);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }
    
    public void initializeLevel1(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);



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
        level.addText("Hint: read the text carefully.", 220,250);

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
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);



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
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addText("This level is very easy, just calculate 5-2=?, right?. Please mark the correct box",220,30);
        level.addText("Wait a second?! Something seems to be odd about this level.",220,50);
        level.addText("Hint: you have to think outside the box.",220,70);


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
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addText("The Grim Reaper has arrived to take Sarah's life, but Sarah didn't want to die yet, so she begged the Grim Reaper",220,30);
        level.addText("to let her live longer by lighting up a candle and saying \"Let me live until you see this candle burns up one day.\".",220,50);
        level.addText("The grim reaper agreed and left the scene. Sarah them immediately extinguished the candle by blowing at it.",220,70);
        level.addText("Surprisely, even after many years, the Grim Reaper never came again to take Sarah's life.",220,90);

        level.addText("How did Sarah escape her death? Please mark the correct box.",220,130);

        level.addButton("Because the Grim Reaper wanted to stay away from candles.",20,true,0,260,600,40);
        level.addButton("Because the Grim Reaper decided that Sarah can live forever.",20,true,0,320,600,40);
        level.addButton("Because the Grim Reaper was afraid to return to Sarah once more.",20,true,0,380,600,40);
        level.addButton("Because the Grim Reaper never saw the candle burning up.",20,true,0,440,600,40);
        level.addButton("Because the Grim Reaper was too busy with taking others' life that he forgot Sarah.",20,true,0,500,600,40);
        level.addButton("Because the Grim Reaper was killed by something or someone.",20,true,0,560,600,40);

        level.addAnswer(3);
    }

    public void initializeLevel5(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "59";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addText("This question is easier than you think.",220,30);
        level.addText("How many holes do you see on this page? Please enter the answer below.",220,70);
        level.addText("Hint: look at every letter you see on the page, which letters has holes in them?",220,90);

    }

    public void initializeLevel6(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "I am your best friend Sarah and I live in Belgium";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addText("The following text has been encrypted using a simple algorithm.",220,30);
        level.addText("J bn zpvs cftu gsjfoe Tbsbi boe J mjwf jo Cfmhjvn",220,50);
        level.addText("You need to decrypt this text. Please enter the answer below. (The answer is case-sensitive.)",220,90);
        level.addText("Hint: look at the text carefully and you should find a pattern",220,110);


    }

    public void initializeLevel7(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "Eva Carole Alice Dilan Bob";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addText("Alice,Bob,Carole,Dilan and Eva are having a 100m race. Each of them has his or her own strategies.",220,30);
        level.addText("We will first assume that it will take each runner exactly 1 second to run 1 meter.",220,50);
        level.addText("Alice runs 1 meter and then stops for 1 second.",220,70);
        level.addText("Bob runs 5 meters and then stops for 10 seconds.",220,90);
        level.addText("Carole runs 3 meters and then stops for 2 seconds.",220,110);
        level.addText("Dilan runs 50 meters and then stops for 75 seconds.",220,130);
        level.addText("Eva runs 10 meters and then stops for 5 seconds.",220,150);
        level.addText("Each runner will repeat their strategies during the entire race.",220,170);

        level.addText("In what order will the runners reach the finish? Please enter the answer below.",220,210);
        level.addText("List their names from left to right with the left most being 1st and right most being last.",220,230);
        level.addText("Use a single space to seperate the names, each name must begin with capital, and do not put multiple spaces between names.",220,250);


    }

    public void initializeLevel8(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElemsA(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel9(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElemsA(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }

    public void initializeLevel10(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElemsA(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }


}

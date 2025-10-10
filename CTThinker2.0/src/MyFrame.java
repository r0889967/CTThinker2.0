import javax.swing.JFrame;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFrame extends JFrame {
    private int width = 1200;
    private int height = 800;
    private MyPanel panel;
    private final ArrayList<MyPanel> panels = new ArrayList<>();
    private int levelNumber = 1;

    MyFrame() throws FileNotFoundException {
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

    private void addTextsToLevel(String path,MyPanel panel,int x_offset,int y_offset,int spacing) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            panel.addText(text,x_offset,y_offset+i*spacing);
            i++;
        }
    }

    private void switchPanel(MyPanel newPanel) {
        this.remove(panel);
        panel = newPanel;
        this.add(panel);
        this.repaint();
    }


    private void initializeHomeScreen() {
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

    private void initializeInfoScreen(){
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

    private void initializeLevelSelectionScreen() {
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

    private void initializeLevelBaseElemsA(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        int next = levelNumber+3;

        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->{switchPanel(panels.get(2));
                                                     panels.get(next-1).reset();});
        buttons.add(exitButton);

        MyRect nextLevelButton = new MyRect(Color.green,"Next level",30,
                1050,700,150,60,()->{
            if(panels.get(next-1).isAnswerCorrect()){
                switchPanel(panels.get(next));
                panels.get(next-1).reset();
            }
        });

        buttons.add(nextLevelButton);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }

    private void initializeLevelBaseElemsB(ArrayList<MyRect> buttons, ArrayList<MyString> texts) {
        int next = levelNumber+3;

        MyRect exitButton = new MyRect(Color.red,"Exit level",30,
                0,700,150,60,()->{switchPanel(panels.get(2));
            panels.get(next-1).reset();});
        buttons.add(exitButton);

        MyRect nextLevelButton = new MyRect(Color.green,"Next level",30,
                1050,700,150,60,()->{
            if(panels.get(next-1).isAnswerCorrect()){
                switchPanel(panels.get(next));
                panels.get(next-1).reset();
            }
        });

        buttons.add(nextLevelButton);

        MyRect inputPrompt = new MyRect("",30,0,300,600,50);
        buttons.add(inputPrompt);

        MyString levelName = new MyString("Level "+levelNumber++,75,0,75);
        texts.add(levelName);
    }

    private void initializeLevel1() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level1.txt",level,220,30,20);

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

    private void initializeLevel2() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level2.txt",level,220,30,20);

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

    private void initializeLevel3() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level3.txt",level,220,30,20);


        level.addButton("1",20,true,0,260,100,40);
        level.addButton("2",20,true,120,260,100,40);
        level.addButton(Color.white,"3",75,true,190,0,100,75);
        level.addButton("4",20,true,240,260,100,40);
        level.addButton("5",20,true,360,260,100,40);
        level.addButton("6",20,true,480,260,100,40);

        level.addAnswer(2);
    }

    private void initializeLevel4() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level4.txt",level,220,30,20);

        level.addButton("Because the Grim Reaper wanted to stay away from candles.",20,true,0,260,600,40);
        level.addButton("Because the Grim Reaper decided that Sarah can live forever.",20,true,0,320,600,40);
        level.addButton("Because the Grim Reaper was afraid to return to Sarah once more.",20,true,0,380,600,40);
        level.addButton("Because the Grim Reaper never saw the candle burning up.",20,true,0,440,600,40);
        level.addButton("Because the Grim Reaper was too busy with taking others' life that he forgot Sarah.",20,true,0,500,600,40);
        level.addButton("Because the Grim Reaper was killed by something or someone.",20,true,0,560,600,40);

        level.addAnswer(3);
    }

    private void initializeLevel5() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "59";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        addTextsToLevel("src\\levels\\level5.txt",level,220,30,20);
    }

    private void initializeLevel6(){
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

    private void initializeLevel7(){
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

    private void initializeLevel8(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addText("An confident man and a snail decided to have a very long race, the one who reaches the finish first wins.",220,30);
        level.addText("When the race started, the man was already gone while the snail was just crawling slowly.",220,50);
        level.addText("The man was very confident that he will win but once he reaches the finish, the snail was already there",220,70);
        level.addText("The man couldn't believe that he lost",220,90);

        level.addText("What are the possible and reasonable causes that made the slow snail beat the fast man? Please mark the correct boxes.",220,130);

        level.addButton("The snail was a super-snail that can go very fast.",20,true,0,260,700,40);
        level.addButton("The man got overconfident and thus decided to sleep for many hours during the race, allowing the snail to win.",20,true,0,320,700,40);
        level.addButton("The snail had asked an identical looking snail to deploy itself at the finish line beforehand, creating the illusion that the snail won.",20,true,0,380,700,40);
        level.addButton("The snail had learned to teleport",20,true,0,440,700,40);
        level.addButton("The man might had faced some unforeseen circumstances during the race, causing him to lose.",20,true,0,500,700,40);

        level.addAnswer(1);
        level.addAnswer(2);
        level.addAnswer(4);
    }

    private void initializeLevel9(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addText("Below we have a bunch of words, all relating to fruits, except for one word.",220,30);
        level.addText("Can you spot the odd words? Please mark the correct boxes.",220,70);
        level.addText("Hint: think carefully, a word can have multiple meanings.",220,90);

        level.addButton("apple",20,true,0,260,100,40);
        level.addButton("pear",20,true,120,260,100,40);
        level.addButton("watermelon",20,true,240,260,100,40);
        level.addButton("kiwi",20,true,360,260,100,40);
        level.addButton("cherry",20,true,480,260,100,40);
        level.addButton("peach",20,true,600,260,100,40);
        level.addButton("strawberry",20,true,720,260,100,40);
        level.addButton("orange",20,true,840,260,100,40);
        level.addButton("banana",20,true,960,260,100,40);

        level.addAnswer(3);
        level.addAnswer(7);
    }

    private void initializeLevel10(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElemsA(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }


}

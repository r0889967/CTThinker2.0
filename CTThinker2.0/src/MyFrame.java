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
        initializeLevel11();initializeLevel12();initializeLevel13();initializeLevel14();initializeLevel15();
        initializeLevel16();initializeLevel17();initializeLevel18();initializeLevel19();initializeLevel20();
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

    private void initializeInfoScreen() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        MyPanel infoPanel = new MyPanel(buttons,texts);
        panels.add(infoPanel);

        infoPanel.addButton(Color.orange,"Main menu",30, 0,700,150,60,()->switchPanel(panels.get(0)));
        infoPanel.addText("Info about this tool",75,0,75);
        infoPanel.addTextsToLevel("src\\levels\\info.txt",30,0,100,30);
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

        int size = 75;
        if (levelNumber>9){
            size = 60;
        }

        MyString levelName = new MyString("Level "+levelNumber++,size,0,75);

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

        int size = 75;
        if (levelNumber>9){
            size = 60;
        }

        MyString levelName = new MyString("Level "+levelNumber++,size,0,75);
        texts.add(levelName);
    }

    private void initializeLevel1() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level1.txt",20,220,30,20);
        level.addOptionButtonsToLevelH("src\\levels\\level1b.txt",0,260,130,120,40);
    }

    private void initializeLevel2() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level2.txt",20,220,30,20);
        level.addOptionButtonsToLevelH("src\\levels\\level2b.txt",0,260,110,100,40);
    }

    private void initializeLevel3() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level3.txt",20,220,30,20);


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

        level.addTextsToLevel("src\\levels\\level4.txt",20,220,30,20);
        level.addOptionButtonsToLevelV("src\\levels\\level4b.txt",0,260,60,600,40);
    }

    private void initializeLevel5() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level5.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level5b.txt");
    }

    private void initializeLevel6() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level6.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level6b.txt");
    }

    private void initializeLevel7() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level7.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level7b.txt",0,260,120,100,40);
    }

    private void initializeLevel8() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level8.txt",20,220,30,20);
        level.addOptionButtonsToLevelV("src\\levels\\level8b.txt",0,260,60,700,40);
    }

    private void initializeLevel9() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level9.txt",20,220,30,20);
        level.addOptionButtonsToLevelH("src\\levels\\level9b.txt",0,260,120,100,40);
    }

    private void initializeLevel10() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level10.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level10b.txt",0,260,120,100,50);
    }

    private void initializeLevel11() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level11.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level11b.txt");
    }

    private void initializeLevel12() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level12.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level12b.txt");
    }

    private void initializeLevel13(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel14(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel15(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel16(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel17(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel18(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel19(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }

    private void initializeLevel20(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);
    }


}

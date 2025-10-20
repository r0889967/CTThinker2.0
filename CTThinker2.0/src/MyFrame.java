import javax.swing.JFrame;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        initializeLevel21();initializeLevel22();initializeLevel23();initializeLevel24();initializeLevel25();
        initializeLevel26();initializeLevel27();initializeLevel28();initializeLevel29();initializeLevel30();
        initializeLevel31();initializeLevel32();initializeLevel33();initializeLevel34();initializeLevel35();
        initializeLevel36();initializeLevel37();initializeLevel38();initializeLevel39();initializeLevel40();
        initializeLevel41();initializeLevel42();initializeLevel43();initializeLevel44();initializeLevel45();
        initializeEndScreen();
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
        panel = new NonLevelPanel(buttons,texts);
        panels.add(panel);

        panel.addButton(Color.green,"Start game",30, 500,400,150,60,()->switchPanel(panels.get(2)));
        panel.addButton(Color.orange,"Info",30, 500,500,150,60,()->switchPanel(panels.get(1)));
        panel.addButton(Color.red,"Quit game",30, 500,600,150,60, this::dispose);

        panel.addText("Welcome to CTThinker2.0",75,0,75);
        panel.addText("Great tool to improve your critical thinking skills",30,0,110);
        panel.addText("If it's your first time playing, please read the info first.",30,0,140);

        this.add(panel);
    }

    private void initializeInfoScreen() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        NonLevelPanel infoPanel = new NonLevelPanel(buttons,texts);
        panels.add(infoPanel);

        infoPanel.addButton(Color.orange,"Main menu",30, 0,700,150,60,()->switchPanel(panels.get(0)));
        infoPanel.addText("Info about this tool",75,0,75);
        infoPanel.addTextsToLevel("src\\levels\\info.txt",20,0,100,20);
    }

    private void initializeLevelSelectionScreen() {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        NonLevelPanel levelSelectionPanel = new NonLevelPanel(buttons,texts);
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

    private void initializeLevelBaseElemsAC(LevelPanel panel) {
        int next = levelNumber+3;

        panel.addButton(Color.red,"Exit Level",30,
                0,700,150,60,()->{switchPanel(panels.get(2));
                    panel.reset();});

        panel.addButton(Color.green,"Next level",30,
                1050,700,150,60,()->{
                    if(panel.isAnswerCorrect()){
                        switchPanel(panels.get(next));
                        panel.reset();
                    }
                });

        int size = 75;
        if (levelNumber>9){
            size = 60;
        }

        panel.addText("Level "+levelNumber++,size,0,75);
    }

    private void initializeLevelBaseElemsB(LevelPanelTypeB panel) {
        int next = levelNumber+3;

        panel.addButton(Color.red,"Exit Level",30,
                0,700,150,60,()->{switchPanel(panels.get(2));
                    panel.reset();});

        panel.addButton(Color.green,"Next level",30,
                1050,700,150,60,()->{
                    if(panel.isAnswerCorrect()){
                        switchPanel(panels.get(next));
                        panel.reset();
                    }
                });

        panel.addButton(Color.lightGray,"",30,0,300,600,50,()->{});

        int size = 75;
        if (levelNumber>9){
            size = 60;
        }

        panel.addText("Level "+levelNumber++,size,0,75);
        panel.addMyKeyListener();
    }

    private void initializeLevel1() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level1.txt",20,220,30,20);
        level.addOptionButtonsToLevelHorizontal("src\\levels\\level1b.txt",0,260,130,120,40);
    }

    private void initializeLevel2() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level2.txt",20,220,30,20);
        level.addOptionButtonsToLevelHorizontal("src\\levels\\level2b.txt",0,260,110,100,40);
    }

    private void initializeLevel3() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level3.txt",20,220,30,20);
        level.addOptionButtonsToLevelCustom("src\\levels\\level3b.txt");
    }

    private void initializeLevel4() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level4.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level4b.txt",0,260,60,600,40);
    }

    private void initializeLevel5() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level5.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level5b.txt");
    }

    private void initializeLevel6() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level6.txt",20,220,30,20);
        level.addOptionButtonsToLevelHorizontal("src\\levels\\level6b.txt",0,260,120,100,40);
    }

    private void initializeLevel7() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level7.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level7b.txt",0,260,120,100,50);
    }

    private void initializeLevel8() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level8.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level8b.txt",0,260,60,700,40);
    }

    private void initializeLevel9() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level9.txt",20,220,30,20);
        level.addOptionButtonsToLevelHorizontal("src\\levels\\level9b.txt",0,260,120,100,40);
    }

    private void initializeLevel10() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level10.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level10b.txt");
    }

    private void initializeLevel11() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level11.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level11b.txt");
    }

    private void initializeLevel12() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level12.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level12b.txt",0,260,60,700,40);
    }

    private void initializeLevel13() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level13.txt",20,220,30,20);
        //level.addDragableButtonsToLevelH("src\\levels\\level13b.txt",0,260,80,50,50);
    }

    private void initializeLevel14() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        //level.addTextsToLevel("src\\levels\\level14.txt",20,220,30,20);
        //level.addSimpleAnswer("src\\levels\\level14b.txt");
    }

    private void initializeLevel15() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level15.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level15b.txt",0,260,60,600,40);
    }

    private void initializeLevel16() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level16.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level16b.txt",0,260,60,600,40);
    }

    private void initializeLevel17() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level17.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level17b.txt",0,260,110,100,40);
    }

    private void initializeLevel18() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level18.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level18b.txt",0,260,120,100,50);
    }

    private void initializeLevel19() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level19.txt",20,220,30,20);
    }

    private void initializeLevel20(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel21(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel22(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel23(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel24(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel25(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel26(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel27(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel28(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel29(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel30(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
    }

    private void initializeLevel31() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level31.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level31b.txt");
    }

    private void initializeLevel32() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level32.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level32b.txt");
    }

    private void initializeLevel33() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level33.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level33b.txt");
    }

    private void initializeLevel34() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level34.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level34b.txt");
    }

    private void initializeLevel35() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level35.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level35b.txt");
    }

    private void initializeLevel36() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level36.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level36b.txt",0,260,60,600,40);
    }

    private void initializeLevel37() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        initializeLevelBaseElemsAC(level);
        panels.add(level);
        level.addTextsToLevel("src\\levels\\level37.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level37b.txt",0,260,110,60,40);
    }

    private void initializeLevel38() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level38.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level38b.txt");
    }

    private void initializeLevel39() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level39.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level39b.txt",0,260,60,600,40);
    }

    private void initializeLevel40() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level40.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level40b.txt");
    }

    private void initializeLevel41() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> correctOrder = new ArrayList<>();
        LevelPanelTypeC level = new LevelPanelTypeC(buttons,texts, correctOrder);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level41.txt",20,220,30,20);
        level.addDragableButtonsToLevelH("src\\levels\\level41b.txt",0,260,120,110,50);
    }

    private void initializeLevel42() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level42.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level42b.txt");
    }

    private void initializeLevel43() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "";
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        initializeLevelBaseElemsB(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level43.txt",20,220,30,20);
        level.addSimpleAnswer("src\\levels\\level43b.txt");
    }

    private void initializeLevel44() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        initializeLevelBaseElemsAC(level);
        panels.add(level);

        level.addTextsToLevel("src\\levels\\level44.txt",20,220,30,20);
        level.addOptionButtonsToLevelVertical("src\\levels\\level44b.txt",0,220,60,600,40);
    }

    private void initializeLevel45(){
    }

    private void initializeEndScreen(){

    }


}

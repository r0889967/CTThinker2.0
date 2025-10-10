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

    private void addOptionsToLevelH(String path,LevelPanelTypeA panel,int x_offset,int y_offset,int spacing, int b_width, int b_height) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.charAt(text.length()-1)=='*') {
                panel.addButton(text.substring(0,text.length()-1), 20, true, x_offset + i * spacing, y_offset, b_width, b_height);
                panel.addAnswer(i);
            }else{
                panel.addButton(text, 20, true, x_offset + i * spacing, y_offset, b_width, b_height);
            }
            i++;
        }
    }

    private void addOptionsToLevelV(String path,LevelPanelTypeA panel,int x_offset,int y_offset,int spacing, int b_width, int b_height) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        String text = "";
        int i = 0;
        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.charAt(text.length()-1)=='*') {
                panel.addButton(text.substring(0,text.length()-1), 20, true, x_offset, y_offset+ i * spacing, b_width, b_height);
                panel.addAnswer(i);
            }else{
                panel.addButton(text, 20, true, x_offset, y_offset+ i * spacing, b_width, b_height);
            }
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
        addOptionsToLevelH("src\\levels\\level1b.txt",level,0,260,130,120,40);
    }

    private void initializeLevel2() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level2.txt",level,220,30,20);
        addOptionsToLevelH("src\\levels\\level2b.txt",level,0,260,110,100,40);
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
        addOptionsToLevelV("src\\levels\\level4b.txt",level,0,260,60,600,40);
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

    private void initializeLevel6() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "I am your best friend Sarah and I live in Belgium";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        addTextsToLevel("src\\levels\\level6.txt",level,220,30,20);
    }

    private void initializeLevel7() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        String answer = "Eva Carole Alice Dilan Bob";
        initializeLevelBaseElemsB(buttons,texts);
        LevelPanelTypeB level = new LevelPanelTypeB(buttons,texts, answer);
        panels.add(level);

        addTextsToLevel("src\\levels\\level7.txt",level,220,30,20);
    }

    private void initializeLevel8() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level8.txt",level,220,30,20);
        addOptionsToLevelV("src\\levels\\level8b.txt",level,0,260,60,700,40);
    }

    private void initializeLevel9() throws FileNotFoundException {
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        initializeLevelBaseElemsA(buttons,texts);
        LevelPanelTypeA level = new LevelPanelTypeA(buttons,texts, answers);
        panels.add(level);

        addTextsToLevel("src\\levels\\level9.txt",level,220,30,20);
        addOptionsToLevelH("src\\levels\\level9b.txt",level,0,260,120,100,40);
    }

    private void initializeLevel10(){
        ArrayList<MyRect> buttons = new ArrayList<>();
        ArrayList<MyString> texts = new ArrayList<>();

        initializeLevelBaseElemsA(buttons,texts);

        MyPanel level = new MyPanel(buttons,texts);
        panels.add(level);
    }


}

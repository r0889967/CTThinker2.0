
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private final MyPanel panel;
    private final MyRect button;

    public MyKeyListener(MyPanel panel, MyRect button) {
        this.panel = panel;
        this.button = button;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
        panel.grabFocus();
        char key = e.getKeyChar();
        String text = button.getText();


        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            text = text.substring(0, text.length() - 1);
        }else {
            if(key == ' '){
                text = text + ' ';
            }
            else if(Character.isLetterOrDigit(key)) {
                text = text + key;
            }
        }
        button.setText(text);
        panel.repaint();
    }
}

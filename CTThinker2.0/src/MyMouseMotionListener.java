import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouseMotionListener implements MouseMotionListener {
    MyPanel panel;
    ArrayList<MyRect> buttons;
    MyRect button;

    MyMouseMotionListener(MyPanel panel,ArrayList<MyRect> buttons) {
        this.panel = panel;
        this.buttons = buttons;
    }

    private void selectButton(int mx,int my){
        if(buttons.isEmpty()) return;
        button = buttons.getFirst();
        int dist = Math.abs(mx- button.getX())+Math.abs(my- button.getY());

        for (MyRect other: buttons) {
            if(Math.abs(mx- other.getX())+Math.abs(my- other.getY())<dist){
                button = other;
                dist = Math.abs(mx-other.getX())+Math.abs(my-other.getY());
            }
        }
    }

    private boolean mouseInButton(int mx,int my){
        if (button == null) return false;
        return mx >= button.getX() && mx <= button.getX() + button.getWidth() &&
                my >= button.getY() && my <= button.getY() + button.getHeight();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        selectButton(e.getX(), e.getY());
        if (mouseInButton(e.getX(), e.getY())) {
            button.drag(e.getX(), e.getY());
        }
        panel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouseMotionListener implements MouseMotionListener {
    private final MyPanel panel;
    private final ArrayList<MyRect> buttons;
    private MyRect button;

    MyMouseMotionListener(MyPanel panel,ArrayList<MyRect> buttons) {
        this.panel = panel;
        this.buttons = buttons;
    }

    private void selectButton(int mx,int my){
        if(buttons.isEmpty()) return;
        button = buttons.getFirst();
        int dist = Math.abs(mx- button.getX()-button.getWidth()/2)+Math.abs(my- button.getY()-button.getHeight()/2);

        for (MyRect other: buttons) {
            int otherDist = Math.abs(mx- other.getX()- other.getWidth()/2)+Math.abs(my- other.getY()- other.getHeight()/2);
            if(otherDist<dist){
                button = other;
                dist = otherDist;
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

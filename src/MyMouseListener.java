import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyMouseListener implements MouseListener {
    private final MyPanel panel;
    private final ArrayList<MyRect> buttons;
    private MyRect button;

    MyMouseListener(MyPanel panel,ArrayList<MyRect> buttons) {
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
    public void mouseClicked(MouseEvent e) {
        selectButton(e.getX(), e.getY());
        if (mouseInButton(e.getX(), e.getY())) {
            button.toggleMarked();
            button.executeFunction();
        }
        panel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

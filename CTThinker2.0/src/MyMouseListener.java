import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyMouseListener implements MouseListener {
    MyPanel panel;
    ArrayList<MyRect> buttons;
    MyRect button;

    MyMouseListener(MyPanel panel,ArrayList<MyRect> buttons) {
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


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RubberLinesPanel extends JPanel {
    private Point p1 = null, p2 = null;

    //-----------------------------------------------
    // Sets up the applet to listen for mouse events.
    //-----------------------------------------------
    public RubberLinesPanel(){
        LineListener listener = new LineListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setBackground(Color.BLACK);
    }

    //------------------------------------------------------------
    // Draws the current line from the initial mouse down point to
    // the current position of the mouse.
    //------------------------------------------------------------
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        page.setColor(Color.green);

        if(p1 != null && p2 != null){
            page.drawLine(p1.x,p1.y,p2.x,p2.y);
        }

    }

    //---------------------------------------------
    //Represents the listener for all mouse events.
    //---------------------------------------------

    private class LineListener implements MouseListener, MouseMotionListener{
        @Override
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            p2 = e.getPoint();
            repaint();
        }

        //--------------------------------
        //empty bois so interface is happy
        //--------------------------------

        @Override
        public void mouseClicked(MouseEvent e){}



        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {}
    }
}

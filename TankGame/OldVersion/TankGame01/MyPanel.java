package TankGame01;

import javax.swing.*;
import java.awt.*;

/**
 * The type My panel.
 */
public class MyPanel extends JPanel {

    /**
     * The Tank 01.
     */
    Hero tank01 = null;

    /**
     * Instantiates a new My panel.
     */
    public MyPanel() {
        tank01 = new Hero(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(tank01.getX(),tank01.getY(),g,0,0);
        drawTank(tank01.getX() + 300,tank01.getY() + 200,g,0,1);

    }

    /**
     * Draw tank.
     *
     * @param x         the x
     * @param y         the y
     * @param g         the g
     * @param direction the direction
     * @param type      the type
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0 :
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.ORANGE);
                break;
        }

        switch (direction){
            case 0:
              g.fill3DRect(x,y,10,60,false);
              g.fill3DRect(x + 10,y + 10,30,40,false);
              g.fill3DRect(x + 40,y,10,60,false);
              g.fillOval(x + 10,y + 15,30,30);
              g.drawLine(x + 25,y + 25, x + 25, y - 10);
              break;
            default:
                System.out.println("DNE");
        }

    }
}

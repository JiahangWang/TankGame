package TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * The type My panel.
 */
public class MyPanel extends JPanel implements KeyListener {

    /**
     * The Tank 01.
     */
    Hero hero;
    Vector<Enemy> enemies = new Vector<Enemy>();
    int enemyNum = 4;

    /**
     * Instantiates a new My panel.
     */
    public MyPanel() {
        hero = new Hero(300,300,0,10);
        for (int i = 1; i <= enemyNum; i++) {
            enemies.add(new Enemy(100 * (i + 1), 50,1,1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(g,hero.getX(), hero.getY(),hero.getDirection(),0);

        for (Enemy enemy : enemies) {
            drawTank(g,enemy.getX(),enemy.getY(),enemy.getDirection(),enemy.getSpeed());
        }
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
    public void drawTank(Graphics g, int x, int y, int direction, int type) {
        switch (type) {
            case 0 :
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.ORANGE);
                break;
        }

        switch (direction){  // 0:up  1:down  2:right  3:left
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,30,40,false);
                g.fill3DRect(x + 40,y,10,60,false);
                g.fillOval(x + 10,y + 15,30,30);
                g.drawLine(x + 25,y + 30, x + 25, y - 10);
                break;
            case 1:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,30,40,false);
                g.fill3DRect(x + 40,y,10,60,false);
                g.fillOval(x + 10,y + 15,30,30);
                g.drawLine(x + 25,y + 30, x + 25, y + 70);
                break;
            case 2:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,30,false);
                g.fill3DRect(x,y + 40,60,10,false);
                g.fillOval(x + 15,y + 10,30,30);
                g.drawLine(x + 30,y + 25, x + 70, y + 25);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,30,false);
                g.fill3DRect(x,y + 40,60,10,false);
                g.fillOval(x + 15,y + 10,30,30);
                g.drawLine(x + 30,y + 25, x - 10, y + 25);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_S :
                hero.setDirection(1);
                hero.setY(hero.getY() + hero.getSpeed());
                break;
            case KeyEvent.VK_W:
                hero.setDirection(0);
                hero.setY(hero.getY() - hero.getSpeed());
                break;
            case KeyEvent.VK_A:
                hero.setDirection(3);
                hero.setX(hero.getX() - hero.getSpeed());
                break;
            case KeyEvent.VK_D:
                hero.setDirection(2);
                hero.setX(hero.getX() + hero.getSpeed());
                break;
        }
//        System.out.println("Tank move!");
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

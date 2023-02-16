package TankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * The type My panel.
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {

    /**
     * The Tank 01.
     */
    Hero hero;
    /**
     * The Enemies.
     */
    Vector<Enemy> enemies = new Vector<Enemy>();
    /**
     * The Enemy num.
     */
    int enemyNum = 4;

    /**
     * Instantiates a new My panel.
     */
    public MyPanel() {
        hero = new Hero(300,300,Direction.UP,10);
        for (int i = 1; i <= enemyNum; i++) {
            enemies.add(new Enemy(100 * (i + 1), 50,Direction.DOWN,1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1100,750);
        drawTank(g,hero.getX(), hero.getY(),hero.getDirection(),TankType.HERO);

        for (Enemy enemy : enemies) {
            drawTank(g,enemy.getX(),enemy.getY(),enemy.getDirection(),TankType.ENEMY);
        }

        g.setColor(Color.RED);

        if(hero.shoot != null && hero.shoot.isLived()){
//            g.fill3DRect(hero.shoot.getX(), hero.shoot.getY(), 2, 2, false);
            g.draw3DRect(hero.shoot.getX(), hero.shoot.getY(), 2, 2, false);
        }
    }

    /**
     * Draw tank.
     *
     * @param g         the g
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param type      the type
     */
    public void drawTank(Graphics g, int x, int y, Direction direction, TankType type) {
        switch (type) {
            case HERO:
                g.setColor(Color.CYAN);
                break;
            case ENEMY:
                g.setColor(Color.ORANGE);
                break;
        }

        switch (direction){  // 0:up  1:down  2:right  3:left
            case UP:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,30,40,false);
                g.fill3DRect(x + 40,y,10,60,false);
                g.fillOval(x + 10,y + 15,30,30);
                g.drawLine(x + 25,y + 30, x + 25, y - 10);
                break;
            case DOWN:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,30,40,false);
                g.fill3DRect(x + 40,y,10,60,false);
                g.fillOval(x + 10,y + 15,30,30);
                g.drawLine(x + 25,y + 30, x + 25, y + 70);
                break;
            case RIGHT:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,30,false);
                g.fill3DRect(x,y + 40,60,10,false);
                g.fillOval(x + 15,y + 10,30,30);
                g.drawLine(x + 30,y + 25, x + 70, y + 25);
                break;
            case LEFT:
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
                hero.setDirection(Direction.DOWN);
                hero.setY(hero.getY() + hero.getSpeed());
                break;
            case KeyEvent.VK_W:
                hero.setDirection(Direction.UP);
                hero.setY(hero.getY() - hero.getSpeed());
                break;
            case KeyEvent.VK_A:
                hero.setDirection(Direction.LEFT);
                hero.setX(hero.getX() - hero.getSpeed());
                break;
            case KeyEvent.VK_D:
                hero.setDirection(Direction.RIGHT);
                hero.setX(hero.getX() + hero.getSpeed());
                break;
            case KeyEvent.VK_J:
                hero.fire();
        }
//        System.out.println("Tank move!");
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}

package TankGame04;

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
    Vector<Enemy> enemies = new Vector<>();
    /**
     * The Enemy num.
     */
    int enemyNum = 4;

    /**
     * The Explodes.
     */
    Vector<Explode> explodes = new Vector<>();

    /**
     * The Explode 01.
     */
    Image explode01 = null;
    /**
     * The Explode 02.
     */
    Image explode02 = null;
    /**
     * The Explode 03.
     */
    Image explode03 = null;

    /**
     * Instantiates a new My panel.
     */
    public MyPanel() {
        // Create new hero
        hero = new Hero(500,300, Direction.UP,10);

        // Create all the new enemies and their shoots
        for (int i = 1; i <= enemyNum; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 50, Direction.DOWN,1);
            Shoot shoot = new Shoot(enemy.getX() + 25,enemy.getY() + 70,Direction.DOWN);
            enemy.getShoots().add(shoot);
            new Thread(shoot).start();
            enemies.add(enemy);
        }

        // initialize image
        explode01 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode01.png"));
        explode02 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode02.png"));
        explode03 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode03.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // draw background
        g.fillRect(0,0,1100,750);
        drawTank(g,hero.getX(), hero.getY(),hero.getDirection(), TankType.HERO);

        // draw all the enemy tank and their shoot
        for (Enemy enemy : enemies) {
            // Determine if the enemy is lived
            if(enemy.isLived()) {

                // draw enemy tank
                drawTank(g, enemy.getX(), enemy.getY(), enemy.getDirection(), TankType.ENEMY);

                // draw enemy tank's shoots
                for (int i = 0; i < enemy.getShoots().size(); i++) {
                    Shoot shoot = enemy.getShoots().get(i);
                    if (shoot.isLived()) {
                        g.draw3DRect(shoot.getX(), shoot.getY(), 2, 2, false);
                    } else enemy.getShoots().remove(shoot);
                }
            }
        }

        // draw hero's shoot
        if(hero.getShoot() != null && hero.getShoot().isLived()){
            g.draw3DRect(hero.getShoot().getX(), hero.getShoot().getY(), 2, 2, false);
        }

        // draw all the explode in explodes
        for (int i = 0; i < explodes.size(); i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Explode explode = explodes.get(i);

            if(explode.getLife() > 6) g.drawImage(explode01,explode.getX(), explode.getY(), 75,87,this);
            else if(explode.getLife() > 3) g.drawImage(explode02,explode.getX(), explode.getY(), 70,55,this);
            else g.drawImage(explode03,explode.getX(), explode.getY(), 49,44,this);
            // decrease the life of the explode
            explode.decreaseLife();
            // if the life of explode is 0 then remove it from explodes
            if(explode.getLife() == 0) explodes.remove(explode);
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
        // Determine the type of the tank
        switch (type) {
            case HERO -> g.setColor(Color.CYAN);
            case ENEMY -> g.setColor(Color.ORANGE);
        }

        // Determine the direction of the tank
        switch (direction) {  // 0:up  1:down  2:right  3:left
            case UP -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 60, false);
                g.fillOval(x + 10, y + 15, 30, 30);
                g.drawLine(x + 25, y + 30, x + 25, y - 10);
            }
            case DOWN -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 60, false);
                g.fillOval(x + 10, y + 15, 30, 30);
                g.drawLine(x + 25, y + 30, x + 25, y + 70);
            }
            case RIGHT -> {
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 60, 10, false);
                g.fillOval(x + 15, y + 10, 30, 30);
                g.drawLine(x + 30, y + 25, x + 70, y + 25);
            }
            case LEFT -> {
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 60, 10, false);
                g.fillOval(x + 15, y + 10, 30, 30);
                g.drawLine(x + 30, y + 25, x - 10, y + 25);
            }
        }

    }

    /**
     * Hit tank.
     *
     * @param shoot the shoot
     * @param enemy the enemy
     */
    public void hitTank(Shoot shoot, Enemy enemy){
        switch (enemy.getDirection()) {
            case UP, DOWN -> {
                if (shoot.getX() > enemy.getX() && shoot.getX() < enemy.getX() + 50
                        && shoot.getY() > enemy.getY() && shoot.getY() < enemy.getY() + 60) {
                    shoot.setLived(false);
                    enemy.setLived(false);
                    // remove this enemy from enemies
                    enemies.remove(enemy);
                    // Create Explode Object add into explodes
                    Explode explode = new Explode(enemy.getX(), enemy.getY());
                    explodes.add(explode);
                }
            }
            case RIGHT, LEFT -> {
                if (shoot.getX() > enemy.getX() && shoot.getX() < enemy.getX() + 60
                        && shoot.getY() > enemy.getY() && shoot.getY() < enemy.getY() + 40) {
                    shoot.setLived(false);
                    enemy.setLived(false);
                    // remove this enemy from enemies
                    enemies.remove(enemy);
                    // Create Explode Object add into explodes
                    Explode explode = new Explode(enemy.getX(), enemy.getY());
                    explodes.add(explode);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Determine the keyboard input
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S -> {
                hero.setDirection(Direction.DOWN);
                hero.setY(hero.getY() + hero.getSpeed());
            }
            case KeyEvent.VK_W -> {
                hero.setDirection(Direction.UP);
                hero.setY(hero.getY() - hero.getSpeed());
            }
            case KeyEvent.VK_A -> {
                hero.setDirection(Direction.LEFT);
                hero.setX(hero.getX() - hero.getSpeed());
            }
            case KeyEvent.VK_D -> {
                hero.setDirection(Direction.RIGHT);
                hero.setX(hero.getX() + hero.getSpeed());
            }
            case KeyEvent.VK_J -> hero.fire();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        // every 100ms re-pain the panel
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Determine if hit enemy tank
            if(hero.getShoot() != null && hero.getShoot().isLived()){
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    hitTank(hero.getShoot(), enemy);
                }
            }
            this.repaint();
        }
    }
}

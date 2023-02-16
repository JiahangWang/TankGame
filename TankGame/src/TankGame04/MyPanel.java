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
    int enemyNum = 5;

    /**
     * The Explodes.
     */
    Vector<Explode> explodes = new Vector<>();

    /**
     * The Explode 01.
     */
    Image explode01;
    /**
     * The Explode 02.
     */
    Image explode02;
    /**
     * The Explode 03.
     */
    Image explode03;

    /**
     * The Earth.
     */
    Image earth;

    /**
     * Instantiates a new My panel.
     */
    public MyPanel() {
        // Create new hero
        hero = new Hero(800,500, Direction.UP,10);

        // Create all the new enemies and their shoots
        for (int i = 1; i <= enemyNum; i++) {
            // create new enemy
            Enemy enemy = new Enemy(100 * (i + 1), 50, Direction.DOWN,2);
            // start enemy thread
            new Thread(enemy).start();
            // add enemy into enemies
            enemies.add(enemy);
        }

        // initialize image
        explode01 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode01.png"));
        explode02 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode02.png"));
        explode03 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/explode03.png"));
        earth = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/Earth.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // draw background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,1100,750);
        g.drawImage(earth,0,0,1100,750,this);
        // draw hero tank
        if(hero != null && hero.isLived()){
            drawTank(g,hero.getX(), hero.getY(),hero.getDirection(), TankType.HERO);
        }

        // draw all the enemy tank and their shoot
        for (Enemy enemy : enemies) {
            // Determine if the enemy is lived
            if(enemy.isLived()) {

                // draw enemy tank
                drawTank(g, enemy.getX(), enemy.getY(), enemy.getDirection(), TankType.ENEMY);

                // draw enemy tank's shoots
                g.setColor(Color.YELLOW);
                for (int i = 0; i < enemy.getShoots().size(); i++) {
                    Shoot shoot = enemy.getShoots().get(i);
                    if (shoot.isLived()) {
                        g.draw3DRect(shoot.getX(), shoot.getY(), 2, 3, false);
                    } else enemy.getShoots().remove(shoot);
                }
            }
        }



        // draw hero's shoot
        g.setColor(Color.CYAN);
        for (int i = 0; i < hero.getShoots().size(); i++) {
            Shoot shoot = hero.getShoots().get(i);
            if(shoot.isLived()){
                g.draw3DRect(shoot.getX(), shoot.getY(), 2, 3, false);
            }
            else hero.getShoots().remove(shoot);
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
        switch (direction) {
            case UP -> {
                g.fill3DRect(x + 10, y + 10, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 60, false);
                g.fill3DRect(x, y, 10, 60, false);
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
     * Hit tanks.
     */
    public void hitEnemies(){
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            for (int j = 0; j < hero.getShoots().size(); j++) {
                Shoot shoot = hero.getShoots().get(j);
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
        }
    }

    /**
     * Hit tanks.
     *
     * @param shoot the shoot
     * @param tank  the tank
     */
    public void hitTank(Shoot shoot, Tank tank){
        switch (tank.getDirection()) {
            case UP, DOWN -> {
                if (shoot.getX() > tank.getX() && shoot.getX() < tank.getX() + 50
                        && shoot.getY() > tank.getY() && shoot.getY() < tank.getY() + 60) {
                    shoot.setLived(false);
                    tank.setLived(false);
                    // remove this tank from enemies
                    enemies.remove(tank);
                    // Create Explode Object add into explodes
                    Explode explode = new Explode(tank.getX(), tank.getY());
                    explodes.add(explode);
                }
            }
            case RIGHT, LEFT -> {
                if (shoot.getX() > tank.getX() && shoot.getX() < tank.getX() + 60
                        && shoot.getY() > tank.getY() && shoot.getY() < tank.getY() + 40) {
                    shoot.setLived(false);
                    tank.setLived(false);
                    // remove this tank from enemies
                    enemies.remove(tank);
                    // Create Explode Object add into explodes
                    Explode explode = new Explode(tank.getX(), tank.getY());
                    explodes.add(explode);
                }
            }
        }
    }


    /**
     * Hit hero.
     */
    public void hitHero(){
        // get all enemies
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            // get all shoots of the enemy
            for (int j = 0; j < enemy.getShoots().size(); j++) {
                Shoot shoot = enemy.getShoots().get(j);
                if(hero.isLived() && shoot.isLived()){
                    hitTank(shoot,hero);
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
            case KeyEvent.VK_W -> {
                hero.setDirection(Direction.UP);
                if(hero.getY() > 0) hero.setY(hero.getY() - hero.getSpeed());
            }
            case KeyEvent.VK_S -> {
                hero.setDirection(Direction.DOWN);
                if(hero.getY() + 60 < 750) hero.setY(hero.getY() + hero.getSpeed());
            }
            case KeyEvent.VK_A -> {
                hero.setDirection(Direction.LEFT);
                if(hero.getX() > 0) hero.setX(hero.getX() - hero.getSpeed());
            }
            case KeyEvent.VK_D -> {
                hero.setDirection(Direction.RIGHT);
                if(hero.getX() + 60 < 1100) hero.setX(hero.getX() + hero.getSpeed());
            }
            case KeyEvent.VK_ENTER -> {
                hero.fire();
            }
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

            // Determine if hero hit enemy tanks
            hitEnemies();

            // Determine if enemy hit hero
            hitHero();

            this.repaint();
        }
    }
}

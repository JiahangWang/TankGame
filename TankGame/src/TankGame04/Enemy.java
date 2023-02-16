package TankGame04;

import java.util.Vector;

/**
 * The type Enemy.
 */
public class Enemy extends Tank implements Runnable {

    /**
     * The Shoots.
     */
    private Vector<Shoot> shoots = new Vector<>();

    /**
     * Instantiates a new Enemy.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Enemy(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    /**
     * Instantiates a new Enemy.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param speed     the speed
     */
    public Enemy(int x, int y, Direction direction, int speed) {
        super(x, y, direction, speed);
    }

    public Vector<Shoot> getShoots() {
        return shoots;
    }

    public void setShoots(Vector<Shoot> shoots) {
        this.shoots = shoots;
    }

    @Override
    public void run() {
        while (true) {
            // create new enemy shoot
            if(isLived() && shoots.size() < 2){
                Shoot shoot = null;
                switch (getDirection()) {
                    case UP -> shoot = new Shoot(getX() + 25, getY() - 10, Direction.UP);
                    case DOWN -> shoot = new Shoot(getX() + 25, getY() + 70, Direction.DOWN);
                    case RIGHT -> shoot = new Shoot(getX() + 75, getY() + 25, Direction.RIGHT);
                    case LEFT -> shoot = new Shoot(getX() - 10, getY() + 25, Direction.LEFT);
                }
                shoots.add(shoot);
                new Thread(shoot).start();
            }

            // moving according to its direction
            switch (getDirection()) {
                case UP -> {
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(getY() > 0) setY(getY() - getSpeed());
                    }
                }
                case DOWN -> {
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(getY() + 60 < 750) setY(getY() + getSpeed());
                    }
                }
                case LEFT -> {
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(getX() > 0) setX(getX() - getSpeed());
                    }
                }
                case RIGHT -> {
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(getX() + 60 < 1100) setX(getX() + getSpeed());
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Randomly change its direction
            setDirection(Direction.values()[(int) (Math.random() * 4)]);
            // exit when it is not lived
            if(!(isLived())) break;
        }
    }
}

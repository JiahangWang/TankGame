package TankGame04;

import java.util.Vector;

/**
 * The type Enemy.
 */
public class Enemy extends Tank {

    private boolean isLived  =true;

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

    public boolean isLived() {
        return isLived;
    }

    public void setLived(boolean lived) {
        isLived = lived;
    }

    public Vector<Shoot> getShoots() {
        return shoots;
    }

    public void setShoots(Vector<Shoot> shoots) {
        this.shoots = shoots;
    }
}

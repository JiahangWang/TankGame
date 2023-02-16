package TankGame02;

/**
 * The type Enemy.
 */
public class Enemy extends Tank{
    /**
     * Instantiates a new Enemy.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param speed     the speed
     */
    public Enemy(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    /**
     * Instantiates a new Enemy.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
    }

}

package TankGame02;

/**
 * The type Tank 01.
 */
public class Hero extends Tank {

    /**
     * Instantiates a new Hero.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param speed     the speed
     */
    public Hero(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    /**
     * Instantiates a new Hero.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Hero(int x, int y, int direction) {
        super(x, y, direction);
    }

}

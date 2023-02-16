package TankGame03;

/**
 * The type Enemy.
 */
public class Enemy extends Tank {

    public Enemy(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    public Enemy(int x, int y, Direction direction, int speed) {
        super(x, y, direction, speed);
    }
}

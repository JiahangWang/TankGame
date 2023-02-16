package TankGame04;

/**
 * The type Tank.
 */
public class Tank {

    private int x; // x-axis
    private int y;  // y-axis
    private Direction direction;
    private int speed = 5;
    private boolean isLived = true;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Tank(int x, int y, Direction direction, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLived() {
        return isLived;
    }

    public void setLived(boolean lived) {
        isLived = lived;
    }
}


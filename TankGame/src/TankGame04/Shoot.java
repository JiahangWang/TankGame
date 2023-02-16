package TankGame04;

/**
 * The type Shoot.
 */
public class Shoot implements Runnable{

    private int x;
    private int y;
    private Direction direction;
    private int speed = 10;
    private boolean isLived = true;

    /**
     * Instantiates a new Shoot.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Shoot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Instantiates a new Shoot.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param speed     the speed
     */
    public Shoot(int x, int y, Direction direction, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Is lived boolean.
     *
     * @return the boolean
     */
    public boolean isLived() {
        return isLived;
    }

    /**
     * Sets lived.
     *
     * @param lived the lived
     */
    public void setLived(boolean lived) {
        isLived = lived;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (getDirection()) {
                case UP -> setY(getY() - getSpeed());
                case DOWN -> setY(getY() + getSpeed());
                case LEFT -> setX(getX() - getSpeed());
                case RIGHT -> setX(getX() + getSpeed());
            }
            System.out.println(getX() + "  " + getY());
            if(!(x >= 0 && x <= 1100 && y >= 0 && y <= 750 && isLived)){
                setLived(false);
                break;
            }
        }
    }


}

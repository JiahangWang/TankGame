package TankGame03;

/**
 * The type Tank 01.
 */
public class Hero extends Tank {

    /**
     * The Shoot.
     */
    Shoot shoot;

    /**
     * Instantiates a new Hero.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Hero(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    /**
     * Instantiates a new Hero.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     * @param speed     the speed
     */
    public Hero(int x, int y, Direction direction, int speed) {
        super(x, y, direction, speed);
    }

    /**
     * Fire.
     */
    public void fire(){
        switch (getDirection()){
            case UP:
                shoot = new Shoot(getX() + 25,getY() - 10,Direction.UP);
                break;
            case DOWN:
                shoot = new Shoot(getX() + 25,getY() + 70,Direction.DOWN);
                break;
            case RIGHT:
                shoot = new Shoot(getX() + 75,getY() + 25,Direction.RIGHT);
                break;
            case LEFT:
                shoot = new Shoot(getX() - 10,getY() + 25,Direction.LEFT);
                break;
        }
        new Thread(shoot).start();
    }
}

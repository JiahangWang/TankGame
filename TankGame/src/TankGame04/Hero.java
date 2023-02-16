package TankGame04;

import java.util.Vector;

/**
 * The type Tank 01.
 */
public class Hero extends Tank {

    /**
     * The Shoot.
     */
    private Shoot shoot;

    /**
     * The Shoots.
     */
    private Vector<Shoot> shoots = new Vector<>();

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
     * Gets shoot.
     *
     * @return the shoot
     */
    public Shoot getShoot() {
        return shoot;
    }

    /**
     * Sets shoot.
     *
     * @param shoot the shoot
     */
    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }

    /**
     * Gets shoots.
     *
     * @return the shoots
     */
    public Vector<Shoot> getShoots() {
        return shoots;
    }

    /**
     * Sets shoots.
     *
     * @param shoots the shoots
     */
    public void setShoots(Vector<Shoot> shoots) {
        this.shoots = shoots;
    }

    /**
     * Fire.
     */
    public void fire(){
        if(shoots.size() == 5){
            return;
        }
        switch (getDirection()) {
            case UP -> shoot = new Shoot(getX() + 25, getY() - 10, Direction.UP);
            case DOWN -> shoot = new Shoot(getX() + 25, getY() + 70, Direction.DOWN);
            case RIGHT -> shoot = new Shoot(getX() + 75, getY() + 25, Direction.RIGHT);
            case LEFT -> shoot = new Shoot(getX() - 10, getY() + 25, Direction.LEFT);
        }
        // add this shoot into shoots
        shoots.add(shoot);
        // start this shoot thread
        new Thread(shoot).start();
    }
}

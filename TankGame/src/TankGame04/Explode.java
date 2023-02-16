package TankGame04;

/**
 * The type Explode.
 */
public class Explode {

    private int x;
    private int y;
    /**
     * The Is lived.
     */
    boolean isLived = true;
    private int life = 9;

    /**
     * Instantiates a new Explode.
     *
     * @param x the x
     * @param y the y
     */
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Decrease life.
     */
    public void decreaseLife() {
        if(life > 0){
            life--;
        }
        else {
            isLived = false;
        }
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

    /**
     * Gets life.
     *
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * Sets life.
     *
     * @param life the life
     */
    public void setLife(int life) {
        this.life = life;
    }
}

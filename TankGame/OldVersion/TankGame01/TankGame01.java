package TankGame01;

import javax.swing.*;

/**
 * The type Tank game 01.
 * @author Jiahang Wang
 * @Version: 1.0
 */
public class TankGame01 extends JFrame {

    /**
     * The Mp.
     */
    MyPanel mp;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    /**
     * Instantiates a new Tank game 01.
     */
    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setLocation(500,250);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

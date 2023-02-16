package TankGame02;

import javax.swing.*;

/**
 * The type Tank game 02.
 * @author Jiahang Wang
 * @Version 2.0
 */
public class TankGame02 extends JFrame {

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
        TankGame02 tankGame02 = new TankGame02();
    }

    /**
     * Instantiates a new Tank game 02.
     */
    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setLocation(500,250);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

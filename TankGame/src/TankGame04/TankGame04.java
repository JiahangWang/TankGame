package TankGame04;

import javax.swing.*;


/**
 * The type Tank game 04.
 * @author Jiahang Wang
 * @version 4.0
 */
public class TankGame04 extends JFrame {


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
        TankGame04 tankGame04 = new TankGame04();
    }


    /**
     * Instantiates a new Tank game 04.
     */
    public TankGame04() {
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setLocation(500,250);
        this.setSize(1100,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

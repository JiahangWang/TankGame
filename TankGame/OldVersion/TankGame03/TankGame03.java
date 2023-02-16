package TankGame03;

import javax.swing.*;


/**
 * The type Tank game 03.
 * @author Jiahang Wang
 * @version 3.0
 */
public class TankGame03 extends JFrame {


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
        TankGame03 tankGame03 = new TankGame03();
    }


    /**
     * Instantiates a new Tank game 03.
     */
    public TankGame03() {
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

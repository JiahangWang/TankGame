package EventTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {

    MyPanel mp;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        // 窗口JFrame，可以监听键盘事件
        this.addKeyListener(mp);
        this.setLocation(500,250);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// KeyListener 是监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    int x = 120;
    int y = 150;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) { // 有字符输出时，该方法会触发

    }

    @Override
    public void keyPressed(KeyEvent e) {  // 当某个键按下时，该方法会触发
        switch (e.getKeyCode()){
            case KeyEvent.VK_S :
                y += 5;
                break;
            case KeyEvent.VK_W:
                y -= 5;
                break;
            case KeyEvent.VK_A:
                x -= 5;
                break;
            case KeyEvent.VK_D:
                x += 5;
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {  // 当某个键松开时，该方法触发

    }
}

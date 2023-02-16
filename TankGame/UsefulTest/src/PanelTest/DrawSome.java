package PanelTest;

import javax.swing.*;

public class DrawSome extends JFrame {  // JFrame对应窗口，可以理解成是一个画框

    // 定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawSome();
    }

    public DrawSome() { // 构造器
        // 初始化面板
        mp = new MyPanel();
        // 把面板放入到窗口（画框）
        this.add(mp);
        // 设置窗口大小
        this.setSize(800,700);
        // 当点击窗口小×，程序退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可以显示
        this.setVisible(true);
    }

}

package PanelTest;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g);  // 调用父类的方法完成初始化
        // 获取图片资源 路径为相对于根目录的位置
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/cat.jpg"));
        g.drawImage(image,300,300,129,115,this);
        // 画字符串
        g.setColor(Color.BLUE);
        g.setFont(new Font("黑体",Font.CENTER_BASELINE,45));
        g.drawString("玖玖",300,530); // 坐标为字符串的左下角
    }

}

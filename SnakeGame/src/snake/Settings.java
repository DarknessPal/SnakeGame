package snake;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class Settings extends JPanel implements ActionListener {
    private final int width = Settings.screenHeight - 20*2;
    private final int height = Settings.screenHeight - (20*2);
    JPanel setAppleColor = new JPanel();
    public static int screenWidth = 420;
    public static int screenHeight = 440;
    public static int snakeLength = 1;
    public static Color appleColor = GREEN;
    public static Color snakeColor = RED;
    public static int snakeSpeed = 120;
    String selectAppleColorString = "Select Apple Color";
    public void draw(Graphics g) {
        appleColor(g);
    }
    public Settings() {

        setLayout(null);
        Color[] colors = {RED, ORANGE, YELLOW, GREEN, BLUE, PINK, CYAN, DARK_GRAY, GRAY, BLACK,};
        JComboBox selectAppleColor = new JComboBox(colors);
 /*        box.setEditable(false);
        box.addItemListener(this);
        comboBoxPane.add(box);*/

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectAppleColor.getSelectedIndex() == 0) {
                    appleColor = RED;
                } else if (selectAppleColor.getSelectedIndex() == 1) {
                    appleColor = BLUE;
                }
            }
        };
 //       selectAppleColor.addActionListener(actionListener);
 /*   selectAppleColor.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
                if (box.getSelectedIndex() == 0) {
                    text.setBackgroud(Corol.red);
                } else if (box.getSelectedIndex() == 1) {
                    text.setBackgroud(Corol.blue);
                }
            }
        }
    });*/

        this.setSize(400, 400);
        this.setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

        }

    public void appleColor (Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Ink Free", Font.BOLD, 10));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(selectAppleColorString, (width - metrics.stringWidth(selectAppleColorString))/2,height/2);
    }

    private static void createAndShowGUI() {

    }
}

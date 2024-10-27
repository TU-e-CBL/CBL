package CBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TextPanel extends JPanel {

    public static JLabel lineLabel;
    private JLabel enter;
    
    public TextPanel() {
        
        setLayout(null); 
        setBackground(Color.BLACK);
        
        lineLabel = new JLabel("...", SwingConstants.LEFT);
        enter = new JLabel("▶", SwingConstants.RIGHT);
        addLabel(lineLabel, SwingConstants.LEFT, SwingConstants.TOP);
        addLabel(enter, SwingConstants.RIGHT, SwingConstants.BOTTOM);
        enter.setVisible(false);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 5),
            BorderFactory.createEmptyBorder(10, 10, 10, 10) 
        ));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < Play.screenHeight; i = i + 16) {
            g.fillRect(0, i, Play.screenWidth, 4);
        }
             //* */
    }

    public void setParameters(int x, int y, int width, int height) {
        setSize(width, height);
        setBounds(x, y, width, height);

        for (var component : getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setBounds(25, 25, width - 50, height - 50); 
            }
        }
    }

    public void setLine(String line) {
        lineLabel.setText(line);
        repaint();
        revalidate();
    }

    public void addLabel(JLabel lineLabel, int horizontal, int vertical) {
        lineLabel.setForeground(Color.WHITE);
        lineLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        lineLabel.setHorizontalAlignment(horizontal);
        lineLabel.setVerticalAlignment(vertical); 
        add(lineLabel);
    }

    public void interaction(String[] dialogue, TextPanel textPanel) {
        Play.upPressed = false;
        Play.downPressed = false;
        Play.leftPressed = false;
        Play.rightPressed = false;
        Play.timer.stop();
    
        int[] currentLine = {0};

        textPanel.setVisible(true);

        Timer delayTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enter.setVisible(true);
                MouseAdapter[] mouseAdapter = new MouseAdapter[1]; 
                mouseAdapter[0] = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (currentLine[0] < dialogue.length) {
                            enter.setVisible(false);
                            Play.playSound("bleep.wav");
                            textPanel.setLine(dialogue[currentLine[0]]);
                            currentLine[0]++;
                        } else {
                            textPanel.setVisible(false); 
                            Play.timer.start();
                        }
                        new Timer(3000, new ActionListener() { 
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                enter.setVisible(true);
                                textPanel.addMouseListener(mouseAdapter[0]);
                                ((Timer) evt.getSource()).stop(); 
                            }
                        }).start();
                        textPanel.removeMouseListener(mouseAdapter[0]);
                    }
                };
                textPanel.addMouseListener(mouseAdapter[0]);
            }
        });
        delayTimer.setRepeats(false);  
        delayTimer.start();
    }
}

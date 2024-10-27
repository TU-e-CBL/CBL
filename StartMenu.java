package CBL;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartMenu extends JPanel {

    private static final int TILE_SIZE = 90; 
    TimeUnit time = TimeUnit.SECONDS; 
    private boolean drawBackground = true;

    public StartMenu(Play play) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>SETAGAYA<br/>HOUSE</div></html>", SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 64));

        JButton startButton = new JButton("NEW GAME");
        startButton.setFont(new Font("Arial", Font.BOLD, 32));
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);

        JButton exitButton = new JButton("EXIT TO DESKTOP");
        exitButton.setFont(new Font("Arial", Font.BOLD, 32));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (topFrame != null) {
                topFrame.dispose();
            }
        });
        

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 18)); // 2 rows, 1 column, with 10px vertical gap
        buttonPanel.setOpaque(false);
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        startButton.addActionListener(e -> {
            buttonPanel.setVisible(false);
            titleLabel.setText("<html><div style='text-align: center;'>SETAGAYA<br/>21:00</div></html>");
            drawBackground = false;
            setBackground(Color.BLACK);
            repaint(); 
            Timer timer = new Timer(3000, event -> { 
                setVisible(false);
                play.setFocusable(true);
                play.requestFocusInWindow();
            });
            
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start();
        });

        add(titleLabel, BorderLayout.CENTER);
        buttonPanel.setBorder(new EmptyBorder( 0, play.screenWidth / 3+50, play.screenHeight / 3, play.screenWidth / 3+50));
        add(buttonPanel, BorderLayout.SOUTH);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color darkGray = new Color(20, 20, 20);

        for (int y = 0; y < height; y += TILE_SIZE) {
            for (int x = 0; x < width; x += TILE_SIZE) {
                if ((x / TILE_SIZE + y / TILE_SIZE) % 2 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(darkGray);
                }
                if(drawBackground){
                    g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }
}
package CBL;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Play extends JPanel implements ActionListener {

    // public static CustomTextPanel textPanel;
    public static TextPanel textPanel = new TextPanel();
    public static Timer timer;
    private Character player; 
    private Collision collision; 
    private Rooms rooms;

    public static boolean upPressed = false;
    public static boolean downPressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;

    private JButton minimizeButton;
    private JButton closeButton;

    public static int screenWidth;
    public static int screenHeight;

    public Play() {
        timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
        requestFocusInWindow(); 
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
        int startX = 300;
        int startY =  screenHeight / 2 - 45;

        player = new Character(startX, startY); 
        rooms = new Rooms();
        collision = new Collision(rooms, this::repaint);
        rooms.floor2_kitchen();

        addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_W:
                            upPressed = true;
                            break;
                        case KeyEvent.VK_S:
                            downPressed = true;
                            break;
                        case KeyEvent.VK_A:
                            leftPressed = true;
                            break;
                        case KeyEvent.VK_D:
                            rightPressed = true;
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_W:
                            upPressed = false;
                            break;
                        case KeyEvent.VK_S:
                            downPressed = false;
                            break;
                        case KeyEvent.VK_A:
                            leftPressed = false;
                            break;
                        case KeyEvent.VK_D:
                            rightPressed = false;
                            break;
                    }
                }
            }
        );
        // smooth movement
        
        JPanel controlPanel = new JPanel();
        minimizeButton = new JButton("-");
        closeButton = new JButton("X");

        minimizeButton.addActionListener(e -> minimizeWindow());
        closeButton.addActionListener(e -> closeWindow());

        controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        controlPanel.add(minimizeButton);
        controlPanel.add(closeButton);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color backgroundColor = rooms.getBackgroundColor();
        int squareSize = getWidth() / 16;

        for (int i = 0; i < 16; i++) {
            for (int o = 0; o < 9; o++) {
                if ((i + o) % 2 == 0) {
                    g.setColor(backgroundColor);
                } else {
                    if (backgroundColor == Color.BLACK) {
                        g.setColor(Color.GRAY);
                    } else {
                        g.setColor(backgroundColor.darker());
                    }
                }

                int x = i * squareSize;
                int y = o * squareSize;
                g.fillRect(x, y, squareSize, squareSize);
            }
        }
        rooms.drawObjects(g);
        player.draw(g);
        //* 
        g.setColor(Color.BLACK);
        for (int i = 0; i < getHeight(); i = i + 15) {
            g.fillRect(0, i, getWidth(), 5);
        }
             //* */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Store previous position for collision detection
        int prevX = player.x;
        int prevY = player.y;


        collision.resolveMovement(player, prevX, prevY, rooms.getObjects(),
                                  upPressed, downPressed, leftPressed, rightPressed);

        // Update character's position
        player.setPosition(player.x, player.y);

        // Repaint to reflect position changes
        repaint();
    }

    private void minimizeWindow() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.setState(JFrame.ICONIFIED);
        }
    }

    private void closeWindow() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> {
                JFrame frame = new JFrame("Play");
                Play play = new Play();
                textPanel.setVisible(false);
                
                JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));
                
                play.setBounds(0, 0, screenWidth, screenHeight);
                layeredPane.add(play, Integer.valueOf(0));
                
                layeredPane.add(textPanel, Integer.valueOf(1)); 

                frame.add(layeredPane);
                frame.setUndecorated(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true); 
                play.requestFocusInWindow();
            }
        );
    }    
}

package CBL;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Play extends JPanel implements ActionListener {

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
        Timer timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
        requestFocusInWindow(); 
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
        int startX = screenWidth / 2 - 40;
        int startY =  screenHeight - 200;

        player = new Character(startX, startY, 80, 90, 12); 
        rooms = new Rooms();
        collision = new Collision(rooms, this::repaint);
        rooms.initRoom1();

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
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        rooms.drawObjects(g);
        player.draw(g);
        //* 
        g.setColor(Color.BLACK);
        for (int i = 0; i < getHeight(); i = i + 16) {
            g.fillRect(0, i, getWidth(), 4);
        }
             //* */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Store previous position for collision detection
        int prevX = player.getX();
        int prevY = player.getY();


        collision.resolveMovement(player, prevX, prevY, rooms.getObjects(),
                                  upPressed, downPressed, leftPressed, rightPressed);

        // Update character's position
        player.setPosition(player.getX(), player.getY());

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
        
                frame.setUndecorated(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(play); 
                frame.setVisible(true); 
        
                play.requestFocusInWindow(); 
            }
        );
    }    
}

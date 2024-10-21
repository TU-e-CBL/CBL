package CBL;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Play extends JPanel implements ActionListener {

    private Character player; 
    private Collision collision; 
    private Rooms rooms;

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    private JButton minimizeButton;
    private JButton closeButton;

    public Play() {
        Timer timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
        requestFocusInWindow(); 
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int startX = screenWidth / 2 - 40;
        int startY = screenHeight / 2 - 45;

        player = new Character(startX, startY, 4); 
        rooms = new Rooms();
        collision = new Collision(rooms, this::repaint);

        rooms.initRoom1(screenWidth, screenHeight);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Store previous position for collision detection
        int prevX = player.getX();
        int prevY = player.getY();

        collision.resolveMovement(player, prevX, prevY, rooms.getWalls(), rooms.getDoors(),
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
        JFrame frame = new JFrame("Play");
        Play playPanel = new Play();

        frame.setUndecorated(true); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.add(playPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        // Request focus to the play panel
        playPanel.requestFocusInWindow();
    }
}
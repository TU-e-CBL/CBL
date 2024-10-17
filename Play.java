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
        int startX = screenWidth / 2;
        int startY = screenHeight / 2;

        player = new Character(startX, startY); 
        rooms = new Rooms();
        collision = new Collision(rooms, this::repaint);

        rooms.initRoom1(screenWidth, screenHeight);

        addKeyListener(new KeyAdapter() {
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
        });
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
        // Draw player character
        player.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Store previous position for collision detection
        int prevX = player.getX();
        int prevY = player.getY();

        // Use the collision manager to resolve movement
        collision.resolveMovement(player.getMovement(), prevX, prevY, rooms.getWalls(), rooms.getDoors(),
                                  upPressed, downPressed, leftPressed, rightPressed);

        // Update character's position
        player.setPosition(player.getMovement().getX(), player.getMovement().getY());

        // Repaint to reflect position changes
        repaint();
    }

    private void minimizeWindow() {
        // Minimize the window
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.setState(JFrame.ICONIFIED);
        }
    }

    private void closeWindow() {
        // Close the application
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.dispose();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game with Character");
        Play playPanel = new Play();

        frame.setUndecorated(true); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.add(playPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        // Optionally, request focus to the play panel
        playPanel.requestFocusInWindow();
    }
}

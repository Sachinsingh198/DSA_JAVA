package OOPS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallBounceGame extends JPanel implements ActionListener {
    // Game variables
    private int ballX = 50, ballY = 50; // Ball starting position
    private int ballDX = 4, ballDY = 4; // Ball speed/direction
    private int ballSize = 20;
    private int paddleX = 150, paddleWidth = 80, paddleHeight = 10;
    private int paddleY = 350; // Paddle position
    private boolean gameRunning = true;

    public BallBounceGame() {
        // Set up timer for animation
        Timer timer = new Timer(16, this); // ~60 FPS
        timer.start();

        // Mouse listener for paddle control
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                paddleX = e.getX() - paddleWidth / 2; // Center paddle on mouse
                if (paddleX < 0) paddleX = 0; // Keep within bounds
                if (paddleX > getWidth() - paddleWidth) paddleX = getWidth() - paddleWidth;
            }
        });

        setFocusable(true);
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (gameRunning) {
            // Draw ball
            g.setColor(Color.RED);
            g.fillOval(ballX, ballY, ballSize, ballSize);

            // Draw paddle
            g.setColor(Color.WHITE);
            g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
        } else {
            // Game over text
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Game Over, Ace!", 120, 200);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            // Move ball
            ballX += ballDX;
            ballY += ballDY;

            // Bounce off walls
            if (ballX <= 0 || ballX + ballSize >= getWidth()) {
                ballDX = -ballDX;
            }
            if (ballY <= 0) {
                ballDY = -ballDY;
            }

            // Check paddle collision
            if (ballY + ballSize >= paddleY && ballY + ballSize <= paddleY + paddleHeight &&
                    ballX + ballSize >= paddleX && ballX <= paddleX + paddleWidth) {
                ballDY = -ballDY; // Bounce off paddle
            }

            // Game over if ball misses paddle
            if (ballY > getHeight()) {
                gameRunning = false;
            }
        }
        repaint(); // Redraw the screen
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Bounce Game - For Ace");
        BallBounceGame game = new BallBounceGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true);

    }
}

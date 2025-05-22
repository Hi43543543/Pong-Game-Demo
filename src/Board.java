import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final Ball ball;
    private final Paddle leftPaddle;
    private final Paddle rightPaddle;
    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.GRAY);

        ball = new Ball();
        leftPaddle = new Paddle(KeyEvent.VK_W, KeyEvent.VK_S, 15);
        rightPaddle = new Paddle(KeyEvent.VK_UP, KeyEvent.VK_DOWN, BOARD_WIDTH - PADDLE_WIDTH - 15);
        sprites = new ArrayList<>(List.of(ball, leftPaddle, rightPaddle));

        activeKeyCodes = new HashSet<>();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftPaddle.handleActiveKeys(activeKeyCodes);
        rightPaddle.handleActiveKeys(activeKeyCodes);

        for(Sprite sprite : sprites) {
            sprite.tick();
        }

        if(ball.isColliding(leftPaddle)) {
            ball.bounceRight();
            // bounce right
        } else if (ball.isColliding(rightPaddle)) {
            ball.bounceLeft();
            // bounce left
        }

        if (ball.pos.y <= 0 || ball.pos.y >= BOARD_HEIGHT - BALL_HEIGHT) {
            ball.flipVy();
        }




        if (ball.getPos().x <= -BALL_WIDTH) {
            rightPaddle.setScore(1);
            ball.resetBall();
            // Increase right player's score
        } else if (ball.getPos().x >= BOARD_WIDTH) {
            leftPaddle.setScore(1);
            ball.resetBall();
            // Increase left player's score
        }

        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }
        if(leftPaddle.getScore() == 11 || rightPaddle.getScore() ==11) {
            sprites.remove(leftPaddle);
            sprites.remove(rightPaddle);
            sprites.remove(ball);

            if (leftPaddle.getScore() < rightPaddle.getScore()) {
                graphics.drawString("Game Over, Right Wins!", 200, BOARD_HEIGHT / 3);
                graphics.drawString(("Final Score " + leftPaddle.getScore() + ":" + rightPaddle.getScore()), 220, BOARD_HEIGHT / 2);

                graphics.drawString(("The biggest rally was: " + rightPaddle.getScore()), 190, 320);
            } else {
                graphics.drawString("Game Over, Left Wins!", 200, BOARD_HEIGHT / 3);
                graphics.drawString(("Final Score " + leftPaddle.getScore() + ":" + rightPaddle.getScore()), 220, BOARD_HEIGHT / 2);
                graphics.drawString(("The biggest rally was: " + leftPaddle.getScore()), 190, 320);
            }
        } else {
            graphics.setFont(new Font("Arial", Font.BOLD, 42));
            graphics.setColor(Color.PINK);
            graphics.drawString("rally score: " + ball.getRally(),20,190);

            //drawing basic scoring system to screen
            graphics.drawString("right paddle score: " + leftPaddle.getScore(), 20, 90);
            graphics.drawString("left paddle score: " + rightPaddle.getScore(), 20, 140);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        activeKeyCodes.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        activeKeyCodes.remove(keyEvent.getKeyCode());
    }
}

import static utils.Constants.*;

import java.util.Set;

public class Paddle extends Sprite {
    private int upKey;
    private int downKey;
    private int dy;
    private int score;

    public Paddle(int upKey, int downKey, int xPos) {
        super(PADDLE_IMAGE_PATH, xPos, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        dy = 0;

        if (activeKeyCodes.contains(upKey)) {
            dy -= PADDLE_SPEED;
        }
        if (activeKeyCodes.contains(downKey)) {
            dy += PADDLE_SPEED;
        }
    }

    @Override
    public void tick() {
        pos.translate(0, dy);
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE_HEIGHT);
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score += score;
    }
}    
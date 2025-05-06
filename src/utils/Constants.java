package utils;

public final class Constants {
    private Constants() {
        // prevents instantiation
    }

    // Board constants
    public static final int BOARD_WIDTH = 650;
    public static final int BOARD_HEIGHT = 490;
    // A delay of 25 milliseconds results in a frame rate of 45 FPS.
    public static final int TICK_DELAY = 25;

    // Player constants
    public static final String PLAYER_IMAGE_PATH = "resources/amogus.png";
    public static final int PLAYER_WIDTH = 60;
    public static final int PLAYER_HEIGHT = 80;
    public static final int PLAYER_SPEED = 1;

    public static final String BALL_IMAGE_PATH = "resources/Peter who gets hit around.png";
    public static final int BALL_WIDTH = 100;
    public static final int BALL_HEIGHT = 110;
    public static final int BALL_SPEED = 3;

    // Wall constants
    public static final String WALL_IMAGE_PATH = "resources/wall.png";
    public static final int WALL_WIDTH = 200;
    public static final int WALL_HEIGHT = 200;
}

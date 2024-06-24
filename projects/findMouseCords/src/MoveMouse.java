import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;

public class MoveMouse {

    public static void main(String[] args) {
        // Get the coordinates where you want to move the mouse
        int targetX = 1261;
        int targetY = 1078;

        // Create an instance of Robot class
        try {
            Robot robot = new Robot();

            // Move the mouse cursor to the target coordinates
            robot.mouseMove(targetX, targetY);

            // Print a message indicating the mouse has been moved
            System.out.println("Mouse moved to: X = " + targetX + ", Y = " + targetY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

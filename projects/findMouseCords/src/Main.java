import java.awt.*;

public class Main {

    public static void main(String[] args) {
        while (true) {
            // Get current mouse pointer info
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();

            // Extract coordinates
            int xCoord = pointerInfo.getLocation().x;
            int yCoord = pointerInfo.getLocation().y;

            // Print coordinates
            System.out.println("Mouse coordinates: X = " + xCoord + ", Y = " + yCoord);

            // Sleep for a short duration to avoid high CPU usage
            try {
                Thread.sleep(500); // Adjust the duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
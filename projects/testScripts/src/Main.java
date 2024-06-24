import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int length = 8;
        System.out.println(generateRandomString(length));
    }
    public static String generateRandomString(int length) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        return sb.toString();
    }
}
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

// Import Bouncy Castle for additional cryptographic algorithms
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@SuppressWarnings("unused")
public class CryptoTool {
    static {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String generateSHA256Hash(byte[] data) throws NoSuchAlgorithmException {
        // Generate SHA-256 hash of the input data
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Update the digest with the input data
        byte[] hash = digest.digest(data);
        StringBuilder hexString = new StringBuilder();
        // Convert byte array to hex string
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Welcome to the CryptoTool ---");
        System.out.println("Choose an option:");
        System.out.println("1. Generate SHA-256 Hash of Text");
        System.out.println("0. Exit");

        int choice = -1;
        while (choice != 0) {
            System.out.println("\nYour choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter th text to hash using SHA-256:");
                        String textToHash = scanner.nextLine();
                        try {
                            String hash = generateSHA256Hash(textToHash.getBytes());
                            System.out.println("SHA-256 Hash: " + hash);
                        } catch (NoSuchAlgorithmException e) {
                            System.out.println("Error generating hash: " + e.getMessage());
                        } break;
                    case 0:
                        System.out.println("Exiting the CryptoTool. Bye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

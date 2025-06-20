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

    public static String generateSHA256HashFromFile (String filePath) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Try to read the file
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Read the file in chunks
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Update the digest with the bytes read
                digest.update(buffer, 0, bytesRead);
            }
        }
        byte[] hash = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static SecretKey generateAESkey() throws NoSuchAlgorithmException {
        // Generate a new AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Use 256-bit AES
        return keyGen.generateKey();
    }

    public static IvParameterSpec generateIV() {
        // Generate a new Initialization Vector (IV) for AES
        byte[] iv = new byte[16]; // AES block size is 16 bytes
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static byte[] encryptAES(byte[] data, SecretKey key, IvParameterSpec iv) throws Exception {
        // Get a Cipher instance for AES in CBC mode with PKCS7Padding
        // The "BC" at the end indicates that we are preferring the Bouncy Castle implementation
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // Initialize the cipher for encryption with the provided key and IV
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        // Encrypt the data
        return cipher.doFinal(data);
    }

    public static byte[] decryptAES(byte[] encryptedData, SecretKey key, IvParameterSpec iv) throws Exception {
        // Get a Cipher instance for AES in CBC mode with PKCS7Padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // Initialize the cipher for decryption with the provided key and IV
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        // Decrypt the data
        return cipher.doFinal(encryptedData);
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Welcome to the CryptoTool ---");
        System.out.println("Choose an option:");
        System.out.println("1. Generate SHA-256 Hash of Text");
        System.out.println("2. Generate SHA-256 Hash of File");
        System.out.println("3. Generate AES and IV key");
        System.out.println("4. Encrypt Text using AES");
        System.out.println("5. Decrypt Text using AES");
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
                    case 2:
                        System.out.println("Enter the file path to hash using SHA-256:");
                        String filePath = scanner.nextLine();
                        try {
                            String fileHash = generateSHA256HashFromFile(filePath);
                            System.out.println("SHA-256 Hash of file: " + fileHash);
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + e.getMessage());
                        } catch (NoSuchAlgorithmException e) {
                            System.out.println("Error generating hash: " + e.getMessage());
                        } break;
                    case 3:
                        try {
                            SecretKey aesKey = generateAESkey();
                            IvParameterSpec iv = generateIV();
                            System.out.println("Generated AES Key: " + Base64.getEncoder().encodeToString(aesKey.getEncoded()));
                            System.out.println("Generated IV (Base64): " + Base64.getEncoder().encodeToString(iv.getIV()));
                            System.out.println("You can use these keys for AES encryption/decryption.");
                        } catch (NoSuchAlgorithmException e) {
                            System.out.println("Error generating AES key: " + e.getMessage());
                        } break;
                    case 4:
                        System.out.print("Text to encrypt: ");
                        String plainText = scanner.nextLine();
                        System.out.print("Enter AES Key (Base64): ");
                        String keyB64 = scanner.nextLine();
                        System.out.print("Enter IV (Base64): ");
                        String ivB64 = scanner.nextLine();

                        try {
                            SecretKey aesKey = new SecretKeySpec(Base64.getDecoder().decode(keyB64), "AES");
                            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(ivB64));
                            byte[] encryptedData = encryptAES(plainText.getBytes(), aesKey, iv);
                            System.out.println("Encrypted Data (Base64): " + Base64.getEncoder().encodeToString(encryptedData));
                        } catch (Exception e) {
                            System.out.println("Error during encryption: " + e.getMessage());
                        } break;
                    case 5:
                        System.out.print("Text to decrypt: ");
                        String encryptedText = scanner.nextLine();
                        System.out.print("Enter AES Key (Base64): ");
                        String decryptKeyB64 = scanner.nextLine();
                        System.out.print("Enter IV (Base64): ");
                        String decryptIvB64 = scanner.nextLine();

                        try {
                            SecretKey aesKey = new SecretKeySpec(Base64.getDecoder().decode(decryptKeyB64), "AES");
                            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(decryptIvB64));
                            byte[] decryptedData = decryptAES(Base64.getDecoder().decode(encryptedText), aesKey, iv);
                            System.out.println("Decrypted Data: " + new String(decryptedData));
                        } catch (Exception e) {
                            System.out.println("Error during decryption: " + e.getMessage());
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

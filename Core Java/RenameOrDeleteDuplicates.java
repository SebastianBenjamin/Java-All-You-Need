import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;

public class RenameOrDeleteDuplicates {

    public static void main(String[] args) throws Exception {
        // Update this path to your folder path
        File folder = new File("E:\\KJSIM\\Sem 1\\Benjamin_Sebastian_MCA-2024-26_Java (1)");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".java") && name.matches(".* \\(\\d+\\)\\.java"));

        if (files == null) {
            System.out.println("Folder not found or empty.");
            return;
        }

        for (File duplicate : files) {
            String originalName = duplicate.getName().replaceAll(" \\(\\d+\\)", "");
            File originalFile = new File(folder, originalName);

            if (!originalFile.exists()) {
                // No original exists → rename
                File newFile = new File(folder, originalName);
                if (duplicate.renameTo(newFile)) {
                    System.out.println("Renamed: " + duplicate.getName() + " → " + originalName);
                } else {
                    System.out.println("Failed to rename: " + duplicate.getName());
                }
            } else {
                // Compare content
                String hash1 = getFileHash(duplicate);
                String hash2 = getFileHash(originalFile);

                if (hash1.equals(hash2)) {
                    // Same content → delete duplicate
                    if (duplicate.delete()) {
                        System.out.println("Deleted duplicate: " + duplicate.getName());
                    } else {
                        System.out.println("Failed to delete: " + duplicate.getName());
                    }
                } else {
                    // Different content → leave it
                    System.out.println("Conflict: " + duplicate.getName() + " ≠ " + originalName);
                }
            }
        }
    }

    // Generate SHA-256 hash of file content
    private static String getFileHash(File file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = Files.readAllBytes(file.toPath());
        byte[] hash = digest.digest(bytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

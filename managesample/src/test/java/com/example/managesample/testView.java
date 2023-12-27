package com.example.managesample;

import javax.swing.*;
import java.io.File;

public class testView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            chooseAndPrintFilePath();
        });
    }

    private static void chooseAndPrintFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // In ra đường dẫn của tệp được chọn
            System.out.println("Đường dẫn tệp được chọn: " + filePath);
        } else {
            // Người dùng đã chọn Cancel hoặc có lỗi xảy ra
            System.out.println("Không có tệp nào được chọn.");
        }
    }
}

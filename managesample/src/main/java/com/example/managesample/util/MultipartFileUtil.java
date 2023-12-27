package com.example.managesample.util;

import com.example.managesample.model.Sample;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MultipartFileUtil {
    public static void createFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path path= Paths.get(uploadDir);
        if(!Files.exists(path)){
            Files.createDirectories(path);
        }

        try(InputStream inputStream= multipartFile.getInputStream()){
            Path filePath= path.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException exception){
            throw new IOException("can't save file");
        }
    }

    public static void deleteFile(Sample sample) throws IOException {
        Path path = Path.of(sample.getPath());
        Files.delete(path);
    }

    public static void updateFile(Sample sample, String newName) throws IOException {
        Path path = Path.of( sample.getPath());
        Files.move(path, path.resolveSibling(newName));
    }

//    public static void createLabelFile(String sampleName) throws IOException {
//        String name = sampleName.split("\\.")[0];
//        String fileName = "D:\\test flask cors\\retrain\\labels\\train\\" +name + ".txt";
//        String content= "";
//        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName));
//        writer.write(content);
//        writer.close();
//    }

//    new
//    example: D:\test flask cors\data\images\train
    public static void createLabelFile(Sample sample) throws IOException {
        System.out.println(sample.getPath());
        String name = sample.getName().split("\\.")[0];
        String pathForLabel = sample.getPath().replace("images", "labels");
        String fileName = pathForLabel+ "\\" +name + ".txt";
        System.out.println(fileName);
        String content= "";
        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }

//    public static void deleteLabelFile(String fileName){
//        String[] parts = fileName.split("\\.");
//        String path = "D:\\test flask cors\\retrain\\labels\\train\\" + parts[0] + ".txt";
//        File file = new File(path);
//        file.delete();
//    }
    public static void deleteLabelFile(Sample sample){
        String[] parts = sample.getName().split("\\.");
        String samplePath = sample.getPath().replace("images", "labels");
        String parentPath = samplePath.substring(0, samplePath.lastIndexOf("\\"));
        String path = parentPath + "\\" + parts[0] + ".txt";
        System.out.println(path);
        File file = new File(path);
        file.delete();
    }


//    public static void generateLabelHavingInfor(String name, String data) throws IOException {
//        String[] parts = name.split("\\.");
//        String fileName = "D:\\test flask cors\\retrain\\labels\\train\\" + parts[0] + ".txt";
//        String content= data;
//        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName));
//        writer.write(content);
//        writer.close();
//    }

    public static void generateLabelHavingInfor(Sample sample, String data) throws IOException {
        String[] parts = sample.getName().split("\\.");
        String samplePath = sample.getPath().replace("images", "labels");
        String parentPath = samplePath.substring(0, samplePath.lastIndexOf("\\"));
        String path = parentPath + "\\" + parts[0] + ".txt";
        String content= data;
        BufferedWriter writer= new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();
    }
}

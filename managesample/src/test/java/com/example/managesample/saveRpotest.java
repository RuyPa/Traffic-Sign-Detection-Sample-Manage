package com.example.managesample;

import com.example.managesample.model.Sample;
import com.example.managesample.model.User;
import com.example.managesample.repository.LabelRepository;
import com.example.managesample.repository.SampleRepository;
import com.example.managesample.repository.UserRepository;
import com.example.managesample.util.MultipartFileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class saveRpotest {
    @Autowired private SampleRepository sampleRepository;
    @Autowired private LabelRepository labelRepository;
    @Autowired private UserRepository userRepository;

//    @Test
//    public void tesst(){
//        Sample sample= new Sample(1,"2","3", "asf");
//        Sample sample1= sampleRepository.save(sample);
//    }

//    @Test
//    public void deleteFile() throws IOException {
//        Sample sample = sampleRepository.getReferenceById(11);
//        Path path = Path.of(sample.getPath());
//        Files.delete(path);
//    }

//    @Test
//    public void saveFile() throws IOException {
//        Sample sample = sampleRepository.getReferenceById(10);
//        MultipartFileUtil.updateFile(sample);
//    }

//    @Test
//    public void tesstasgsa(){
//        Sample sample= sampleRepository.getById(1);
////        sample.setLabels(labelRepository.getAllBySampleId(sample.getId()));
//        System.out.println(sample.getLabels().size());
//    }

//    @Test() okkkk dung cho tim ten file
//    public void testaste(){
//        String path = "D:\\test flask cors\\data\\labels\\train";
//        String filename = "20210329_60611d7abc7af.txt";
//        File file = new File(path);
//        File[] files = file.listFiles();
//        for(File file1 : files){
//            if(file1.getName().equals(filename)){
//                System.out.println("iokkk");
//            }
//        }
//    }

//    @Test
//    public void generateFile() throws IOException {
//        String name = "test";
//        String fileName = "D:\\test flask cors\\data\\labels\\train\\" +name + ".txt";
//        String content= "0 0.455895 0.153748 0.259010 0.234283\n" +
//                "0 0.449915 0.351845 0.211190 0.142849";
//
//        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName));
//        writer.write(content);
//        writer.close();
//
//
////        0 0.425425 0.156340 0.132394 0.179175
////        0 0.516931 0.228969 0.152548 0.135567
//    }

//    @Test
//    public void removeFile(){
//        String path = "D:\\test flask cors\\data\\labels\\train\\test.txt";
//        File file = new File(path);
//        file.delete();
//    }

//    @Test
//    public void createfileellae() throws IOException {
//        MultipartFileUtil.createLabelFile("hoa.png");
//    }

//    @Test
//    public void username(){
//        User user= userRepository.getUserByUsername("nokidding121002@gmail.com");
//        System.out.println(user);
//    }

//    @Test
//    public void addANewSampleByPath(){
//
//    }


//    public Sample addSample(Sample sample, MultipartFile multipartFile) throws IOException {
//        String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        sample.setName(fileName);
//        MultipartFileUtil.createLabelFile(sample.getName());
//        sample= sampleRepository.save(sample);
//        String upload = "D:\\test flask cors\\retrain\\images\\train";
//        MultipartFileUtil.createFile(upload, fileName, multipartFile);
//        sample.setPath(upload + "\\" + fileName);
//        sample= sampleRepository.save(sample);
//        return sampleRepository.save(sample);
//    }

}

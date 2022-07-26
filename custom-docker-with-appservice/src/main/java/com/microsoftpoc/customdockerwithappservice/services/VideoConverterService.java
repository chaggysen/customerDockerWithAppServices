package com.microsoftpoc.customdockerwithappservice.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import com.microsoftpoc.customdockerwithappservice.enums.ConversionStatus;

@Service
public class VideoConverterService {
    
    public ConversionStatus convertMp4ToAvi(String inputMp4Path, String outputAviPath){
        // MAKE SURE TO CHANGE PATHS
        String ffmpegPath = "\"C:/Users/Administrator/Documents/PoCs/customerDockerWithAppServices/custom-docker-with-appservice/ffmpeg\"";
        String command = ffmpegPath + " -i \"" + inputMp4Path + "\" \"" + outputAviPath + "\""; 

        File out = new File("C:/Users/Administrator/Documents/PoCs/customerDockerWithAppServices/custom-docker-with-appservice/output.txt"); // File to write stdout to
        File err = new File("C:/Users/Administrator/Documents/PoCs/customerDockerWithAppServices/custom-docker-with-appservice/output.txt"); // File to write stderr to    

        ProcessBuilder processBuilder = new ProcessBuilder().command(command);

        processBuilder.redirectOutput(out); // Redirect stdout to file

        if(out == err) { 
            processBuilder.redirectErrorStream(true); // Combine stderr into stdout
          } else { 
            processBuilder.redirectError(err); // Redirect stderr to file
          }

        try {
            Process process = processBuilder.start();
     
            //read the output
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String output = null;
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
            }
            //wait for the process to complete
            process.waitFor();
     
            //close the resources
            bufferedReader.close();
            process.destroy();
            return ConversionStatus.SUCCESS;
     
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ConversionStatus.FAILURE;
        }

    }
}

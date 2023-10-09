package com.miraz.universitybackend.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BackupService {

//    @Scheduled(cron = "0 0 * * * *") // Runs every hour at the top of the hour
    @Scheduled(cron = "0 */1 * * * *") // Runs every 1 minutes
    public void performBackup() throws IOException {
        // Execute the mongodump command to create a backup
        String command = "mongodump --uri \"mongodb+srv://miraz:miraz@cluster0.p7znshz.mongodb.net/university\" --out C:\\Users\\wwwmi\\dump";
        Process process = Runtime.getRuntime().exec(command);

        // Wait for the process to complete
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check the exit value of the process to handle any errors
        int exitValue = process.exitValue();
        if (exitValue == 0) {
            System.out.println("Backup completed successfully.");
            // Execute the mongorestore command to import the data
            String importCommand = "mongorestore --host localhost --port 27017 --db backup C:\\Users\\wwwmi\\dump\\university";
            Process importProcess = Runtime.getRuntime().exec(importCommand);

            // Wait for the import process to complete
            try {
                importProcess.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check the exit value of the import process
            int importExitValue = importProcess.exitValue();
            if (importExitValue == 0) {
                System.out.println("Import completed successfully.");
            } else {
                System.out.println("Import failed. Exit value: " + importExitValue);
            }
        } else {
            System.out.println("Backup failed. Exit value: " + exitValue);
        }
    }
}
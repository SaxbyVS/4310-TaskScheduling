package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class JobFileGenerator {

    public static void generate_job_file(int jobCount){
            try{
                FileWriter wr = new FileWriter("data/job.txt");
                Random rand = new Random();

                BufferedWriter bw = new BufferedWriter(wr);
                for (int i = 0; i < jobCount; i++){
                    int burstTime = rand.nextInt(20) + 1;
                    bw.write("Job "+String.valueOf(i + 1));
                    bw.newLine();
                    bw.write(String.valueOf(burstTime));
                    if (i != jobCount - 1){
                        bw.newLine();
                    }
                }

                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}

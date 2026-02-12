package org.example;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import Algorithms.*;
import Type.*;
import File.*;

/*
MAIN:
    - testing file
        -correctness and trialing
 */

public class Main {
    public static void main(String[] args) throws IOException {

        //CORRECTNESS TESTING
//        correctness_testing();

        //TRIALING
        trial(15);
//        JobFileGenerator.generate_job_file(5);
    }

    public static void trial(int jobCount) throws IOException {
        System.out.println("Beginning Trials");
        System.out.println("-----------------------------\n");

        System.out.println(jobCount+ " Job Trials:");
        int trialCount = 20;

        //lists to hold avg times for each trial
        List<Double> FCFS_times = new ArrayList<>();
        List<Double> SJF_times = new ArrayList<>();
        List<Double> RR2_times = new ArrayList<>();
        List<Double> RR5_times = new ArrayList<>();

        //generate new job file and run on each algorithm
        for (int i = 0; i < trialCount; i++) {
            System.out.println("Trial "+(i+1));
            JobFileGenerator.generate_job_file(jobCount);

            ScheduleResult fcfs_result = FCFS.schedule(FileHandler.job_file_read("data/job.txt"));
            FCFS_times.add(fcfs_result.avgTurnaroundTime);
            ScheduleResult sjf_result = SJF.schedule(FileHandler.job_file_read("data/job.txt"));
            SJF_times.add(sjf_result.avgTurnaroundTime);
            ScheduleResult rr2_result = RR.schedule(FileHandler.job_file_read("data/job.txt"), 2);
            RR2_times.add(rr2_result.avgTurnaroundTime);
            ScheduleResult rr5_result = RR.schedule(FileHandler.job_file_read("data/job.txt"), 5);
            RR5_times.add(rr5_result.avgTurnaroundTime);
        }

        //calc averages and save results
        OptionalDouble FCFS_avg = FCFS_times.stream().mapToDouble(Double::doubleValue).average();
        OptionalDouble SJF_avg = SJF_times.stream().mapToDouble(Double::doubleValue).average();
        OptionalDouble RR2_avg = RR2_times.stream().mapToDouble(Double::doubleValue).average();
        OptionalDouble RR5_avg = RR5_times.stream().mapToDouble(Double::doubleValue).average();

        String output_path = "data/output.txt";
        FileHandler.saveResults(output_path, "++ " + jobCount+ " Job Trial Results ++\n");
        FileHandler.saveResults(output_path, "FCFS avg time: "+FCFS_avg.getAsDouble());
        FileHandler.saveResults(output_path, "SJF avg time: "+SJF_avg.getAsDouble());
        FileHandler.saveResults(output_path, "RR2 avg time: "+RR2_avg.getAsDouble());
        FileHandler.saveResults(output_path, "RR5 avg time: "+RR5_avg.getAsDouble()+"\n");

        System.out.println("********** END OF TRIALS **********");

    }

    public static void correctness_testing() throws IOException {
        //TESTING CASE 1, 2, 3
        System.out.println("--CORRECTNESS TESTING--\n");

        //FCFS
        System.out.println("FIRST COME FIRST SERVE: \n");

        System.out.println("FCFS TEST CASE 1");
        ScheduleResult fcfs_result1 = FCFS.schedule(FileHandler.job_file_read("data/test1.txt"), true);
        System.out.println(fcfs_result1+"\n");

        System.out.println("FCFS TEST CASE 2");
        ScheduleResult fcfs_result2 = FCFS.schedule(FileHandler.job_file_read("data/test2.txt"), true);
        System.out.println(fcfs_result2+"\n");

        System.out.println("FCFS TEST CASE 3");
        ScheduleResult fcfs_result3 = FCFS.schedule(FileHandler.job_file_read("data/test3.txt"), true);
        System.out.println(fcfs_result3+"\n");

        //SJF
        System.out.println("SHORTEST JOB FIRST: \n");

        System.out.println("SJF TEST CASE 1");
        ScheduleResult sjf_result1 = SJF.schedule(FileHandler.job_file_read("data/test1.txt"), true);
        System.out.println(sjf_result1+"\n");

        System.out.println("SJF TEST CASE 2");
        ScheduleResult sjf_result2 = SJF.schedule(FileHandler.job_file_read("data/test2.txt"), true);
        System.out.println(sjf_result2+"\n");

        System.out.println("SJF TEST CASE 3");
        ScheduleResult sjf_result3 = SJF.schedule(FileHandler.job_file_read("data/test3.txt"), true);
        System.out.println(sjf_result3+"\n");

        //RR2
        System.out.println("ROUND ROBIN 2: \n");

        System.out.println("RR-2 TEST CASE 1");
        ScheduleResult rr2_result1 = RR.schedule(FileHandler.job_file_read("data/test1.txt"), 2, true);
        System.out.println(rr2_result1+"\n");

        System.out.println("RR-2 TEST CASE 2");
        ScheduleResult rr2_result2 = RR.schedule(FileHandler.job_file_read("data/test2.txt"), 2, true);
        System.out.println(rr2_result2+"\n");

        System.out.println("RR-2 TEST CASE 3");
        ScheduleResult rr2_result3 = RR.schedule(FileHandler.job_file_read("data/test3.txt"), 2, true);
        System.out.println(rr2_result3+"\n");

        //RR5
        System.out.println("ROUND ROBIN 5: \n");

        System.out.println("RR-5 TEST CASE 1");
        ScheduleResult rr5_result1 = RR.schedule(FileHandler.job_file_read("data/test1.txt"), 5, true);
        System.out.println(rr5_result1+"\n");

        System.out.println("RR-5 TEST CASE 2");
        ScheduleResult rr5_result2 = RR.schedule(FileHandler.job_file_read("data/test2.txt"), 5, true);
        System.out.println(rr5_result2+"\n");

        System.out.println("RR-5 TEST CASE 3");
        ScheduleResult rr5_result3 = RR.schedule(FileHandler.job_file_read("data/test3.txt"), 5, true);
        System.out.println(rr5_result3+"\n");
    }
}
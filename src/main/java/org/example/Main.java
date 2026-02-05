package org.example;
import java.io.IOException;
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
        correctness_testing();


    }

    public static void correctness_testing() throws IOException {
        //TESTING CASE 1, 2, 3
        System.out.println("--CORRECTNESS TESTING--\n");

        //FCFS
        System.out.println("FIRST COME FIRST SERVE: \n");

        System.out.println("FCFS TEST CASE 1");
        ScheduleResult fcfs_result1 = FCFS.schedule(FileHandler.job_file_read("data/test1.txt"));
        System.out.println(fcfs_result1+"\n");

        System.out.println("FCFS TEST CASE 2");
        ScheduleResult fcfs_result2 = FCFS.schedule(FileHandler.job_file_read("data/test2.txt"));
        System.out.println(fcfs_result2+"\n");

        System.out.println("FCFS TEST CASE 3");
        ScheduleResult fcfs_result3 = FCFS.schedule(FileHandler.job_file_read("data/test3.txt"));
        System.out.println(fcfs_result3+"\n");

        //SJF
        System.out.println("SHORTEST JOB FIRST: \n");

        System.out.println("SJF TEST CASE 1");
        ScheduleResult sjf_result1 = SJF.schedule(FileHandler.job_file_read("data/test1.txt"));
        System.out.println(sjf_result1+"\n");

        System.out.println("SJF TEST CASE 2");
        ScheduleResult sjf_result2 = SJF.schedule(FileHandler.job_file_read("data/test2.txt"));
        System.out.println(sjf_result2+"\n");

        System.out.println("SJF TEST CASE 3");
        ScheduleResult sjf_result3 = SJF.schedule(FileHandler.job_file_read("data/test3.txt"));
        System.out.println(sjf_result3+"\n");

        //RR2
        System.out.println("ROUND ROBIN 2: \n");

        System.out.println("RR-2 TEST CASE 1");
        ScheduleResult rr2_result1 = RR.schedule(FileHandler.job_file_read("data/test1.txt"), 2);
        System.out.println(rr2_result1+"\n");

        System.out.println("RR-2 TEST CASE 2");
        ScheduleResult rr2_result2 = RR.schedule(FileHandler.job_file_read("data/test2.txt"), 2);
        System.out.println(rr2_result2+"\n");

        System.out.println("RR-2 TEST CASE 3");
        ScheduleResult rr2_result3 = RR.schedule(FileHandler.job_file_read("data/test3.txt"), 2);
        System.out.println(rr2_result3+"\n");

        //RR5
        System.out.println("ROUND ROBIN 5: \n");

        System.out.println("RR-5 TEST CASE 1");
        ScheduleResult rr5_result1 = RR.schedule(FileHandler.job_file_read("data/test1.txt"), 5);
        System.out.println(rr5_result1+"\n");

        System.out.println("RR-5 TEST CASE 2");
        ScheduleResult rr5_result2 = RR.schedule(FileHandler.job_file_read("data/test2.txt"), 5);
        System.out.println(rr5_result2+"\n");

        System.out.println("RR-5 TEST CASE 3");
        ScheduleResult rr5_result3 = RR.schedule(FileHandler.job_file_read("data/test3.txt"), 5);
        System.out.println(rr5_result3+"\n");
    }
}
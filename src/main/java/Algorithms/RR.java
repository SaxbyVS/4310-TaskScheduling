package Algorithms;

import Type.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Class RR:
    - Round Robin algo
    - schedule function takes list of jobs and specific quantum; returns ScheduleResult obj
 */

public class RR {

    public static ScheduleResult schedule(List<ProcessJob> processes, int quantum){
        int time = 0;
        Queue<ProcessJob> jobQ = new LinkedList<ProcessJob>(processes);

        while(!jobQ.isEmpty()){
            ProcessJob job = jobQ.poll();

            int runTime = Math.min(job.remainingTime, quantum);
            time += runTime;
            job.remainingTime -= runTime;

            if (job.remainingTime > 0){
                jobQ.offer(job);
            }else{
                job.completionTime = time;
            }
        }

        return new ScheduleResult(processes);
    }
}

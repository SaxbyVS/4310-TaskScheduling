package Type;

import java.util.List;

/*
Class ScheduleResult:
    - used to store result of scheduling algorithm execution (see Algorithms)
    - holds list of processes (ProcessJob)
    - holds/computes average turnaround time for list of completed jobs
 */

public class ScheduleResult {
    public List<ProcessJob> processJobs;
    public double avgTurnaroundTime;

    public ScheduleResult(List<ProcessJob> procs){
        this.processJobs = procs;
        this.avgTurnaroundTime = (double) procs.stream().mapToInt(p -> p.completionTime).sum() / procs.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
//        for (ProcessJob p : processJobs) {
//            sb.append(p.toString() + "\n");
//        }
        sb.append("Avg Turnaround Time: " +this.avgTurnaroundTime);
        return sb.toString();
    }
}

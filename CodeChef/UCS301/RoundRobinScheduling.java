import java.util.*;

public class RoundRobinScheduling {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int process = sc.nextInt();
    Process processes[] = new Process[process];
 
    for (int i = 0; i < process; i++) {
      int processName = sc.nextInt();
      int arrivalTime = sc.nextInt();
      int burstTime = sc.nextInt();
      processes[i] = new Process(processName, arrivalTime, burstTime);
    }

    sc.close();

    Arrays.sort(processes, Comparator.comparingInt(val -> val.arrivalTime));
    int currentTime = processes[0].arrivalTime;
        while(true){
            boolean loop = true;
            int count =0;
            int burst =0;
            for(int i =0; i< processes.length;i++){
                Process value = processes[i];
                if(value.arrivalTime > currentTime)
                    count++;
                
                if(value.arrivalTime <= currentTime && value.burstTime != 0){
                    System.out.print(value.processName + " ");
                    processes[i].burstTime-=1;
                    loop = false;
                }
                currentTime++;
        }
        if(loop && count==0){
            break;
        }
       
     }


    // Queue<Process> waitTime = new PriorityQueue<Process>();
    // List<Integer> order = new ArrayList<Integer>();
 
    // int index =0;
    // while(index < processes.length){
    //     while(index < processes.length &&  processes[index].arrivalTime < currentTime){
    //         waitTime.add(processes[index]);
    //         index++;
    //     }
        // if (!waitTime.isEmpty())
        // System.out.print(waitTime.poll().processName);
   // }

    // for (int x = 0; x < order.size(); x++) {
    //   System.out.print(order.get(x));
    // }
  }

  static class Process implements Comparable<Process> {
    int arrivalTime;
    int burstTime;
    int processName;

    public Process(int ProcessName, int arrivalTime, int burstTime) {
      this.processName = ProcessName;
      this.arrivalTime = arrivalTime;
      this.burstTime = burstTime;
    }

    @Override
    public int compareTo(Process newProcess) {
      if (this.burstTime < newProcess.burstTime) {
        return this.arrivalTime;
      } else return -1;
    }
  }
}

import java.util.*;

public class MinimumAverageWaitingTime {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numOfCustomers = in.nextInt();
    Customer[] customers = new Customer[numOfCustomers];

    for (int i = 0; i < numOfCustomers; i++) {
      int orderTime = in.nextInt();
      int cookTime = in.nextInt();
      customers[i] = new Customer(orderTime, cookTime);
    }
    in.close();

    Arrays.sort(customers, Comparator.comparingInt(o -> o.orderTime));

    Queue<Customer> waitTime = new PriorityQueue<>();
    long currentTime = 0L;
    long totalWaitTime = 0L;
    int index = 0;

    while (!waitTime.isEmpty() || index < customers.length) {
      while (
        index < customers.length && customers[index].orderTime <= currentTime
      ) {
        waitTime.add(customers[index]);
        index++;
      }
      if (waitTime.isEmpty()) {
        currentTime = customers[index].orderTime;
        continue;
      }

      Customer served = waitTime.poll();
      currentTime += served.cookTime;
      totalWaitTime += currentTime - served.orderTime;
    }

    System.out.println(totalWaitTime / customers.length);
  }

  static class Customer implements Comparable<Customer> {
    int orderTime;
    int cookTime;

    public Customer(int orderTime, int cookTime) {
      this.orderTime = orderTime;
      this.cookTime = cookTime;
    }

    @Override
    public int compareTo(Customer o) {
      if (this.cookTime > o.cookTime) {
        return this.orderTime;
      } else return -1;
    }
  }
}
/*
 * basically what you do in this problem is , take t =10 and 10 process have
 * entered. Assume no one has been cooked yet. So right now I need to arrange
 * these in order of cooking time. So firtly the array is arranged wrt to
 * arrival time. Then put in a priority queue acc to the cooking time. eg. If
 * first process takes 10 sec, and at the end of 10 sec there are 4 total
 * processes waiting, then min time will be acc to cooking time. Thats the logic
 * behind the solution.
 */

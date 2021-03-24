class Solution {
  Stack<Integer> s = new Stack();
  int min = 0;

  public void push(int x) {
    if (s.size() == 0) {
      s.push(x);
      min = x;
    } else {
      if (x >= min) {
        s.push(x);
      } else if (x < min) {
        s.push(2 * x - min);
        min = x;
      }
    }
  }

  public void pop() {
    if (s.size() == 0) {
      return;
    } else if (s.peek() >= min) {
      s.pop();
    } else {
      min = 2 * min - s.peek();
      s.pop();
    }
  }

  public int top() {
    if (s.size() == 0) {
      return -1;
    } else {
      if (s.peek() >= min) {
        return s.peek();
      } else if (s.peek() < min) {
        return min;
      }

      return -1;
    }
  }

  public int getMin() {
    if (s.size() == 0) {
      return -1;
    }
    return min;
  }
}

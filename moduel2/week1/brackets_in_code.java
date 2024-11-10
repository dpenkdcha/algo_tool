package moduel2.week1;

import java.util.Scanner;
import java.util.Stack;

// Check brackets in the code
public class brackets_in_code {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    char[] strChar = str.toCharArray();

    Stack<Character> stk = new Stack<>();
    Stack<Integer> stkTrack = new Stack<>();
    for (int i = 0; i < strChar.length; i++) {
      if (strChar[i] == '(' || strChar[i] == '{' || strChar[i] == '[') {
        stk.push(strChar[i]);
        stkTrack.push(i);
      } else if (!stk.isEmpty()) {
        if ((strChar[i] == ')' && stk.peek() == '(')
            || (strChar[i] == '}' && stk.peek() == '{')
            || (strChar[i] == ']' && stk.peek() == '[')) {
          stk.pop();
          stkTrack.pop();
        } else if ((strChar[i] == ')' && stk.peek() != '(')
            || (strChar[i] == '}' && stk.peek() != '{')
            || (strChar[i] == ']' && stk.peek() != '[')) {
          stkTrack.push(i);
          break;
        }
      } else if (strChar[i] == ')' || strChar[i] == '}' || strChar[i] == ']') {
        stk.push('0');
        stkTrack.push(i);
        break;
      }
    }

    if (stk.isEmpty())
      System.out.println("Success");
    else
      System.out.println(stkTrack.peek()+1);
    scanner.close();
  }
}

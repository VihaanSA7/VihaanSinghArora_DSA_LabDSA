package lab3q1;

import java.util.*;

public class BalBracQ1 
{
	static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack = new ArrayDeque<Character>();
 
        for (int i = 0; i < expr.length(); i++) 
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') 
            {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            
            switch (x) 
            {
            case ')': check = stack.pop();
                	  if (check == '{' || check == '[')
                      return false;
                	  break;
 
            case '}': check = stack.pop();
                	  if (check == '(' || check == '[')
                      return false;
                	  break;
            case ']': check = stack.pop();
                      if (check == '(' || check == '{')
                      return false;
                      break;
            }
        }
 
        return (stack.isEmpty());
    }
 
    public static void main(String[] args) throws Exception
    {
        String expr = "(([{}]))";
        if (areBracketsBalanced(expr))
            System.out.println("The Entered String has Balanced Brackets");
        else
            System.out.println("The Entered String does Not have Balanced Brackets");
    }
}



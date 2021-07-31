package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            // LIFO -- stack.push() , stack.pop() , stack.peek();

            // FIFO -- queue.offer() , queue.poll(),  queue.peek();

        String input = scanner.nextLine();
        ArrayDeque<String> stack =  new ArrayDeque<>();

        while (!input.equals("Home")){


            if (!input.equals("back")){
                stack.push(input);
                System.out.println(input);
            }else{
                if (stack.size() > 1){
                   stack.pop();
                    System.out.println(stack.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            }

            input = scanner.nextLine();

        }

    }
}

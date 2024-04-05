package com.stackroute.twostacks;

public class App
{
    public static void main( String[] args )
    {
        TwoStacks.MyQueue queue = new TwoStacks.MyQueue();
        queue.push(80);
        queue.push(60);
        queue.pop();
        System.out.println(queue.peek());

    }
}

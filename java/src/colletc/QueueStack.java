package colletc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueStack {
    public static void main(String[] args) {
        //queue
        Queue<String> q = new LinkedList<>();
        //add or offer
        q.offer("apple");
        q.offer("pear");

        //poll or peek
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        //PriorityQueue
        //需要实现 `Comparable`接口
        Queue<Person> queue = new PriorityQueue<>();

        queue.offer(new Person("Bob", 51));
        queue.offer(new Person("Boss", 12));

        System.out.println(queue.poll().getAge());
        System.out.println(queue.poll().getAge());

        //Deque
        //总是调用`xxxFirst()`/`xxxLast()`以便与`Queue`的方法区分开；
        Deque<String> deque = new LinkedList<>();

        //Stack
        Deque<String> stack = new LinkedList<>();
        stack.push("apple");
        stack.push("pear");

        //poll or peek
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

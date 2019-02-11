package com.company;

import java.util.Scanner;
import java.util.Stack;

public class EmergencyTracker
{
    Scanner input = new Scanner(System.in);
    Stack<String> emergencyStack = new Stack<>();
    boolean running = true;

    public static void main(String[] args)
    {
        EmergencyTracker tracker = new EmergencyTracker();
        tracker.run();
    }

    public void run()
    {
        System.out.println("Please enter one of the following commands.       |");
        System.out.println("==================================================|");
        System.out.println("\"add\" to add a emergency.                         |");
        System.out.println("\"peek\" to print out the next emergency.           |");
        System.out.println("\"Remove\" to remove the next emergency.            |");
        System.out.println("\"amount\" to print out the amount of emergencies.  |");
        System.out.println("\"panic\" to wipe list and skip town.               |");
        System.out.println("==================================================|");

        while (running)
        {
            System.out.println("---------------------------------------");
            System.out.println("Please enter a command.");
            System.out.println("---------------------------------------");
            String command = input.next();
            switch (command)
            {
                case "add":
                    addEmergency();
                    break;
                case "peek":
                    peek();
                    break;
                case "remove":
                    removeEmergency();
                    break;
                case "amount":
                    printAmount();
                    break;
                case "panic":
                    panic();
                    break;
                    default:
                        System.out.println("Invalid command.");
            }
        }
    }

    public void addEmergency()
    {
        String addEmergency = input.next();
        emergencyStack.push(addEmergency);
        System.out.println(emergencyStack.peek() + " added.");
    }

    public void peek()
    {
        if (emergencyStack.size() > 0)
        {
            System.out.println(emergencyStack.peek() + " is the next emergency on the list.");
        }
        else
        {
            System.out.println("There are no more emergencies left to peek at.");
        }
    }

    public void removeEmergency()
    {
        if (emergencyStack.size() > 0)
        {
            System.out.println(emergencyStack.peek() + " has been removed from the list.");
            emergencyStack.pop();
        }
        else
        {
            System.out.println("There are no more emergencies left to remove.");
        }
    }

    public void printAmount()
    {
        if (emergencyStack.size() > 1)
        {
            System.out.println(emergencyStack.size() + " emergencies left.");
        }
        else if (emergencyStack.size() == 1)
        {
            System.out.println(emergencyStack.size() + " emergency left.");

        }
        else
        {
            System.out.println("There are no more emergencies left.");
        }

    }

    public void panic()
    {
        System.out.println("Burning all the evidence.....");
        System.out.println("Get outta dodge!");
        System.out.println("Terminating system.");
        emergencyStack.clear();
        System.out.println("System Terminated.");
        running = false;
    }
}

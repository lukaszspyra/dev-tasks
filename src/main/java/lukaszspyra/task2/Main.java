package lukaszspyra.task2;

import lukaszspyra.Console;
import lukaszspyra.IntegerParser;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Task2 task2 = new Task2(new Console(new Scanner(System.in), System.out, new IntegerParser()));
    task2.startApp();
  }

}

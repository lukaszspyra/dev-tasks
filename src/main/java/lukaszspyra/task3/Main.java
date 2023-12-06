package lukaszspyra.task3;

import lukaszspyra.Console;
import lukaszspyra.IntegerParser;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
   Task3 task3 = new Task3(new Console(new Scanner(System.in), System.out, new IntegerParser()));
   task3.startApp();
  }
}

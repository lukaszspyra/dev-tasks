package lukaszspyra.task1;

import lukaszspyra.IntegerParser;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
  Task1 task1 = new Task1(1, new Console(new Scanner(System.in), System.out, new IntegerParser()));
  task1.startApp();
  }

}

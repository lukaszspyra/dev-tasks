package lukaszspyra.task2;

import lukaszspyra.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the second task.
 */
public class Task2Test {

  @Test
  public void shallFindPairsSummingTo13() {
    //given
    List<Integer> input = Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);
    String expectedOutput = "0 13\n" +
        "3 10\n" +
        "6 7\n" +
        "6 7";
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task2 task2 = new Task2(new Console(new Scanner("test"), new PrintStream(outputStream), null));

    //when
    task2.findPairsSumming13(input);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

}

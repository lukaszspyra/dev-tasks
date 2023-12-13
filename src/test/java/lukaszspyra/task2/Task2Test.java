package lukaszspyra.task2;

import lukaszspyra.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the second task.
 */
public class Task2Test {

  @ParameterizedTest
  @MethodSource("integerListsWithPairSumming13")
  public void shallFindPairsSummingTo13(List<Integer> input, String expectedOutput) {
    //given
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task2 task2 = new Task2(new Console(null, new PrintStream(outputStream), null));

    //when
    task2.findPairsSumming13(input);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

  private static Stream<Arguments> integerListsWithPairSumming13() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0),
            "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7"),
        Arguments.of(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 7, 13, 0),
            "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7"),
        Arguments.of(Arrays.asList(13, 13, 0, 0),
            "0 13\n" +
                "0 13\n" +
                "0 13\n" +
                "0 13"
        )
    );
  }

}

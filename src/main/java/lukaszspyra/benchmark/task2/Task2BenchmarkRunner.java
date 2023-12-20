package lukaszspyra.benchmark.task2;

import lukaszspyra.Console;
import lukaszspyra.task2.Task2;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Fork(1)
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
public class Task2BenchmarkRunner {

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }

  @Benchmark
  public void task2FindPairsOf13(BenchmarkInput input) {
    input.task2.findPairsSumming13(input.SAMPLE_NUMBERS);
  }

  @State(Scope.Benchmark)
  public static class BenchmarkInput {

    Task2 task2;
    final List<Integer> SAMPLE_NUMBERS = IntStream.range(1, 100).boxed().collect(toList());

    @Setup(Level.Invocation)
    public void setUp() {
      task2 = new Task2(new Console(null, System.out, null));
    }

  }

}

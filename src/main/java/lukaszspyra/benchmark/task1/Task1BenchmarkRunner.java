package lukaszspyra.benchmark.task1;

import lukaszspyra.Console;
import lukaszspyra.task1.Task1;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
public class Task1BenchmarkRunner {

  @Benchmark
  public void task1WithDifferentBatchSizes(BenchmarkInput input) {
    input.task1.processInput(input.SAMPLE_NUMBERS);
  }

  @Benchmark
  public void task1SingleStreamProcessing(BenchmarkInput input) {
    input.task1.singleStreamProcessedInput(input.SAMPLE_NUMBERS);
  }

  @State(Scope.Benchmark)
  public static class BenchmarkInput {

    @Param({"1", "10", "100", "1000", "10000"})
    int batchSize;
    Task1 task1;
    final List<Integer> SAMPLE_NUMBERS = IntStream.range(1, 10000000).boxed().collect(toList());

    @Setup(Level.Invocation)
    public void setUp() {
      PrintStream mockStream = new PrintStream(new OutputStream() {
        public void write(int b) {
          //mock
        }
      });
      task1 = new Task1(batchSize, new Console(null, mockStream, null));
    }

  }

}

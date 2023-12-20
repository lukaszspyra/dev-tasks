package lukaszspyra.benchmark;

import lukaszspyra.benchmark.task1.Task1BenchmarkRunner;
import lukaszspyra.benchmark.task2.Task2BenchmarkRunner;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkMain {

  public static void main(String[] args) throws Exception {
    Options options = new OptionsBuilder()
        .include(Task1BenchmarkRunner.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(options).run();
  }

}

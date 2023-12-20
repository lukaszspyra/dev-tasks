# Task2 application benchmark results by Java Microbenchmark Harness (JMH)

-  for list of 10M integers (brute force with nested loops doesn't terminate)

| Benchmark                                | Mode | Cnt | Score   Error   | Units |
|------------------------------------------|------|-----|-----------------|-------|
| Task2BenchmarkRunner.task2FindPairsOf13  | avgt | 5   | 5,988 ± 0,613   | s/op  |

- for list of 100k integers

| Benchmark                                         | Mode | Cnt | Score   Error   | Units |
|---------------------------------------------------|------|-----|-----------------|-------|
| Task2BenchmarkRunner.task2FindPairsOf13           | avgt | 5   | 0,036 ± 0,029   | s/op  |
| Task2BenchmarkRunner.task2FindPairsOf13BruteForce | avgt | 5   | 12,341 ± 1,282   | s/op  |

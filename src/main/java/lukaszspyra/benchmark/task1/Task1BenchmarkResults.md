# Task1 application benchmark results by Java Microbenchmark Harness (JMH)

- for batch size 1 - OutOfMemoryError for list of 10M integers

| Benchmark                                         | (batchSize) | Mode | Cnt | Score  Error   | Units |
|---------------------------------------------------|-------------|------|-----|----------------|-------|
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 10          | avgt | 5   | 6,660 ± 1,057  | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 100         | avgt | 5   | 6,495 ± 2,325  | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 1000        | avgt | 5   | 6,429 ± 2,788  | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 10000       | avgt | 5   | 6,628 ± 0,354  | s/op  |

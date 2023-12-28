# Task1 application benchmark results by Java Microbenchmark Harness (JMH)

- for batch size 1 - OutOfMemoryError for list of 10M integers

| Benchmark                                         | (batchSize) | Mode | Cnt | Score  Error      | Units |
|---------------------------------------------------|-------------|------|-----|-------------------|-------|
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 10          | avgt | 5   | 11,318 ± 1,117    | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 100         | avgt | 5   | 12,653 ± 1,128    | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 1000        | avgt | 5   | 12,897 ± 5,705    | s/op  |
| Task1BenchmarkRunner.task1WithDifferentBatchSizes | 10000       | avgt | 5   | 12,121 ± 5,985    | s/op  |
| --------------------------------------------------|-------------|------|-----| ----------------- |-------|
| Task1BenchmarkRunner.task1SingleStreamProcessing  | 10          | avgt | 5   | 8,824 ± 6,295     | s/op  |

# Task1 application benchmark results by Java Microbenchmark Harness (JMH)

- for batch size 1 - OutOfMemoryError for list of 10M integers

| Benchmark                                    | (batchSize) | Mode | Cnt | Score      Error   | Units |
|----------------------------------------------|-------------|------|-----|--------------------|-------|
| BenchmarkRunner.task1WithDifferentBatchSizes | 10          | avgt | 5   | 5567,339 ± 134,900 | ms/op |
| BenchmarkRunner.task1WithDifferentBatchSizes | 100         | avgt | 5   | 6682,969 ± 325,397 | ms/op |
| BenchmarkRunner.task1WithDifferentBatchSizes | 1000        | avgt | 5   | 6732,565 ± 290,751 | ms/op |
| BenchmarkRunner.task1WithDifferentBatchSizes | 10000       | avgt | 5   | 6686,578 ± 519,961 | ms/op |

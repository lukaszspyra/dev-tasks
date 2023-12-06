# Task1 application

User enters list of integers separated by spaces. App will output the list of distinct elements sorted in ascending order, 
plus the basic measurement information that contains the number of elements in the source, number of distinct elements, min and max value.

Notes:
- Input data is read using Scanner class, validation done for numbers by NumberFormat#ParseException
- input list is processed lazily using streams API, numbers are collected in batches (grouped in map by lists with corresponding batch number, starting from 0)
- input is processed second time to get statistics using IntStream#summaryStatistics()
- list of numbers is parsed as LinkedList to split space occupied in case of big data source
- there is unit test checking standard output against expected one

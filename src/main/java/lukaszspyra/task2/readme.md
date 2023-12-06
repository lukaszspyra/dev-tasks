# Task2 application

User enters list of integers separated by spaces. App will output all the pairs in this list, that sum up to 13. 
Each pair in the output have the first number not greater than the second one and are sorted in an ascending order.

Notes:
- Input data is read using Scanner class, validation done for numbers by NumberFormat#ParseException
- input list is sorted naturally for integers, algorithm is looping over the list and compares sum of lowest/highest numbers and moves index if too low/too high result
- list of numbers is parsed as LinkedList to split space occupied in case of big data source
- there is unit test checking standard output against expected one

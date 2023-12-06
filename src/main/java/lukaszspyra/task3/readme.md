# Task3 application
Application outputs number of separated graphs.
User enters numbers as follows:
- First positive integer (describing numbers of connections in the graph).
- pair of integer separated by space (describing two end of connection).

Notes:
- Input data is read using Scanner class
- Validation done for numbers by NumberFormat#ParseException with first number to be positive (remaining input is ignored on this line),
from second line only a pair of integers is accepted (with less/more numbers app will terminate)
- Graph model is created in the form of Map<Integer, List<Integer>> - key is each vertex, whilst list contain all vertices connecting to it
- Algorithm processes each vertex and connected ones using depth first search recursive technique, returning when given vertex was already visited. If all neighbours are visited and there are still not visited numbers in the graph model, counter for separate graphs increases.
- there is junit parameterized test (data feed via method), checking standard output against expected one

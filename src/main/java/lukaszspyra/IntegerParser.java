package lukaszspyra;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class IntegerParser {

  public List<Integer> parse(final String[] strings) throws ParseException {
    NumberFormat integerInstance = NumberFormat.getIntegerInstance();
    final List<Integer> integers = new LinkedList<>();
    for (String i : strings) {
      integers.add(integerInstance.parse(i).intValue());
    }
    return integers;
  }

}

package lukaszspyra;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class IntegerParser {

  private final NumberFormat integerInstance = NumberFormat.getIntegerInstance();

  public List<Integer> parse(final String[] strings) throws ParseException {
    final List<Integer> integers = new LinkedList<>();
    for (String i : strings) {
      integers.add(integerInstance.parse(i).intValue());
    }
    return integers;
  }

  public int parse(final String string) throws ParseException {
    return integerInstance.parse(string).intValue();
  }

}

package helpers;

import Generic.customExceptions.CustomE2eException;
import org.apache.commons.lang.StringUtils;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Formatting class contains static methods for formatting to and from common inputs.
 * This should be used to format common input data and return data presentable to the interface
 * under interaction.
 * Likewise, these methods support transforming interface specific formats back to common input
 * formats.
 */

public class Formatting {

  /**
   * Takes a date as a String and compares to recognised patterns
   *
   * @param date        containing date/time
   * @param printStream passing in the PrintStream to log exceptions
   * @return Date as a String in the common format of yyyy/mm/dd
   */

  public static String dateFormatter(PrintStream printStream, String date) throws CustomE2eException {
    List<SimpleDateFormat> knownPatterns = new ArrayList<>();
    knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    knownPatterns.add(new SimpleDateFormat("yyyy/MM/dd"));
    knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));

    for (SimpleDateFormat pattern : knownPatterns) {
      try {
        var formattedDate = new Date(pattern.parse(date).getTime());
        return new SimpleDateFormat("yyyy/MM/dd").format(formattedDate);
      } catch (ParseException ex) {
        throw new CustomE2eException("Failed in parsing date");
      }
    }
    printStream.println(CommonHelper.wrapMessage("Error: Data pattern didn't match known " + 
        "patterns"));
    throw new CustomE2eException("Data pattern didn't match known patterns");
  }

  public static String changeDateFormatIntoExpected(String date, String currentFormat,
                                                    String expectedFormat) throws ParseException, CustomE2eException {

    try {
      SimpleDateFormat currentSimpleDateFormat = new SimpleDateFormat(currentFormat, Locale.ENGLISH);
      SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat(expectedFormat);
      Date dateFormat = currentSimpleDateFormat.parse(date);
      currentSimpleDateFormat.format(dateFormat);
      return newSimpleDateFormat.format(dateFormat);
    }catch (ParseException e){
      return date;
    }
  }

  /**
   * Determine SimpleDateFormat pattern matching with the given date string. Returns null if
   * format is unknown. You can simply extend DateUtil with more formats if needed.
   * @param dateString The date string to determine the SimpleDateFormat pattern for.
   * @return The matching SimpleDateFormat pattern, or null if format is unknown.
   * @see SimpleDateFormat
   */
  public static String determineDateFormat(String dateString) {
    for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
      if (dateString.toLowerCase().matches(regexp)) {
        return DATE_FORMAT_REGEXPS.get(regexp);
      }
    }
    return null; // Unknown format.
  }

  public static String getCurrencyValue(int amount) {
    DecimalFormat formatter = new DecimalFormat("#,###");
    return String.format("£%s", formatter.format(amount));
  }

  //Need to revisit this for other formats
  private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {{
    put("^\\d{8}$", "yyyyMMdd");
    put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
    put("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[1,2])/(19|20|21)\\d{2}$", "dd/MM/yyyy");
    put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
//    put("^(0[1-9]|1[1,2])/(0[1-9]|[12][0-9]|3[01])/(19|20|21)\\d{2}$", "MM/dd/yyyy");
    put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
    put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
    put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
    put("^\\d{12}$", "yyyyMMddHHmm");
    put("^\\d{8}\\s\\d{4}$", "yyyyMMdd HHmm");
    put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}$", "dd-MM-yyyy HH:mm");
    put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy-MM-dd HH:mm");
    put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}$", "MM/dd/yyyy HH:mm");
    put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy/MM/dd HH:mm");
    put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMM yyyy HH:mm");
    put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMMM yyyy HH:mm");
    put("^\\d{14}$", "yyyyMMddHHmmss");
    put("^\\d{8}\\s\\d{6}$", "yyyyMMdd HHmmss");
    put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd-MM-yyyy HH:mm:ss");
    put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy-MM-dd HH:mm:ss");
    put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "MM/dd/yyyy HH:mm:ss");
    put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy/MM/dd HH:mm:ss");
    put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMM yyyy HH:mm:ss");
    put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMMM yyyy HH:mm:ss");
  }};


  public static String capitalizeFirstCharacter(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }

  public static String capitalizeAllFirstCapitalizeRemoveSpace(String text) {
    UnaryOperator<String> capitalize =
        str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    String result = Stream.of(text.split(" ")).map(capitalize).collect(Collectors.joining(" "));
    return result.replace(" ", "");
  }

  public static String addSpacesAfterCapital(String text) {
    var textAfterSplit =StringUtils.splitByCharacterTypeCamelCase(text);
    return Stream.of(textAfterSplit).collect(Collectors.joining(" "));
  }

  /**
   * Separates common single String addresses and returns them as a HashMap<String,Object>
   *
   * @param addressBlock an address as a single String - will include NameOrNumber and up to 4
   *                     AddressLines separated by a comma
   * @return an object containing 'NameOrNumber' and up to 4 'AddressLine[i]'
   */
  public static Map<String, Object> addressLineSeparator(String addressBlock) {
    var formattedAddress = new HashMap<String, Object>();
    var addressSections = addressBlock.split(",");
    for (int i = 0; i < addressSections.length; i++) {
      if (i == 0) {
        formattedAddress.put("NameOrNumber", addressSections[i].trim());
      } else {
        formattedAddress.put("AddressLine" + i, addressSections[i].trim());
      }
    }
    return formattedAddress;
  }

  /**
   * Takes multiple AddressLine Strings and NameOrNumber and returns single String block
   *
   * @param nameOrNumber (String) Building Name or Number
   * @param addressLine1 (String) AddressLine
   *                     Overloaded method takes up to 5 args
   * @return (String) Single String block of concatenated address
   */
  public static String addressConcat(String nameOrNumber, String addressLine1) {

    return nameOrNumber + "," + addressLine1;
  }

  /**
   * @see #addressConcat(String, String)
   */
  public static String addressConcat(String nameOrNumber, String addressLine1,
                                     String addressLine2) {

    return nameOrNumber + "," + addressLine1 + ", " + addressLine2;
  }

  /**
   * @see #addressConcat(String, String)
   */
  public static String addressConcat(String nameOrNumber, String addressLine1,
                                     String addressLine2, String addressLine3) {

    return nameOrNumber + "," + addressLine1 + ", " + addressLine2 + ", " + addressLine3;
  }

  /**
   * @see #addressConcat(String, String)
   */

  public static String addressConcat(String nameOrNumber, String addressLine1,
                                     String addressLine2, String addressLine3,
                                     String addressLine4) {

    return nameOrNumber + "," + addressLine1 + ", " + addressLine2 + ", " + addressLine3 + "," + 
        " " + addressLine4;
  }

  /**
   * Takes a single line address String without symbolic separation and matches a single
   * line/block comma separated address pattern
   *
   * @param oneLineAddressOutput example 3 FIVE ACRES FOLD NORTHAMPTON
   * @param controlDataAddress   example 3, FIVE ACRES FOLD, NORTHAMPTON
   * @return comma separated String following the controlDataAddress pattern
   * Can add an identifier argument at later date if necessary
   * To review as Operation list grows the need for dynamic case matching (currently block caps)
   */
  public static String addressSingleLinePatternMatch(String oneLineAddressOutput,
                                                     String controlDataAddress) {
    StringBuilder sb = new StringBuilder(oneLineAddressOutput);
    for (int i = 0; i < controlDataAddress.length(); i++) {
      if (controlDataAddress.charAt(i) == ',') {
        sb.insert(i, ',');
      }
    }
    return sb.toString().trim();
  }

  public static String covertNumberIntoMonths(int numberOfMonth) {
    String nameOfMonth;
    switch (numberOfMonth) {
      case 1:
        nameOfMonth = "Jan";
        break;
      case 2:
        nameOfMonth = "Feb";
        break;
      case 3:
        nameOfMonth = "Mar";
        break;
      case 4:
        nameOfMonth = "Apr";
        break;
      case 5:
        nameOfMonth = "May";
        break;
      case 6:
        nameOfMonth = "Jun";
        break;
      case 7:
        nameOfMonth = "Jul";
        break;
      case 8:
        nameOfMonth = "Aug";
        break;
      case 9:
        nameOfMonth = "Sep";
        break;
      case 10:
        nameOfMonth = "Oct";
        break;
      case 11:
        nameOfMonth = "Nov";
        break;
      case 12:
        nameOfMonth = "Dec";
        break;
      default:
        nameOfMonth = "Not valid value";
    }
    return nameOfMonth;
  }


  public static List<String> getValuesInList(String values, String splitter) {
    List<String> normalizeValue = new ArrayList<>();
    if (values != null) {
      normalizeValue = new ArrayList<>(Arrays.asList(values.trim().split(splitter)));
    }
    return normalizeValue;
  }

  public static SortedMap<String, Object> getValuesIfNotAbsent(Map<String, Object> values,
                                                               String key) {
    if (values.containsKey(key)) {
      return (SortedMap<String, Object>) values.get(key);
    }
    return new TreeMap<String, Object>();
  }

  public static String getTextFromRegex(String searchArea, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(searchArea);
    boolean matchFound = matcher.find();
    String textRegex = null;
    if (matchFound) {
      textRegex = matcher.group(0);
    }
    return textRegex;
  }

  public static Map<String, Object> converStringListIntoMap(String utilMapString) {
    if (utilMapString.startsWith("{") && utilMapString.endsWith("}")) {
      utilMapString = utilMapString.substring(1, utilMapString.length() - 1).trim();
    }
    return Arrays.stream(utilMapString.replace(" ", "").split(",")).map(s -> s.split("=")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
  }

  public static boolean isNumeric(String stringNum) {
    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    if (stringNum == null) {
      return false;
    }
    return pattern.matcher(stringNum).matches();
  }

  public static String currencyWithChosenLocalisation(double value, Locale locale) {
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    return nf.format(value);
  }
}

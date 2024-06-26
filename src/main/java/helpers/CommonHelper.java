package helpers;

import Generic.customExceptions.CustomE2eException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.yaml.snakeyaml.Yaml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Common helper class provides various utility methods that are commonly used
 * throughout the application.
 */
public class CommonHelper extends SeleniumHelper {

  public static final org.apache.logging.log4j.Logger LOGGER =
      LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

  public CommonHelper(WebDriver pDriver) {
    super(pDriver);
  }

  public static String[] splitDate(String originalDate) {

    var convertedDate = new String[3];
    if (originalDate.contains("/")) {
      convertedDate = originalDate.split("/");
    } else if (originalDate.contains("-")) {
      convertedDate = originalDate.split("-");
    }
    if (convertedDate[1].startsWith("0")) {
      convertedDate[1] = convertedDate[1].substring(1);
    }
    if (convertedDate[2].startsWith("0")) {
      convertedDate[2] = convertedDate[2].substring(1);
    }
    return convertedDate;
  }

  //TODO consider deleting. Could not make this generic enough.
  public static String getTagValue(String xml, String tagName, int statusCode) {
    if (statusCode == 200 && xml.contains("<" + tagName + ">")) {
      return xml.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
    } else if (statusCode == 200 && !xml.contains("<" + tagName + ">")) {
      return "NoUserFound";
    }
    return "INVALID";
  }

  public static void overwriteXmlFile(File xmlFile, Document document, Transformer transformer) throws TransformerException, FileNotFoundException {
    StreamResult result = new StreamResult(new PrintWriter(new FileOutputStream(xmlFile, false)));
    DOMSource source = new DOMSource(document);
    transformer.transform(source, result);
  }

  public static Transformer createXmlTransformer() throws TransformerConfigurationException {
    return TransformerFactory.newInstance().newTransformer();
  }

  public static void makeChanges(Document document, String tagName, String tagValue) {
    Element root = document.getDocumentElement();
    var elm = root.getElementsByTagName(tagName);
    elm.item(0).setTextContent(tagValue);
  }

  public static Document readXmlDocument(File xmlFile) throws ParserConfigurationException,
      IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(xmlFile);
  }

  private static Map<String, Object> readDataFromYaml(String fileLocation) throws IOException {
    InputStream inputStream = new FileInputStream(fileLocation);
    Yaml yaml = new Yaml();
    return yaml.load(inputStream);
  }

  public static Map<String, Object> getLatestDataFromYaml(String defaultDataFile, Map<String,
      Object> overrideData) throws IOException {
    Map<String, Object> defaultData = readDataFromYaml(defaultDataFile);
    HashMap<String, Object> returnFinalData = new HashMap<>();

    returnFinalData.putAll(defaultData);
    returnFinalData.putAll(overrideData);

    return returnFinalData;
  }


  public static Document convertStringToXMLDocument(String xmlString) {
    //Parser that produces DOM object trees from XML content
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    //API to obtain DOM Document instance
    DocumentBuilder builder = null;
    try {
      //Create DocumentBuilder with default configuration
      builder = factory.newDocumentBuilder();

      //Parse the content to Document object
      return builder.parse(new InputSource(new StringReader(xmlString)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String wrapMessage(String message) {
    return String.format("[%s] - %s", Instant.now().toString(), message);
  }

  public static String yesNoSwitch(String value) {
    switch (value) {
      case "1":
        return "Yes";
      case "2":
        return "No";
      default:
        return "Could not interpret value";
    }
  }

  public static String convertBooleanIntoString(Object value) {
    boolean normalizeValue;
    if(value instanceof String){
      normalizeValue = convertStringIntoBoolean(value);
    }  else {
      normalizeValue = (Boolean) value;
    }
    if (normalizeValue) {
      return "Yes";
    } else if (!(normalizeValue)) {
      return "No";
    }
    return "Could not interpret value";
  }

  public static Boolean convertStringIntoBoolean(Object value) {
    if(value instanceof Boolean){
      return (Boolean) value;
    } else if (value.toString().equalsIgnoreCase("Yes") || value.toString().equalsIgnoreCase("true")) {
      return true;
    } else if (value.toString().equalsIgnoreCase("No") || value.toString().equalsIgnoreCase("false")) {
      return false;
    }
    return null;
  }


  public static int convertBooleanIntoInteger(Boolean value) {
        if (!value) {
            return 1;
        } else if (value) {
            return 0;
        }
        return 1;

  }

  public byte[] getScreenshotAsByteArray() {

    return ((TakesScreenshot) getCurrentWebDriverInstance()).getScreenshotAs(OutputType
            .BYTES);
//
//    var vScreenShot = ((TakesScreenshot) getCurrentWebDriverInstance()).getScreenshotAs(OutputType
//            .BYTES);
//
//
//    fileName = System.getProperty("user.dir") + fileName;
//
//    File srcFile = new File(fileName);
//
////    File srcFile =
////        ((TakesScreenshot) getCurrentWebDriverInstance()).getScreenshotAs(OutputType.FILE);
//    File f = srcFile.getParentFile();
//
//
//
//    try {
//      boolean folderCreated = f.mkdir();
//      if (!folderCreated && !f.exists()) {
//        LOGGER.info("Folder not created");
//      }
//    } catch (SecurityException e) {
//      LOGGER.error(e.getMessage());
//      LOGGER.error(e.getCause());
//    }
//    try {
////      FileUtils.copyFile(srcFile, new File(fileName));
//
//      ByteSink byteSink = Files.asByteSink(srcFile);
//      byteSink.write(vScreenShot);
//      FileUtils.writeByteArrayToFile(srcFile, vScreenShot);
//
//    } catch (IOException e) {
//      LOGGER.error(e.getMessage());
//      LOGGER.error(e.getCause());
//    }
//
//    return vScreenShot;

  }


  public void saveScreenshot(String fileName) {
    fileName = System.getProperty("user.dir") + fileName;

    File srcFile =
        ((TakesScreenshot) getCurrentWebDriverInstance()).getScreenshotAs(OutputType.FILE);
    File f = srcFile.getParentFile();



    try {
      boolean folderCreated = f.mkdir();
      if (!folderCreated && !f.exists()) {
        LOGGER.info("Folder not created");
      }
    } catch (SecurityException e) {
      LOGGER.error(e.getMessage());
      LOGGER.error(e.getCause());
    }
    try {
      FileUtils.copyFile(srcFile, new File(fileName));
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
      LOGGER.error(e.getCause());
    }
  }

  public static LocalDate extractDateFromString(LocalDate defaultDate, String text) throws CustomE2eException {
    Pattern newDatePattern = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}");
    var matches = newDatePattern.matcher(text);
    if (matches.find()) {
      var extractedDateText = matches.group(0);
      var extractedDate = LocalDate.parse(extractedDateText, DateTimeFormatter.ofPattern("dd/MM" +
          "/yyyy"));
      return extractedDate;
    } else {
      return defaultDate;
    }
    // Pattern datePattern = Pattern.compile("(^0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/
    // (\\d{4}$)");
    //  String extractedDate = String.valueOf(text.split(String.valueOf(datePattern), 10));

  }

  public LocalDate getCurrentDate() {
    return LocalDate.now();
  }

  public int getRowNumberWithCellData(List<WebElement> element, String data) throws CustomE2eException {
    for (var rowNum = 0; rowNum < element.size(); rowNum++) {
      WebElement row = element.get(rowNum);
      List<WebElement> cells = row.findElements(By.tagName("td"));
      for (var colNum = 0; colNum < cells.size(); colNum++) {
        if (data.equalsIgnoreCase(cells.get(colNum).getText())) {
          return rowNum;
        }
      }
    }
    return -1;
  }

  public Long getPolicyExpiresInDays(String policyEndDate) {
    var policyExpireInDays = getCurrentDate();
    var policyEndDateNorm = LocalDate.parse(policyEndDate, DateTimeFormatter.ofPattern("dd/MM" +
        "/yyyy"));
    LocalDate endDtNorm = LocalDate.of(policyEndDateNorm.getYear(), policyEndDateNorm.getMonth(),
        policyEndDateNorm.getDayOfMonth());
    var changes = ChronoUnit.DAYS.between(policyExpireInDays, endDtNorm);
    return changes - 1;
  }

  public static String getCurrentMonth(String monthFormat) {
    Calendar cal = Calendar.getInstance();
    return new SimpleDateFormat(monthFormat).format(cal.getTime());
  }
}

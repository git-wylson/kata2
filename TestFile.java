
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;
import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import itec.fcc.rpp.pil.regionalview.portfolio.entities.RwaBridgePharos;

 
public class TestFile {

  private TestFile() {}

  public static final String DEFAULT_ENCODING = "Cp1252";
  public static final String PIPE = "|";
  public static final String COMMA = ",";
  public static final String REGEX = "-|_";
  public static final String SEMICOLON = ";";
  public static final String FORMATDATE_DD_MMM_YYYY = "dd-MMM-yyyy";

  public static List<Map<String, String>> getData(String absolutePath, String separator)
      throws IOException {
    List<Map<String, String>> csvData = new ArrayList<>();
    BufferedReader bReader = null;
    InputStreamReader inReader = null;
    String line = "";
    String cvsSplitBy = "\\" + separator;

    try {
      inReader = new InputStreamReader(new FileInputStream(absolutePath), DEFAULT_ENCODING);
      bReader = new BufferedReader(inReader);
      String[] headers = bReader.readLine().split(cvsSplitBy, -1);

      while ((line = bReader.readLine()) != null) {
        String[] row = line.split(cvsSplitBy, -1);
        Map<String, String> lineMap = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
          if (i < row.length) {
            lineMap.put(buildHeader(headers[i]), row[i]);
          } else {
            lineMap.put(buildHeader(headers[i]), "");
          }
        }
        csvData.add(lineMap);
      }

    } finally {
      bReader.close();
      inReader.close();
    }

    return csvData;
  }


  @SuppressWarnings("unchecked")
  public static <T> List<T> readData(String absolutePath, String separator, Class<?> clazz)
      throws IOException {
    List<T> csvData = new ArrayList<>();
    BufferedReader bReader = null;
    String line = "";
    String cvsSplitBy = "\\" + separator;

    try {
      bReader = new BufferedReader(
          new InputStreamReader(new FileInputStream(absolutePath), DEFAULT_ENCODING));

      // read column header
      String[] headers = bReader.readLine().split(cvsSplitBy, -1);
      // read field Class
      List<Field> fields = getColumnFieldMapping(clazz);

      while ((line = bReader.readLine()) != null) {
        T obj = (T) createObject(clazz);
        String[] row = line.split(cvsSplitBy, -1);
        for (int i = 0; i < headers.length; i++) {
          for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(buildHeader(headers[i]))) {
              setValue(obj, field, row[i]);
            }
          }
        }

        if (obj != null) {
          csvData.add(obj);
        }
      }

    } finally {
      bReader.close();
    }

    return csvData;
  }


  private static Object setValue(Object obj, Field field, Object value) {
    if (obj != null && value != null) {
      Object valueToSet = null;
      try {
        if (field.getType().toString().equals(Long.class.toString())) {
          valueToSet =
              Strings.isNullOrEmpty(value.toString()) ? null : Long.parseLong(value.toString());

        } else if (field.getType().toString().equals(BigDecimal.class.toString())) {
          valueToSet =
              Strings.isNullOrEmpty(value.toString()) ? null : new BigDecimal(value.toString());

        } else if (field.getType().toString().equals(Integer.class.toString())) {
          valueToSet =
              Strings.isNullOrEmpty(value.toString()) ? null : Integer.parseInt(value.toString());

        } else if (field.getType().toString().equals(Double.class.toString())) {
          valueToSet =
              Strings.isNullOrEmpty(value.toString()) ? null : Double.parseDouble(value.toString());

        } else if (field.getType().toString().equals(Date.class.toString())) {
          SimpleDateFormat sdf = new SimpleDateFormat(FORMATDATE_DD_MMM_YYYY);
          valueToSet = Strings.isNullOrEmpty(value.toString()) ? null : sdf.parse(value.toString());

        } else if (field.getType().toString().equals(String.class.toString())) {
          valueToSet = String.valueOf(value);
        } else {
          valueToSet = value;
        }

        Method method = obj.getClass().getMethod("set" + StringUtils.capitalize(field.getName()),
            new Class[] {field.getType()});
        return method.invoke(obj, valueToSet);
      } catch (NoSuchMethodException | SecurityException | IllegalAccessException
          | InvocationTargetException | ParseException e) {
        e.printStackTrace();
      }
    }
    return null;
  }



  @SuppressWarnings("rawtypes")
  private static Object createObject(Class<?> clazz) {
    Class clazzObj;
    try {
      clazzObj = Class.forName(clazz.getName());
      return clazzObj.newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static List<Field> getColumnFieldMapping(Class<?> clazz) {
    List<Field> fields = new ArrayList<>();
    getAllFields(fields, clazz);
    List<Field> headers = new ArrayList<>();

    for (Field field : fields) {
      if (!field.getType().toString().equals(List.class.toString())
          && !"serialVersionUID".equals(field.getName())) {
        headers.add(field);
      }
    }
    return headers;
  }

  /**
   * 
   * @param clazz
   * @return
   */
  public static String[] getColumnNameMapping(Class<?> clazz) {
    List<Field> fields = new ArrayList<>();
    getAllFields(fields, clazz);
    String[] headers = new String[fields.size()];
    int cpt = 0;

    for (Field field : fields) {
      if (!field.getType().toString().equals(List.class.toString())
          && !"serialVersionUID".equals(field.getName())) {
        headers[cpt] = field.getName();
        cpt++;
      }
    }
    return headers;
  }

  private static List<Field> getAllFields(List<Field> fields, Class<?> clazz) {
    fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
    if (clazz.getSuperclass() != null) {
      fields = getAllFields(fields, clazz.getSuperclass());
    }
    return fields;
  }

  private static String buildHeader(String name) {
    return name.replaceAll(REGEX, "").toUpperCase();
  }

  /**
   * 
   * @param fileName
   * @param results
   * @param clazz
   * @throws IOException
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void createCSVFile(String fileName, List<RwaBridgePharos> results, Class<?> clazz)
      throws IOException {
    CSVWriter csvWriter = null;
    try {
      csvWriter = new CSVWriter(new FileWriter(fileName));
      BeanToCsv beanToCsv = new BeanToCsv();

      ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
      mappingStrategy.setType(clazz);

      mappingStrategy.setColumnMapping(getColumnNameMapping(clazz));
      beanToCsv.write(mappingStrategy, csvWriter, results);

    } finally {
      if (csvWriter != null) {
        csvWriter.close();
      }
    }
  }

}

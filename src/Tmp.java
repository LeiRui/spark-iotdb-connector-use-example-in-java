import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Tmp {

  public static void main(String[] args) {
    SparkSession spark = SparkSession
        .builder()
        .appName("Build a DataFrame from Scratch")
        .master("local[*]")
        .getOrCreate();

    Dataset<Row> df = spark.read().format("org.apache.iotdb.sparkdb")
        .option("url","jdbc:iotdb://127.0.0.1:6667/")
        .option("sql","select * from root").load();

//    df.printSchema();

    df.show();

  }
}

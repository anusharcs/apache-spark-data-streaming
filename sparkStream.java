import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;
import org.apache.spark.Sparkconf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming. StreamingQueryException;

public class sparkStream {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException {
	Sparkconf conf = new Sparkconf().setAppName("Order-Spark-Structured-Streaming").setMaster("local[*]");
	
	SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
	
	Dataset<Row> truckinfoDf = spark.readStrean()
			.format("kafka")
			.option("kafka.bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094")  //change this according to no. of brokers
			.option("subscribe", "order-info-kafka")											  //topic name
			.load()
			.selectExpr("CAST (key AS STRING)", "CAST(value AS STRING)")
			.select(getjson_object(col("value"), "$.OrderNumber").alias("OrderNumber"),
					getjson_object(col("value"), "$.Price").alias("price"),
					getjson_object(col("value"), "$.Category").alias ("Category"),
					get_json_object(col("value"), "$.uniqueId").alias("uniqueId"),
					getjson_object(col("value"), "$.city").alias("city"),
					get_json_object(col("value"), "$.PaymentMode").alias("PaymentMode"),
					get_json_object(col("value"), "$.DeliveryPartnerName").alias("DeliveryPartnerName"),
					getjson_object(col ("value"), "$.Seller").alias("Seller"));
			
			Dataset<Row> busInfo = truckinfoDf.filter(col ("Category").equalTo("PersonalCare"));
			busInfo.writeStream().format("json")
I				.option("checkpointLocation",
						"/Users/s@v@Deo/demo-workspace/GenerateStreamData/simulated-data/check-point")
				.option("path", "/Users/s@v@beo/demo-workspace/GenerateStreamData/simulated-data/out/bus").start()
				.awaitTermination();			//change path
	}
}
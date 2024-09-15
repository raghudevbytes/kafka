package com.kafka.masteringkafka;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class MasteringKafkaApplication {

	public static void main(String[] args) {

		Schema.Parser parser = new Schema.Parser();
		Schema schema = parser.parse("{\n" +
				"    \"type\": \"record\",\n" +
				"    \"namespace\": \"com.customer\",\n" +
				"    \"name\": \"customer\",\n" +
				"    \"fields\": [\n" +
				"      {\n" +
				"        \"type\": [\"null\",\"string\"],\"name\": \"name\",\"default\": null\n" +
				"      },\n" +
				"      {\n" +
				"        \"type\": \"int\",\n" +
				"        \"name\": \"age\",\n" +
				"        \"default\": 0\n" +
				"      },\n" +
				"      {\n" +
				"        \"name\": \"status\",\n" +
				"        \"type\": {\n" +
				"          \"name\": \"Status\",\n" +
				"          \"type\": \"enum\",\n" +
				"          \"symbols\": [\"ACTIVE\",\"BLOCKED\",\"SUSPENDED\",\"INACTIVE\",\"NEW\"]\n" +
				"        }\n" +
				"      },\n" +
				"      {\n" +
				"        \"name\": \"lastLoggedIn\",\n" +
				"        \"type\": {\n" +
				"          \"type\": \"long\",\n" +
				"          \"logicalType\": \"timestamp-millis\"\n" +
				"        },\n" +
				"        \"doc\": \"User last logged in time\"\n" +
				"      }\n" +
				"    ]\n" +
				"  }");
		GenericRecordBuilder builder = new GenericRecordBuilder(schema);
		builder.set("name","Raghu");
		builder.set("status",Status.ACTIVE);
		builder.set("age",30);
		builder.set("lastLoggedIn",System.currentTimeMillis());
		GenericRecord record = builder.build();
		System.out.println(record);
	}


}
enum Status{
	ACTIVE,BLOCKED,SUSPENDED,INACTIVE,NEW
}

package com.kafka.masteringkafka;

import com.avro.model.Customer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;

public class MasteringKafkaApplication {

	public static void main(String[] args) {
		//this builder created by avro plugin and this class extends SpecificRecordBase
		Customer.Builder customerBuilder = Customer.newBuilder();
		customerBuilder.setAge(30);
		customerBuilder.setName("James");
		customerBuilder.setStatus(com.avro.model.Status.NEW);
		customerBuilder.setLastLoggedIn(Instant.ofEpochSecond(System.currentTimeMillis()));
		System.out.println(customerBuilder.getAge());
	}


}
enum Status{
	ACTIVE,BLOCKED,SUSPENDED,INACTIVE,NEW
}

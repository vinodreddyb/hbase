package com.vinod.hadoop.hbaseexamples;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * 
 * 
 TBALE :- 
 
  create 'Blog','info','content'

 OUTPUT :-
 
 blog3     column=content:post, timestamp=1415258689503, value=Cassandra is a no sql database                              
 blog3     column=info:author, timestamp=1415258689503, value=Reddy                                                        
 blog3     column=info:title, timestamp=1415258689503, value=Cassandra blog     
 * 
 * @author vinod
 *
 */
public class HBaseConnector {

	public static void main(String[] args) {
		HTable table = null;
		try {
			Configuration config = HBaseConfiguration.create();
			table = new HTable(config, "Blog");
			Put p = new Put(Bytes.toBytes("blog3"));
			p.add(Bytes.toBytes("info"), Bytes.toBytes("author"),
					Bytes.toBytes("Reddy"));
			p.add(Bytes.toBytes("info"), Bytes.toBytes("title"),
					Bytes.toBytes("Cassandra blog"));
			p.add(Bytes.toBytes("content"), Bytes.toBytes("post"),
					Bytes.toBytes("Cassandra is a no sql database"));
			table.put(p);
		} catch (IOException e) {
		  e.printStackTrace();
		} finally {
			try {table.close();} catch (IOException e) {}
		}

	}

}

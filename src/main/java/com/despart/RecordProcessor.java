package com.despart;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.types.InitializationInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ProcessRecordsInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownInput;
import com.amazonaws.services.kinesis.model.Record;

import java.nio.ByteBuffer;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RecordProcessor implements IRecordProcessor {

	public void initialize(InitializationInput initializationInput) {

	}

	public void processRecords(ProcessRecordsInput processRecordsInput) {
		List<Record> records = processRecordsInput.getRecords();

		for(Record r : records) {

			ByteBuffer byteBufferData = r.getData();

			byte[] bytes;
			if(byteBufferData.hasArray()) {
				bytes = byteBufferData.array();
			} else {
				bytes = new byte[byteBufferData.remaining()];
				byteBufferData.get(bytes);
			}

			String data = new String(bytes, UTF_8);
			System.out.println(data);
		}
	}

	public void shutdown(ShutdownInput shutdownInput) {

	}
}

package com.despart;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessorFactory;

public class RecordProcessorFactory implements IRecordProcessorFactory {

	public RecordProcessorFactory() {
		super();
	}

	public IRecordProcessor createProcessor() {
		return new RecordProcessor();
	}
}

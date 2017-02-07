package com.despart;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.KinesisClientLibConfiguration;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker;

import java.net.InetAddress;
import java.util.UUID;

public class Application {

	private static final String APPLICATION_NAME = "YourApplicationName";
	private static final String STREAM_NAME = "words";
	private static final String REGION = "us-east-1";
	private static final String AWS_ACCESS_KEY_ID = "<ENTER_KEY_ID>";
	private static final String AWS_SECRET_KEY="<ENTER_SECRET_KEY>";


	private static AWSCredentialsProvider awsCredentialsProvider = new AWSCredentialsProvider() {
		public AWSCredentials getCredentials() {
			return new AWSCredentials() {
				public String getAWSAccessKeyId() {
					return AWS_ACCESS_KEY_ID;
				}

				public String getAWSSecretKey() {
					return AWS_SECRET_KEY;
				}
			};
		}

		public void refresh() {

		}
	};

	public static void main(String[] args) throws Exception {

		final KinesisClientLibConfiguration config = new KinesisClientLibConfiguration(
				APPLICATION_NAME,
				STREAM_NAME,
				awsCredentialsProvider,
				InetAddress.getLocalHost().getCanonicalHostName() + ":" + UUID.randomUUID())
				.withRegionName(REGION);

		RecordProcessorFactory recordProcessorFactory = new RecordProcessorFactory();

		final Worker worker = new Worker.Builder()
				.recordProcessorFactory(recordProcessorFactory)
				.config(config)
				.build();

		worker.run();
	}
}

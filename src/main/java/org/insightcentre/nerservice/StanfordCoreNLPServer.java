package org.insightcentre.nerservice;

import CoreNLP.StanfordCoreNLPService;

import org.apache.log4j.Logger;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class StanfordCoreNLPServer {
	static final Logger logger = Logger.getLogger(StanfordCoreNLPServer.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static public void main(String[] args) throws InterruptedException{
		if ( args.length != 2 ) {
			System.out.println("Usage: StanfordCoreNLPServer <port> <config>");
			System.exit(2);
			return;
		}
		final int portNum = Integer.parseInt(args[0]);
		final String configFile = args[1];
		try {
			final StanfordCoreNLPService.Processor processor = new StanfordCoreNLPService.Processor( new StanfordCoreNLPHandler());
			TServerTransport serverTransport = new TServerSocket(portNum);
			TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
			logger.info("The Stanford Core NLP Server is running");
			server.serve();
		}
		catch (Exception ex) {
			logger.error("Error while executing server", ex);
		}
		logger.info("Shutting down server");
	}
}

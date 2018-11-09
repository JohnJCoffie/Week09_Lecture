package edu.dmacc.coma502.lecture;

public class Placeholder {
	
	private Logger logger;
	
	public Placeholder(Logger logger) {
		this.logger = logger;
	}
	
	public void process() {
		logger.logInfo("processing");
	}

}

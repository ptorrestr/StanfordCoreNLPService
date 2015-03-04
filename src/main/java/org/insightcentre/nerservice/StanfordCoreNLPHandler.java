package org.insightcentre.nerservice;

import java.util.Set;
import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import CoreNLP.StanfordCoreNLPService;
import CoreNLP.NamedEntity;

import org.apache.log4j.Logger;

public class StanfordCoreNLPHandler implements StanfordCoreNLPService.Iface {
	static final Logger logger = Logger.getLogger(StanfordCoreNLPHandler.class);
	private StanfordCoreNLP stanfordCoreNLP;
	private Entities entities;

	public StanfordCoreNLPHandler () {
		Properties props = new Properties();
                props.put("annotators","tokenize, ssplit, pos, lemma, ner");
		stanfordCoreNLP = new StanfordCoreNLP(props);
		entities = new Entities(stanfordCoreNLP);
	}

	public Set<String> get_entities(String text) {
		logger.debug("Get entities for :" + text);
		Set<String> names = entities.getNamedEntities(text);
		logger.debug(names);
		return names;
	}

	public String ping() {
		logger.info("Ping()");
		return "Ping()";
	}
}

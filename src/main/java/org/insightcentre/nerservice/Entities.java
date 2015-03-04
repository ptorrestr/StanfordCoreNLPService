package org.insightcentre.nerservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class Entities {
	private StanfordCoreNLP stanfordCoreNLP;
	public Entities(StanfordCoreNLP stanfordCoreNLP) {
		this.stanfordCoreNLP = stanfordCoreNLP;
	}

	public Set<String> getNamedEntities(String text) {
		Set<String> namedEntities = new HashSet<String>();
		if ( text == null || text.trim().length() == 0) 
			return namedEntities;
		Annotation document = new Annotation(text);
		this.stanfordCoreNLP.annotate(document);
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		for ( CoreMap sentence : sentences ) {
			String currentNer = "";
			for ( CoreLabel token : sentence.get(TokensAnnotation.class) ) {
				String word = token.get(TextAnnotation.class);
				String namedEntityAnnot = token.get(NamedEntityTagAnnotation.class);
				if ( !namedEntityAnnot.equals("O") )
					currentNer += " " + word;
				else {
					if ( !currentNer.equals("") )
						namedEntities.add(currentNer.trim());
					currentNer = "";
				}
			}
			if ( !currentNer.equals("") )
				namedEntities.add(currentNer.trim());
		}
		return namedEntities;
	}
}

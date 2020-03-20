package com.utils.utils_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
	
	private static final long serialVersionUID = 4261903549479142700L;

	public HibernateAwareObjectMapper() {
		Hibernate4Module hm = new Hibernate4Module();
		hm.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, true);
		registerModule(hm);
		configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
	
}

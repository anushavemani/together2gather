package com.us.g2g.hbm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseHome {
	
	private static final Log log = LogFactory.getLog(BaseHome.class);
	
	
	public SessionFactory getSessionFactory() {
		try {
			SessionFactory sf =   new Configuration().configure().buildSessionFactory();
			return sf;
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

}

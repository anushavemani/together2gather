package com.us.g2g.hbm;
// Generated Jul 26, 2017 12:54:47 AM by Hibernate Tools 5.2.3.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Participant.
 * @see com.us.g2g.hbm.Participant
 * @author Hibernate Tools
 */
public class ParticipantHome  extends BaseHome {

	private static final Log log = LogFactory.getLog(ParticipantHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	
	public void persist(Participant transientInstance) {
		log.debug("persisting Participant instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Participant instance) {
		log.debug("attaching dirty Participant instance");
		try {
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(instance);
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Participant instance) {
		log.debug("attaching clean Participant instance");
		try {
			Session session = sessionFactory.openSession();
			session.lock(instance, LockMode.NONE);
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Participant persistentInstance) {
		log.debug("deleting Participant instance");
		try {
			Session session = sessionFactory.openSession();
			session.delete(persistentInstance);
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void merge(Participant detachedInstance) {
		log.debug("merging Participant instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.update(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Participant findById(java.lang.Integer id) {
		log.debug("getting Participant instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			Participant instance = (Participant) session.get("com.us.g2g.hbm.Participant", id);
			session.close();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Participant> findByExample(Participant instance) {
		log.debug("finding Participant instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Participant> results = (List<Participant>) session.createCriteria("com.us.g2g.hbm.Participant")
								 .add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Participant> findAll() {
		log.debug("finding Participant instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Participant> results = (List<Participant>) session.createCriteria("com.us.g2g.hbm.Participant").list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

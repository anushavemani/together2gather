package com.us.g2g.hbm;
// Generated Jul 26, 2017 12:54:47 AM by Hibernate Tools 5.2.3.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class Payment.
 * @see com.us.g2g.hbm.Payment
 * @author Hibernate Tools
 */
public class PaymentHome  extends BaseHome {

	private static final Log log = LogFactory.getLog(PaymentHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	
	public void persist(Payment transientInstance) {
		log.debug("persisting Payment instance");
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

	public void attachDirty(Payment instance) {
		log.debug("attaching dirty Payment instance");
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

	public void attachClean(Payment instance) {
		log.debug("attaching clean Payment instance");
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

	public void delete(Payment persistentInstance) {
		log.debug("deleting Payment instance");
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

	public Payment merge(Payment detachedInstance) {
		log.debug("merging Payment instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Payment result = (Payment) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Payment findById(java.lang.Integer id) {
		log.debug("getting Payment instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			Payment instance = (Payment) session.get("com.us.g2g.hbm.Payment", id);
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
	public List<Payment> findByExample(Payment instance) {
		log.debug("finding Payment instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Payment> results = (List<Payment>) session.createCriteria("com.us.g2g.hbm.Payment")
								 .add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Payment> findAll() {
		log.debug("finding Payment instance by example");
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("deprecation")
			List<Payment> results = (List<Payment>) session.createCriteria("com.us.g2g.hbm.Payment").list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

package com.us.g2g.hbm;
// Generated Jul 26, 2017 12:54:47 AM by Hibernate Tools 5.2.3.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;


/**
 * Home object for domain model class User.
 * @see com.us.g2g.hbm.User
 * @author Hibernate Tools
 */
public class UserHome extends BaseHome{

	private static final Log log = LogFactory.getLog(UserHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	

	public int persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer id = (Integer) session.save(transientInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("persist successful");
			return id;
		}catch (ConstraintViolationException re) {
			log.error("attach failed", re);
			return -2;
		}  catch (RuntimeException re) {
			log.error("persist failed", re);
			return -1;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(instance);
			session.close();
			log.debug("attach successful");
		}catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
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

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
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

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			Session session = sessionFactory.openSession();
			User result = (User) session.merge(detachedInstance);
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			User instance = (User) session.get("com.us.g2g.hbm.User", id);
			Hibernate.initialize(instance.getEventsForCreatedBy());
			Hibernate.initialize(instance.getParticipants());
			Hibernate.initialize(instance.getPayments());
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
	@SuppressWarnings("deprecation")
	public User findById(String email) {
		log.debug("getting User instance with email: " + email);
		try {
			
			Session session = sessionFactory.openSession();
			User instance = (User) session.createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
			Hibernate.initialize(instance.getEventsForCreatedBy());
			Hibernate.initialize(instance.getParticipants());
			Hibernate.initialize(instance.getPayments());
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

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<User> results = (List<User>) session.createCriteria("com.us.g2g.hbm.User")
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
	public List<User> findAll() {
		log.debug("finding User instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<User> results = (List<User>) session.createCriteria("com.us.g2g.hbm.User").list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public User findCompleteUser(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			User instance = (User) session.get("com.us.g2g.hbm.User", id);
			Hibernate.initialize(instance.getEventsForCreatedBy());
			Hibernate.initialize(instance.getParticipants());
			Hibernate.initialize(instance.getCommentsForApprovedBy());
			Hibernate.initialize(instance.getCommentsForPostedBy());
			Hibernate.initialize(instance.getEventsForApprovedBy());
			Hibernate.initialize(instance.getPayments());
			Hibernate.initialize(instance.getPhotosForApprovedBy());
			Hibernate.initialize(instance.getPhotosForUserId());
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
}
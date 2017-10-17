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

/**
 * Home object for domain model class Event.
 * @see com.us.g2g.hbm.Event
 * @author Hibernate Tools
 */
public class EventHome  extends BaseHome {

	private static final Log log = LogFactory.getLog(EventHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	
	
	public int persist(Event transientInstance) {
		log.debug("persisting Event instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer id = (Integer) session.save(transientInstance);
//			session.flush();
			session.getTransaction().commit();
			session.close();
			log.debug("persist successful");
			return id;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Event instance) {
		log.debug("attaching dirty Event instance");
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

	public void attachClean(Event instance) {
		log.debug("attaching clean Event instance");
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

	public void delete(Event persistentInstance) {
		log.debug("deleting Event instance");
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

	public Event merge(Event detachedInstance) {
		log.debug("merging Event instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Event result = (Event) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Event findById(java.lang.Integer id) {
		log.debug("getting Event instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			Event instance = (Event) session.get("com.us.g2g.hbm.Event", id);
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
	public List<Event> findByExample(Event instance) {
		log.debug("finding Event instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Event> results = (List<Event>) session.createCriteria("com.us.g2g.hbm.Event")
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
	public List<Event> findAll() {
		log.debug("finding Event instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Event> results = (List<Event>) session.createCriteria("com.us.g2g.hbm.Event").list();
			for (Event event : results) {
				for (Comment comment : event.getComments()) {
					comment.setCommentedBy(comment.getUserByPostedBy().getShortName());
					Hibernate.initialize(comment.getUserByPostedBy());
				}
				for (Photo photo : event.getPhotos()) {
					Hibernate.initialize(photo.getUserByUserId());
				}
				Hibernate.initialize(event.getUserByCreatedBy());
				Hibernate.initialize(event.getPayments());
				for(Payment payment:event.getPayments()){
					Hibernate.initialize(payment.getUser());
				}
				Hibernate.initialize(event.getParticipants());
				for(Participant participant: event.getParticipants()){
					Hibernate.initialize(participant.getUser());
					participant.setName(participant.getUser().getName());
				}
			}
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

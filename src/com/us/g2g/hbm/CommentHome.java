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
 * Home object for domain model class Comment.
 * @see com.us.g2g.hbm.Comment
 * @author Hibernate Tools
 */
public class CommentHome extends BaseHome {

	private static final Log log = LogFactory.getLog(Comment.class);

	private final SessionFactory sessionFactory = getSessionFactory();



	public void persist(Comment transientInstance) {
		log.debug("persisting Comment instance");
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

	public void attachDirty(Comment instance) {
		log.debug("attaching dirty Comment instance");
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

	public void attachClean(Comment instance) {
		log.debug("attaching clean Comment instance");
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

	public void delete(Comment persistentInstance) {
		log.debug("deleting Comment instance");
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

	public Comment merge(Comment detachedInstance) {
		log.debug("merging Comment instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Comment result = (Comment) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comment findById(java.lang.Integer id) {
		log.debug("getting Comment instance with id: " + id);
		try {
			
			Session session = sessionFactory.openSession();
			Comment instance = (Comment) session.get("com.us.g2g.hbm.Comment", id);
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
	public List<Comment> findByExample(Comment instance) {
		log.debug("finding Comment instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Comment> results = (List<Comment>) session.createCriteria("com.us.g2g.hbm.Comment")
								 .add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Comment> findAll() {
		log.debug("finding Comment instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Comment> results = (List<Comment>) session.createCriteria("com.us.g2g.hbm.Comment").list();
			for (Comment comment : results) {
				Hibernate.initialize(comment.getEvent());
				Hibernate.initialize(comment.getUserByPostedBy());
				Hibernate.initialize(comment.getUserByApprovedBy());
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

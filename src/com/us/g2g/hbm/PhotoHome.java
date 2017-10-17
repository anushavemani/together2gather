package com.us.g2g.hbm;
// Generated Jul 26, 2017 12:54:47 AM by Hibernate Tools 5.2.3.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Photo.
 * @see com.us.g2g.hbm.Photo
 * @author Hibernate Tools
 */
public class PhotoHome  extends BaseHome {

	private static final Log log = LogFactory.getLog(PhotoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	

	public void persist(Photo transientInstance) {
		log.debug("persisting Photo instance");
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

	public void attachDirty(Photo instance) {
		log.debug("attaching dirty Photo instance");
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

	public void attachClean(Photo instance) {
		log.debug("attaching clean Photo instance");
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

	public void delete(Photo persistentInstance) {
		log.debug("deleting Photo instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Photo merge(Photo detachedInstance) {
		log.debug("merging Photo instance");
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Photo result = (Photo) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Photo findById(java.lang.Integer id) {
		log.debug("getting Photo instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Photo instance = (Photo) session.get("com.us.g2g.hbm.Photo", id);
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
	public List<Photo> findAll() {
		log.debug("getting all Photo instance: ");
		try {
			Session session = sessionFactory.openSession();
			List<Photo> instance = (List<Photo>) session.createCriteria("com.us.g2g.hbm.Photo").list();
			for (Photo photo : instance) {
				Hibernate.initialize(photo.getEvent());
				Hibernate.initialize(photo.getUserByUserId());
			}
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

	public List<Photo> findByExample(Photo instance) {
		log.debug("finding Photo instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Photo> results = (List<Photo>) session.createCriteria("com.us.g2g.hbm.Photo")
					 .add(create(instance)).list();
			session.close();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void deleteById(Integer picId) {
		// TODO Auto-generated method stub
		
	}
}

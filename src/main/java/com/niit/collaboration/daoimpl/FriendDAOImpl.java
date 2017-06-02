package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@Transactional
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	private Integer getMaxId() {

		String hql = "select max(id) from Friend";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			log.debug("Enter into calculate MaxID");
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			log.debug("Enter In to MAXID Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

	public List<Friend> listMyFriend(String user_id) {
		String hql1 = "select friend_id  from Friend where user_id='" + user_id + "' and status = 'Y' ";

		/* + " union  " + */

		String hql2 = "select user_id from Friend where friend_id='" + user_id + "' and status = 'Y'";

		log.debug("getMyFriends hql1 : " + hql1);
		log.debug("getMyFriends hql2 : " + hql2);

		List<Friend> list1 = sessionFactory.openSession().createQuery(hql1).list();
		List<Friend> list2 = sessionFactory.openSession().createQuery(hql2).list();

		list1.addAll(list2);
log.debug("array count"+list1.size());
		return list1;
	}

	public Friend get(String friend_id,String user_id) {
		String hql = "from Friend where user_id=" + "'" + user_id + "' and friend_id= '" + friend_id + "' and status= 'R' ";

		log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);

		return (Friend) query.uniqueResult();
	}

	public boolean save(Friend friend) {
		try {
			// log.debug("*********************Previous id " + getMaxId());
			friend.setId(getMaxId() + 1);
			log.debug("***********************generated id:" + getMaxId());
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			log.debug("Enter into SAVE EXCEPTION");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Friend friend) {
		try {
			log.debug("Starting of the method update");
			log.debug("user ID : " + friend.getUser_id() + " Friend id :" + friend.getFriend_id());
			log.debug("user ID : " + friend.getUser_id() + " Friend id :" + friend.getFriend_id());
			sessionFactory.getCurrentSession().update(friend);
			log.debug("Successfully updated");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Not able to update the status");
			return false;
		}
	}

	public List<Friend> getNewFriendRequests(String user_id) {
		String hql = "select user_id from Friend where friend_id=" + "'" + user_id + "' and status ='" + "R'";

		log.debug(hql);
		 return  sessionFactory.openSession().createQuery(hql).list();
	}

	public boolean setOnline(String user_id) {
		log.debug("Starting of the metnod setOnline"+user_id);
		
		//String hql = " UPDATE Friend	SET isOnline = 'Y' where friend_id='" + user_id + "'";
		
		try {
			String hql = " UPDATE Friend	SET is_online = 'Y' where friend_id= ?";
			
			
			
			
			log.debug("hql: " + hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, user_id);
			
			
			query.executeUpdate();
			log.debug("Ending of the metnod setOnline"+query);
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean setOffLine(String user_id) {
		try {
			log.debug("Starting of the metnod setOffLine");
			String hql = " UPDATE Friend	SET is_online = 'N' where friend_id='" + user_id + "'";
			log.debug("hql: " + hql);
			Query query = sessionFactory.openSession().createQuery(hql);
			query.executeUpdate();
			log.debug("Ending of the metnod setOffLine");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Friend> getRequestsSendByMe(String user_id) {
		String hql = "select friend_id from Friend where user_id=" + "'" + user_id + "' and status ='" + "R'";

		log.debug(hql);
		return  sessionFactory.openSession().createQuery(hql).list();
	}

	public List<Friend> getNonFriendUsers(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}

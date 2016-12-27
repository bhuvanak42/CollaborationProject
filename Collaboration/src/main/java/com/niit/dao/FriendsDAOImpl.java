package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friends;
import com.niit.model.UsersDetail;
//import com.niit.model.UsersDetail;

@SuppressWarnings("deprecation")
@EnableTransactionManagement
@Repository("friendsDAO")
public class FriendsDAOImpl implements FriendsDAO {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(FriendsDAOImpl.class);
	
	
	
	@Autowired
	UsersDetailDao usersDetailDao;
	
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public FriendsDAOImpl()
		{
		}
		
		
		public FriendsDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public Friends get(String userID) 
		{
			
			String hql="from Friends where userID = " + "'" + userID + "'";
	
			@SuppressWarnings({ "rawtypes" })
			Query query=sessionFactory.openSession().createQuery(hql);
			@SuppressWarnings({ "unchecked" })
			List<Friends> list=query.list();
			if(list==null || list.isEmpty())
			{
				
				return null;
			}
			else
			{
				return list.get(0);
			}
		}

		
		@Transactional
		public boolean save(Friends friends){	
			
			/*Session session = sessionFactory.openSession();*/

			Session session = sessionFactory.openSession();
			
			try{
				session.save(friends);
				session.flush();
		return true;
			}catch (Exception e ){
				//TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}	
		@Transactional
		public boolean update(Friends friends){
			Session session =sessionFactory.openSession();
			try{
				session.update(friends);
				session.flush();
		return true;
			} catch (Exception e){
				//TODO Auto-generated catch block
		       e.printStackTrace();
		       return false;
			}
		}
		
	/*	@Transactional
		public boolean delete(Friends friends){
			try{
		       sessionFactory.openSession().delete(friends);
		return true;
			} catch (Exception e){
				//TODO Auto-generated catch block
		       e.printStackTrace();
		       return false;
			}
		}*/
		
		@Transactional
		public Friends get(String userID, String friendID) {
			String hql = "from Friends where friendID =" + "'" + friendID + "' and userID= '" + userID + "'";
			//String hql = "from Friends where friendID=" + "'" + userID + "' and userID= '" + friendID + "'";
			
			Query query = sessionFactory.openSession().createQuery(hql);
			
			List<Friends> list = (List<Friends>) query.list();
			
			if(list != null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
			
		}

		@Transactional
		public boolean delete(String userID, String friendID) {
			Friends friend = new Friends();
			friend.setFriendID(friendID);
			friend.setUserID(userID);
			Session session = sessionFactory.openSession();
			session.delete(friend);
			session.flush();
			return true;
			
		}

		@Transactional
		public List<Friends> getMyFriend(String userID) {
			String hql = "from Friends where userID=" + "'" + userID + "' and status = '" + "A'";
			@SuppressWarnings("rawtypes")
			Query query =sessionFactory.openSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Friends> list = (List<Friends>) query.list();
			if(list!=null||!list.isEmpty())
			return list;
			else
				return null;
			
		}

		@Transactional
		public List<Friends> getNewFriendRequests(String userID) {
			String hql = "from Friends where friendID=" + "'" + userID + "' and status = '" + "N'";
			@SuppressWarnings("rawtypes")
			Query query =sessionFactory.openSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Friends> list = (List<Friends>) query.list();
			return list;
		}

		
		@Transactional
		public void setOnline(String loggedInUserID) {
			Logger.debug("Starting of the method setOnline");
			String hql = "UPDATE Friends SET isOnline = 'Y' where userID ='" + loggedInUserID + "'";
			Logger.debug("hql: " + hql);
			Query query = sessionFactory.openSession().createQuery(hql);
			query.executeUpdate();
			Logger.debug("Ending of the method setOnline");
		}
		

		@Transactional
		public void setOffLine(String loggedInUserID) {
			Logger.debug("Starting of the method setOffline");
			String hql = "UPDATE Friends SET isOnline = 'N' where userID = '" + loggedInUserID + "'";
			Logger.debug("hql: " + hql);
			Query query = sessionFactory.openSession().createQuery(hql);
			query.executeUpdate();
			Logger.debug("Ending of the method setOffline");
		}
		@SuppressWarnings("null")
		@Transactional
		public List<UsersDetail> showNewUsers(String userID) {
			// TODO Auto-generated method stub
			
			String hql = "from UsersDetail";
			@SuppressWarnings("rawtypes")
			Query query =sessionFactory.openSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<UsersDetail> list = (List<UsersDetail>) query.list();
			
			
			String hql2 = "from Friends where userID = '"+userID+"'";
			
			@SuppressWarnings("rawtypes")
			Query query2 =sessionFactory.openSession().createQuery(hql2);
			
			@SuppressWarnings("unchecked")
			List<Friends> list2 = (List<Friends>) query2.list();
			/*for(Friends friends:list2){
				System.out.println("fcyhjbk   "+ friends.getUserID());
			}*/
			
			
			// Make the two lists
			List<String> list3 = new ArrayList<String>() ;
			for(UsersDetail user:list){
				//System.out.println("aefszdc "+user.getUsername());
				list3.add(user.getUsername());
			}
						
			List<String> list4 = new ArrayList<String>() ;
			for(Friends friend:list2){
				list4.add(friend.getFriendID());
			}
			
						// Prepare a union
						List<String> union = new ArrayList<String>(list3);
						union.addAll(list4);
						
						// Prepare an intersection
						List<String> intersection = new ArrayList<String>(list3);
						intersection.retainAll(list4);
						
						// Subtract the intersection from the union
						union.removeAll(intersection);
						
						List<UsersDetail> list5 = new ArrayList<UsersDetail>() ;
						// Print the result
						for (String n : union) {
						  //  System.out.println(n);
						    list5.add(usersDetailDao.getUserByUsername(n));
						    
						}
			return list5;
			
			/*
			List<Friends> list3;
			for(UsersDetail user:list){
			//	if(!(user.getUsername().equals(userID))){
					
					for(Friends friend:list2){
						if(!(user.getUsername().equals(friend.getFriendID()))){
							list3.add(friend);
						}
					}
					
				
			}
			
			
			
			return list2;*/
		}


		
}

	
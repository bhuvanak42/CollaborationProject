package com.niit.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.datetime.joda.LocalDateTimeParser;

import com.niit.dao.EventDao;
import com.niit.dao.UsersDetailDao;
import com.niit.model.Event;
import com.niit.model.UsersDetail;

public class EventTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Event event = (Event) context.getBean("event");
		EventDao eventDAO = (EventDao) context.getBean("eventDao");
		UsersDetailDao userDetailsDAO = (UsersDetailDao) context.getBean("usersDetailDao");
		UsersDetail usersDetail =userDetailsDAO.getUserById(2);
		
		// INSERT OBJECTS INTO DB
		
		event.setEventId("EVENT_001");
		event.setDescription("description");
		event.setEventDate(new Date());
		event.setTitle("title");
		event.setVenue("venue");
		event.setUsersID(1);
		eventDAO.saveOrUpdateEvent(event);

		/*event.setEventId("EVENT_002");
		event.setDescription("description");
		event.setEventDate(new Date());
		event.setTitle("title");
		event.setVenue("venue");
		event.setUsersID(2);
		eventDAO.saveOrUpdateEvent(event);
		
		event.setEventId("EVENT_003");
		event.setDescription("description");
		event.setEventDate(new Date());
		event.setTitle("title");
		event.setUsersID(3);
		event.setVenue("venue");
		eventDAO.saveOrUpdateEvent(event);*/
		
		/*event = eventDAO.getEventById("EVENT_001");
		System.out.println(event.getEventId() + "\t" + event.getDescription() + "\t" + "\t" + event.getEventDate());
		*/
		
		/*boolean flag=eventDAO.delete(event);
		System.out.println("delete  "+flag);*/
		context.close();
	}
}
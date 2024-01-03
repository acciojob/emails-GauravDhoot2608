package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Mail{
	
	Date date;
	String sender;
	String message;
	
	public Mail(Date date , String sender , String message) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.sender = sender;
		this.message = message;
	}
}

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    List<Mail> inbox ;
    
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    List<Mail> trash ;
   
    public Gmail(String emailId, int inboxCapacity) {
    	super(emailId);
    	this.inboxCapacity = inboxCapacity;
    	inbox = new ArrayList<Mail>();
    	trash = new ArrayList<Mail>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order(Ascending order). This means that the date of a new mail is greater than equal to the dates of mails received already.

    	if(inbox.size() >= inboxCapacity) {
    		trash.add(inbox.get(0));
    		inbox.remove(0);
    	}
    	inbox.add(new Mail(date, sender, message));
    }
    

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
    	for(int i=0 ; i<inbox.size() ; i++) {
    		if(inbox.get(i).message.contains(message)) {
    			Mail mail = inbox.remove(i);
    			trash.add(mail);
    			return;
    		}
    	}

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
    	
    	return inbox.size() == 0 ? null : inbox.get(getInboxSize()-1).message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
    	return inbox.size() == 0 ? null : inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
    	int count = 0;
    	for(int i=0 ; i<inbox.size() ; i++) {
    		Mail mail = inbox.get(i);
    		if(mail.date.compareTo(start) >= 0 && mail.date.compareTo(end) <= 0) {
    			count++;
    		}
    	}
    	return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
    	return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
    	return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
    	trash = new ArrayList<Mail>();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
    	return inboxCapacity;
    }
}

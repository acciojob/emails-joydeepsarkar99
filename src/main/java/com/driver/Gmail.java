package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    LinkedHashMap<String,Container> inbox = new LinkedHashMap<>();
    ArrayList<Container> trash = new ArrayList<>();
   public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(inbox.size() == this.inboxCapacity){
            int count = 1;
            for(Map.Entry<String, Container> entry : inbox.entrySet()) {
                if(count == 1) {
                    trash.add(entry.getValue());
                    inbox.remove(entry);
                    break;
                }
                count++;
            }
        }
        else inbox.put(message,new Container(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        if(inbox.containsKey(message)){
            trash.add(inbox.get(message));
            inbox.remove(message);
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size() == 0) return null;

        StringBuilder latestMsg = new StringBuilder("") ;
        int count = 1;
        for(Map.Entry<String, Container> entry : inbox.entrySet()) {
            if(count == inbox.size()) {
                Container obj = entry.getValue();
                latestMsg.append(obj.getMessage());
                break;
            }
            count++;
        }
        return latestMsg.toString();
    }

    public String findOldestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if (inbox.size() == 0) return null;

        StringBuilder oldestMsg = new StringBuilder("") ;
        int count = 1;
        for (Map.Entry<String, Container> entry : inbox.entrySet()) {
            if (count == 1) {
                Container obj = entry.getValue();
                oldestMsg.append(obj.getMessage());
            }
            count++;
        }
        return oldestMsg.toString();
   }


    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
            int mailCount = 0;
            for(Map.Entry<String, Container> entry : inbox.entrySet()) {
                    Container obj = entry.getValue();
                    Date objDate = obj.getDate();
                    if (objDate.compareTo(start) >= 0 && objDate.compareTo(end) <= 0){
                        mailCount++;
                    }
                }
            return mailCount;
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
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}

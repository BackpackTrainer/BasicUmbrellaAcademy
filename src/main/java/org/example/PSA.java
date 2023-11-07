package org.example;

public class PSA implements  IPublicServiceAnnouncementUtility{
    String announcement;
    @Override
    public void setAnnouncement(String s) {
        this.announcement = s;
    }

    @Override
    public void makeAnnouncement(String message) {
        System.out.println("This is a public service announcement.  " + message);
    }

}

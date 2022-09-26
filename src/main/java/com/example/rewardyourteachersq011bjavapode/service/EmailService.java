package com.example.rewardyourteachersq011bjavapode.service;

public interface EmailService {
     void sendSimpleEmail( String body, String subject, String recieverEmail);

     void sendSimpleEmailWithAttachment(String body, String subject, String attachment);

}

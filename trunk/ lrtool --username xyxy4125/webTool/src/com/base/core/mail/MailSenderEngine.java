package com.base.core.mail;

import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

public class MailSenderEngine{
    private JavaMailSender sender;
    private FreemarkMimeMessagePreparator messagePreparator;

    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }

    public void setMessagePreparator(FreemarkMimeMessagePreparator messagePreparator) {
        this.messagePreparator = messagePreparator;
    }

    public JavaMailSender getSender() {
        return sender;
    }

    public FreemarkMimeMessagePreparator getMessagePreparator() {
        return messagePreparator;
    }

    public String sendMail(String from,String to,String subject,Map mailData,String templateFileName){
        messagePreparator.setPlainTextTemplate(templateFileName+"Text.ftl");
        messagePreparator.setHtmlTemplate(templateFileName+"Html.ftl");        
        messagePreparator.setData(mailData);
        messagePreparator.setTo(to);
        messagePreparator.setFrom(from);
        messagePreparator.setSubject(subject);
        try{
            sender.send(messagePreparator);
        }catch(Exception e){
            e.printStackTrace();
        }
        return messagePreparator.getMailContent();
    }
}

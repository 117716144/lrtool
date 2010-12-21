package com.base.core.mail;

import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Map;

public class FreemarkMimeMessagePreparator implements MimeMessagePreparator {
    private FreeMarkerConfigurer freeMarkerConfigurer;
    private String plainTextTemplate =  "commonText.ftl";
    private String htmlTemplate = "commonHtml.ftl";
    private String from;
    private String to;
    private String subject;
    private Map data;
    private String mailContent;

    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }

    public void setPlainTextTemplate(String plainTextTemplate) {
        this.plainTextTemplate = plainTextTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void prepare(MimeMessage msg) throws Exception {
        //set header details
        msg.addFrom(InternetAddress.parse(from));
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject(subject,"UTF-8");
        //create wrapper multipart/alternative part
        MimeMultipart ma = new MimeMultipart("alternative");
        msg.setContent(ma);
        //create the plan text
        BodyPart plainText = new MimeBodyPart();
        String bodyText = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(plainTextTemplate), data);
        plainText.setContent(bodyText,"text/plain;charset=UTF-8");
        //return mail content for communication log
        mailContent = plainText.getContent().toString();
        ma.addBodyPart(plainText);

        //create the html part
        BodyPart html = new MimeBodyPart();
        html.setContent(FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(htmlTemplate), data), "text/html;charset=UTF-8");
        ma.addBodyPart(html);
    }
}

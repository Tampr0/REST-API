package com.crud.tasks.service;


import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);

    public void send(final Mail mail) {
        LOGGER.info("Sending email start to process ...");
        try {
            javaMailSender.send(createMailMessage(mail));
            LOGGER.info("Email has been sent");
        } catch (MailException e) {
            LOGGER.error("There was some error during email sending", e.getMessage(), e);
        }
    }
    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if (mail.getToCc() == null) {
            LOGGER.info("If toCc field remain empty, no additional receiver will be set");
        } else {
            mailMessage.setCc(mail.getToCc());
        }
        return mailMessage;
    }

}

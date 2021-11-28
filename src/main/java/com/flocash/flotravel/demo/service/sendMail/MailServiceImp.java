package com.flocash.flotravel.demo.service.sendMail;

import com.flocash.flotravel.demo.dto.mail.Mail;
import com.flocash.flotravel.demo.dto.mail.MailPackagesContent;
import com.flocash.flotravel.demo.dto.packages.provider.PackageOrder;
import com.flocash.flotravel.demo.mapper.mail.PackagesMailContentMapper;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailServiceImp implements MailService {

    @Value("${spring.mail.username}")
    private String fromEmail;
//    @Value("${flotravel.domain}")
//    private String host;

    JavaMailSender mailSender;
    Configuration fmConfiguration;

    private PackagesMailContentMapper packagesMailContentMapper;

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    public void setFmConfiguration(Configuration fmConfiguration) {
        this.fmConfiguration = fmConfiguration;
    }

    @Autowired
    public void setPackagesMailContentMapper(PackagesMailContentMapper packagesMailContentMapper) {
        this.packagesMailContentMapper = packagesMailContentMapper;
    }

    public void sendEmailPackagesBooking(String targetEmail, PackageOrder p) {
        Mail mail = new Mail();
        mail.setMailFrom(fromEmail);
        mail.setMailTo(targetEmail);
        mail.setMailSubject("Flotravel: Packages - " + p.getBookingStatusDes());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(mail.getMailFrom());
            mimeMessageHelper.setTo(mail.getMailTo());
            mail.setMailContent(geContentFromTemplatePackages(p, "host"));
            mimeMessageHelper.setText(mail.getMailContent(), true);
            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    public String geContentFromTemplatePackages(PackageOrder model, String reqUrl) {
        StringBuilder content = new StringBuilder();
        MailPackagesContent data = packagesMailContentMapper.mapMailPackagesContent(model, reqUrl);
        try {
            content.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(fmConfiguration.getTemplate("email-packages-template.ftl"), data));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

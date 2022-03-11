package com.trimou.example.trimoutdemo.service;

import com.trimou.example.trimoutdemo.request.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.trimou.Mustache;
import org.trimou.engine.MustacheEngine;
import org.trimou.engine.MustacheEngineBuilder;
import org.trimou.engine.locator.FileSystemTemplateLocator;
import org.trimou.util.ImmutableMap;

import java.io.StringWriter;

@Service
public class SendMailService {
    private MustacheEngine engine;

    public SendMailService(@Value("${resources.email.path}") String emailPath) {
        this.engine = MustacheEngineBuilder
                .newBuilder()
                .addTemplateLocator(new FileSystemTemplateLocator(1, emailPath))
                .build();
    }

    public void sendEmail(EmailRequest emailRequest) {
        Mustache mustache = getMustacheFactoryInstance(emailRequest);
        StringWriter stringWriter = new StringWriter();

        //hardcoded firstName is just for example.
        //you can use Map<String, Object> mapping.
        mustache.render(stringWriter, ImmutableMap.<String, Object> of("firstName", emailRequest.getFrom()));
        System.out.println(stringWriter.toString());
    }

    public Mustache getMustacheFactoryInstance(EmailRequest emailRequest) {
        return engine.getMustache(createMailPath(emailRequest));
    }

    //if you need add path like language you can add.
    //hierarchy is like template.en/welcome.html
    //   template.tr/welcome.html
    public String createMailPath(EmailRequest emailRequest) {
        return // "/" + emailRequest.getLanguage()
                 "/" + emailRequest.getEmailName();
    }
}

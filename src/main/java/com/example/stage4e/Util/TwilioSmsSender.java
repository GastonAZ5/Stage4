package com.example.stage4e.Util;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSender implements SmsSender{

    private final TwilioConfiguration twilioConfiguration;
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);


    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getPhoneNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}"+ smsRequest);

        } else {
        throw new IllegalArgumentException("PhoneNumber ["+smsRequest.getPhoneNumber()+"] is not a valid number ");
    }
}

            private boolean isPhoneNumberValid(String phoneNumber) {
                 return true;
            }
    }

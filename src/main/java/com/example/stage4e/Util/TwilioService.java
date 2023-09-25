package com.example.stage4e.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioService {

    private final TwilioSmsSender twilioSmsSender;

    @Autowired
    public TwilioService(TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void SendSms(SmsRequest smsRequest){
        twilioSmsSender.sendSms(smsRequest);
    }
}

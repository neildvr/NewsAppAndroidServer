package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Remind;
import com.qoobico.remindme.server.repository.RemindRepository;
import com.qoobico.remindme.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

     @Autowired
    private RemindRepository remindRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder() {
        List<Remind> list = remindRepository.findAll();
        return createMockRemind();
    }
    private Remind createMockRemind(){
        Remind remind = new Remind();
        remind.setId(1);
        remind.setRemindDate(new Date());
        remind.setTitle("News is a");
        return remind;
    }

}

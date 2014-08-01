package org.motechproject.testagent.web;

import org.motechproject.testagent.test.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TestController {

    @Autowired
    private Tester tester;

    @RequestMapping(value = "/start/{runs}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void startTest(@PathVariable int runs) {
        tester.startTest(runs);
    }
}

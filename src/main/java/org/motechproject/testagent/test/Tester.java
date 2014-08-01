package org.motechproject.testagent.test;

import org.apache.commons.lang.time.StopWatch;
import org.motechproject.event.MotechEvent;
import org.motechproject.tasks.ex.TriggerNotFoundException;
import org.motechproject.tasks.service.TriggerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Tester {

    private static final Logger LOG = LoggerFactory.getLogger(Tester.class);

    @Autowired
    private TriggerHandler tth;

    public void startTest(int runs) {
        StopWatch stopWatch = new StopWatch();

        LOG.info("Starting test");

        stopWatch.start();
        for (int i = 0; i < runs; i++) {
            String testId = "Our ID :" + i;

            Map<String, Object> params = new HashMap<>();
            params.put("testId", testId);

            MotechEvent event = new MotechEvent("test-trigger", params);

            try {
                tth.handle(event);
            } catch (TriggerNotFoundException e) {
                LOG.error("Error during test", e);
            }

            LOG.info("Completed run {}", i);
        }
        stopWatch.stop();

        LOG.info("Runs - {}, Test Time - {}", new Object[] {runs, stopWatch.getTime()});
    }
}

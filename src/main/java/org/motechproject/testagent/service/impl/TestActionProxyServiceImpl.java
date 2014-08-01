package org.motechproject.testagent.service.impl;

import org.motechproject.testagent.service.TestActionProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("testActionProxyService")
public class TestActionProxyServiceImpl implements TestActionProxyService {

    private static final Logger LOG = LoggerFactory.getLogger(TestActionProxyServiceImpl.class);

    @Override
    public void execute(String str, Integer integer) {
        if (LOG.isInfoEnabled()) {
            LOG.info("EXECUTION: " + str + " " + integer);
        }
    }
}

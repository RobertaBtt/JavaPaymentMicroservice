package com.form3.payment.infrastructure;

import com.form3.payment.infrastructure.config.TestRepositoryConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@org.junit.runner.RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestRepositoryConfig.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
public abstract class AbstractDBUnitTest {
}

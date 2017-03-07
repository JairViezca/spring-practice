package com.accenture.dao.config;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.config.PersistenceJPAConfig;
import com.accenture.dao.repository.BookRepository;

@Ignore("No test runnable methods")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class})
public class PersistenceContextTest {

	@Autowired
	protected BookRepository booksRepository;
	
}

package fr.wd.kata.business.services;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.wd.kata.config.FbqServiceConfig;
import fr.wd.kata.domain.FooBarQix;

/**
 * Testing integration with Spring
 * @author wylson dibinga wd
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FbqServiceConfig.class})
public class FoobarqixServiceImplTest {

	@Autowired
	private IFoobarqixService foobarqixService;

	@Test
	public void test_calculteNumber_Should_Test_The_fonctional_method() {
		// Given
		Integer maxNumber = 100;

		// When
		List<FooBarQix> results = foobarqixService.calculteNumber(maxNumber);

		// Then
		assertThat(results).isNotNull();
		assertThat(results).isNotEmpty();
		assertThat(results).hasSize(maxNumber);
		assertThat(results.get(51)).isNotNull();
		assertThat(results.get(51).getIndex()).isEqualTo(52);
		assertThat(results.get(51).getResult()).isEqualTo("Bar");

		assertThat(results.get(6).getIndex()).isEqualTo(7);
		assertThat(results.get(6).getResult()).isEqualTo("QixQix");
	}

}

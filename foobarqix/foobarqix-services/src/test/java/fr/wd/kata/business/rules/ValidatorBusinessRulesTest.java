package fr.wd.kata.business.rules;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test with mockito for Business rules
 * @author wylson dibinga
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidatorBusinessRulesTest {

	@InjectMocks
	@Spy
	private ValidatorBusinessRules validator;

	@Test
	public void test_calculateNumberTest_ShouldReturn_FooFoo_If_Number_Is_3() {
		// Given
		Integer number = 3;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("FooFoo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_BarBar_If_Number_Is_5() {
		// Given
		Integer number = 5;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("BarBar");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_QixQix_If_Number_Is_7() {
		// Given
		Integer number = 7;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("QixQix");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Same_Number_If_4() {
		// Given
		Integer number = 4;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("4");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Same_Number_If_8() {
		// Given
		Integer number = 8;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("8");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Same_Number_If_9() {
		// Given
		Integer number = 9;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("Foo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Same_Number_If_10() {
		// Given
		Integer number = 10;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("Bar");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_True_If_Number_Is_33() {
		// Given
		Integer number = 33;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("FooFooFoo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_FooBar_If_Number_Is_51() {
		// Given
		Integer number = 51;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("FooBar");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_BarFoo_If_Number_Is_53() {
		// Given
		Integer number = 53;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("BarFoo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Foo_If_Number_Is_13() {
		// Given
		Integer number = 13;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("Foo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_FooBarBar_If_Number_Is_15() {
		// Given
		Integer number = 15;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("FooBarBar");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Foo_If_Number_Is_99() {
		// Given
		Integer number = 99;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("Foo");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_FooQix_If_Number_Is_21() {
		// Given
		Integer number = 21;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("FooQix");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Empty_If_Null() {
		// Given
		Integer number = null;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Empty_If_NegativeNumber() {
		// Given
		Integer number = -1;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("");
	}

	@Test
	public void test_calculateNumberTest_ShouldReturn_Empty_If_Zero() {
		// Given
		Integer number = 0;

		// When
		String answer = validator.calculateNumber(number);

		// Then
		assertThat(answer).isEqualTo("");
	}

}

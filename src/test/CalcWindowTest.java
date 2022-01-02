package test;

import gui.CalcWindow;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CalcWindowTest {	
	static CalcWindow window;
	
	@BeforeAll
	public static void InstantiateWindow() throws Exception {
		window = new CalcWindow();
	}
	
	@Test
	public void testRoundingMethodDecimals1() throws Exception
	{
		CalcWindow.setDecimalPrecision(1);
		CalcWindow.setRoundingMethod("D");
		assertEquals("10.5", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodDecimals2() throws Exception
	{
		CalcWindow.setDecimalPrecision(2);
		CalcWindow.setRoundingMethod("D");
		assertEquals("10.46", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodDecimals3() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("D");
		assertEquals("10.456", window.evaluateExpression("10.456"));
	}
	
	
	
	
	// (https://www.my-gcsescience.com/decimal-places-significant-figures/)
	// (https://www.omnicalculator.com/math/sig-fig)
	// (https://en.wikipedia.org/wiki/Significant_figures#Rules_to_identify_significant_figures_in_a_number)
	@Test
	public void testRoundingMethodSignificantFigures1() throws Exception
	{
		System.out.println("======== SF ========");
		CalcWindow.setDecimalPrecision(1);
		CalcWindow.setRoundingMethod("S");
		assertEquals("10", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures2() throws Exception
	{
		CalcWindow.setDecimalPrecision(2);
		CalcWindow.setRoundingMethod("S");
		assertEquals("10", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures3() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		assertEquals("10.5", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures4() throws Exception
	{
		CalcWindow.setDecimalPrecision(4);
		CalcWindow.setRoundingMethod("S");
		assertEquals("10.46", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures5() throws Exception
	{
		CalcWindow.setDecimalPrecision(5);
		CalcWindow.setRoundingMethod("S");
		assertEquals("10.456", window.evaluateExpression("10.456"));
	}
	
	
	//rule: all non-zero digits are significant
	@Test
	public void testRoundingMethodSignificantFigures6() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		assertEquals("0.456", window.evaluateExpression("0.456"));
	}
	
	//rule: zeroes placed between non-zero digits are significant
	@Test
	public void testRoundingMethodSignificantFigures7() throws Exception
	{
		CalcWindow.setDecimalPrecision(5);
		CalcWindow.setRoundingMethod("S");
		assertEquals("5.0505", window.evaluateExpression("5.0505"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures8() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		assertEquals("5.05", window.evaluateExpression("5.0505"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures9() throws Exception
	{
		CalcWindow.setDecimalPrecision(2);
		CalcWindow.setRoundingMethod("S");
		assertEquals("5.0", window.evaluateExpression("5.0404")); //round down
	}
	
	
	@Test
	public void testRoundingMethodSignificantFigures10() throws Exception
	{
		CalcWindow.setDecimalPrecision(2);
		CalcWindow.setRoundingMethod("S");
		assertEquals("5.1", window.evaluateExpression("5.0505")); //round UP
	}
	
	//rule: leading zeroes are not significant
	@Test
	public void testRoundingMethodSignificantFigures11() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		assertEquals("0.456", window.evaluateExpression("0.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures12() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		assertEquals("0.000456", window.evaluateExpression("0.000456"));
	}
	
	//rule: in an integer, trailing zeroes are NOT significant
	@Test
	public void testRoundingMethodSignificantFigures13() throws Exception
	{
		CalcWindow.setDecimalPrecision(6);
		CalcWindow.setRoundingMethod("S");
		assertEquals("555000", window.evaluateExpression("555000"));
	}
	
	//rule: in a decimal number, trailing zeroes ARE significant
	@Test
	public void testRoundingMethodSignificantFigures14() throws Exception
	{
		CalcWindow.setDecimalPrecision(4);
		CalcWindow.setRoundingMethod("S");
		assertEquals("5.555", window.evaluateExpression("5.555000"));
	}
	
	

}

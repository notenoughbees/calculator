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
	
	
	
	
	
	@Test
	public void testRoundingMethodSignificantFigures1() throws Exception
	{
		System.out.println("======== SF ========");
		CalcWindow.setDecimalPrecision(1);
		CalcWindow.setRoundingMethod("S");
		//System.out.println(window.evaluateExpression("10.456"));
		assertEquals("10", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures2() throws Exception
	{
		CalcWindow.setDecimalPrecision(2);
		CalcWindow.setRoundingMethod("S");
		//System.out.println(window.evaluateExpression("10.456"));
		assertEquals("10", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures3() throws Exception
	{
		CalcWindow.setDecimalPrecision(3);
		CalcWindow.setRoundingMethod("S");
		//System.out.println(window.evaluateExpression("10.456"));
		assertEquals("10.5", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures4() throws Exception
	{
		CalcWindow.setDecimalPrecision(4);
		CalcWindow.setRoundingMethod("S");
		//System.out.println(window.evaluateExpression("10.456"));
		assertEquals("10.46", window.evaluateExpression("10.456"));
	}
	
	@Test
	public void testRoundingMethodSignificantFigures5() throws Exception
	{
		CalcWindow.setDecimalPrecision(5);
		CalcWindow.setRoundingMethod("S");
		//System.out.println(window.evaluateExpression("10.456"));
		assertEquals("10.456", window.evaluateExpression("10.456"));
	}
	
	

}

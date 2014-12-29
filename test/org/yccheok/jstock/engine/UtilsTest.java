/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yccheok.jstock.engine;

import java.awt.GraphicsEnvironment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yccheok.jstock.gui.JStock;
import org.yccheok.jstock.gui.JStockOptions;

/**
 *
 * @author yccheok
 */
public class UtilsTest {// extends TestCase {

//	public UtilsTest(String testName) {
		// super(testName);
//	}

	boolean headless_check;

	// @Override
	@Before
	public void setUp() throws Exception {
		// super.setUp();
		headless_check = GraphicsEnvironment.isHeadless();
		if (headless_check) {
			// CI Servers run in headless mode where there is no keyboard or
			// monitor (eg. Swing). If in such an environment just ignore these
			// tests
			System.out.println("headless_check is true");
			Assert.assertTrue(
					"java.awt.HeadlessException will happen on the CI Server - just assert True",
					true);
//			throw new RuntimeException("Does the CI ever reach this code");
		}
		JStock.getInstance().initJStockOptions(new JStockOptions());
	}

	// @Override
	@After
	public void tearDown() throws Exception {
		// super.tearDown();
	}

	/**
	 * Test of toCompleteUnitedStatesGoogleFormat method, of class Utils.
	 */
	@Test
	public void testToCompleteUnitedStatesGoogleFormat() {
		System.out.println("toCompleteUnitedStatesGoogleFormat");

		Code code = Code.newInstance("MCD");
		String result = Utils.toCompleteUnitedStatesGoogleFormat(code);
		Assert.assertEquals("NYSE:MCD", result);

		// Test for cache.
		code = Code.newInstance("MCD");
		result = Utils.toCompleteUnitedStatesGoogleFormat(code);
		Assert.assertEquals("NYSE:MCD", result);

		code = Code.newInstance("ENVS");
		result = Utils.toCompleteUnitedStatesGoogleFormat(code);
		// Not LON:ENVS
		Assert.assertEquals("OTCMKTS:ENVS", result);

	}

	/**
	 * Test of toGoogleFormat method, of class Utils.
	 */
	@Test
	public void testToGoogleFormat() {
		System.out.println("toGoogleFormat");

		Code code = Code.newInstance("^DJI");
		String expResult = "INDEXDJX:.DJI";
		String result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^IXIC");
		expResult = "INDEXNASDAQ:.IXIC";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^BSESN");
		expResult = "INDEXBOM:SENSEX";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^NSEI");
		expResult = "NSE:NIFTY";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^NSEBANK");
		expResult = "NSE:BANKNIFTY";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^BVSP");
		expResult = "INDEXBVMF:IBOV";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^ATX");
		expResult = "INDEXVIE:ATX";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^FTSE");
		expResult = "INDEXFTSE:UKX";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^TWII");
		expResult = "TPE:TAIEX";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^NZ50");
		expResult = "NZE:NZ50G";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^OMX");
		expResult = "INDEXNASDAQ:OMXS30";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^AXJO");
		expResult = "INDEXASX:XJO";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("^AORD");
		expResult = "INDEXASX:XAO";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("USDMYR=X");
		expResult = "CURRENCY:USDMYR";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("RDS-B");
		expResult = "RDS.B";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("a.ss");
		expResult = "SHA:A";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("b.SZ");
		expResult = "SHE:B";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.sa");
		expResult = "BVMF:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.vi");
		expResult = "VIE:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.SI");
		expResult = "SGX:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.tw");
		expResult = "TPE:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.nz");
		expResult = "NZE:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.st");
		expResult = "STO:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.n");
		expResult = "NSE:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.b");
		expResult = "BOM:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("c.l");
		expResult = "LON:C";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("tatamotor.ns");
		expResult = "NSE:TATAMOTORS";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);

		code = Code.newInstance("8ih.ax");
		expResult = "ASX:8IH";
		result = Utils.toGoogleFormat(code);
		Assert.assertEquals(expResult, result);
	}
}

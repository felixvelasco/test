/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

/**
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BaseModelTest {

	private static int calledCount = 0;
	private static String firstCalled = null;
	private static String lastCalled;
	private static List<String> executionOrder = new ArrayList<>();

	@Test
	public void testLifecycleOrder() {
		BaseModel.getInstance().getModel();

		assertThat(calledCount, is(24));
		assertThat(firstCalled, is("700"));
		assertThat(lastCalled, is("200"));
	}

	@Test
	public void testLifecycleSequence() {
		BaseModel.getInstance().getModel();

		assertThat(
				executionOrder,
				contains("700", "500", "320", "319", "318", "317", "316", "315", "314", "313", "312", "311", "310",
						"309", "308", "307", "306", "305", "304", "303", "302", "301", "300", "200"));
	}

	public static abstract class Listener implements JVModelLifecycleListener {
		private String name;

		public Listener(String name) {
			this.name = name;
		}

		@Override
		public void modelCreated(BaseModel baseModel) {
			calledCount++;
			lastCalled = name;
			if (firstCalled == null) {
				firstCalled = name;
			}
			executionOrder.add(name);
		}
	}

	public static class Listener700 extends Listener {

		public Listener700() {
			super("700");
		}

	}

	public static class Listener500 extends Listener {

		public Listener500() {
			super("500");
		}

	}

	public static class Listener200 extends Listener {

		public Listener200() {
			super("200");
		}

	}

	public static class Listener300 extends Listener {

		public Listener300() {
			super("300");
		}

	}

	public static class Listener301 extends Listener {

		public Listener301() {
			super("301");
		}

	}

	public static class Listener302 extends Listener {

		public Listener302() {
			super("302");
		}

	}

	public static class Listener303 extends Listener {

		public Listener303() {
			super("303");
		}

	}

	public static class Listener304 extends Listener {

		public Listener304() {
			super("304");
		}

	}

	public static class Listener305 extends Listener {

		public Listener305() {
			super("305");
		}

	}

	public static class Listener306 extends Listener {

		public Listener306() {
			super("306");
		}

	}

	public static class Listener307 extends Listener {

		public Listener307() {
			super("307");
		}

	}

	public static class Listener308 extends Listener {

		public Listener308() {
			super("308");
		}

	}

	public static class Listener309 extends Listener {

		public Listener309() {
			super("309");
		}

	}

	public static class Listener310 extends Listener {

		public Listener310() {
			super("310");
		}

	}

	public static class Listener311 extends Listener {

		public Listener311() {
			super("311");
		}

	}

	public static class Listener312 extends Listener {

		public Listener312() {
			super("312");
		}

	}

	public static class Listener313 extends Listener {

		public Listener313() {
			super("313");
		}

	}

	public static class Listener314 extends Listener {

		public Listener314() {
			super("314");
		}

	}

	public static class Listener315 extends Listener {

		public Listener315() {
			super("315");
		}

	}

	public static class Listener316 extends Listener {

		public Listener316() {
			super("316");
		}

	}

	public static class Listener317 extends Listener {

		public Listener317() {
			super("317");
		}

	}

	public static class Listener318 extends Listener {

		public Listener318() {
			super("318");
		}

	}

	public static class Listener319 extends Listener {

		public Listener319() {
			super("319");
		}

	}

	public static class Listener320 extends Listener {

		public Listener320() {
			super("320");
		}

	}

}

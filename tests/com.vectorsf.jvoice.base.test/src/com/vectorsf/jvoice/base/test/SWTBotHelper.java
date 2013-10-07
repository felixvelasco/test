package com.vectorsf.jvoice.base.test;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.osgi.framework.Bundle;

public class SWTBotHelper {

	protected String rutaProperties = "src/main/config/properties";

	protected static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.diagram.core.test");

	private SWTBotHelper() {
	}

	public static void openView(SWTWorkbenchBot bot, String node, String view) {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode(node).select(view);
		bot.button("OK").click();

	}

	public static void openPerspective(SWTWorkbenchBot bot, String perspective) {
		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();
		bot.table().select(perspective);
		bot.button("OK").click();

	}

	public static void closeWelcomeView(SWTWorkbenchBot bot) {
		try {
			bot.viewByTitle("Welcome").close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

}
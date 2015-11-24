package project;

import launcher.Launcher;

public class Main00 {
	final static String CONTEXT = "";

	private void execute() {
		Launcher.startTomcat(CONTEXT);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.h2.Driver");
		new Main00().execute();
	}
}

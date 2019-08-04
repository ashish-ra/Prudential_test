package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cucumber.api.cli.Main;
import enums.FeatureTags;

public class MainClass {

	public static void main(String[] args) {
		
		
		String selected_tag="@"+selectOption("Select Test Cases to run:", "Test Annotation Selector", getFeatureTags());
		System.out.println("Selected tag: "+selected_tag);
				
		// this will run the feature file
		Main.main(new String[]{ 
	            "--glue","stepDefiniton/",
	            "--tags",selected_tag,
	            "-p","html:target/cucumber-reports",
	            "--monochrome",
	            "featureFiles"}
	        );
	}
	
	private static String selectOption(String msg1,String msg2,String[] arrayName) {
		//This method will create java Swing Option selector 
		
		JFrame frame = new JFrame();
		String optionSelected = (String) JOptionPane.showInputDialog(frame, 
				msg1,
				msg2,
				JOptionPane.QUESTION_MESSAGE,
				null, 
				arrayName, 
				arrayName[0]);

		return optionSelected;
	}
	
	public static String[] getFeatureTags() {
		
		// This method will return enum constants from enums.FeatureTags as a String array 
		
	    FeatureTags[] evalues = enums.FeatureTags.values();
	    String[] names = new String[evalues.length];

	    for (int i = 0; i < evalues.length; i++) {
	        names[i] = evalues[i].name();
	    }

	    return names;
	}

}

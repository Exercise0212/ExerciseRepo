package com.exercise.searchlogic;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class PluginSearchLogic {

	/**
	 *  checks whether the given keyword is present in the Passage text or not.
	 *  
	 * @param passagetext : text in which the keyword should be searched.
	 * @param word : keyword to be searched.
	 */
	public static void isWordPresesnt(String passagetext, String word){
		
		if(passagetext != null && word != null){
		boolean isWordPresent = Arrays.asList(passagetext.split(" ")).contains(word);
		
		if(isWordPresent){
			JOptionPane.showMessageDialog(null, "Word is present in the Passage.");
		}else{
			JOptionPane.showMessageDialog(null, "Word is not present in the Passage.");
		}
	  }else{
		  JOptionPane.showMessageDialog(null, "Error : Passage or  word have incorrect data.");
	  }
	}
}

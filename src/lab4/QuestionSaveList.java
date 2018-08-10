package lab4;

import java.util.ArrayList;

public class QuestionSaveList {
	String input;
	ArrayList<String> question = new ArrayList<String>();
	public void setinput(String input) {
		this.input = input;
	}
	public QuestionSaveList() {
	}
	public void Add() {
		question.add(input);
	}
	public String[] getQuestion() {
		String[] qq = new String[question.size()];
		for(int i =0;i<question.size();i++) {
			qq[i] = question.get(i);
		}
		return qq;
	}
	public boolean AvoidDuplicated() {
		for(String temp :this.getQuestion()) {
			if(temp.equals(input)) {
				return false;
			}
		}
		return true;
	}
}

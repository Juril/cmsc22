/*
* Created by Juril Digamon on 09/13/16.
*/
import java.util.*;
import java.io.*;

class Date{

	private int year;
	private int month;
	private int day;

	Date(){
		day = 1;
		month = 1;
		year = 1000;
	}

	Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int year){
		if(!(year >= 1000 && year <= 9999))
			throw new IllegalArgumentException("Imong year nga input kay wrong! Dapat 1000 to 9999 lang.");		
		this.year = year;
	}

	public void setMonth(int month){
		if(!(month >= 1 && month <= 12))
			throw new IllegalArgumentException("Imong month nga input kay wrong! Dapat 1 to 12 lang.");		
		this.month = month;
	}

	public void setDay(int day){
		boolean leap = false;
		if(year % 4 == 0 || (year % 100 == 0 && year % 400 == 0)){
			leap = true;
		}
		if(!(leap) && month == 2 && day > 28)
				throw new IllegalArgumentException("Taman ra 28 ang February kung dili pa leap year!");	
		if(!(day >= 1 && day <= 31))
			throw new IllegalArgumentException("Imong day nga input kay wrong! Dapat 1 to 31 lang.");
		if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
			throw new IllegalArgumentException("Imong month nga input kay taman ra dapat sa 30 ang day!");		
		this.day = day;
	}

	public String toString(){
		return String.format("%02d/%02d/%d",day, month, year);
	}

	public void setDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
}


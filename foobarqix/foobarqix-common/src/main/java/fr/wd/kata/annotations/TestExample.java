package fr.wd.kata.annotations;

import lombok.Data;


@Data
public class TestExample {
	@TesterInfo(
			priority = TesterInfo.Priority.HIGH, 
			createdBy = "mkyong.com",  
			tags = {"sales","test" },lastModified="14/06/2016"
		)
	 private String header;
	
	@TesterInfo(
			priority = TesterInfo.Priority.LOW, 
			createdBy = "wylson.com",  
			tags = {"banana","orage" },lastModified="24/06/2020"
		)
	 private String property;

}
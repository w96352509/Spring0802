package com.study.spring;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JsonDBTest {

	public static void main(String[] args) throws Exception{
		
       Path path =Paths.get("src/main/java/com/study/spring/case04/person.json");
       List<String> list = Files.readAllLines(path);
       //List合併 String
       String json  = list.stream().collect(Collectors.joining());
       System.out.println(json);
	}

}

package com.study.spring;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.spring.case04.Person;

public class JsonDBTest {

	public static void main(String[] args) throws Exception{
		
       Path path =Paths.get("src/main/java/com/study/spring/case04/person.json");
       List<String> list = Files.readAllLines(path); //將檔案變成列表
       
       //List合併 String 讀檔部分
       String json  = list.stream().collect(Collectors.joining()); //將列表變成字串
       System.out.println(json);
       
       
       //轉成List<Person> //寫檔 //變成集合後可以做修改
	  Gson gson = new Gson();
	  //得到Array的型態(集合性資料對Gson的處理)
	  Type type = new TypeToken<ArrayList<Person>>() {}.getType(); //字串轉乘List所需要的步驟
	  List<Person> people = gson.fromJson(json,type); //(方法 , 型別)
	  System.out.println(people);
	  
	  //新增一筆 Person 到 people集合
	  Person person = new Person();
	  person.setName(new Faker().name().firstName());
	  person.setAge(new Random().nextInt(100)+1);
	  person.setBirth(new Faker().date().birthday());
      people.add(person); //person +到 people  List
      System.out.println(people);
      
      //將 people 集合回存到 Person.json
      json = gson.toJson(people);
      Files.write(path, json.getBytes("utf-8"));
	}

}

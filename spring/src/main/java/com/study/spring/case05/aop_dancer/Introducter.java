package com.study.spring.case05.aop_dancer;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducter { // 經紀人
    //將Performance 及其子類別轉換成為Singer
	@DeclareParents(value = "com.study.spring.case05.aop_dancer.Performance+",
			defaultImpl = BackSinger.class) //+號子類別/轉成singer/可自選
	public Singer singer;
	//將Performance 及其子類別轉換成為Actor
	@DeclareParents(value = "com.study.spring.case05.aop_dancer.Performance+",
			defaultImpl = TalkActor.class) //+號子類別/轉成TalkActor/可自選
	public Actor actor;

}

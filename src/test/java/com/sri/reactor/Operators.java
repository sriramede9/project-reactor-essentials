package com.sri.reactor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

@Slf4j
public class Operators {

//	@Test
//	public void subsribeSimple() {
//
//		
//		// note that subscribe on will be applied globally even through Schedulars are added between them
//		
//		Flux<Integer> map = Flux.range(1, 4).map(i -> {
//			log.info("Map  1 - Number {} on Thread {}", i, Thread.currentThread().getName());
//			return i;
//		}).subscribeOn(Schedulers.boundedElastic())
//		.map(i ->{
//			log.info("Map  2 - Number {} on Thread {}", i, Thread.currentThread().getName());
//			return i;
//		}).log();
//	
//		map.subscribe(System.out::println);
//	
//	}
//	@Test
//	public void publishSimple() {
//		
//		
//		// note that subscribe on will be applied globally even through Schedulars are added between them
//		
//		Flux<Integer> map = Flux.range(1, 4).map(i -> {
//			log.info("Map  1 - Number {} on Thread {}", i, Thread.currentThread().getName());
//			return i;
//		}).publishOn(Schedulers.boundedElastic())
//				.map(i ->{
//					log.info("Map  2 - Number {} on Thread {}", i, Thread.currentThread().getName());
//					return i;
//				}).log();
//		
////		map.subscribe(System.out::println);
//		map.subscribe(System.out::println);
//		
//	}

//	@Test
//	public void test_File() {
//
//		Mono<List<String>> fromCallable = Mono.fromCallable(() -> Files.readAllLines(Path.of("test.txt"))).log()
//				.subscribeOn(Schedulers.boundedElastic());
//
////		fromCallable.subscribe(System.out::println);
//
//		StepVerifier.create(fromCallable).expectSubscription().thenConsumeWhile(file -> {
//			System.out.println(file.size());
//			return file.size() > 0;
//		}).verifyComplete();
//	}

//	@Test
//	public void Test_Swith_IF_Empty() {
//
//		Flux<Object> return_Empty_Flux = return_Empty_Flux();
//
//		Flux<Object> log2 = return_Empty_Flux.switchIfEmpty(Flux.just("Not empty Anymore")).log();
//		
//		StepVerifier.create(log2).expectSubscription().expectNext("Not empty Anymore").verifyComplete();
//	}
//
//	public Flux<Object> return_Empty_Flux() {
//		return Flux.empty();
//	}
	
	@Test
	public void test_Defer_Flux() {
		
		Flux<Long> defer = Flux.defer(()->Mono.just(System.currentTimeMillis()));
		
		defer.subscribe(System.out::println);
		defer.subscribe(System.out::println);
		defer.subscribe(System.out::println);
		defer.subscribe(System.out::println);
		defer.subscribe(System.out::println);
	}
}

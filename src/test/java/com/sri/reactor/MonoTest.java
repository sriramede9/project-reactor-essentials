package com.sri.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class MonoTest {

//	@Test
//	public void test() {
////		Mono<String> just = Mono.just("Sri").map(s -> {throw new RuntimeException("REx");});
//
//		Mono<String> mono = Mono.just("Sri").log().map(String::toUpperCase);
//
//		mono.subscribe(System.out::println, (s) -> {
//			System.out.println("On success");
//		});
//
////		StepVerifier.create(mono).expectErrorMessage("REx").verify();
//
//	}

//	@Test
//	public void test_error() {
//		Mono<String> just = Mono.error(new RuntimeException("alpha"));
//
//		just.log();
//		
////		just.subscribe(System.out::println, Throwable::getLocalizedMessage, () -> log.info("Completed"));
//		
//		just.subscribe((s)-> log.info(s),Throwable::getLocalizedMessage);
//
////		StepVerifier.create(mono).expectErrorMessage("REx").verify();
//
//	}
//	@Test
//	public void test_error2() {
//		Mono<String> just = Mono.just("sri").log().map(String::toUpperCase);
//		
//		
//		just.subscribe((s)-> log.info(s),Throwable::getLocalizedMessage,()->log.info("finished"),subcription-> subcription.request(5));
//		
//		
//	}
//	@Test
//	public void mono_doOnMethods() {
////		Mono<String> just = Mono.just("sri").log().map(String::toUpperCase);
//
//		Mono<String> just = Mono.just("Sri").doOnSubscribe(subscription -> log.info("subscribed"))
//				.doOnRequest((longnumber) -> log.info("Number of items requested" + longnumber))
//				.doOnNext((s)->log.info("when called on next do this"+s))
//				.doOnSuccess((s)->log.info("do on success executed"));
//
//		just.subscribe((s) -> log.info(s), Throwable::getLocalizedMessage, () -> log.info("finished"),
//				subcription -> subcription.request(5));
//
//	}
//	
	// do on error methods

//	@Test
//	public void mono_doOnErorMethods() {
//
//		Mono<Object> log2 = Mono.error(new RuntimeException("ex")).doOnError(s-> log.info("do on error called"+s.getLocalizedMessage()))
//		.log();
//		
////		log2.subscribe(s -> log.
////				info("received s {}",s));
//		
//		StepVerifier.create(log2).expectErrorMessage("ex").verify();
//	}

}

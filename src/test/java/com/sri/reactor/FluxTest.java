package com.sri.reactor;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxTest {

//	@Test
//	public void FluxJust() {
//		Flux<Integer> log = Flux.just(1, 2, 3, 4, 5, 6).log().doOnNext((s) -> System.out.println(" on every next " + s))
//				.doOnComplete(() -> System.out.println("On complete do this"));
//
//		log.subscribe(System.out::println);
//
//		StepVerifier.create(log).expectNext(1, 2, 3, 4, 5, 6).verifyComplete();
//	}
//	@Test
//	public void FluxJustMultiply() {
//		Flux<Object> log = Flux.just(1, 2, 3, 4, 5, 6).map(i -> i * 2)
//				.doOnNext((s) -> System.out.println(" on every next " + s))
//				.doOnComplete(() -> System.out.println("On complete do this"))
//				.error(new RuntimeException("Throw damn error after complete"))
//				.doOnError(s -> System.err.println("on error throw this" + s.getMessage()));
//
//		log.subscribe(System.out::println,
//				e -> System.out.println("received error message \t" + e.getLocalizedMessage()));
//
////		StepVerifier.create(log).expectNext(1, 2, 3, 4, 5, 6).verifyComplete();
//	}
//	
//	@Test
//	public void FluxWithLists() {
//		Flux<Integer> fromIterable = Flux.fromIterable(List.of(1, 2, 3, 4, 5)).log();
//
//		fromIterable.subscribe(System.out::print);
//	}

//	@Test
//	public void FluxWithError() {
//
//		Flux<Integer> map = Flux.range(1, 5).log().map(x -> {
//			if (x == 4) {
//				throw new RuntimeException("RE");
//			}
//			return x;
//		});
//
////		map.subscribe(System.out::println, x -> {
////			System.out.println("localized message" + x.getLocalizedMessage());
////		});
//
//		map.subscribe(System.out::println, Throwable::getLocalizedMessage, () -> System.out.println("On Done"),
//				subscription -> subscription.request(3));
//
//	}
//	@Test
//	public void FluxWithUglyBackPressure() {
//
//		Flux<Integer> range = Flux.range(1, 10).log();
//
//		range.subscribe(new Subscriber() {
//
//			private Subscription subscription;
//			private int count = 0;
//			private int requestcount = 2;
//			
//
//			@Override
//			public void onSubscribe(Subscription s) {
//				// TODO Auto-generated method stub
//				this.subscription = s;
//				this.subscription.request(requestcount);
//			}
//
//			@Override
//			public void onNext(Object t) {
//				// TODO Auto-generated method stub
//				count++;
//				if(count>=requestcount) {
//					count =0;
//					this.subscription.request(requestcount);
//				}
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onComplete() {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		
////		StepVerifier.create(range).expectNext(1,2,3,4,5,6,7,8,9,10).verifyComplete();
//	}
//	@Test
//	public void FluxWithNotSoUglyBackPressure() {
//
//		Flux<Integer> range = Flux.range(1, 10).log();
//
//		range.subscribe(new BaseSubscriber<Integer>() {
//		
//			private Subscription subscription;
//			private int requestcount=2;
//			private int count=0;
//			
//			protected void hookOnSubscribe(Subscription subscription){
////				subscription.request(Long.MAX_VALUE);
//				this.subscription=subscription;
//				this.subscription.request(requestcount);
//			}
//
//			/**
//			 * Hook for processing of onNext values. You can call {@link #request(long)} here
//			 * to further request data from the source {@link org.reactivestreams.Publisher} if
//			 * the {@link #hookOnSubscribe(Subscription) initial request} wasn't unbounded.
//			 * <p>Defaults to doing nothing.
//			 *
//			 * @param value the emitted value to process
//			 */
//			protected void hookOnNext(Integer value){
//				// NO-OP
////				super.hookOnNext(value);
//				count++;
//				if(count>=requestcount) {
//					count =0;
//					this.subscription.request(requestcount);
//				}
//			}
//		} );
//		
////		StepVerifier.create(range).expectNext(1,2,3,4,5,6,7,8,9,10).verifyComplete();
//	}

//	@Test
//	public void test_Flux_interval() throws InterruptedException {
//
//		Flux<Long> log = Flux
//				.interval(Duration.ofMillis(20))
//				.take(9)
//				.log();
//
//		log.subscribe(System.out::println);
//
//		Thread.sleep(300);
//	}
	@Test
	public void test_Flux_intervalWithStepVerifier() throws InterruptedException {

		Flux<Long> log = intervalFlux();

		log.subscribe(System.out::println);
		
		StepVerifier.withVirtualTime(this::intervalFlux)
		.expectSubscription()
		.thenAwait(Duration.ofDays(3))
		.expectNext(0l, 1l)
		.thenCancel()
		.verify();

//		Thread.sleep(300);
	}

	private Flux<Long> intervalFlux() {
		return Flux.interval(Duration.ofDays(1)).take(10).log();
	}

}

package com.sri.reactor;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

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
	@Test
	public void FluxWithUglyBackPressure() {

		Flux<Integer> range = Flux.range(1, 10).log();

		range.subscribe(new Subscriber() {

			private Subscription subscription;
			private int count = 0;
			private int requestcount = 2;
			

			@Override
			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.subscription = s;
				this.subscription.request(requestcount);
			}

			@Override
			public void onNext(Object t) {
				// TODO Auto-generated method stub
				count++;
				if(count>=requestcount) {
					count =0;
					this.subscription.request(requestcount);
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub

			}
		});
		
//		StepVerifier.create(range).expectNext(1,2,3,4,5,6,7,8,9,10).verifyComplete();
	}
}

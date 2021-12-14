package reactor.partone

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoDefer {

    fun successfulDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        return LocalDateTime.now()
    }

    fun monoJust(): Mono<LocalDateTime> =
        Mono.just(successfulDateFetching())


    fun monoDefer(): Mono<LocalDateTime> =
        Mono.defer { monoJust() }

    fun monoDeferSubscription() {
        val myMono = monoDefer()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoDeferInstantiation() {
        val myMono = monoDefer()
    }
}

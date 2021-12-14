package reactor.partone

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoJust {

    fun successfulDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        return LocalDateTime.now()
    }

    fun monoJust(): Mono<LocalDateTime> =
        Mono.just(successfulDateFetching())

    fun monoJustSubscription() {
        val myMono = monoJust()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoJustInstantiation() {
        val myMono = monoJust()
    }
}

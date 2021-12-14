package reactor.partone

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoCreate {

    fun successfulDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        Mono.fromCallable { }
        return LocalDateTime.now()
    }

    fun monoCreate(): Mono<LocalDateTime> =
        Mono.create { monoSink ->
            monoSink.success(successfulDateFetching())
        }

    fun monoCreateSubscription() {
        val myMono = monoCreate()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoCreateInstantiation() {
        val myMono = monoCreate()
    }
}

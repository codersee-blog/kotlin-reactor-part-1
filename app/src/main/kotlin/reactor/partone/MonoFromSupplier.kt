package reactor.partone

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoFromSupplier {

    fun successfulDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        Mono.fromCallable { }
        return LocalDateTime.now()
    }

    fun monoFromSupplier(): Mono<LocalDateTime> =
        Mono.fromSupplier { successfulDateFetching() }

    fun monoFromSupplierSubscription() {
        val myMono = monoFromSupplier()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoFromSupplierInstantiation() {
        val myMono = monoFromSupplier()
    }
}

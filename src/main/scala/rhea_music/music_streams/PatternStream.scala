package rhea_music.music_streams

import rhea_music.ImplicitConversions._
import scala_dsl.ImplicitConversions._

import java.util.concurrent.atomic.AtomicInteger

import org.jfugue.pattern.{Pattern, PatternProducer}
import org.jfugue.player.Player
import org.jfugue.realtime.RealtimePlayer
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PatternStream(val stream: Stream[PatternProducer]) {

  def setVoice(voice: Int): PatternStream =
    stream.map[PatternProducer]((p: PatternProducer) => {
      val pattern: Pattern = new Pattern
      pattern.add(p.getPattern.setVoice(voice), 1)
      pattern
    })

  def play(): Unit =
    stream.subscribe((p: PatternProducer) => {
      PatternStream.RTplayer.play(p.getPattern)
    })

  def playFinal(): Unit =
    stream.subscribe((p: PatternProducer) => {
      PatternStream.player.play(p.getPattern)
    })
}

object PatternStream {
  val player: Player = new Player
  val RTplayer: RealtimePlayer = new RealtimePlayer

  def repeatFunc[T](func: () => T): Stream[T] =
    Stream.just(func()).loop((entry: Stream[T]) => entry.map(n => func()))

  def merge(s1: PatternStream, s2: PatternStream): PatternStream =
    Stream.concat[PatternProducer](s1, s2)
      .reduce(
        (new Pattern, new AtomicInteger(0)),
        (tuple: Tuple2[Pattern, AtomicInteger], p: PatternProducer) => {
          val pattern: Pattern = tuple._1
          val counter: AtomicInteger = tuple._2
          println("Got " + counter.get())
          pattern.add(p, 1).setVoice(counter.getAndIncrement())
          (pattern, counter)
        }
      ).map[PatternProducer]((tuple: Tuple2[Pattern, _]) => tuple._1.asInstanceOf[PatternProducer]) : PatternStream


}
/*val p: Pattern = new Pattern
p.add(p1.getPattern.setVoice(0))
p.add(p2.getPattern.setVoice(1))
p*/

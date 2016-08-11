package rhea_music.music_streams

import rhea_music.ImplicitConversions._
import scala_dsl.ImplicitConversions._
import scala.languageFeature.implicitConversions._

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

  def sync(s1: PatternStream, s2: PatternStream): PatternStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer](
      s1, s2,
      (p1: PatternProducer, p2: PatternProducer) => {
        val pattern: Pattern = new Pattern()
        pattern.add(p1, p2)
        pattern
      })

  def sync3(s1: PatternStream, s2: PatternStream, s3: PatternStream): PatternStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer, PatternProducer](
      s1, s2, s3,
      (p1: PatternProducer, p2: PatternProducer, p3: PatternProducer) => {
        val pattern: Pattern = new Pattern()
        pattern.add(p1, p2, p3)
        pattern
      })
}
/*val p: Pattern = new Pattern
p.add(p1.getPattern.setVoice(0))
p.add(p2.getPattern.setVoice(1))
p*/

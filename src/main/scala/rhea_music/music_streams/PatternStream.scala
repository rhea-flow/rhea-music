package rhea_music.music_streams

import rhea_music.ImplicitConversions._
import scala_dsl.ImplicitConversions._
import scala.languageFeature.implicitConversions._

import java.io.File
import org.jfugue.midi.MidiFileManager
import org.jfugue.pattern.{Pattern, PatternProducer}
import org.jfugue.player.Player
import org.jfugue.realtime.RealtimePlayer
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PatternStream(val stream: Stream[PatternProducer]) {

  def set(setter: Pattern => Pattern) =
    stream.map[PatternProducer]((p: PatternProducer) => {
      setter(p.getPattern)
    })

  def setVoice(voice: Int): PatternStream = set(_.setVoice(voice))

  def setInstrument(instr: Int): PatternStream = set(_.setInstrument(instr))

  def setInstrument(instr: String): PatternStream = set(_.setInstrument(instr))

  def setTempo(tempo: Int): PatternStream = set(_.setTempo(tempo))

  def setTempo(tempo: String): PatternStream = set(_.setTempo(tempo))

  def play(): Unit =
    stream.subscribe((p: PatternProducer) => {
      PatternStream.RTplayer.play(p.getPattern)
    })

  def playFinal(): Unit =
    stream.subscribe((p: PatternProducer) => {
      PatternStream.player.play(p.getPattern)
    })

  def accumulate(): PatternStream =
    stream.reduce(new Pattern(): Pattern, (pat: Pattern, p: PatternProducer) => {
      pat.add(p)
      pat
    }).cast[PatternProducer](classOf[PatternProducer])

  def writeMidi(filename: String): Unit = {
    println("Writing MIDI file...")
    stream.accumulate().subscribe((p: PatternProducer) => {
      MidiFileManager.savePatternToMidi(p, new File(filename + ".midi"))
      println("Done [" + filename + ".midi" + "]")
    })
  }
}

object PatternStream {
  val player: Player = new Player
  val RTplayer: RealtimePlayer = new RealtimePlayer

  def repeatFunc[T](func: () => T): Stream[T] =
    Stream.just(func()).loop((entry: Stream[T]) => entry.map(n => func()))

  def sync(s1: PatternStream, s2: PatternStream): PatternStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer](
      s1, s2,
      (p1: PatternProducer, p2: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2))
      )

  def sync3(s1: PatternStream, s2: PatternStream, s3: PatternStream): PatternStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer, PatternProducer](
      s1, s2, s3,
      (p1: PatternProducer, p2: PatternProducer, p3: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2),
                          p3.getPattern.setVoice(3))
      )

  def sync4(s1: PatternStream, s2: PatternStream, s3: PatternStream, s4: PatternStream): PatternStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer, PatternProducer, PatternProducer](
      s1, s2, s3, s4,
      (p1: PatternProducer, p2: PatternProducer, p3: PatternProducer, p4: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2),
                          p3.getPattern.setVoice(2), p4.getPattern.setVoice(4))
      )
}

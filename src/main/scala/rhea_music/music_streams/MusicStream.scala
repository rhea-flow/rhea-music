package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.collection.JavaConverters._
import scala.languageFeature.implicitConversions._
import java.io.File

import org.jfugue.midi.MidiFileManager
import org.jfugue.pattern.{Pattern, PatternProducer}
import org.jfugue.player.Player
import org.jfugue.realtime.RealtimePlayer
import org.rhea_core.Stream
import org.rhea_core.util.functions.Func2
import rhea_music.music_types.MusicString

/**
  * @author Orestis Melkonian
  */
class MusicStream(val _stream: Stream[_ <: MusicString]) {

//  def set(setter: Pattern => Pattern) =
//    stream.map[PatternProducer]((p: PatternProducer) => {
//      setter(p.getPattern)
//    })
//
//  def setVoice(voice: Int): MusicStream = set(_.setVoice(voice))
//
//  def setInstrument(instr: Int): MusicStream = set(_.setInstrument(instr))
//
//  def setInstrument(instr: String): MusicStream = set(_.setInstrument(instr))
//
//  def setTempo(tempo: Int): MusicStream = set(_.setTempo(tempo))
//
//  def setTempo(tempo: String): MusicStream = set(_.setTempo(tempo))
//
  def ||(that: MusicStream): MusicStream =
    Stream.just(MusicString.merge(_stream.toBlocking.toList.asScala.toList))
//    Stream.just(this.extractString, that.extractString).asInstanceOf[Stream[MusicString]]

  def extractString: String =
    _stream.accumulate().toBlocking.first().repr//.drop(1)

  def accumulate(): MusicStream =
    _stream.reduce("": MusicString, (s1: MusicString, s2: MusicString) => s1 ++ s2)

  def writeMidi(filename: String): Unit = {
    println("Writing MIDI file...")
    _stream.accumulate().subscribe((p: MusicString) => {
      println(p.repr)
      MidiFileManager.savePatternToMidi(p, new File(filename + ".midi"))
      println("Done [" + filename + ".midi" + "]")
    })
  }

  def play() = _stream.subscribe((s: MusicString) => MusicStream.RTplayer.play(s))

  def playTogether() = _stream.subscribe((s: MusicString) => MusicStream.RTplayer.play(s))

  def playFinal() = _stream.subscribe((s: MusicString) => MusicStream.player.play(s))

  def print() = println(extractString)

}

object MusicStream {
  val player: Player = new Player
  val RTplayer: RealtimePlayer = new RealtimePlayer

  def repeatFunc[T](func: () => T): Stream[T] =
    Stream.just(func()).loop((entry: Stream[T]) => entry.map(n => func()))

  /*def sync(s1: MusicStream, s2: MusicStream): MusicStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer](
      s1, s2,
      (p1: PatternProducer, p2: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2))
      )

  def sync3(s1: MusicStream, s2: MusicStream, s3: MusicStream): MusicStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer, PatternProducer](
      s1, s2, s3,
      (p1: PatternProducer, p2: PatternProducer, p3: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2),
                          p3.getPattern.setVoice(3))
      )

  def sync4(s1: MusicStream, s2: MusicStream, s3: MusicStream, s4: MusicStream): MusicStream =
    Stream.zip[PatternProducer, PatternProducer, PatternProducer, PatternProducer, PatternProducer](
      s1, s2, s3, s4,
      (p1: PatternProducer, p2: PatternProducer, p3: PatternProducer, p4: PatternProducer) =>
        new Pattern().add(p1.getPattern.setVoice(1), p2.getPattern.setVoice(2),
                          p3.getPattern.setVoice(2), p4.getPattern.setVoice(4))
      )*/
}

package rhea_music.music_streams

import rhea_music.util.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.collection.JavaConverters._
import scala.languageFeature.implicitConversions._
import java.io.File

import org.jfugue.midi.MidiFileManager
import org.jfugue.pattern.Pattern
import org.jfugue.player.Player
import org.jfugue.realtime.RealtimePlayer
import org.rhea_core.Stream
import rhea_music.music_types.{MusicString, Wrapper, Voice, Instrument}
import rhea_music.util.VoiceMinter
import rhea_music.constants.Instruments._

/**
  * @author Orestis Melkonian
  */
class MusicStream(val _stream: Stream[_ <: MusicString]) {

  var context: List[Wrapper] = List() // TODO

  def set(wrapper: Wrapper) =
    context = context :+ wrapper

  def ||(that: MusicStream): MusicStream =
    Stream.concat(
      VoiceMinter.nextVoice ||> this,
      VoiceMinter.nextVoice ||> that)

  def extractString: String =
    _stream.accumulate().toBlocking.first().repr

  def accumulate(): MusicStream =
    _stream.reduce("": MusicString, (s1: MusicString, s2: MusicString) => s1 ++ s2)

  def writeMidi(filename: String): Unit = {
    println("Writing MIDI file...")
    _stream.accumulate().subscribe((p: MusicString) => {
      MidiFileManager.savePatternToMidi(p, new File(filename + ".midi"))
      println("Done [" + filename + ".midi" + "]")
    })
  }

  def play() = _stream.subscribe { s => MusicStream.RTplayer.play(s) }

  def playTogether() = _stream.subscribe((s: MusicString) => MusicStream.RTplayer.play(s))

  def playFinal() = _stream.subscribe((s: MusicString) => MusicStream.player.play(s))

  def print() = println(extractString)

}

object MusicStream {
  val player: Player = new Player
  val RTplayer: RealtimePlayer = new RealtimePlayer

  def repeatFunc[T](func: () => T): Stream[T] =
    Stream.just(func()).loop((entry: Stream[T]) => entry.map(n => func()))

  def playString(s: String) =
    RTplayer.play(new Pattern(s))

}

package rhea_music.music_types

import org.jfugue.pattern.{Pattern, PatternProducer}
import rhea_music.util.VoiceMinter

/**
  * All music types implement this, ensuring they are proper Staccato strings.
  *
  * @author Orestis Melkonian
  */
abstract class MusicString extends PatternProducer {

  // Staccato representation.
  var repr: String

  override def getPattern: Pattern = new Pattern(repr)

  def ++(that: MusicString): MusicString = {
    repr += " " + that.repr
    repr = repr.trim
    this
  }

  def ||(that: MusicString): MusicString = {
    this.repr =
      (VoiceMinter.nextVoice |> this.repr) + " " +
      (VoiceMinter.nextVoice |> that.repr)
    this
  }

  override def toString = repr
}

object MusicString {
  def merge(strings: List[MusicString]): MusicString = {
    var tmp = ""
    for (s <- strings)
      tmp += VoiceMinter.nextVoice |> s.repr
    new MusicString {
      override var repr: String = tmp
    }
  }
}

package rhea_music.music_types

import org.jfugue.pattern.{Pattern, PatternProducer}
import rhea_music.util.VoiceMinter

/**
  * All music types implement this, ensuring they are proper Staccato strings.
  *
  * @author Orestis Melkonian
  */
trait MusicString extends PatternProducer {

  // Staccato representation.
  var repr: String

  override def getPattern: Pattern = new Pattern(repr)

  def ++(that: MusicString): MusicString = {
    this.repr = this.repr + " " + that.repr
    this
  }

  def ||(that: MusicString): MusicString = {
    val v1 = VoiceMinter.nextVoice
    val v2 = VoiceMinter.nextVoice
    this.wrap(v1) ++ this.wrap(v2)
  }

  def wrap(wrapper: Wrapper[_]): MusicString =
    new MusicString {
      override var repr: String = wrapper.wrap + " " + this.repr
    }

}

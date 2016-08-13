package rhea_music.music_types

/**
  * All music types implement this, ensuring they are proper Staccato strings.
  * @author Orestis Melkonian
  */
trait MusicString {

  // Staccato representation.
  def repr: String

  def +(that: MusicString): MusicString =
    new MusicString {
      override def repr: String = this.repr + " " + that.repr
    }

}

package rhea_music.music_types

/**
  * All music types implement this, ensuring they are proper Staccato strings.
  * @author Orestis Melkonian
  */
abstract class Wrapper[T](val music: MusicString,
                          val t: T
                         ) extends MusicString {

  def wrap: T => String
  override def repr: String = wrap(t) + " " + music
}

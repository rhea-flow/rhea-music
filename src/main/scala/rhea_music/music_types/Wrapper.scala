package rhea_music.music_types

/**
  * All music types implement this, ensuring they are proper Staccato strings.
  * @author Orestis Melkonian
  */
abstract class Wrapper[T](val t: T) {
  def wrap: T => String
}

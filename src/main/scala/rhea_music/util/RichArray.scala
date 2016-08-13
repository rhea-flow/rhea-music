package rhea_music.util

/**
  * @author Orestis Melkonian
  */
class RichArray[T](val array: Array[T]) {

  def fromTo(from: T, to: T): Array[T] = {
    array.slice(array.indexOf(from), array.indexOf(to) + 1)
  }

}

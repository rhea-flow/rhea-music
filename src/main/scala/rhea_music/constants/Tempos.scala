package rhea_music.constants

/**
  * @author Orestis Melkonian
  */

object Tempos {

  // Type alias
  type TempoType = Int

  // Constants
  val grave = 40
  val largo = 45
  val larghetto = 50
  val lento = 55
  val adagio = 60
  val adagietto = 65
  val andante = 70
  val andantino = 80
  val moderato = 95
  val allegretto = 110
  val allegro = 120
  val vivace = 145
  val presto = 180
  val pretissimo = 220

  // Array collection
  def allTempoTypes: Array[TempoType] = Array(
    40, 45, 50, 55, 60, 65, 70, 80, 95, 110, 120, 145, 180, 220
  )
}

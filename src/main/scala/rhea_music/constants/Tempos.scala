package rhea_music.constants

import rhea_music.music_types.Tempo

/**
  * @author Orestis Melkonian
  */

object Tempos {

  // Constants
  val grave = new Tempo(40)
  val largo = new Tempo(45)
  val larghetto = new Tempo(50)
  val lento = new Tempo(55)
  val adagio = new Tempo(60)
  val adagietto = new Tempo(65)
  val andante = new Tempo(70)
  val andantino = new Tempo(80)
  val moderato = new Tempo(95)
  val allegretto = new Tempo(110)
  val allegro = new Tempo(120)
  val vivace = new Tempo(145)
  val presto = new Tempo(180)
  val pretissimo = new Tempo(220)

  // Array collection
  def allTempoTypes: Array[Tempo] = Array(
    grave,
    largo,
    larghetto,
    lento,
    adagio,
    adagietto,
    andante,
    andantino,
    moderato,
    allegretto,
    allegro,
    vivace,
    presto,
    pretissimo
  )
}

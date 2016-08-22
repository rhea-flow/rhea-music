package rhea_music.constants

import rhea_music.music_types.Tone
import rhea_music.constants.NoteMods._

/**
  * @author Orestis Melkonian
  */
object Tones {

  // Constants
  val C = new Tone('C')
  val Cb = new Tone('C', b)
  val Cs = new Tone('C', s)
  val D = new Tone('D')
	val Db = new Tone('D', b)
	val Ds = new Tone('D', s)
  val E = new Tone('E')
	val Eb = new Tone('E',  b)
  val Es = new Tone('E',  s)
  val F = new Tone('F')
  val Fb = new Tone('F', b)
	val Fs = new Tone('F', s)
  val G = new Tone('G')
	val Gb = new Tone('G', b)
	val Gs = new Tone('G', s)
  val A = new Tone('A')
	val Ab = new Tone('A', b)
	val As = new Tone('A', s)
  val B = new Tone('B')
	val Bb = new Tone('B', b)
  val Bs = new Tone('B', s)

//  val REST = new Tone('R')

  // Array collection
  def allTonesSharp: Array[Tone] = Array(
    C, Cs,
    D, Ds,
    E,
    F, Fs,
    G, Gs,
    A, As,
    B
  )

  def allTonesFlat: Array[Tone] = Array(
    C,
    Db, D,
    Eb, E,
    F,
    Gb, G,
    Ab, A,
    Bb, B
  )
}

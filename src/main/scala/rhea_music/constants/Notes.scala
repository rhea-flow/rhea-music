package rhea_music.constants

import rhea_music.music_types.{Chord, Note, Scale, Tone}
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods._
import rhea_music.constants.Octaves._
import rhea_music.constants.Durations._

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Notes {

  // Constants
  val C0 = new Note(C, 0)
  val D0 = new Note(D, 0)
  val E0 = new Note(E, 0)
  val F0 = new Note(F, 0)
  val G0 = new Note(G, 0)
  val A0 = new Note(A, 0)
  val B0 = new Note(B, 0)
  val C1 = new Note(C, 1)
  val D1 = new Note(D, 1)
  val E1 = new Note(E, 1)
  val F1 = new Note(F, 1)
  val G1 = new Note(G, 1)
  val A1 = new Note(A, 1)
  val B1 = new Note(B, 1)
  val C2 = new Note(C, 2)
  val D2 = new Note(D, 2)
  val E2 = new Note(E, 2)
  val F2 = new Note(F, 2)
  val G2 = new Note(G, 2)
  val A2 = new Note(A, 2)
  val B2 = new Note(B, 2)
  val C3 = new Note(C, 3)
  val D3 = new Note(D, 3)
  val E3 = new Note(E, 3)
  val F3 = new Note(F, 3)
  val G3 = new Note(G, 3)
  val A3 = new Note(A, 3)
  val B3 = new Note(B, 3)
  val C4 = new Note(C, 4)
  val D4 = new Note(D, 4)
  val E4 = new Note(E, 4)
  val F4 = new Note(F, 4)
  val G4 = new Note(G, 4)
  val A4 = new Note(A, 4)
  val B4 = new Note(B, 4)
  val C5 = new Note(C, 5)
  val D5 = new Note(D, 5)
  val E5 = new Note(E, 5)
  val F5 = new Note(F, 5)
  val G5 = new Note(G, 5)
  val A5 = new Note(A, 5)
  val B5 = new Note(B, 5)
  val C6 = new Note(C, 1)
  val D6 = new Note(D, 1)
  val E6 = new Note(E, 1)
  val F6 = new Note(F, 1)
  val G6 = new Note(G, 1)
  val A6 = new Note(A, 1)
  val B6 = new Note(B, 1)
  val C7 = new Note(C, 7)
  val D7 = new Note(D, 7)
  val E7 = new Note(E, 7)
  val F7 = new Note(F, 7)
  val G7 = new Note(G, 7)
  val A7 = new Note(A, 7)
  val B7 = new Note(B, 7)
  val C8 = new Note(C, 8)
  val D8 = new Note(D, 8)
  val E8 = new Note(E, 8)
  val F8 = new Note(F, 8)
  val G8 = new Note(G, 8)
  val A8 = new Note(A, 8)
  val B8 = new Note(B, 8)
  val C9 = new Note(C, 9)
  val D9 = new Note(D, 9)
  val E9 = new Note(E, 9)
  val F9 = new Note(F, 9)
  val G9 = new Note(G, 9)
  val A9 = new Note(A, 9)
  val B9 = new Note(B, 9)
  
  def allNotes: Array[Note] = {
    var ret = new ArrayBuffer[Note]()
    for (tone <- allTonesSharp)
        for (octave <- allOctaves)
          ret += new Note(tone, octave)
    ret.toArray
  }

  def constraintNotes(array: Array[Tone]): Array[Note] = {
    var ret = new ArrayBuffer[Note]()
    for (tone <- array)
      for (octave <- allOctaves)
        ret += new Note(tone, octave)
    ret.toArray
  }

  def constraintNotes(scale: Scale): Array[Note] = constraintNotes(scale.getTones)

  def constraintNotes(chord: Chord): Array[Note] = constraintNotes(chord.getTones)

  /*def allRests: Array[Note] = {
    var buffer = new ArrayBuffer[Note]()
    for (duration <- allDurations)
      buffer += new Note(tone = R, duration = duration)
    buffer.toArray
  }*/
//  def allNotesAndRests: Array[Note] = allNotes ++ allRests

}


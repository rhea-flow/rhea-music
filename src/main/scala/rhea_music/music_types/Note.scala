package rhea_music.music_types

import rhea_music.util.ImplicitConversions._

import rhea_music.constants.Durations._
import rhea_music.constants.Octaves._
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods._
import rhea_music.music_streams.MusicStream
import rhea_music.util.Random.randNote

/**
  * @author Orestis Melkonian
  */
class Note(var root: Tone = C,
           var octave: Octave = noOctave,
           var duration: Duration = noDuration
          ) extends MusicString with Cloneable {

  override var repr: String = root + (if (octave == noOctave) "" else octave) + duration

  def clean: Note = {
    octave = noOctave
    duration = noDuration
    if (root.mod == n)
      root.mod = noNoteMod
    this
  }

  def clone(root: Tone = root, octave: Octave = octave, duration: Duration = duration): Note =
    new Note(root, octave, duration)

  override def equals(o: Any) = o match {
    case that: Note =>
      (root == that.root) &&
      (octave == that.octave) &&
      (duration == that.duration)
    case _ => false
  }

  override def toString = repr
}

object Note {
  def randNotes: MusicStream = MusicStream.repeatFunc(randNote)
}

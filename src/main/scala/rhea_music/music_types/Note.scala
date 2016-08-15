package rhea_music.music_types

import rhea_music.ImplicitConversions._

import rhea_music.constants.Durations._
import rhea_music.constants.Octaves._
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods._
import rhea_music.music_streams.MusicStream
import rhea_music.util.Random.randNote

/**
  * @author Orestis Melkonian
  */
class Note(var tone: Tone = C,
           var octave: Octave = noOctave,
           var duration: Duration = quarter
          ) extends MusicString {

  override def repr: String = tone + (if (octave == noOctave) "" else octave) + duration

  def clean: Note = {
    octave = noOctave
    duration = noDuration
    if (tone.mod == n)
      tone.mod = noNoteMod
    this
  }

}

object Note {
  def randNotes: MusicStream = MusicStream.repeatFunc(randNote)
}

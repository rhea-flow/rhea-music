package rhea_music.constants

import rhea_music.music_types.Instrument

/**
  * @author Orestis Melkonian
  */
object Instruments {

  // Constants
  val PIANO = new Instrument(0)
  val BRIGHT_ACOUSTIC = new Instrument(1)
  val ELECTRIC_GRAND = new Instrument(2)
  val HONKEY_TONK = new Instrument(3)
  val ELECTRIC_PIANO = new Instrument(4)
  val ELECTRIC_PIANO_2 = new Instrument(5)
  val HARPSICHORD = new Instrument(6)
  val CLAVINET = new Instrument(7)
  val CELESTA = new Instrument(8)
  val GLOCKENSPIEL = new Instrument(9)

  val MUSIC_BOX = new Instrument(10)
  val VIBRAPHONE = new Instrument(11)
  val MARIMBA = new Instrument(12)
  val XYLOPHONE = new Instrument(13)
  val TUBULAR_BELLS = new Instrument(14)
  val DULCIMER = new Instrument(15)
  val DRAWBAR_ORGAN = new Instrument(16)
  val PERCUSSIVE_ORGAN = new Instrument(17)
  val ROCK_ORGAN = new Instrument(18)
  val CHURCH_ORGAN = new Instrument(19)

  val REED_ORGAN = new Instrument(20)
  val ACCORDIAN = new Instrument(21)
  val HARMONICA = new Instrument(22)
  val TANGO_ACCORDIAN = new Instrument(23)
  val GUITAR = new Instrument(24)
  val STEEL_STRING_GUITAR = new Instrument(25)
  val ELECTRIC_JAZZ_GUITAR = new Instrument(26)
  val ELECTRIC_CLEAN_GUITAR = new Instrument(27)
  val ELECTRIC_MUTED_GUITAR = new Instrument(28)
  val OVERDRIVEN_GUITAR = new Instrument(29)

  val DISTORTION_GUITAR = new Instrument(30)
  val GUITAR_HARMONICS = new Instrument(31)
  val ACOUSTIC_BASS = new Instrument(32)
  val ELECTRIC_BASS_FINGER = new Instrument(33)
  val ELECTRIC_BASS_PICK = new Instrument(34)
  val FRETLESS_BASS = new Instrument(35)
  val SLAP_BASS_1 = new Instrument(36)
  val SLAP_BASS_2 = new Instrument(37)
  val SYNTH_BASS_1 = new Instrument(38)
  val SYNTH_BASS_2 = new Instrument(39)

  val VIOLIN = new Instrument(40)
  val VIOLA = new Instrument(41)
  val CELLO = new Instrument(42)
  val CONTRABASS = new Instrument(43)
  val TREMOLO_STRINGS = new Instrument(44)
  val PIZZICATO_STRINGS = new Instrument(45)
  val ORCHESTRAL_STRINGS = new Instrument(46)
  val TIMPANI = new Instrument(47)
  val STRING_ENSEMBLE_1 = new Instrument(48)
  val STRING_ENSEMBLE_2 = new Instrument(49)

  val SYNTH_STRINGS_1 = new Instrument(50)
  val SYNTH_STRINGS_2 = new Instrument(51)
  val CHOIR_AAHS = new Instrument(52)
  val VOICE_OOHS = new Instrument(53)
  val SYNTH_VOICE = new Instrument(54)
  val ORCHESTRA_HIT = new Instrument(55)
  val TRUMPET = new Instrument(56)
  val TROMBONE = new Instrument(57)
  val TUBA = new Instrument(58)
  val MUTED_TRUMPET = new Instrument(59)

  val FRENCH_HORN = new Instrument(60)
  val BRASS_SECTION = new Instrument(61)
  val SYNTH_BRASS_1 = new Instrument(62)
  val SYNTH_BRASS_2 = new Instrument(63)
  val SOPRANO_SAX = new Instrument(64)
  val ALTO_SAX = new Instrument(65)
  val TENOR_SAX = new Instrument(66)
  val BARITONE_SAX = new Instrument(67)
  val OBOE = new Instrument(68)
  val ENGLISH_HORN = new Instrument(69)

  val BASSOON = new Instrument(70)
  val CLARINET = new Instrument(71)
  val PICCOLO = new Instrument(72)
  val FLUTE = new Instrument(73)
  val RECORDER = new Instrument(74)
  val PAN_FLUTE = new Instrument(75)
  val BLOWN_BOTTLE = new Instrument(76)
  val SKAKUHACHI = new Instrument(77)
  val WHISTLE = new Instrument(78)
  val OCARINA = new Instrument(79)

  val SQUARE = new Instrument(80)
  val SAWTOOTH = new Instrument(81)
  val CALLIOPE = new Instrument(82)
  val CHIFF = new Instrument(83)
  val CHARANG = new Instrument(84)
  val VOICE = new Instrument(85)
  val FIFTHS = new Instrument(86)
  val BASS_LEAD = new Instrument(87)
  val NEW_AGE = new Instrument(88)
  val WARM = new Instrument(89)

  val POLY_SYNTH = new Instrument(90)
  val CHOIR = new Instrument(91)
  val BOWED = new Instrument(92)
  val METALLIC = new Instrument(93)
  val HALO = new Instrument(94)
  val SWEEP = new Instrument(95)
  val RAIN = new Instrument(96)
  val SOUNDTRACK = new Instrument(97)
  val CRYSTAL = new Instrument(98)
  val ATMOSPHERE = new Instrument(99)

  val BRIGHTNESS = new Instrument(100)
  val GOBLINS = new Instrument(101)
  val ECHOES = new Instrument(102)
  val SCI_FI = new Instrument(103)
  val SITAR = new Instrument(104)
  val BANJO = new Instrument(105)
  val SHAMISEN = new Instrument(106)
  val KOTO = new Instrument(107)
  val KALIMBA = new Instrument(108)
  val BAGPIPE = new Instrument(109)

  val FIDDLE = new Instrument(110)
  val SHANAI = new Instrument(111)
  val TINKLE_BELL = new Instrument(112)
  val AGOGO = new Instrument(113)
  val STEEL_DRUMS = new Instrument(114)
  val WOODBLOCK = new Instrument(115)
  val TAIKO_DRUM = new Instrument(116)
  val MELODIC_TOM = new Instrument(117)
  val SYNTH_DRUM = new Instrument(118)
  val REVERSE_CYMBAL = new Instrument(119)

  val GUITAR_FRET_NOISE = new Instrument(120)
  val BREATH_NOISE = new Instrument(121)
  val SEASHORE = new Instrument(122)
  val BIRD_TWEET = new Instrument(123)
  val TELEPHONE_RING = new Instrument(124)
  val HELICOPTER = new Instrument(125)
  val APPLAUSE = new Instrument(126)
  val GUNSHOT = new Instrument(127)


  def allInstruments: Array[Instrument] = Array(
    PIANO,
    BRIGHT_ACOUSTIC,
    ELECTRIC_GRAND,
    HONKEY_TONK,
    ELECTRIC_PIANO,
    ELECTRIC_PIANO_2,
    HARPSICHORD,
    CLAVINET,
    CELESTA,
    GLOCKENSPIEL,
  
    MUSIC_BOX,
    VIBRAPHONE,
    MARIMBA,
    XYLOPHONE,
    TUBULAR_BELLS,
    DULCIMER,
    DRAWBAR_ORGAN,
    PERCUSSIVE_ORGAN,
    ROCK_ORGAN,
    CHURCH_ORGAN,
  
    REED_ORGAN,
    ACCORDIAN,
    HARMONICA,
    TANGO_ACCORDIAN,
    GUITAR,
    STEEL_STRING_GUITAR,
    ELECTRIC_JAZZ_GUITAR,
    ELECTRIC_CLEAN_GUITAR,
    ELECTRIC_MUTED_GUITAR,
    OVERDRIVEN_GUITAR,
  
    DISTORTION_GUITAR,
    GUITAR_HARMONICS,
    ACOUSTIC_BASS,
    ELECTRIC_BASS_FINGER,
    ELECTRIC_BASS_PICK,
    FRETLESS_BASS,
    SLAP_BASS_1,
    SLAP_BASS_2,
    SYNTH_BASS_1,
    SYNTH_BASS_2,
  
    VIOLIN,
    VIOLA,
    CELLO,
    CONTRABASS,
    TREMOLO_STRINGS,
    PIZZICATO_STRINGS,
    ORCHESTRAL_STRINGS,
    TIMPANI,
    STRING_ENSEMBLE_1,
    STRING_ENSEMBLE_2,
  
    SYNTH_STRINGS_1,
    SYNTH_STRINGS_2,
    CHOIR_AAHS,
    VOICE_OOHS,
    SYNTH_VOICE,
    ORCHESTRA_HIT,
    TRUMPET,
    TROMBONE,
    TUBA,
    MUTED_TRUMPET,
  
    FRENCH_HORN,
    BRASS_SECTION,
    SYNTH_BRASS_1,
    SYNTH_BRASS_2,
    SOPRANO_SAX,
    ALTO_SAX,
    TENOR_SAX,
    BARITONE_SAX,
    OBOE,
    ENGLISH_HORN,
  
    BASSOON,
    CLARINET,
    PICCOLO,
    FLUTE,
    RECORDER,
    PAN_FLUTE,
    BLOWN_BOTTLE,
    SKAKUHACHI,
    WHISTLE,
    OCARINA,
  
    SQUARE,
    SAWTOOTH,
    CALLIOPE,
    CHIFF,
    CHARANG,
    VOICE,
    FIFTHS,
    BASS_LEAD,
    NEW_AGE,
    WARM,
  
    POLY_SYNTH,
    CHOIR,
    BOWED,
    METALLIC,
    HALO,
    SWEEP,
    RAIN,
    SOUNDTRACK,
    CRYSTAL,
    ATMOSPHERE,
  
    BRIGHTNESS,
    GOBLINS,
    ECHOES,
    SCI_FI,
    SITAR,
    BANJO,
    SHAMISEN,
    KOTO,
    KALIMBA,
    BAGPIPE,
  
    FIDDLE,
    SHANAI,
    TINKLE_BELL,
    AGOGO,
    STEEL_DRUMS,
    WOODBLOCK,
    TAIKO_DRUM,
    MELODIC_TOM,
    SYNTH_DRUM,
    REVERSE_CYMBAL,
  
    GUITAR_FRET_NOISE,
    BREATH_NOISE,
    SEASHORE,
    BIRD_TWEET,
    TELEPHONE_RING,
    HELICOPTER,
    APPLAUSE,
    GUNSHOT
  )
}

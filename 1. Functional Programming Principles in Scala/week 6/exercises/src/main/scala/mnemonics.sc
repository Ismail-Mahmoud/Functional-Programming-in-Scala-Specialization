import scala.io.Source

//val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
//val in = Source.fromURL("https://gist.githubusercontent.com/wchargin/8927565/raw/d9783627c731268fb2935a731a618aa8e95cf465/words")
//val in = Source.fromURL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt")
//val words = in.getLines().toList.filter(word => word.forall(ch => ch.isLetter))
val words = List("Scala", "fun", "lksdhv", "is", "sack", "ar", "air", "ah", "re", "to", "pack", "rack")
words.length

val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char, Char] = mnem.flatMap{case (dig, str) => str.map(_ -> dig)}

def wordCode(word: String): String = word.toUpperCase.map(charCode)

val wordsOfNumber: Map[String, Seq[String]] = words.groupBy(wordCode).withDefaultValue(Seq())

type Sentence = List[String]
def encode(number: String): Set[Sentence] = {
  if(number.isEmpty) Set(List())
  else {
    for {
      first <- 1 to number.length
      word <- wordsOfNumber(number.take(first))
      rem <- encode(number.drop(first))
    } yield word :: rem
  }.toSet
}

def translate(number: String): String = (encode(number).map(_.mkString(" ")).mkString("\n"))

translate("7225247386")
val age: Map[String, Int] = Map("ali" -> 10, ("ahmed", 22), "samir" -> 19)
age + ("ziad" -> 13)

age("ali")
age.get("ali")
//age("karam")  //Error
age.get("karam")

def getAge(name: String) = age.get(name) match {
  case None => "NOT FOUND"
  case Some(x) => x
}
getAge("ali")
getAge("karam")

val age2 = age.withDefaultValue("NOT FOUND")
age2("ali")
age2("karam")

val a = Map(3 -> 4, 5 -> 6)
val b = Map(3 -> 7)
a ++ b    // 7 overrides 4 for key 3
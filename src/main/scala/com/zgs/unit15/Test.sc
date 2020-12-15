//Option类型
val capitals = Map("France"->"Paris","Japan"->"Tokyo")
capitals get "France"
capitals get "North Pole"

def show(x:Option[String]) = x match {
  case Some(s) => s
  case None => "na"
}
show(capitals get "Japan")





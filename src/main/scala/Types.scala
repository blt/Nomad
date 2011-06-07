package us.troutwine.nomad

package object types {
  sealed trait NomadType
  case class Database(driver:String, url:String,
                      user:String, password:String) extends NomadType
}

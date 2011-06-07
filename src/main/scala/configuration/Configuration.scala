package us.troutwine.nomad

import org.apache.commons.configuration.XMLConfiguration
import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.commons.configuration.{ConfigurationUtils => CU}
import org.apache.commons.configuration.{HierarchicalConfiguration => HC}
import scala.collection.JavaConversions._
import java.util.ArrayList

package object configuration {
  private val dbconf = new PropertiesConfiguration(CU.locate("nomad.conf"))

  /*
   * Return the parsed contents of the resource nomad.conf.
   */
  def db: types.Database = types.Database(
    dbconf.getString("driver"),
    dbconf.getString("url"),
    dbconf.getString("user"),
    dbconf.getString("password")
  )
}

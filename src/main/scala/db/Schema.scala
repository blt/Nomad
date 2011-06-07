package us.troutwine.nomad.db
import us.troutwine.nomad.types.Database
import us.troutwine.nomad.configuration

import java.util.Properties

package object schema {
  import com.googlecode.flyway.core.Flyway

  private val props:Properties = {
    var p:Properties = new Properties()
    configuration.db match {
      case Database(driver, url, user, password) => {
        p.setProperty("flyway.driver", driver)
        p.setProperty("flyway.url", url)
        p.setProperty("flyway.user", user)
        p.setProperty("flyway.password", password)
      }
    }
    p
  }
  private val flyway:Flyway = {
    var f:Flyway = new Flyway()
    f.configure(props)
    f
  }

  /*
   * Prepare the database configured from nomad.conf for schema migrations.
   */
  def init = flyway.init

  /*
   * Run a migration for the database configured from nomad.conf. Create,
   * delete and modify that which comes from the SQL files in
   * resources/db/migration/.
   *
   * Each migration SQL file must be named V{version_num}__{name}.sql,
   * where {version_num} and {name} are free-form strings. Please note the
   * _two_ underscores. Very important, that.
   */
  def migrate = flyway.migrate

  /*
   * Destroy the schema of the database configured from nomad.conf.
   */
  def clean = flyway.clean
}

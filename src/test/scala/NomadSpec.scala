package us.troutwine.nomad.spec
import us.troutwine.nomad.db.schema

import org.scalatest.Spec

class NomadSpec extends Spec {
  describe("Schema") {
    it("should initialize, migrate and clean with no error") {
      schema.init
      schema.migrate
      schema.clean
    }
  }
}

Nomad -- A database schema migration library for Scala.
=======================================================

Dealing with database migrations in Scala stinks. The tools available are
either strangely Java, external applications or entirely tied to a single
application oweing to the fomulation of your tables in SQL combinators.

Yuck: too foreign, no help when testing or too magical.

Nomad is a dead simple wrapper around Flyway. You can do these things:

   * Prepare a database for schema migrations,
   * migrate tables/indexes/constraints etc and
   * delete everything.

It's all plain SQL and a little bit of configuration--absolutely dull in the
best possible way.

Installation
------------

Kindly include this in your project definition:

```
resolvers += "troutwine.us repository" at "http://maven.troutwine.us/"
libraryDependencies += "us.troutwine" %% "Nomad" % '0.1.0"
```

Usage
-----

Have a look at the source and resources included in `src/test/`. You must have
a file named `nomad.conf` somewhere on the resource path at runtime. There
must also be SQL files in `resources/db/migrations` named
`V{version_num}__{name}.sql` where "{version_num}" and "{name}" are free-form
strings.

A complete example of Nomad's use is contained in
`src/test/scala/NomadSpec.scala`, reproduced below:


```
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
```

That's it!

Acknowledgments
===============

This project has been an outgrowth of my work with the kind folks at
[FluentStream Technologies](http://www.fluentstream.com/).

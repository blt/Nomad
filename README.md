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

Acknowledgments
===============

This project has been an outgrowth of my work with the kind folks at
[FluentStream Technologies](http://www.fluentstream.com/).

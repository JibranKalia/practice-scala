case class DatabaseConfig(timeout: Option[Int])
case class ServerConfig(databaseConfig: Option[DatabaseConfig])

object GroupedSequence {
  def main(args: Array[String]): Unit = {
    val someNumbersGrouped = Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6))

    val doubled = someNumbersGrouped.map(group => {
      group.map(number => number * 2)
    })
    println(doubled)
    val doubledFlat = someNumbersGrouped.flatMap { group =>
      group.map(number => number * 2)
    }

    println(doubledFlat)

    val maybeNumber = Some(1)
    val maybeDoubled = maybeNumber.map(n => n * 2)
    println(maybeDoubled)

    val notNumber: Option[Int] = None
    val noneDoubled = notNumber.map(n => n * 2)
    println(noneDoubled)

    val maybeServerConfig: Option[ServerConfig] = Some(ServerConfig(Some(DatabaseConfig(Some(30)))))
    // Double timeout safely

    val maybedDoubledTimeout = maybeServerConfig.flatMap { serverConfig =>
      serverConfig.databaseConfig.flatMap { dbConfig =>
        dbConfig.timeout.map(n => n * 2)
      }
    }

    println(maybedDoubledTimeout)

    val noneServerConfig: Option[ServerConfig] = Some(ServerConfig(Some(DatabaseConfig(None))))

    val noneDoubled2 = noneServerConfig.flatMap { serverConfig =>
      serverConfig.databaseConfig.flatMap { dbConfig =>
        dbConfig.timeout.map(n => n * 2)
      }
    }

    println(noneDoubled2)

  }
}

lazy val problem1 = (project in file("problem1"))
  .settings(
    name := "Problem1",
    Compile / mainClass := Some("com.tst.homeTests.Problem1")
  )

lazy val problem2 = (project in file("problem2"))
  .settings(
    name := "Problem2",
    Compile / mainClass := Some("com.tst.homeTests.Problem2")
  )

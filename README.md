# Next Drop — RuneLite plugin

Shows the chance your target unique hits **on the next kill**, plus dry-streak math.

OSRS loot is RNG. Nobody can tell you the actual next drop. This plugin tells you the honest numbers:

- chance on the **next kill**
- chance within the next N kills (default 50)
- kills until 50% / 90% chance from here
- how dry you already are vs the wiki rate

Geometric rolls are **memoryless**. Being 800 dry on a 1/200 does not make kill 801 more likely than kill 1. Expected remaining kills is still the rate.

## Run it

Needs JDK 11+ and IntelliJ.

1. Clone this repo and open it as a Gradle project.
2. Copy the `gradle/` wrapper from https://github.com/runelite/example-plugin if wrapper JARs are missing.
3. Run the `run` Gradle task (developer-mode RuneLite with this plugin loaded).
4. Plugin config → Next Drop → pick a preset and set KC.

In-game command: `!nextdrop`

## License

BSD 2-Clause.

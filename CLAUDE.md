# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

**Geo Brain** — single-Activity Android app (Kotlin + Jetpack Compose) for learning world geography and taking themed tests. Package: `com.bigcool.puzzle.merge.c`.

## Build / Run

Gradle with Kotlin DSL. AGP 9.0.1, Kotlin 2.0.21, compileSdk 36 (minor 1), minSdk 28, Java 11.

```bash
./gradlew assembleDebug           # build debug APK
./gradlew installDebug            # install on connected device/emulator
./gradlew lint                    # Android lint
./gradlew test                    # unit tests (JVM)
./gradlew connectedAndroidTest    # instrumentation tests (needs device)
./gradlew :app:testDebugUnitTest --tests "ClassName.methodName"   # single test
```

There is no wrapper-less build path — always use `./gradlew`. `local.properties` pins the SDK path and is not checked in.

## Architecture

All UI runs inside a single `MainActivity` locked to portrait (set in `AndroidManifest.xml` via `screenOrientation="portrait"` + `configChanges`). No Fragments, no secondary Activities — navigation is in-Compose.

### Layer layout (under `app/src/main/java/com/bigcool/puzzle/merge/c/`)

- `ui/theme/` — `Color.kt` (dark-blue palette), `Type.kt` (binds `res/font/font.ttf` to `AppFont` and fills the whole `Typography`), `Theme.kt` (`GeoBrainTheme` — forced dark scheme, transparent system bars). **All text must flow through `Typography` or `AppFont`** so the project font is used app-wide.
- `data/` — plain Kotlin data classes + two in-memory `object` data sources (`CountriesData`, `TestsData`) and `PrefsManager` (SharedPreferences, file `geo_brain_prefs`). There is no DB, no network, no DI framework.
- `ui/components/` — shared Compose widgets (gradient top bar, stat cards, buttons, test question card, timer, etc.).
- `ui/screens/` — one file per screen: Loading, Main (bottom nav host), Learn, CountryDetail, Tests, TestTaking, Result, Statistics.
- Navigation is a hand-rolled stack of a `sealed class Screen` held in `rememberSaveable` state inside `MainActivity` / a top-level nav composable — **not** `androidx.navigation.compose`. When adding a screen, add a `Screen` subtype and a branch in the navigator, not a NavGraph.

### Data model conventions

- `CountriesData.continents` is the source of truth for the Learn tab. Each continent has ≤10 countries; Antarctica is a special entry (`isSpecial = true`, `specialInfo` string, empty `countries`) and must be rendered as an educational card, not a country list.
- **Excluded from all content**: Russia, Iran, North Korea. Do not add them to countries, neighbors lists, or test questions/options.
- `TestsData.tests` contains exactly 20 `GeoTest` entries with stable integer `id`s (1..20). `PrefsManager` keys are built from those ids (`test_<id>_best`, `_last`, `_attempts`, `_completions`, `_total_score`, `_total_q`) — **never renumber existing tests** or user stats will be lost / mis-attributed. Append new tests with fresh ids.
- `PrefsManager.recordAttempt(testId, score, totalQuestions, completed)` is the only write path. `completed = false` means the timer expired; completions counter only advances when `completed = true`. Averages are computed from running `total_score / attempts`.

### Test-taking flow

`TestTakingScreen` owns a 5-minute countdown (`LaunchedEffect` + `delay`). When time hits 0 it calls `recordAttempt(..., completed = false)` and navigates to `ResultScreen` with `timeExpired = true`. Normal finish passes `completed = true`. The result screen is the only place that shows retry / back buttons — don't duplicate that logic elsewhere.

## Conventions

- English-only copy. No localization resources beyond `values/`.
- Dark navy palette only — do not introduce light-theme variants or `dynamicColor`. `GeoBrainTheme` is intentionally dark-only.
- Prefer adding to existing files in `data/` and `ui/screens/` over creating new packages; the flat structure is deliberate.
- Material Icons Extended is available (`androidx.compose.material:material-icons-extended`) — use it for geography-flavored iconography instead of bundling drawables.

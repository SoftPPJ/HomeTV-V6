# My Home TV V6

The V6 Android TV IPTV player source repository. This project is maintained separately from the new HomeTV Next V1 application.

## Repository and branch

- Repository: [SoftPPJ/HomeTV-V6](https://github.com/SoftPPJ/HomeTV-V6)
- Active development branch: `my-home-tv-v6-development`
- Default branch: `main` (kept separate from the development branch for now)
- Android application ID: `com.softppj.myhometv.v6`
- Version name configured in the development source: `6.0.0-dev`
- Debug APK filename configured by the project: `HomeTV-V6.apk`

## Current playback architecture

The inspected Gradle configuration includes:

- AndroidX Media3 1.5.1 playback components, including HLS, DASH, RTSP and SmoothStreaming modules.
- LibVLC 3.5.1 for supported fallback/protocol handling.
- Jellyfin Media3 FFmpeg decoder extension for supported software audio decoding.

The FFmpeg decoder is a Media3 decoder extension, not a separate third playback engine. IJKPlayer is not currently included in the inspected V6 Gradle dependencies. Do not describe it as an active engine or add it without a separate compatibility, licensing and device-test review.

## Development scope

The V6 implementation and stabilization checklists cover:

- Cinematic Android TV home experience and remote navigation.
- IPTV playback, engine routing, reconnect behaviour and preservation of confirmed URL/engine choices.
- Playlist caching, large-list performance, numbering and playlist lifecycle.
- EPG, reminders, viewer profiles, favourites and playback history.
- Picture/audio/subtitle settings and per-channel preferences.
- YouTube and WebView playback behaviour.
- Diagnostics, backup/restore and licence handling.

Checklist entries are not considered complete merely because related source code exists. Refer to the project checklists for the exact pending verification gates.

## Build ownership

This repository is for V6 source development and checks. Its current `.github/workflows/android.yml` workflow is source-only and does not build or publish an APK.

APK compilation and release work is handled separately in [ppj1981/HomeTV-Build](https://github.com/ppj1981/HomeTV-Build). Do not create a release or prerelease from this repository unless the project owner explicitly approves a change to that policy.

## Current verification status

- The `my-home-tv-v6-development` branch was imported from `SoftPPJ/HomeTV` with its commit history preserved.
- The implementation and stabilization documents explicitly identify outstanding compile, regression, licensing and Android TV device-test gates.
- Large-playlist stability, playback protocol coverage, remote behaviour, licence activation/offline behaviour and long-playback reliability require verification on the target TV.
- Never mark a device test passed without observed results.

## Release and backup policy

Do not publish a production APK, prerelease or release without explicit approval. Keep the original private `SoftPPJ/HomeTV` repository unchanged as a backup until the new repositories have been fully reviewed.

## Related project

- [HomeTV Next V1](https://github.com/SoftPPJ/HomeTV-Next)
- [HomeTV APK build repository](https://github.com/ppj1981/HomeTV-Build)

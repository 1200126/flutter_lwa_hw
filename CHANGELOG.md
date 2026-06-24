## 2.2.1

* Fixed iOS podspec naming issue - renamed `flutter_lwa.podspec` to `flutter_lwa_hw.podspec`
* Updated podspec content with correct package name and version
* Updated podspec author and homepage to match new repository
* Updated minimum iOS version to 11.0

## 2.2.0

* **BREAKING**: Package renamed to `flutter_lwa_hw` to avoid conflict with original package
* **BREAKING**: Removed deprecated `PluginRegistry.Registrar` API (Flutter v1 plugin API)
* Updated to Flutter 3.7.2+ compatibility with modern v2 plugin API
* Improved plugin lifecycle management and resource cleanup
* Updated Android Gradle Plugin to 7.3.0
* Updated Gradle wrapper to 7.5.1
* Updated compileSdkVersion to 33 and minSdkVersion to 21
* Updated Jackson libraries to 2.13.0
* Added proper Activity lifecycle handling
* Fixed memory leaks by properly cleaning up resources
* Added Java 8 compilation support

**Migration Guide**:
- Update your `pubspec.yaml` to use `flutter_lwa_hw` instead of `flutter_lwa`
- Update import statements from `package:flutter_lwa/lwa.dart` to `package:flutter_lwa_hw/lwa.dart`
- All other APIs remain the same

## 2.1.0

* Implemented GrantType and ProofKeyParameters arguments to enable using Alexa APIs
* Updated example with options for standard LWA and AVS authentication.

## 2.0.0

* Refactor to support federated development.  

Common types moved into the platform interface package. You may need to add an import statement.
```
import 'package:flutter_lwa_platform_interface/flutter_lwa_platform_interface.dart';
```

## 1.0.2

* Linting and formatting updates

## 1.0.1

* Updated references to deprecated Widgets

## 1.0.0

* Update to Dart 2.12
* Refactoring to support null safety

## 0.2.0

* Update to Login with Amazon iOS SDK to version 3.1.1.

## 0.1.0

* Initial release.

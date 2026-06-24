#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint lwa.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_lwa_hw'
  s.version          = '2.2.0'
  s.summary          = 'Login with Amazon Flutter plugin'
  s.description      = <<-DESC
Login with Amazon Flutter plugin. Call Amazon APIs from your Flutter application.
                       DESC
  s.homepage         = 'https://github.com/1200126/flutter_lwa_hw'
  s.license          = { :file => '../LICENSE' }
  s.author           = { '1200126' => '1200126@users.noreply.github.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'
  s.platform = :ios, '11.0'

  # Flutter.framework does not contain a i386 slice. Only x86_64 simulators are supported.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'VALID_ARCHS[sdk=iphonesimulator*]' => 'x86_64' }

  s.preserve_paths = 'LoginWithAmazon.framework'
  s.xcconfig = { 'OTHER_LDFLAGS' => '-framework LoginWithAmazon -framework SafariServices' }
  s.vendored_frameworks = 'LoginWithAmazon.framework'

end

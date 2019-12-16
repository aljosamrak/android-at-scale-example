# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in -build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# io.github.microutils:kotlin-logging
# Remove all logging related code. Logger declaration will be removed if minified enabled
#-assumenosideeffects class mu.KLogging* {
#    public *;
#}

# io.github.microutils:kotlin-logging
# Keep error level logs
-assumenosideeffects class mu.KLogging* {
    public static *** trace(...);
    public static *** debug(...);
    public static *** info(...);
    public static *** warn(...);

    public static *** entry(...);
    public static *** exit(...);
    public static *** catching(...);
    public static *** throwing(...);
}
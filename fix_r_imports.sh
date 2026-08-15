#!/usr/bin/env bash

echo "1. Replacing all R class imports across Java and Kotlin files..."
find briar-android/src/main/java -type f \( -name "*.java" -o -name "*.kt" \) \
  -exec sed -i 's/import org\.briarproject\.briar\.R;/import com.ksmessaging.R;/g' {} +
find briar-android/src/main/java -type f \( -name "*.java" -o -name "*.kt" \) \
  -exec sed -i 's/import org\.briarproject\.briar\.android\.R;/import com.ksmessaging.R;/g' {} +

echo "2. Updating Manifest package declaration..."
find briar-android -name "AndroidManifest.xml" \
  -exec sed -i 's/package="org\.briarproject\.briar\.android"/package="com.ksmessaging"/g' {} +
find briar-android -name "AndroidManifest.xml" \
  -exec sed -i 's/package="org\.briarproject\.briar"/package="com.ksmessaging"/g' {} +

echo "3. Updating Gradle namespace and application ID..."
find briar-android -type f \( -name "build.gradle" -o -name "build.gradle.kts" \) \
  -exec sed -i 's/namespace "org\.briarproject\.briar\.android"/namespace "com.ksmessaging"/g' {} +
find briar-android -type f \( -name "build.gradle" -o -name "build.gradle.kts" \) \
  -exec sed -i 's/namespace "org\.briarproject\.briar"/namespace "com.ksmessaging"/g' {} +

echo "Done! Verifying remaining R imports..."
grep -rn "import org.briarproject" briar-android/src/main/java | grep "\.R;" || echo "All R imports successfully updated to com.ksmessaging.R!"

#!/usr/bin/env bash

echo "1. Searching and updating namespace in all build.gradle files..."
find . -type f \( -name "build.gradle" -o -name "build.gradle.kts" \) \
  -exec sed -i 's/namespace = ".*"/namespace = "com.ksmessaging"/g' {} +
find . -type f \( -name "build.gradle" -o -name "build.gradle.kts" \) \
  -exec sed -i "s/namespace '.*'/namespace 'com.ksmessaging'/g" {} +

echo "2. Updating root package attribute in AndroidManifest files..."
find briar-android -name "AndroidManifest.xml" \
  -exec sed -i 's/package="[^"]*"/package="com.ksmessaging"/g' {} +

echo "3. Explicitly injecting namespace into briar-android/build.gradle if missing..."
if ! grep -q "namespace 'com.ksmessaging'" briar-android/build.gradle && ! grep -q 'namespace "com.ksmessaging"' briar-android/build.gradle; then
  sed -i '/android {/a \    namespace "com.ksmessaging"' briar-android/build.gradle
fi

echo "Done! Verifying configuration..."
grep -rn "namespace" briar-android/build.gradle

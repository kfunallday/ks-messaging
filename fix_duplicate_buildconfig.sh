#!/usr/bin/env bash

echo "1. Setting main app module namespace..."
if [ -f "briar-android/build.gradle" ]; then
  sed -i 's/namespace .*/namespace "com.ksmessaging"/g' briar-android/build.gradle
fi

echo "2. Setting distinct sub-namespace for bramble-android..."
if [ -f "bramble-android/build.gradle" ]; then
  sed -i 's/namespace .*/namespace "com.ksmessaging.bramble"/g' bramble-android/build.gradle
fi

echo "3. Updating bramble-android AndroidManifest package..."
if [ -f "bramble-android/src/main/AndroidManifest.xml" ]; then
  sed -i 's/package="[^"]*"/package="com.ksmessaging.bramble"/g' bramble-android/src/main/AndroidManifest.xml
fi

echo "Done! Namespaces separated."

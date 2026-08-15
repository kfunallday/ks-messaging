#!/usr/bin/env bash

SOURCE_DIR="my_assets"

if [ ! -d "$SOURCE_DIR" ]; then
  echo "Error: $SOURCE_DIR directory not found!"
  exit 1
fi

echo "Replacing strictly PNG and SVG assets across entire repo..."

for asset in "$SOURCE_DIR"/*; do
  if [ -f "$asset" ]; then
    filename=$(basename "$asset")
    basename_no_ext="${filename%.*}"

    echo "----------------------------------------"
    echo "Processing asset: $filename"

    # Search entire workspace for matching .png or .svg files (case-insensitive extension match)
    find . -type f \( -iname "${basename_no_ext}.png" -o -iname "${basename_no_ext}.svg" \) \
      -not -path "./.git/*" \
      -not -path "./$SOURCE_DIR/*" | while read -r target; do
      
      cp -f "$asset" "$target"
      echo "  [✓] OVERWRITTEN: $target"
    done
  fi
done

echo "----------------------------------------"
echo "Strict SVG/PNG replacement complete!"

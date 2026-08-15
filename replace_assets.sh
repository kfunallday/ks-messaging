#!/bin/bash
# Staging folder containing your replacement files
ASSETS_DIR="my_assets"

if [ ! -d "$ASSETS_DIR" ]; then
    echo "Staging folder $ASSETS_DIR not found. Skipping replacements."
    exit 0
fi

# Find every file placed inside my_assets/
find "$ASSETS_DIR" -type f | while read -r src_file; do
    filename=$(basename "$src_file")
    
    # Search the project for existing files with the EXACT same filename
    find . -path "./$ASSETS_DIR" -prune -o -name "$filename" -type f -print | while read -r dest_file; do
        if [ "$dest_file" != "./$ASSETS_DIR" ]; then
            cp -f "$src_file" "$dest_file"
            echo "Replaced matching file: $dest_file"
        fi
    done
done
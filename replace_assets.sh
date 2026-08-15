#!/bin/bash
echo "Replacing custom assets..."

# Find every file in my_assets and replace matching files anywhere in the source tree
for filepath in $(find my_assets -type f); do
    filename=$(basename "$filepath")
    echo "Searching and replacing: $filename"
    
    # Locate all instances of this file in the project (excluding the my_assets folder itself)
    find . -path "./my_assets" -prune -o -name "$filename" -type f -exec cp "$filepath" {} \;
done

echo "Asset replacement complete!"
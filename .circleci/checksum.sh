#!/bin/bash
RESULT_FILE=$1

if [ -f "$RESULT_FILE" ]; then
  rm "$RESULT_FILE"
fi
touch "$RESULT_FILE"

checksum_file() {
  openssl md5 "$1" | awk '{print $2}'
}

FILES=()

# Loop through all build.gradle files
while read -r -d ''; do
	FILES+=("$REPLY")
done < <(find . -regextype posix-extended -regex '(.*/)?build.gradle(.kts)?' -type f -print0)

# Loop through buildSrc files
while read -r -d ''; do
	FILES+=("$REPLY")
done < <( find buildSrc -type f -not -path "*/build/*" -not -path "*/.gradle/*" -print0)

# Loop through files and append MD5 to result file
for FILE in "${FILES[@]}"; do
	checksum_file "$FILE" >> "$RESULT_FILE"
done
# Now sort the file so that it is
sort "$RESULT_FILE" -o "$RESULT_FILE"
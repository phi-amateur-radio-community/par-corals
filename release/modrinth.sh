#!/usr/bin/env bash

tag=${TAG}
version_code=${tag#v}
version_rel="Version ${version_code%%-*}"
is_release=false
status="listed"
changelog_jq=$(jq -Rs . <<< "$CHANGELOG")

if [[ $VERSION_TYPE == "alpha" ]]; then
  version_suffix="-Alpha"
  version_type_modrinth="alpha"
  status="unlisted"
elif [[ $VERSION_TYPE == "beta" ]]; then
  version_suffix="-Beta"
  version_type_modrinth="beta"
elif [[ $VERSION_TYPE == "rc" ]]; then
  version_suffix="-RC${version_code##*rc}"
  version_type_modrinth="beta"
else
  version_suffix=""
  version_type_modrinth="release"
  is_release=true
fi

cat > metadata.json <<EOF
{
  "name": "${version_rel}${version_suffix}",
  "version_number": "${version_code}",
  "changelog": ${changelog_jq},
  "dependencies": [],
  "game_versions": ["1.20.1"],
  "version_type": "${version_type_modrinth}",
  "loaders": ["fabric"],
  "featured": ${is_release},
  "status": "${status}",
  "project_id": "${PROJECT_ID}",
  "file_parts": ["main_file", "sources_file"],
  "primary_file": "main_file"
}
EOF

curl -X POST \
  -H "Authorization: ${MODRINTH_TOKEN}" \
  -H "User-Agent: phi-amateur-radio-community/par-corals" \
  -F "metadata=@metadata.json;type=application/json" \
  -F "main_file=@${MAIN_JAR}" \
  -F "sources_file=@${SOURCE_JAR}" \
  https://api.modrinth.com/v2/version
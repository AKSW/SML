#!/bin/bash
set -e

(cd src && ./build-sml.sh)

targetGitEndpoint='git@github.com:AKSW/SML-CodeMirror-Mode-Bower.git'
targetFolder='target/release/repo'

version=`cat version.txt`
tag="v$version"


git clone "$targetGitEndpoint" "$targetFolder" || true
( cd "$targetFolder" && git pull )

( cd src && ./build-sml.sh )

cp bower.json "$targetFolder"
cp -rf css "$targetFolder"
cp src/sml-codemirror-mode.js "$targetFolder"

cd "$targetFolder"
git add -A
git commit -m "Updating version $version with tag $tag" --allow-empty
git push
# Delete tag if already present
git tag -d "$tag" || true
git push origin ":refs/tags/$tag" || true
git tag "$tag"
git push --tags


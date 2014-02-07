#!/bin/bash
pl=swipl

$pl -s gen_sml.pl -t go
sed < template.js 's/%%%modename%%%/sml/' | sed -e '/%%%table%%%/r sml_table.js' > sml-codemirror-mode.js


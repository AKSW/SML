
top_symbol(smlConfigUnit).
output_file('sml_table.js').

js_vars([
  defaultQueryType=null,
  lexVersion='"sml"',
  startSymbol='"smlConfig"',
  acceptEmpty=false
]).

:-include(gen_ll1).
:-reconsult('sml-grammar.pl').
